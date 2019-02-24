package com.company;

import java.io.*;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Droid droid = new Droid("droid",1,2,3 );
        droid.setArmy(new Army());
        Ship ship = new Ship();
        ship.setDroids(Arrays.asList(droid));

        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("droids.dat"));
        out.writeObject(ship);
        out.close();

        ObjectInputStream in= new ObjectInputStream(new FileInputStream("droids.dat"));
        Ship shipFromFile = (Ship)in.readObject();
        System.out.println(shipFromFile);
        in.close();
    }
}
