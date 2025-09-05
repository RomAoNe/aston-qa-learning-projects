package Lesson_5;

public class Main {
    public static void main(String[] args) {
        String[][] strings = {
                {"1", "2", "3", "4"},
                {"1", "2", "3", "4"},
                {"1", "2", "3", "4"},
                {"1", "2", "3", "4"}
        };

        try {
            int sum = sumArray(strings);
            System.out.println("Сумма элементов массива: " + sum);
        } catch (MyArraySizeException | MyArrayDataException exception) {
            System.out.println("Произошла ошибка: " + exception.getMessage());
            exception.printStackTrace();
        }

        try {
            System.out.println("Обращаюсь к ячейке за пределами массива: " + strings[5][5]);
        } catch (ArrayIndexOutOfBoundsException exception) {
            System.out.println("Ошибка: " + exception.getMessage());
            exception.printStackTrace();
        }
    }

    public static boolean hasFourColumns(String[][] strings) {
        for (int i = 0; i < strings.length; i++) {
            if (strings[i].length != 4) {
                return false;
            }
        }

        return true;
    }

    public static void checkArraySize(String[][] strings) {
        if (strings.length != 4 || hasFourColumns(strings) == false) {
            throw new MyArraySizeException("Массив должен иметь размер 4*4");
        }
    }

    public static int sumArray(String[][] strings) {
        checkArraySize(strings);

        int sum = 0;

        for (int i = 0; i < strings.length; i++) {
            for (int j = 0; j < strings[i].length; j++) {
                try {
                    int value = Integer.parseInt(strings[i][j]);
                    sum += value;
                } catch (NumberFormatException exception) {
                    throw new MyArrayDataException("В ячейке ["
                            + i + "][" + j + "] - \'" + strings[i][j] + "\' вместо числа");
                }
            }
        }

        return sum;
    }
}