package com.company;

import java.io.Serializable;

public class Droid implements Serializable {

    private String name;
    private int armorAmount;
    private int weaponsAmount;
    private transient Army army;
    private int weaponsPower;

    public Droid(String name, int armorAmount, int weaponsAmount, int weaponsPower) {
        this.name = name;
        this.armorAmount = armorAmount;
        this.weaponsAmount = weaponsAmount;
        this.weaponsPower = weaponsPower;
    }

    public Army getArmy() {
        return army;
    }

    public void setArmy(Army army) {
        this.army = army;
    }

    public Droid() {
    }

    public String getName() {
        return name;
    }

    public int getArmorAmount() {
        return armorAmount;
    }

    public int getWeaponsAmount() {
        return weaponsAmount;
    }

    public int getWeaponsPower() {
        return weaponsPower;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return "Droid{" +
                "name='" + name + '\'' +
                ", armorAmount=" + armorAmount +
                ", weaponsAmount=" + weaponsAmount +
                ", army=" + army +
                ", weaponsPower=" + weaponsPower +
                '}';
    }
    //comment

}
