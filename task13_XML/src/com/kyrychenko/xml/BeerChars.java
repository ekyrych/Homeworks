package com.kyrychenko.xml;

public class BeerChars {
    private String name;
    private String value;

    public BeerChars(String name, String value) {
        this.name = name;
        this.value = value;
    }

    public BeerChars() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "BeerChars{" +
                "name='" + name + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
