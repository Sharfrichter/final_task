package command.enums;

public enum Path {
    MAIN_PAGE("main_page.jsp"),
    REGISTRATION_PAGE("registration_page.jsp");
    private String path;

    Path(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }
}
