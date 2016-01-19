
public class BookLengthInsertionSort {
 
    public static void insertionSort(Book[] book) {
    	
        for (int i = 0; i < book.length; i++) {
        	
        	// set first value to be sorted to first index
            Book valueToSort = book[i];
            
            // creating temp variable so nothing is lost
            int j = i;
            
            // checking to see if value being sorted is smaller than the next value
            while (j > 0 && book[j - 1].getLength() > valueToSort.getLength()) {
            	
            	// if it is swaps the two
                book[j] = book[j - 1];
                j--;
            }
           book[j] = valueToSort;
        }
    }
 

}