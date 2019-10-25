import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class PageNumbersReducerTest {

    @Test
    public void stringToArray() {
        String source = "4,5,12,16,2,7,6,15,13,11";

        int[] actual = {4, 5, 12, 16, 2, 7, 6, 15, 13, 11};
        int[] expected = PageNumbersReducer.stringToArray(source);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void heapSort() {
        int[] source = {4, 5, 12, 16, 2, 7, 6, 15, 13, 11};

        int[] actual = {2, 4, 5, 6, 7, 11, 12, 13, 15, 16};
        int[] expected = PageNumbersReducer.heapSort(source);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void reducer() {
        int[] source = {2, 4, 5, 6, 7, 11, 12, 13, 15, 16};

        String actual = "2,4-7,11-13,15,16";
        String expected = PageNumbersReducer.reducer(source);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void pageNumbersReducer() {
        String source = "4,5,12,16,2,7,6,15,13,11";

        String actual = "2,4-7,11-13,15,16";
        int[] array = PageNumbersReducer.stringToArray(source);
        int[] sortedArray = PageNumbersReducer.heapSort(array);
        String expected = PageNumbersReducer.reducer(sortedArray);

        Assert.assertEquals(expected, actual);
    }
}