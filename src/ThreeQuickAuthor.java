//USED FOR TESTING ONLY!!!
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class ThreeQuickAuthor {


	private static final int CUTOFF = 30;

	private ThreeQuickAuthor(){}
	
	//User inputs the collection of books with only parameter as the collection
	public static void sortAuthor(Book[] book){
		//System.out.println(book[0].getAuthor());
		sortAuthor(book, 0, book.length-1,0);//Calls other sortAuthor inputing the lowest value, the highest value (the length of the books array)
		
		assert isSorted(book);//Checks if the collection is sorted
	}
	//Returns the character d of the novel being sorted
	private static int character(Book book, int d){
		int bookLength = book.getAuthor().length();
		assert d >=0 && d <= bookLength;
		if (d== bookLength) return  -1;
		return book.getAuthor().charAt(d);
	}
	//Sorts the books by author
	private static void sortAuthor(Book[] book, int low, int high, int d){
		if (high <= low + CUTOFF){
			insertAuthor(book, low, high, d);
			return;
		}
		
		int lt = low;
		int gt = high;
		int i = low + 1;
		//Takes the character of the first compared novel author
		//char v = book[low].getAuthor().charAt(d);
		int v = character(book[low],d);
		while (i<=gt){
			//Takes every other author one at a time to compare to book[low]
			int t = character(book[low],d);
			if (t < v){
				exchange(book, lt++,i++);
			}
			else if (t>v){
				exchange(book,i,gt--);
			}
			else i++;
		}
		//Calls itself to recursively sort sub-array of novels
		sortAuthor(book, low, lt-1,d);
		if (v>=0){
			sortAuthor(book,lt,gt,d+1);
			sortAuthor(book, gt+1, high,d);
		}
		
	}	
		private static void insertAuthor(Book[] book, int low, int high, int d){
			for (int i=low; i <=high; i++){
				for (int j = i; j>low && less(book[j],book[j-1], d);j--){
					exchange(book,j,j-1);
				}
			}
		}
		
		//Swaps the two novels
		private static void exchange(Book[]book, int i, int j){
			//Temp is a placeholder novel data structure fow swapping
			Book temp = book[i];
			//The smaller element in the array becomes the larger element
			book[i] = book[j];
			// The larger element is placed in its respective area
			book[j] = temp;
		}
		
		private static boolean less(Book x,Book y , int d){
			// Gets the two names of the author
			String firstBook = x.getAuthor();
			String secondBook = y.getAuthor();
			//Checks to see if they are equal
			assert firstBook.substring(0, d).equals(secondBook.substring(0, d));
			
			//For loop to determine which character has a lower value
			for (int i = d; i< Math.min(firstBook.length(),secondBook.length());i++ ){
				if(firstBook.charAt(i) < secondBook.charAt(i)) return true;
				if (firstBook.charAt(i) > secondBook.charAt(i)) return false;
			}
			return firstBook.length() < secondBook.length();
		}
		
		//Checks to see if the novels are already sorted
		private static boolean isSorted(Book[]book){
			for (int i = 1; i<book.length;i++){
				if (book[i].getAuthor().compareTo(book[i-1].getAuthor()) <0){
					return false;
				}
			}return true;
				

		}
		
	//Main Function for Testing. Not actually part of the program
		public static void main(String[]args) throws FileNotFoundException{
			Scanner input = new Scanner(new File("data/Input.txt"));
			Book [] collection = new Book[20];
			for(int i=0; i<20; i++){
				

					String[] book = input.nextLine().split(",");
					Book book2 = new Book(book);
					//System.out.println(book2.getAuthor());
					collection[i] = (book2);
					//System.out.println(book2.getAuthor().length());
				
				
				
				
			}
			//System.out.println(collection.length);
			ThreeQuickAuthor.sortAuthor(collection);
			
			for (int i =0; i< 20; i++ )
			System.out.println(collection[i].getAuthor());
		}

		}		


