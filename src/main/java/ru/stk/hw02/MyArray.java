package ru.stk.hw02;

import java.util.Arrays;

public class MyArray {
    private int size;
    private Integer[] array;

    public MyArray(){
        this.size = 0;
        array = new Integer[size];
    }

    public Integer[] getArray(){
        return array;
    }

    public void add(int value){
        grow();
        array[size] = value;
        size++;
    }

    public Integer remove (int index){

        if (!checkIndex(index)){ return null; };

        Integer removed = array[index];
        System.arraycopy(array, index + 1, array, index, size - 1 - index);

        array[size - 1] = null;
        size--;
        return removed;
    }

    public Integer search (Integer value){
        for (int i = 0; i < size; i++) {
            if (value.equals(array[i])){
                return i;
            }
        }
        return null;
    }

    public void printArray(){
        StringBuilder s = new StringBuilder("[");
        for (int i = 0; i < size - 1; i++) {
            s.append(array[i]);
            s.append(", ");
        }
        if (size > 0) {
            s.append(array[size - 1]);
        }
        s.append("]");
        System.out.println(s);
    }

    private void grow() {
        int newSize;
        if (size == 0){
            newSize = 1;
        } else {
            newSize = size * 2;
        }

        if (array.length == size) {
            array = Arrays.copyOf(array, newSize);
        }
    }

    private boolean checkIndex(int index){
        return index >= 0 && index < size;
    }





}











