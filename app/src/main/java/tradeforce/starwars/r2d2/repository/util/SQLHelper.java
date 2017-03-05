package tradeforce.starwars.r2d2.repository.util;

import android.content.ContentValues;
import android.database.Cursor;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import tradeforce.starwars.repository.Entity;
import tradeforce.starwars.repository.orm.Column;
import tradeforce.starwars.repository.orm.Id;
import tradeforce.starwars.repository.orm.Table;

public final class SQLHelper {

    public static class DDL {

        public static String createEntity(Class<? extends Entity> _class) {
            final tradeforce.starwars.repository.orm.Entity e;
            final Table t;
            final StringBuilder sql;

            sql = new StringBuilder();
            e = _class.getAnnotation(tradeforce.starwars.repository.orm.Entity.class);
            t = _class.getAnnotation(Table.class);

            if (e != null && t != null) {
                sql.append("CREATE TABLE IF NOT EXISTS ").append(t.value()).append(" (");

                List<Field> fields = new LinkedList<>();
                Field f;
                Class<?> type;
                Id id;
                Column c;
                boolean isNumber;

                fields.addAll(Arrays.asList(_class.getFields()));
                fields.addAll(Arrays.asList(_class.getDeclaredFields()));

                for (int i = 0; i < fields.size(); i++) {
                    f = fields.get(i);
                    type = f.getType();
                    id = f.getAnnotation(Id.class);
                    c = f.getAnnotation(Column.class);

                    if (c == null) {
                        continue;
                    }

                    sql.append(c.name());

                    if (isNumber = ((Long.class.equals(type) || long.class.equals(type)) ||
                            (Integer.class.equals(type) || int.class.equals(type)) ||
                            (Short.class.equals(type) || short.class.equals(type)) ||
                            (Byte.class.equals(type) || byte.class.equals(type)))) {
                        sql.append(" INTEGER");
                    } else if (Double.class.equals(type) || double.class.equals(type) ||
                            (Float.class.equals(type) || float.class.equals(type))) {
                        sql.append(" REAL");
                    } else if (String.class.equals(type)) {
                        sql.append(" VARCHAR(").append(c.length()).append(')');
                    }

                    if (id != null) {
                        sql.append(" NOT NULL PRIMARY KEY");

                        if (isNumber && id.autoincrement()) {
                            sql.append(" AUTOINCREMENT");
                        }
                    } else {
                        sql.append(c.nullable() ? " NULL" : " NOT NULL");
                    }

                    sql.append(", ");
                }

                sql.delete(sql.length() - 2, sql.length());
                sql.append(");");
            }

            return sql.toString();
        }
    }

    public static class MDL {

        public static ContentValues getValues(Object model) {
            try {
                final ContentValues cv = new ContentValues();
                final Class<?> _class = model.getClass();
                final Field[] fields = _class.getDeclaredFields();
                Column c;
                String key;
                Object value;

                for (Field f : fields) {
                    f.setAccessible(Boolean.TRUE);
                    c = f.getAnnotation(Column.class);

                    if (c == null) {
                        continue;
                    }

                    key = c.name();
                    value = f.get(model);

                    if (value != null) {
                        if (value instanceof Long) {
                            cv.put(key, (Long) value);
                        } else if (value instanceof Double) {
                            cv.put(key, (Double) value);
                        } else if (value instanceof String) {
                            cv.put(key, value.toString());
                        }
                    }
                }

                return cv;
            } catch (Exception cause) {
                throw new RuntimeException(cause);
            }
        }

        public static String getTableName(Object model) {
            return getTableName(model.getClass());
        }

        public static String getTableName(Class<?> _class) {
            Table t = _class.getAnnotation(Table.class);
            return t != null ? t.value() : null;
        }

        public static <M> M createInstance(Cursor c, Class<?> _class) {
            try {
                M model = (M) _class.newInstance();
                String[] columns = c.getColumnNames();
                String name;
                Column a;
                int index, type;

                for (String column : columns) {
                    for (Field f : _class.getDeclaredFields()) {
                        f.setAccessible(Boolean.TRUE);
                        a = f.getAnnotation(Column.class);
                        if (a == null) {
                            continue;
                        }

                        name = a.name();
                        if (column.equalsIgnoreCase(name)) {
                            index = c.getColumnIndex(column);
                            type = c.getType(index);
                            switch (type) {
                                case Cursor.FIELD_TYPE_STRING:
                                    f.set(model, c.getString(index));
                                    break;
                                case Cursor.FIELD_TYPE_INTEGER:
                                    f.set(model, c.getLong(index));
                                    break;
                                case Cursor.FIELD_TYPE_FLOAT:
                                    f.set(model, c.getDouble(index));
                                    break;
                            }
                        }
                    }
                }

                return model;
            } catch (Exception cause) {
                throw new RuntimeException(cause);
            }
        }
    }
}
