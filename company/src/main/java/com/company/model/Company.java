package com.company.model;

import java.util.UUID;

public class Company {

    private UUID id;
    private UUID userOwner;
    private String document;
    private String name;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getUserOwner() {
        return userOwner;
    }

    public void setUserOwner(UUID userOwner) {
        this.userOwner = userOwner;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
