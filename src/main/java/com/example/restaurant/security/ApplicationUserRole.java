package com.example.restaurant.security;

import com.google.common.collect.Sets;

import java.util.Set;

import static com.example.restaurant.security.ApplicationUserPermission.*;

public enum ApplicationUserRole {
    CLIENT(Sets.newHashSet(MENU_READ, ORDER_READ, ORDER_WRITE)),
    ADMIN(Sets.newHashSet(MENU_READ, MENU_WRITE, ORDER_READ, ORDER_WRITE, STAFF_READ, STAFF_WRITE));

    private final Set<ApplicationUserPermission> permissions;

    ApplicationUserRole(Set<ApplicationUserPermission> permissions) {
        this.permissions = permissions;
    }

    public Set<ApplicationUserPermission> getPermissions() {
        return permissions;
    }
}
