package com.example.restaurant.security;

public enum ApplicationUserPermission {
    MENU_READ("menu:read"),
    MENU_WRITE("menu:write"),
    ORDER_READ("order:read"),
    ORDER_WRITE("order:write"),
    STAFF_READ("staff:read"),
    STAFF_WRITE("staff:write");

    private final String permission;

    ApplicationUserPermission(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }
}
