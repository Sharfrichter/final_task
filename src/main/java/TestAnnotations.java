import Builder.FindAllCreator;
import Model.Drug;

public class TestAnnotations {
    public static void main(String[] args) {
        FindAllCreator<Drug> builder = new FindAllCreator<>();
        System.out.println(builder.createStatement(Drug.class));
        /*FindAllBuilder<User> builder=new FindAllBuilder<>();
        builder.build(User.class);
        User user = new User(1,"aaaa","bbbb","alex","nevski",1);
        Field[] fields = user.getClass().getDeclaredFields();
        for (Field field:fields){
            if(field.isAnnotationPresent(Column.class)){
                System.out.println(field.getAnnotation(Column.class).name());
            }
        }*/
    }
}
