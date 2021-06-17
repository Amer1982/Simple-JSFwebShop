/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.resource.shop.app.business;

public enum AccessPrivilege {
    
    
    USER(1, "user"),
    ADMIN(2, "admin");

    private final int id;
    private final String name;

    private AccessPrivilege(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}