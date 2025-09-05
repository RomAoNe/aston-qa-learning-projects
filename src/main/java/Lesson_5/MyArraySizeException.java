package Lesson_5;

public class MyArraySizeException extends RuntimeException {
    public MyArraySizeException(String wrongArraySize) {
        super(wrongArraySize);
    }
}
