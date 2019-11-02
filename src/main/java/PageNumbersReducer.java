import java.util.*;

public class PageNumbersReducer {
    public static void main( String[] args) {
        String source = "1,5,8, 3, 4,2, 12,14 ,16,15jk"; //"1,5,8, 3, 4,2, 12,14 ,16,15jk,14,14";
        System.out.println(pageNumbersReducer(source));
    }

    public static Integer[] stringToArray(String str) {
        String[] source = str.split(","); //split string on parts by comma

        //creat array with exactly size (valid numbers)
        int size = 0;
        for(int i = 0; i < source.length; i++) {
            try {
                Integer.parseInt(source[i].trim());
                size++;
            } catch (NumberFormatException e) {

            }
        }
        Integer[] array = new Integer[size];

        //fill array with numbers of pages
        size = 0;
        for(int i = 0; i < source.length; i++) {
            try {
                array[size] = Integer.parseInt(source[i].trim());
                size++;
            } catch (NumberFormatException e) {
                System.out.println(e);
            }
        }
        return array;
    }

    public static Integer[] sortArray(Integer[] array) {
        Set<Integer> set = new HashSet<Integer>(Arrays.asList(array));
        array = new Integer[set.size()];
        array = set.toArray(array);
        Arrays.sort(array);

        return array;
    }

    public static String reducer( Integer[] array) {
        int currentPosition = 0;
        int startPosition = 0;
        String result = "";

        //initial values (if array not empty)
        if( array.length > 0) {
            currentPosition = array[0];
            startPosition = array[0];
            result = String.valueOf(array[0]);
        }

        //reduce
        for( int i = 1; i < array.length; i++ ) {
            //if current item not in sequence
            if( array[i] != (currentPosition + 1)) {
                //if pages in sequence large than 1 then reduce pages
                if ((currentPosition - startPosition) > 1) {
                    result += ("-" + array[i - 1]);
                //if pages in sequence equal 1 then comma separated
                } else if ((currentPosition - startPosition) == 1){
                    result += ",";
                    result += array[i-1];
                }
                //write current item
                result += ",";
                result += array[i];
                currentPosition = array[i];
                startPosition = array[i];
            } else {
                currentPosition++;    //add page to sequence
            }

            //close sequence in the end of cycle
            if (i == (array.length-1)) {
                if ((currentPosition - startPosition) > 1) {
                    result += ("-" + array[i]);
                } else if ((currentPosition - startPosition) == 1) {
                    result += ",";
                    result += array[i];
                }
            }
        }

        return result;
    }

    public static String pageNumbersReducer( String str) {
        return reducer(sortArray(stringToArray(str)));
    }
}
