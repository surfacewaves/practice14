package org.example.model;

public class Group {
    private String name;
    private int id;

    public Group(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public Group() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
