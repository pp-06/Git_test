package com.example.JavaCollection.collections;

import java.util.ArrayList;
import java.util.Iterator;

public class CollectionArrayList {
    public static void main(String[] args) {
        ArrayList al = new ArrayList();
        al.add("Sanandh");
        al.add("Ayush");
        al.add("Parth");
        al.add(1,"Adarsh");

        Iterator it = al.iterator();

        while (it.hasNext()){
            System.out.println(it.next());
        }

    }
}
