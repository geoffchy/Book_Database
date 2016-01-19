//Used for testing purposes only

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class ThreeQuickTitle  {
	private static final int CUTOFF = 30;
	private ThreeQuickTitle(){}
	
	//public sort
	public static void sort (Book[] book){
		sort(book,0,book.length-1,0);
		assert isSorted(book);
	}
	
	//takes in a book and an integer as input and returns the character at that specific integer
	private static int charAt(Book book, int d){
		
		//Book title length
		int bookLength = book.getTitle().length();
		//Checks to determine if it is actually greater than zero and less than the total length of the string
		assert d >=0 && d <= bookLength;
		if (d== bookLength) return  -1;
		return book.getTitle().charAt(d);
	}
	//Private sort
	private static void sort(Book[] book, int low, int high, int d){
		if (high <= low + CUTOFF){
			insertion(book, low, high, d);
			return;
		}
		
		int lt = low;
		int gt = high;
		int i = low + 1;
		//Takes the character of the first compared novel author
		//char v = book[low].getAuthor().charAt(d);
		int v = charAt(book[low],d);
		while (i<=gt){
			//Takes every other author one at a time to compare to book[low]
			int t = charAt(book[low],d);
			if (t < v){
				exchange(book, lt++,i++);
			}
			else if (t>v){
				exchange(book,i,gt--);
			}
			else i++;
		}
		//Calls itself to recursively sort sub-array of novels
		sort(book, low, lt-1,d);
		if (v>=0){
			sort(book,lt,gt,d+1);
			sort(book,gt+1, high,d);
		}
	}	
	//Inserts the novels
		private static void insertion(Book[] book, int low, int high, int d){
			for (int i=low; i <=high; i++){
				for (int j = i; j>low && less(book[j],book[j-1], d);j--){
					exchange(book,j,j-1);
				}
			}
		}
		//Physically exchanges the novels
		private static void exchange(Book[]book, int i, int j){
			//Temporary store for a novel
			Book tempBook = book[i];
			//Swaps the two novels in the array
			book[i] = book[j];
			book[j] = tempBook;
		}
		//Determines which string(Title) has a lower value by comparing the characters
		private static boolean less(Book x,Book y, int d){
			//Gets the two titles and stores them as strings
			String firstBook = x.getTitle();
			String secondBook = y.getTitle();
			//Checks if they are equal
			assert firstBook.substring(0, d).equals(secondBook.substring(0, d));
			//Determines which has the lower value
			for (int i = d; i< Math.min(firstBook.length(),secondBook.length());i++ ){
				if(firstBook.charAt(i) < secondBook.charAt(i)) return true;
				else if (firstBook.charAt(i) > secondBook.charAt(i)) return false;
			}
			return firstBook.length() < secondBook.length();
		}
		
		//Checks to see if the array of books is already sorted
		private static boolean isSorted(Book[]book){
			for (int i = 1; i<book.length;i++){
				if (book[i].getTitle().compareTo(book[i-1].getTitle()) <0){
					return false;
				}
			}return true;
				
		}
		//MAIN FUNCTION FOR TESTING ONLY. PLEASE DISREGARD
		public static void main(String[]args) throws FileNotFoundException{
			Scanner input = new Scanner(new File("data/Input.txt"));
			Book [] collection = new Book[20];
			for(int i=0; i<20; i++){
				

					String[] book = input.nextLine().split(",");
					Book book2 = new Book(book);
					//System.out.println(book2.getTitle());
					collection[i] = (book2);
					//System.out.println(book2.getTitle().length());
			}
			//System.out.println(collection.length);
			ThreeQuickTitle.sort(collection);
			for (int i=0;i<20;i++){
				System.out.println(collection[i].getTitle());
			}
			
		
		
}
}

