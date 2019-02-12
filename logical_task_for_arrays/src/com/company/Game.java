package com.company;

import java.util.Random;
import java.util.Scanner;

public class Game {
    static int[] a = new int[10];
    static int power = 25;

    public static int death(int[] a){
        int k = 0 ;
        for (int i = 0; i <a.length ; i++) {
            if(power < a[i]){
                k++;
            }
        }
        return k ;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double d = sc.nextDouble();
        double v = sc.nextDouble();
        System.out.println(d);
        int sum = 25;
        Random rand = new Random();
        for (int i = 0; i < 10 ; i++) {
            a[i]=  rand.nextInt(180)-100;
        }
        for (int i = 0; i < 10; i++) {
            System.out.print("number of the door: "+ (i+1));
            if (a[i]>=0){
                System.out.print(" artifact");
            }else{
                System.out.print(" monster");
            }
            System.out.println(" power: "+ a[i] );
        }

        for (int i = 0; i < 10; i++) {
            sum += a[i];
        }
        if(sum<0){
            System.out.println("unreal");
        }
        for (int i = 0; i < 10; i++) {
            if(a[i]>0){
                System.out.print(" door "+(i+1));
            }
        }
        for (int i = 0; i < 10; i++) {
            if(a[i]<0){
                System.out.print(" door "+(i+1));
            }
        }
    }
}
