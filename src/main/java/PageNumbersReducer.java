public class PageNumbersReducer {
    public static void main( String[] args) {
        String source = "4,5,12,16,2,7,6,15,13,11";
        System.out.println(pageNumbersReducer(source));
    }

    public static int[] stringToArray( String str) {
        String[] source = str.split(",");
        int[] array = new int[source.length];

        for(int i = 0; i < source.length; i++) {
            array[i] = Integer.parseInt(source[i].trim());
        }
        return array;
    }

    public static int[] heapSort( int[] array) {
        int last = array.length - 1;
        int max = 0;
        int buf = 0;

        for( int i = last; i > 0; i--) {
            max = 0;
            for( int j = 1; j <= i; j++) {
                if(array[j] > array[max]) {
                    max = j;
                }
            }
            buf = array[i];
            array[i] = array[max];
            array[max] = buf;
        }

        return array;
    }

    public static String reducer( int[] array) {
        int c = array[0]+1;
        int s = array[0];
        String result = String.valueOf(array[0]);

        for( int i = 1; i < array.length; i++ ) {
            if( array[i] != c || i == (array.length-1)) {
                if ((c - s) > 1) {
                    result += ("-" + array[i - 1]);
                }
                result += ",";
                result += array[i];
                c = array[i];
                s = array[i];
            }
            c++;
        }

        return result;
    }

    public static String pageNumbersReducer( String str) {
        return reducer(heapSort(stringToArray(str)));
    }
}
