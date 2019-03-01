package com.kyrychenko.xml;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;


@XmlRootElement(name = "beer")
public class Beer {
    private String name;
    private BeerType type;
    private String manufacturer;
    private List<BeerIngredient> ingredients;
    private List<BeerChars> chars;
    private boolean alcohol;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BeerType getType() {
        return type;
    }

    public void setType(BeerType type) {
        this.type = type;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public List<BeerIngredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<BeerIngredient> ingredients) {
        this.ingredients = ingredients;
    }

    public List<BeerChars> getChars() {
        return chars;
    }

    public void setChars(List<BeerChars> chars) {
        this.chars = chars;
    }

    public boolean isAlcohol() {
        return alcohol;
    }

    public void setAlcohol(boolean alcohol) {
        this.alcohol = alcohol;
    }

    @Override
    public String toString() {
        return "Beer{" +
                "name='" + name + '\'' +
                ", type=" + type +
                ", manufacturer='" + manufacturer + '\'' +
                ", ingredients=" + ingredients +
                ", chars=" + chars +
                ", alcohol=" + alcohol +
                '}';
    }
}
