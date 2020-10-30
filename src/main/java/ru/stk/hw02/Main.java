package ru.stk.hw02;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        //testArray();


        int bigSize = 100000;
        int[] bigArr = new int[bigSize];

        for (int i = 0; i < bigSize; i++) {
            bigArr[i] = (int) (Math.random() * 1000);
        }
        int[] bubbleArr = Arrays.copyOf(bigArr,100000);
        int[] selectArr = Arrays.copyOf(bigArr,100000);
        int[] insertArr = Arrays.copyOf(bigArr,100000);

        System.out.println("bubble sort timing: " + sortBubbleCheck(bubbleArr) + " ms");
        System.out.println("select sort timing: " + sortSelectCheck(selectArr) + " ms");
        System.out.println("select sort timing: " + sortInsertCheck(insertArr) + " ms");

    }

    private static void testArray(){

        // array add, remove and search
        MyArray arr = new MyArray();
        arr.add(10);
        arr.add(8);
        arr.add(3);
        arr.add(7);
        arr.add(12);

        arr.printArray();

        System.out.println("Element removed - " + arr.remove(2));

        arr.printArray();

        System.out.println(arr.search(12));
        System.out.println(arr.search(112));

    }


    public static long sortBubbleCheck(int[] array) {
        long st, en;

        st = System.nanoTime();
        array = sortBubble(array);
        en = System.nanoTime();

/*        for (int i = 0; i < 100; i++) {
            System.out.print(array[i]+ ", ");
        }
        System.out.println();*/
        return ((en - st) / 1000000);
    }

    public static long sortSelectCheck(int[] array) {
        long st, en;

        st = System.nanoTime();
        array = sortSelect(array);
        en = System.nanoTime();

/*        for (int i = 0; i < 100; i++) {
            System.out.print(array[i]+ ", ");
        }
        System.out.println();*/
        return ((en - st) / 1000000);
    }

    public static long sortInsertCheck(int[] array) {
        long st, en;

        st = System.nanoTime();
        array = sortInsert(array);
        en = System.nanoTime();

/*        for (int i = 0; i < 100; i++) {
            System.out.print(array[i]+ ", ");
        }
        System.out.println();*/
        return ((en - st) / 1000000);
    }

    private static int[] sortBubble(int[] array){
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length  - 1 - i; j++) {
                if (array[j] > (array[j + 1])) {
                    swap(array, j, j + 1);
                }
            }
        }
        return array;
    }

    private static int[] sortSelect(int[] array){

        for (int i = 0; i < array.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            swap(array, minIndex, i);
        }
        return array;
    }

    private static int[] sortInsert(int[] array){

        for (int i = 1; i < array.length; i++) {
            int temp = array[i];
            int in = i;
            while (in > 0 && array[in - 1] >= temp) {
                array[in] = array[in - 1];
                in--;
            }
            array[in] = temp;
        }
        return array;
    }

    private static void swap(int[] array, int indexA, int indexB) {
        int temp = array[indexA];
        array[indexA] = array[indexB];
        array[indexB] = temp;
    }
}
