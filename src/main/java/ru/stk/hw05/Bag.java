package ru.stk.hw05;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.ThreadFactory;

public class Bag {
    //possible things to fill
    private ArrayList<Thing> things = new ArrayList<>();
    //best set (weight / value) to fill the bag
    private ArrayList<Thing> bestList = new ArrayList<>();
    //all possible sets
    private HashSet<ArrayList<Thing>> allSets = new HashSet<>();
    private int capacity;

    public Bag (int capacity){
        this.capacity = capacity;
    }

    public void add(Thing thing){
         things.add(thing);
    }

    public ArrayList<Thing> getBestSet(){

        if (things.size() == 0) return null;


        //shift of things for one position each cycle
        for (int i = 0; i < things.size(); i++) {
            oneShift(things);
            ArrayList<Thing> curList = new ArrayList<>(things);
            genSet(curList);
        }

        calcBestSet();
        return bestList;
    }

    private void oneShift(ArrayList<Thing> list) {
        Thing tmp;
        tmp =  list.get(0);
        for (int i = 1; i < list.size(); i++) {
            list.set(i - 1, list.get(i));
        }
        list.set(list.size() - 1, tmp);
    }

    private void genSet(ArrayList<Thing> list){
        if (list.size() == 0){
            return;
        }
        ArrayList<Thing> l = new ArrayList<>(list);
        allSets.add(l);
        list.remove(0);
        genSet(list);
    }

    private void calcBestSet(){
        int curWeight;
        int curPrice;
        int bestPrice = 0;

        Iterator<ArrayList<Thing>> it = allSets.iterator();
        ArrayList<Thing> curList = new ArrayList<>();
        for (int i = 0; i < allSets.size(); i++) {
            while (it.hasNext()){
                curList = it.next();
                curWeight = getListWeight(curList);
                curPrice = getListPrice(curList);
                if ((curWeight <= capacity) && (curPrice > bestPrice)) {
                    bestPrice = curPrice;
                    bestList = curList;
                }
            }
        }
    }

    private int getListWeight (ArrayList<Thing> list){
        int weight = 0;
        for (Thing s: list){
            weight += s.getWeight();
        }
        return weight;
    }

    private int getListPrice (ArrayList<Thing> list){
        int price = 0;
        for (Thing s: list){
            price += s.getPrise();
        }
        return price;
    }

}
















