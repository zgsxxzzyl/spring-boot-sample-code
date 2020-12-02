package com.dao.provider;

import java.lang.reflect.Field;

public class SqlProvider {

    public String insert(Object o) throws IllegalAccessException {
        Class cls = o.getClass();
        StringBuilder sql = new StringBuilder("INSERT INTO ");
        StringBuilder values = new StringBuilder("VALUES ");
        String className = cls.getSimpleName();
        sql.append(className);
        Field[] fields = cls.getDeclaredFields();
        sql.append("(");
        values.append("(");
        for (int i = 0; i < fields.length; i++) {
            Field field = fields[i];
            sql.append(field.getName());
            sql.append(",");
            field.setAccessible(true);
            if (field.getType() == String.class) {
                values.append("'" + field.get(o) + "'");
                values.append(",");
            } else {
                values.append(field.get(o));
                values.append(",");
            }
        }
        sql.deleteCharAt(sql.length() - 1);
        values.deleteCharAt(values.length() - 1);
        sql.append(")");
        values.append(")");
        sql.append(values);
        return sql.toString();
    }
}
