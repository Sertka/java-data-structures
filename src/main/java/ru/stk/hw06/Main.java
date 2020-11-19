package ru.stk.hw06;

public class Main {

    public static void main(String[] args) {
        fillTree(3, 20);
        fillTree(4, 20);
        fillTree(5, 20);
        fillTree(6, 20);
        fillTree(7, 20);
    }

    private static void fillTree(int depth, int amount) {
        int balanced = 0;
        for (int i = 0; i < amount; i++) {
            Tree<Integer> tree = new TreeImpl<>(depth);
            int n = (int)Math.pow(2, depth) - 1;
            for (int j = 0; j <(n) ; j++) {
               tree.add(getRandomNum(-100, 100));
            }
            if (tree.isTreeBalanced()) {
                balanced++;
            }
        }
        System.out.println("Balanced " + balanced + " trees of " + amount);

    }

    private static int getRandomNum(int a, int b) {
        if (b < a) { return getRandomNum(b, a);}
        return a + (int) ((1 + b - a) * Math.random());
    }

}
