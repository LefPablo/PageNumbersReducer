public class PageNumbersReducer {
    public static void main( String[] args) {

    }

    public static int[] toArray( String str) {
        int[] array = new int[] {};
        return array;
    }

    public static int[] heapSort( int[] array) {
        return array;
    }

    public static String reducer( int[] array) {
        String result = "";
        return result;
    }

    public static String pageNumbersReducer( String str) {
        return reducer(heapSort(toArray(str)));
    }
}
