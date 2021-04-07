package Builder;

import Annotations.Column;
import Annotations.Table;
import Model.Drug;
import Model.User;

import javax.xml.transform.Result;
import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FindAllCreator<T> {
    StringBuilder sql = new StringBuilder();

    public List<T> findAll(Class<T> t, Connection connection) {
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

}
