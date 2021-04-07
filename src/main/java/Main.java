public class Main {
    public static void main(String[] args) {
        ConnectionPool.INSTANCE.init();
        ConnectionPool.INSTANCE.getAvaibleConnections().forEach(System.out::println);
    }
}
