package com.example.demo.databinder;

public class Foo extends AbstractEntity {

    public Foo(String source) {
        super(source);
    }

    @Override
    protected String getMessage() {
        return "this entity is Foo(id=" + super.getId() + ")";
    }
}
