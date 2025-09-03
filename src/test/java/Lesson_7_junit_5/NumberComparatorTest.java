package Lesson_7_junit_5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NumberComparatorTest {
    @Test
    @DisplayName("Сравнение 11 и 5: первое больше второго")
    public void compareWhenFirstIsBiggerTest() {
        NumberComparator numberComparator = new NumberComparator(11, 5);
        int expected = 1;
        int result = numberComparator.compare();
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Сравнение 5 и 10: первое меньше второго")
    public void compareWhenFirstIsSmallerTest() {
        NumberComparator numberComparator = new NumberComparator(5, 10);
        int expected = -1;
        int result = numberComparator.compare();
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Сравнение 5 и 5: числа равны")
    public void compareWhenEqualsTest() {
        NumberComparator numberComparator = new NumberComparator(5, 5);
        int expected = 0;
        int result = numberComparator.compare();
        assertEquals(expected, result);
    }
}