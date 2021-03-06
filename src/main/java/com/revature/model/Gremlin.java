package com.revature.model;

import java.io.Serializable;
import java.util.Objects;

public class Gremlin implements Serializable {

    private String name;
    private int age;
    private String color;
    private boolean isEvil;

    public Gremlin(){

    }

    public Gremlin(String name, int age, String color, boolean isEvil){
        this.name = name;
        this.age = age;
        this.color = color;
        this.isEvil = isEvil;
    }

    public String getName() {
        return name;
    }

    public Gremlin setName(String name) {
        this.name = name;
        return this;
    }

    public int getAge() {
        return age;
    }

    public Gremlin setAge(int age) {
        this.age = age;
        return this;
    }

    public String getColor() {
        return color;
    }

    public Gremlin setColor(String color) {
        this.color = color;
        return this;
    }

    public boolean isEvil() {
        return isEvil;
    }

    public Gremlin setEvil(boolean evil) {
        isEvil = evil;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Gremlin gremlin = (Gremlin) o;
        return age == gremlin.age && isEvil == gremlin.isEvil && Objects.equals(name, gremlin.name) && Objects.equals(color, gremlin.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, color, isEvil);
    }

    @Override
    public String toString() {
        return "Gremlin{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", color='" + color + '\'' +
                ", isEvil=" + isEvil +
                '}';
    }
}
