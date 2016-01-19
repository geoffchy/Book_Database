
public class BookRatingSelectionSort {
	
	public static Book[] selectionSort(Book[] book)

	{
		for(int i = book.length - 1; i >= 0; i--)		// start at the end of the array
		{	
			// set default value for highest value to last index
			int highestIndex = i;				
			for(int j = i; j >= 0; j--)			
			{
				// comparing element to current highest, if it is higher becomes the new highest
				if(book[j].getRating() > book[highestIndex].getRating())
					highestIndex = j;		
			}
			// swapping two values being compared
			Book temp = book[i];
			book[i] = book[highestIndex];
			book[highestIndex] = temp;
		}
		return book;

	}
}
