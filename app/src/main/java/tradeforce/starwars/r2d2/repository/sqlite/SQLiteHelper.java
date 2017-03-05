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

public class SQLiteHelper extends SQLiteOpenHelper {

    private SQLiteHelper(Context context) {
        super(context, "starwars.db", null, 1);
    }

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

    public static <E extends Entity> ReadableDAO<E> getDAOReadable(Context context, Class<E> model) {
        return getDAOReadable(context, model, false);
    }

    public static <E extends Entity> ReadableDAO<E> getDAOReadable(Context context, Class<E> model, boolean debugLog) {
        ReadableDAO<E> dao = new ReadableDAO(context, model);
        dao.logData(debugLog);
        return dao;
    }

    public static <E extends Entity> WritableDAO<E> getDAOWritable(Context context, Class<E> model) {
        return getDAOWritable(context, model, false);
    }

    public static <E extends Entity> WritableDAO<E> getDAOWritable(Context context, Class<E> model, boolean debugLog) {
        WritableDAO<E> dao = new WritableDAO(context, model);
        dao.logData(debugLog);
        return  dao;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(createEntity(Person.class));
        db.execSQL(createEntity(Film.class));
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

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

    public static class WritableDAO<E extends Entity> extends ReadableDAO<E> {

        WritableDAO(Context context, Class<E> model) {
            super(context, model);

            db = sqlite.getWritableDatabase();
        }

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

        public void delete(String key, Object value) {
            if (value != null) {
                String whereClause = String.format(" %s = ? ", key);
                String[] whereArgs = {value.toString()};

                db.delete(table, whereClause, whereArgs);
            }
        }

        public <E extends Entity> void delete(E entity) {
            if (entity.hasId()) {
                String whereClause = " _ID = ? ";
                String[] whereArgs = {entity.getId().toString()};

                db.delete(table, whereClause, whereArgs);
            }
        }

        public void deleteAll() {
            db.delete(table, null, null);
        }
    }
}