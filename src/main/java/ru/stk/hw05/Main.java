package ru.stk.hw05;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        testPower();
        testBag();
    }

    private static void testPower(){
        System.out.println(Math.getPower(3, 3));
        System.out.println(Math.getPower(5, 3));
        System.out.println(Math.getPower(3, 0));
        System.out.println("---------------------------");
    }
    

    private static void testBag() {
        Bag bag = new Bag(10);
        bag.add(new Thing("Тертрадь", 2, 5));
        bag.add(new Thing("Ноутбук", 9, 50));
        bag.add(new Thing("Карандаш", 1, 3));
        bag.add(new Thing("Книга", 5, 10));
        bag.add(new Thing("Мышка", 2, 15));

        ArrayList<Thing> alt = bag.getBestSet();

        for (Thing t : alt){
            t.display();
        }
    }
}
