package ru.stk.hw05;

public class Thing {

    private String name;
    private int weight;
    private int prise;


    public Thing(String name, int weight, int prise) {
        this.name = name;
        this.weight = weight;
        this.prise = prise;
    }

    public int getPrise() {
        return prise;
    }

    public int getWeight() {
        return weight;
    }

    public void display(){
        System.out.println(name + " " + weight + " " + prise);
    }
}
