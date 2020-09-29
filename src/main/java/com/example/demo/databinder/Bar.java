package com.example.demo.databinder;

public class Bar extends AbstractEntity {

    public Bar(String id) {
        super(id);
    }

    @Override
    protected String getMessage() {
        return "this entity is Bar(id=" + super.getId() + ")";
    }
}
