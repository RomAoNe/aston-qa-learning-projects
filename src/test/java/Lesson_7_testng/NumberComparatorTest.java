package Lesson_7_testng;

import org.testng.Assert;
import org.testng.annotations.Test;

public class NumberComparatorTest {
    @Test(description = "10 > 5")
    public void testCompareWhenFirstIsBigger(){
        NumberComparator numberComparator = new NumberComparator(10,5);
        int expected = 1;
        int result = numberComparator.compare();
        Assert.assertEquals(result, expected);
    }

    @Test(description = "5 < 10")
    public void testCompareWhenFirstIsSmaller(){
        NumberComparator numberComparator = new NumberComparator(5, 10);
        int expected = -1;
        int result = numberComparator.compare();
        Assert.assertEquals(result, expected);
    }

    @Test(description = "10 = 10")
    public void testCompareWhenEquals(){
        NumberComparator numberComparator = new NumberComparator(10, 10);
        int expected = 0;
        int result = numberComparator.compare();
        Assert.assertEquals(result, expected);
    }
}