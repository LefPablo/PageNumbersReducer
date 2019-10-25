public class PageNumbersReducer {
    public static void main( String[] args) {
        String source = "4,5,12,16,2,7,6,15,13,11";
        System.out.println(pageNumbersReducer("2, 4, 6, 7, 11, 13, 14, 15, 16"));
    }

    public static int[] stringToArray( String str) {
        String[] source = str.split(","); //split string on parts by comma

        //creat array with exactly size (valid numbers)
        int c = 0;
        for(int i = 0; i < source.length; i++) {
            try {
                Integer.parseInt(source[i].trim());
                c++;
            } catch (NumberFormatException e) {

            }
        }
        int[] array = new int[c];

        //fill array with numbers of pages
        c = 0;
        for(int i = 0; i < source.length; i++) {
            try {
                array[c] = Integer.parseInt(source[i].trim());
                c++;
            } catch (NumberFormatException e) {
                System.out.println(e);
            }
        }
        return array;
    }

    public static int[] sort(int[] array) {
        int last = array.length - 1;
        int max = 0;
        int buf = 0;

        //Selection sort
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
        int c = 0;
        int s = 0;
        String result = "";

        //initial values (if array not empty)
        if( array.length > 0) {
            c = array[0];
            s = array[0];
            result = String.valueOf(array[0]);
        }

        //reduce
        for( int i = 1; i < array.length; i++ ) {
            //if current item not in sequence
            if( array[i] != (c + 1)) {
                //if pages in sequence large than 1 then reduce pages
                if ((c - s) > 1) {
                    result += ("-" + array[i - 1]);
                //if pages in sequence equal 1 then comma separated
                } else if ((c - s) == 1){
                    result += ",";
                    result += array[i-1];
                }
                //write current item
                result += ",";
                result += array[i];
                c = array[i];
                s = array[i];
            //close sequence in the end of cycle
            } else if (i == (array.length-1)) {
                if ((c - s) > 1) {
                    result += ("-" + array[i]);
                } else {
                    result += ",";
                    result += array[i];
                }
            //add page to sequence
            } else {
                c++;
            }
        }

        return result;
    }

    public static String pageNumbersReducer( String str) {
        return reducer(sort(stringToArray(str)));
    }
}
