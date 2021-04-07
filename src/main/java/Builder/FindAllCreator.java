package Builder;

import Annotations.Table;

import java.lang.reflect.Field;

public class FindAllCreator<T> {
    StringBuilder statement = new StringBuilder();

    public String createStatement(Class<T> t) {
        statement.append("SELECT * FROM ");
        statement.append(t.getAnnotation(Table.class).name());
        return statement.toString();
    }

}
