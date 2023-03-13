package com.example.androiddb;

public class Model {

    int id;
    String name;
    int age;
    Boolean isActive;

    @Override
    public String toString() {
        return "Model{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", isActive=" + isActive +
                '}';
    }

    public Model(int id, String name, int age, Boolean isActive) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.isActive = isActive;
    }
}
