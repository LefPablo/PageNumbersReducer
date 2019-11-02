import org.junit.Assert;
import org.junit.Test;

public class PageNumbersReducerTest {

    @Test
    public void stringToArray() {
        String source = "4,5,12,16,2,7,6,15,13,11";

        Integer[] actual = {4, 5, 12, 16, 2, 7, 6, 15, 13, 11};
        Integer[] expected = PageNumbersReducer.stringToArray(source);

        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void stringToArray_Spaces_In_Source() {
        String source = " 4,5, 12 ,16,2 , 7,6,15,13 ,11";

        Integer[] actual = {4, 5, 12, 16, 2, 7, 6, 15, 13, 11};
        Integer[] expected = PageNumbersReducer.stringToArray(source);

        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void stringToArray_Empty_Source() {
        String source = "";

        Integer[] actual = {};
        Integer[] expected = PageNumbersReducer.stringToArray(source);

        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void stringToArray_One_Page() {
        String source = "3";

        Integer[] actual = {3};
        Integer[] expected = PageNumbersReducer.stringToArray(source);

        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void sort() {
        Integer[] source = {4, 5, 12, 16, 2, 7, 6, 15, 13, 11};

        Integer[] actual = {2, 4, 5, 6, 7, 11, 12, 13, 15, 16};
        Integer[] expected = PageNumbersReducer.sortArray(source);

        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void sort_One_item() {
        Integer[] source = {4};

        Integer[] actual = {4};
        Integer[] expected = PageNumbersReducer.sortArray(source);

        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void sort_Empty_Array() {
        Integer[] source = {};

        Integer[] actual = {};
        Integer[] expected = PageNumbersReducer.sortArray(source);

        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void reducer() {
        Integer[] source = {2, 4, 5, 6, 7, 11, 12, 13, 15, 16};

        String actual = "2,4-7,11-13,15,16";
        String expected = PageNumbersReducer.reducer(source);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void reducer_Reduce_In_Begin() {
        Integer[] source = {3, 4, 5, 6, 7, 11, 13, 15, 16};

        String actual = "3-7,11,13,15,16";
        String expected = PageNumbersReducer.reducer(source);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void reducer_Reduce_In_End() {
        Integer[] source = {2, 4, 6, 7, 11, 14, 15, 16};

        String actual = "2,4,6,7,11,14-16";
        String expected = PageNumbersReducer.reducer(source);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void pageNumbersReducer() {
        String source = "1,5,8, 3, 4,2, 12,14 ,16,15jk";
        String actual = "1-5,8,12,14,16";

        Integer[] array = PageNumbersReducer.stringToArray(source);
        Integer[] sortedArray = PageNumbersReducer.sortArray(array);
        String expected = PageNumbersReducer.reducer(sortedArray);

        Assert.assertEquals(expected, actual);
    }
}