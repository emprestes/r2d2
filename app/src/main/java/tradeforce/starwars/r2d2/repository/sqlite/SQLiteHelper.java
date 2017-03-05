package tradeforce.starwars.r2d2.repository.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.Set;
import java.util.TreeSet;

import tradeforce.starwars.domain.model.Film;
import tradeforce.starwars.domain.model.Person;
import tradeforce.starwars.repository.Entity;

import static tradeforce.starwars.r2d2.repository.util.SQLHelper.DDL.createEntity;
import static tradeforce.starwars.r2d2.repository.util.SQLHelper.MDL.createInstance;
import static tradeforce.starwars.r2d2.repository.util.SQLHelper.MDL.getTableName;
import static tradeforce.starwars.r2d2.repository.util.SQLHelper.MDL.getValues;

/**
 * OpenHelper para uso do SQLite.
 *
 * @author Prestes, E. M.
 * @since Março de 2017
 *
 * @see SQLiteOpenHelper
 */
public class SQLiteHelper extends SQLiteOpenHelper {

    private SQLiteHelper(Context context) {
        super(context, "starwars.db", null, 1);
    }

    /**
     * Recupera o id da url informada.
     *
     * @param url URL informada.
     * @return ID recuperado. NULL caso não encontrado.
     */
    public static Long recoveryId(String url) {
        if (url != null && !url.isEmpty()) {
            int index = url.lastIndexOf('/');
            if (index == url.length() - 1) {
                url = url.substring(0, index);
            }

            index = url.lastIndexOf('/');
            url = url.substring(index + 1);

            return Long.valueOf(url);
        }

        return null;
    }

    /**
     * Recupera DAO para leitura de banco de dados.
     *
     * @param context Contexto Android informado.
     * @param model Classe da entidade de modelo que será lida (tabela).
     * @param <E> Tipo da entidade de modelo.
     * @return DAO para leitura.
     */
    public static <E extends Entity> ReadableDAO<E> getDAOReadable(Context context, Class<E> model) {
        return getDAOReadable(context, model, false);
    }

    /**
     * Recupera DAO para leitura de banco de dados.
     *
     * @param context Contexto Android informado.
     * @param model Classe da entidade de modelo que será lida (tabela).
     * @param <E> Tipo da entidade de modelo.
     * @param debugLog Flag para debug em log do conteúdo da entidade informada em tabela.
     * @return DAO para leitura.
     */
    public static <E extends Entity> ReadableDAO<E> getDAOReadable(Context context, Class<E> model, boolean debugLog) {
        ReadableDAO<E> dao = new ReadableDAO(context, model);
        dao.logData(debugLog);
        return dao;
    }

    /**
     * Recupera DAO para escrita de banco de dados.
     *
     * @param context Contexto Android informado.
     * @param model Classe da entidade de modelo que será lida (tabela).
     * @param <E> Tipo da entidade de modelo.
     * @return DAO para escrita.
     */
    public static <E extends Entity> WritableDAO<E> getDAOWritable(Context context, Class<E> model) {
        return getDAOWritable(context, model, false);
    }

    /**
     * Recupera DAO para escrita de banco de dados.
     *
     * @param context Contexto Android informado.
     * @param model Classe da entidade de modelo que será lida (tabela).
     * @param <E> Tipo da entidade de modelo.
     * @param debugLog Flag para debug em log do conteúdo da entidade informada em tabela.
     * @return DAO para escrita.
     */
    public static <E extends Entity> WritableDAO<E> getDAOWritable(Context context, Class<E> model, boolean debugLog) {
        WritableDAO<E> dao = new WritableDAO(context, model);
        dao.logData(debugLog);
        return  dao;
    }

    /** {@inheritDoc} */
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(createEntity(Person.class));
        db.execSQL(createEntity(Film.class));
    }

    /** {@inheritDoc} */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) { }

    private abstract static class DAO<E extends Entity> {

        Context context;

        Class<E> model;

        SQLiteHelper sqlite;

        SQLiteDatabase db;

        String table;

        DAO(Context context, Class<E> model) {
            super();

            this.context = context;
            this.model = model;
            this.table = getTableName(model);
            this.sqlite = new SQLiteHelper(context);
        }

        public void close() {
            db.close();
        }

        void logData(boolean debug) {
            if (debug) {
                Cursor c = db.query(table, null, null, null, null, null, null);

                try {
                    Log.d("sql.table", table);
                    StringBuilder row = new StringBuilder("\n| ");
                    String[] columns = c.getColumnNames();
                    for (String col : c.getColumnNames()) {
                        row.append(col).append(" | ");
                    }
                    row.append('\n').append('-').append('\n');
                    while (c.moveToNext()) {
                        for (int i = 0; i < columns.length; i++) {
                            row.append("| ").append(c.getString(i)).append(' ');
                        }
                        row.append('\n');
                    }
                    row.append('-');
                    Log.d("sql.data", row.toString());
                } finally {
                    c.close();
                }
            }
        }
    }

    /**
     * Classe para representar um DAO para leitura de banco de dados.
     * @param <E> Tipo de entidade informado.
     */
    public static class ReadableDAO<E extends Entity> extends DAO<E> {

        String[] columns;

        String selection;

        String[] selectionArgs;

        String groupBy;

        String having;

        String orderBy;

        ReadableDAO(Context context, Class<E> model) {
            super(context, model);

            db = sqlite.getReadableDatabase();
            columns = null;
            selection = null;
            selectionArgs = null;
            groupBy = null;
            having = null;
            orderBy = null;
        }

        /**
         * Recupera uma entidade do banco de dados em acordo ao ID informado.
         *
         * @param _id ID informado.
         * @return Entidade encontrada. NULL caso não encontrado.
         */
        public E getOne(Long _id) {
            Cursor c;
            E e;
            String selection = " _ID = ? ";
            String[] selectionArgs = {_id.toString()};

            e = null;
            c = db.query(table, columns, selection, selectionArgs, groupBy, having, orderBy);
            try {
                if (c.moveToNext()) {
                    e = createInstance(c, model);
                }
            } finally {
                c.close();
            }

            return e;
        }

        /**
         * Recupera uma entidade do banco de dados em acordo ao critério informado.
         *
         * @param key Nome do campo a pesquisar.
         * @param value Valor a ser encontrado.
         * @return Entidade encontrada. NULL caso não encontrado.
         */
        public E get(String key, String value) {
            Cursor c;
            E e;
            String selection = String.format(" %s = ? ", key);
            String[] selectionArgs = {value};

            e = null;
            c = db.query(table, columns, selection, selectionArgs, groupBy, having, orderBy);
            try {
                if (c.moveToNext()) {
                    e = createInstance(c, model);
                }
            } finally {
                c.close();
            }

            return e;
        }

        /**
         * Procura todas as entidades da tabela.
         *
         * @return Conjunto de entidades.
         */
        public Set<E> findAll() {
            Cursor c;
            Set<E> set;

            set = new TreeSet<>();
            c = db.query(table, columns, selection, selectionArgs, groupBy, having, orderBy);
            try {
                E entity;
                while (c.moveToNext()) {
                    entity = createInstance(c, model);
                    set.add(entity);
                }
            } finally {
                c.close();
            }

            return set;
        }

        /**
         * Procura por ID informado.
         *
         * @param key Nome do campo a pesquisar.
         * @param id ID informado.
         * @return Entidade encontrada. Conjunto vazio caso não encontrado.
         */
        public Set<E> findById(String key, Long id) {
            Cursor c;
            Set<E> set;
            String selection = String.format(" %s = ? ", key);
            String[] selectionArgs = {id.toString()};

            set = new TreeSet<>();
            c = db.query(table, columns, selection, selectionArgs, groupBy, having, orderBy);
            try {
                E entity;
                while (c.moveToNext()) {
                    entity = createInstance(c, model);
                    set.add(entity);
                }
            } finally {
                c.close();
            }

            return set;
        }
    }

    /**
     * Classe para representar um DAO para escrita de banco de dados.
     * @param <E> Tipo de entidade informado.
     */
    public static class WritableDAO<E extends Entity> extends ReadableDAO<E> {

        WritableDAO(Context context, Class<E> model) {
            super(context, model);

            db = sqlite.getWritableDatabase();
        }

        /**
         * Salva uma entidade em banco de dados.
         *
         * @param entity Entidade informada.
         */
        public void save(E entity) {
            final ContentValues values = getValues(entity);
            boolean isUpdated;

            if (isUpdated = entity.hasId()) {
                String whereClause = " _ID = ? ";
                String[] whereArgs = {entity.getId().toString()};

                int rows = db.update(table, values, whereClause, whereArgs);

                isUpdated = rows > 0;
            }

            if (!isUpdated) {
                db.insert(table, null, values);
            }
        }

        /**
         * Apaga entidade(s) do banco de dados.
         *
         * @param key Nome do campo informado.
         * @param value Valor do campo informado.
         */
        public void delete(String key, Object value) {
            if (value != null) {
                String whereClause = String.format(" %s = ? ", key);
                String[] whereArgs = {value.toString()};

                db.delete(table, whereClause, whereArgs);
            }
        }

        /**
         * Apaga entidade(s) do banco de dados.
         *
         * @param entity Entidade a ser apagada informada.
         */
        public void delete(E entity) {
            if (entity.hasId()) {
                String whereClause = " _ID = ? ";
                String[] whereArgs = {entity.getId().toString()};

                db.delete(table, whereClause, whereArgs);
            }
        }

        /**
         * Apaga todas as entidades de uma tabela.
         */
        public void deleteAll() {
            db.delete(table, null, null);
        }
    }
}