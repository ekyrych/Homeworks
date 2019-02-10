package com.company;

import java.util.Arrays;

public class Main {
    public static int[] update(int newSize,int[] a){
        int[] c = new int[newSize];
        System.arraycopy(a,0,c,0,a.length);
        return c;
    }

    public static boolean containsInArray(int element,int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]== element){
                return true;
            }
        }
        return false;
    }

    public static int[] getGiff(int[]a,int[]b){
        int[] c = new int [0];
        int n=0;

        for (int i = 0; i < a.length; i++) {

            if (!containsInArray(a[i],b)){
                c = update(c.length+1,c);
                c[n]=a[i];
                n++;
            }

        }
        return c;
    }

    public static int[] concat(int[] first, int[] second) {
        int[] result = Arrays.copyOf(first, first.length + second.length);
        System.arraycopy(second, 0, result, first.length, second.length);
        return result;
    }

    public static int[] similarElements(int[] a,int[] b){
        int[] c = new int [0];
        int n=0;

        for (int i = 0; i < a.length; i++) {
            int k=0;
            if (containsInArray(a[i],b)){
                k++;
            }
            if (k >0){
                c = update(c.length+1,c);
                c[n]=a[i];
                n++;
            }

        }
        return c;
    }

    public static boolean isOccurredMoreThanNTimes(int b,int[] a,int n){
        int k = 0;
        for (int i = 0; i < a.length; i++) {
            if(a[i]== b){
                k++;
            }
        }
        return k >= n;
    }

    public static int[] removeElement(int[] arr,int index){
        System.arraycopy(arr,index+1,arr,index,arr.length-1-index);
        return arr;
    }

    public static int[] removeSeries(int[] a){
        int n = 0;
        int[] c = new int[0];
        for (int i = 0; i <a.length ; i++) {
            if(a[i]!=a[i-1]){
                c = update(c.length+1,c);
                c[n]=a[i];
                n++;
            }
        }
        return c;
    }

    public static int[] deleteSimilar(int[] a){
        int n = 0;
        int[] c = new int[0];
        for (int i = 0; i < a.length; i++) {

            if (isOccurredMoreThanNTimes(a[i],a, 2)){
                c = update(c.length+1,c);
                c[n]=a[i];
                n++;
            }

        }

        return getGiff(a, c);
    }

    public static int[] notSimilarElements(int[] a,int[] b){
        int[] diff1 = getGiff(a,b);
        int[] diff2 = getGiff(b,a);
        int[] diff = concat(diff1,diff2);
        return diff;
    }

    public static void main(String[] args) {
        int[] a = {1,2,2,2,10,15};
        int[] b = {2,7,14,35,8};

        int[] c = similarElements(a,b);
        for (int i = 0; i < c.length; i++) {
            System.out.println(c[i]);
        }
        System.out.println(" -------------- ");
        c = removeSeries(a);
        for (int i = 0; i < c.length; i++) {
            System.out.println(c[i]);
        }


    }
}
