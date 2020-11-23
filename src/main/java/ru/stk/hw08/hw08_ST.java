package ru.stk.hw08;

public class hw08_ST {

    public static void main(String[] args) {
        HashTable<Product, Integer> hashTable = new HashTableLink<>(7);
      //  HashTable<Integer, Integer> hashTable = new HashTableLink<>(5);

        hashTable.put(new Product(1, "Orange"), 150);
        hashTable.put(new Product(2, "Banana"), 100);
        hashTable.put(new Product(2, "Carrot"), 228);
        hashTable.put(new Product(3, "Lemon"), 250);
        hashTable.put(new Product(4, "Milk"), 120);
        hashTable.put(new Product(5, "Potato"), 67);

//        hashTable.put(1, 150);
//        hashTable.put(2, 100);
//        hashTable.put(3, 228);
//        hashTable.put(4, 250);
//        hashTable.put(5, 120);
//        hashTable.put(6, 67);

        System.out.println("Size is " + hashTable.size());
        hashTable.display();


        System.out.println("Cost potato is " + hashTable.get(new Product(5, "Potato")));
        System.out.println("Cost banana is " + hashTable.get(new Product(2, "Banana")));

        hashTable.remove(new Product(5, "Potato"));
        hashTable.remove(new Product(2, "Banana"));

        System.out.println("Cost potato is " + hashTable.get(new Product(5, "Potato")));
        System.out.println("Cost banana is " + hashTable.get(new Product(2, "Banana")));

        hashTable.display();
    }
}
