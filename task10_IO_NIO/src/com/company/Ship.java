package com.company;

import java.io.Serializable;
import java.util.List;

public class Ship implements Serializable {
    private List<Droid> droids;

    public List<Droid> getDroids() {
        return droids;
    }

    public void setDroids(List<Droid> droids) {
        this.droids = droids;
    }

    @Override
    public String toString() {
        return "Ship{" +
                "droids=" + droids +
                '}';
    }
}
