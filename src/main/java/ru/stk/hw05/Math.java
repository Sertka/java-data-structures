package ru.stk.hw05;

public class Math {
     private static int result;

    public static int getPower (int number, int power){
        result = number;

        if (power == 0) return 1;

        if (power == 1){
            return number;
        }

        if (power < 0) {
            throw new ArithmeticException("Power value must be positive!");
        }

        calcPower(number, power);
        return result;
    }

    private static void calcPower(int number, int power) {
        if (power == 1) {
            return;
        }
        result = result * number;
        power--;
        calcPower(number, power);
    }
}
