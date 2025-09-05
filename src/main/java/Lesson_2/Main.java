package Lesson_2;

public class Main {
    public static void main(String[] args) {
        printThreeWords();
        printSumSign();
        printColor();
        compareNumbers();
        isSumInRange(14, -3);
        printNumberSign(14);
        isNumberNegative(-3);
        printStringMultipleTimes("I am a string of text", 9);
        isLeapYear(1200);
        changeNumbersInArray();
        fillArray();
        multiplyElements();
        replaceElementsWithNumber();
        getFilledArray(19, 8);
    }

    // Задача 1
    public static void printThreeWords() {
        String[] words = new String[]{"Orange", "Banana", "Apple"};

        for (int i = 0; i < words.length; i++) {
            System.out.println(words[i]);
        }

        System.out.println();
    }

    // Задача 2
    public static void printSumSign() {
        int a = 12;
        int b = -34;
        int sum = a + b;

        if (sum >= 0) {
            System.out.println("Сумма положительная");
        } else {
            System.out.println("Сумма отрицательная");
        }

        System.out.println();
    }

    //задача 3
    public static void printColor() {
        int value = 123;
        int redBoundary = 0;
        int yellowBoundary = 100;

        if (value <= redBoundary) {
            System.out.println("Красный");
        } else if (value > redBoundary && value <= yellowBoundary) {
            System.out.println("Желтый");
        } else {
            System.out.println("Зеленый");
        }

        System.out.println();
    }

    // Задача 4
    public static void compareNumbers() {
        int a = -3;
        int b = -44;

        if (a >= b) {
            System.out.println("a >= b");
        } else {
            System.out.println("a < b");
        }

        System.out.println();
    }

    // Задача 5
    public static boolean isSumInRange(int firstSummand, int secondSummand) {
        int sum = firstSummand + secondSummand;
        int upperBoundary = 20;
        int lowerBoundary = 10;

        return sum >= lowerBoundary && sum <= upperBoundary;
    }

    // Задача 6
    public static void printNumberSign(int number) {
        if (number >= 0) {
            System.out.println("Позитивное");
        } else {
            System.out.println("Негативное");
        }

        System.out.println();
    }

    // Задача 7
    public static boolean isNumberNegative(int number) {
        return number < 0;
    }

    // Задача 8
    public static void printStringMultipleTimes(String stringToPrint, int times) {
        for (int i = 0; i < times; i++) {
            System.out.println(stringToPrint);
        }
    }

    // Задача 9
    public static boolean isLeapYear(int year) {
        int divisorFor4 = 4;
        int divisorFor100 = 100;
        int divisorFor400 = 400;

        if (year % divisorFor4 == 0) {
            return year % divisorFor100 != 0 || year % divisorFor400 == 0;
        } else {
            return false;
        }
    }

    // Задача 10
    public static void changeNumbersInArray() {
        int[] binaryArray = {0, 1, 1, 1, 0, 0, 1, 0, 1, 1, 0, 1, 0, 0, 0, 1, 0, 1, 0, 0};

        for (int i = 0; i < binaryArray.length; i++) {
            if (binaryArray[i] == 0) {
                binaryArray[i] = 1;
            } else {
                binaryArray[i] = 0;
            }
        }
    }

    // Задача 11
    public static void fillArray() {
        int step = 1;
        int[] arrayToFill = new int[100];

        for (int i = 0; i < arrayToFill.length; i++) {
            arrayToFill[i] = i + step;
        }
    }

    // Задача 12
    public static void multiplyElements() {
        int boundary = 6;
        int multiplier = 2;
        int[] numbers = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] < boundary) numbers[i] *= multiplier;
        }
    }

    // Задача 13
    public static void replaceElementsWithNumber() {
        int replacer = 1;
        int[][] squareArray = {
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0}
        };

        for (int i = 0; i < squareArray.length; i++) {
            squareArray[i][i] = replacer;
            squareArray[i][squareArray[i].length - 1 - i] = replacer;
        }
    }

    // Задача 14
    public static int[] getFilledArray(int len, int initialValue) {
        int[] arrayToReturn = new int[len];

        for (int i = 0; i < arrayToReturn.length; i++) {
            arrayToReturn[i] = initialValue;
        }

        return arrayToReturn;
    }
}