package model;

import java.util.Arrays;

public enum  Role {
    USER(1),
    ADMIN(0),
    DOCTOR(2);
    private final int id;

    Role(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public static Role resolveRoleById(int i){
        return Arrays.stream(values()).filter(role -> role.id==i).findFirst().get();
    }
}
