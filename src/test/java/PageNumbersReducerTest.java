import org.junit.Assert;
import org.junit.Test;

public class PageNumbersReducerTest {

    @Test
    public void stringToArray() {
        String source = "4,5,12,16,2,7,6,15,13,11";

        int[] actual = {4, 5, 12, 16, 2, 7, 6, 15, 13, 11};
        int[] expected = PageNumbersReducer.stringToArray(source);

        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void stringToArray_Spaces_In_Source() {
        String source = " 4,5, 12 ,16,2 , 7,6,15,13 ,11";

        int[] actual = {4, 5, 12, 16, 2, 7, 6, 15, 13, 11};
        int[] expected = PageNumbersReducer.stringToArray(source);

        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void stringToArray_Empty_Source() {
        String source = "";

        int[] actual = {};
        int[] expected = PageNumbersReducer.stringToArray(source);

        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void stringToArray_One_Page() {
        String source = "3";

        int[] actual = {3};
        int[] expected = PageNumbersReducer.stringToArray(source);

        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void sort() {
        int[] source = {4, 5, 12, 16, 2, 7, 6, 15, 13, 11};

        int[] actual = {2, 4, 5, 6, 7, 11, 12, 13, 15, 16};
        int[] expected = PageNumbersReducer.sort(source);

        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void sort_One_item() {
        int[] source = {4};

        int[] actual = {4};
        int[] expected = PageNumbersReducer.sort(source);

        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void sort_Empty_Array() {
        int[] source = {};

        int[] actual = {};
        int[] expected = PageNumbersReducer.sort(source);

        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void reducer() {
        int[] source = {2, 4, 5, 6, 7, 11, 12, 13, 15, 16};

        String actual = "2,4-7,11-13,15,16";
        String expected = PageNumbersReducer.reducer(source);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void reducer_Reduce_In_Begin() {
        int[] source = {3, 4, 5, 6, 7, 11, 13, 15, 16};

        String actual = "3-7,11,13,15,16";
        String expected = PageNumbersReducer.reducer(source);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void reducer_Reduce_In_End() {
        int[] source = {2, 4, 6, 7, 11, 13, 14, 15, 16};

        String actual = "2,4,6,7,11,13-16";
        String expected = PageNumbersReducer.reducer(source);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void pageNumbersReducer() {
        String source = "4,5,12,16,2,7,6,15,13,11";

        String actual = "2,4-7,11-13,15,16";
        int[] array = PageNumbersReducer.stringToArray(source);
        int[] sortedArray = PageNumbersReducer.sort(array);
        String expected = PageNumbersReducer.reducer(sortedArray);

        Assert.assertEquals(expected, actual);
    }
}