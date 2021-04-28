package DAO.impl;

import DAO.EntityDao;
import annotations.Column;
import annotations.Table;
import model.Drug;
import model.User;
import proxy.StatementProxy;

import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StatementCreator<T,I> {


    public List<T> findAll(Class<T> t, Connection connection) {
        StringBuilder sql = new StringBuilder();
        List<T> list = new ArrayList<>();

        sql.append("SELECT * FROM ");
        sql.append(t.getAnnotation(Table.class).name());
        try(Statement statement=connection.createStatement()) {
            statement.execute(sql.toString());
            ResultSet resultSet = statement.getResultSet();
            Field[] fields = t.getDeclaredFields();
            while (resultSet.next()){
                Object object = null;
                if (t.equals(User.class)) {
                    object = new User();
                }else if(t.equals(Drug.class)){
                    object = new Drug();
                }
                for (Field field : fields) {
                    field.setAccessible(true);
                    if (field.getType().equals(int.class)||field.getType().equals(Integer.class)) {
                        field.set(object, resultSet.getInt(field.getAnnotation(Column.class).name()));
                    } else if (field.getType().equals(String.class)) {
                        field.set(object, resultSet.getString(field.getAnnotation(Column.class).name()));
                    }
                    field.setAccessible(false);
                }
                list.add((T) object);
            }

        } catch (SQLException | IllegalAccessException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }


    public T findById(Class<T> t,Connection connection,I id){
        Object object = null;
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM ");
        sql.append(t.getAnnotation(Table.class).name()).append(" WHERE id=?");
        try(PreparedStatement statement=connection.prepareStatement(sql.toString())) {
            statement.setInt(1, (Integer) id);
            statement.execute();
            ResultSet resultSet = statement.getResultSet();
            Field[] fields = t.getDeclaredFields();
            if(resultSet.next()){
                if (t.equals(User.class)) {
                    object = new User();
                }else if(t.equals(Drug.class)){
                    object = new Drug();
                }
                //...
                for (Field field : fields) {
                    field.setAccessible(true);
                    if (field.getType().equals(int.class)||field.getType().equals(Integer.class)) {
                        field.set(object, resultSet.getInt(field.getAnnotation(Column.class).name()));
                    } else if (field.getType().equals(String.class)) {
                        field.set(object, resultSet.getString(field.getAnnotation(Column.class).name()));
                    }
                    field.setAccessible(false);
                }
            };



        } catch (SQLException | IllegalAccessException throwables) {
            throwables.printStackTrace();
        }
        return (T) object;
    }


    public void delete(Class<T> t,Connection connection,I id){
        StringBuilder sql = new StringBuilder();
        sql.append("DELETE FROM ");
        sql.append(t.getAnnotation(Table.class).name()).append(" WHERE id=?");
        try(PreparedStatement statement=connection.prepareStatement(sql.toString())) {
            statement.setInt(1, (Integer) id);
            statement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }



    public void create(T t,Connection connection){
        StringBuilder sql = new StringBuilder();
        Field[] fields = t.getClass().getDeclaredFields();

        sql.append("INSERT INTO ");
        sql.append(t.getClass().getAnnotation(Table.class).name()).append(" (");
        for(int i=0;i<fields.length;i++){
            if(fields[i].getAnnotation(Column.class).name().equals("id")){

            }else if(i==fields.length-1){
                sql.append(fields[i].getAnnotation(Column.class).name()).append(") ");
            }else {
                sql.append(fields[i].getAnnotation(Column.class).name()).append(",");
            }
        }
        sql.append("VALUES (");
        for(int i=0;i<fields.length;i++){
            if(fields[i].getAnnotation(Column.class).name().equals("id")){

            }else if(i==fields.length-1){
                sql.append("?) ");
            }else {
                sql.append("?,");
            }
        }
        try(PreparedStatement statement=connection.prepareStatement(sql.toString())) {
            statement.setString(1,t.getClass().getAnnotation(Table.class).name());
            int counter =1;
            for(int i=0;i<fields.length;i++){
                if(fields[i].getAnnotation(Column.class).name().equals("id")){

                }else {
                    fields[i].setAccessible(true);
                    statement.setString(counter,fields[i].get(t).toString());
                    fields[i].setAccessible(false);
                    counter++;

                }
            }
            statement.executeUpdate();

        } catch (SQLException | IllegalAccessException throwables) {
            throwables.printStackTrace();
        }


    }



    public T update(T t,Connection connection){
        StringBuilder sql = new StringBuilder();
        Field[] fields = t.getClass().getDeclaredFields();
        sql.append("UPDATE ").append(t.getClass().getAnnotation(Table.class).name()).append(" SET ");

        for(int i=0;i<fields.length;i++){
            if(!fields[i].getAnnotation(Column.class).name().equals("id")){
                if(i==fields.length-1){
                    sql.append(fields[i].getAnnotation(Column.class).name()).append("=");
                    fields[i].setAccessible(true);
                    sql.append("?");

                }else {
                    sql.append(fields[i].getAnnotation(Column.class).name()).append("=");
                    sql.append("?").append(",");
                }
            }
        }
        sql.append(" WHERE id=?");
        try(StatementProxy statement=new StatementProxy(connection.prepareStatement(sql.toString()))) {
            int counter=1;
            Integer id=0;
            for(int i=0;i<fields.length;i++){
                if(!fields[i].getAnnotation(Column.class).name().equals("id")){
                    fields[i].setAccessible(true);
                    statement.setValue(counter,fields[i].get(t));
                    fields[i].setAccessible(false);
                    counter++;
                }else {
                    fields[i].setAccessible(true);
                    id= (Integer) fields[i].get(t);
                    fields[i].setAccessible(false);

                }

            }
                statement.setValue(counter,id);
            statement.executeUpdate();

        } catch (SQLException | IllegalAccessException throwables) {
            throwables.printStackTrace();
        }
        return t;
    }

}
