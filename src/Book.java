
public class Book {
	
	// initiate default values for variables
	private String title = "";
	private String author = "";
	private int length = 0;
	private int rating = 0;
	
	Book(String[] books){
		
		// set values from input array
		title = books[0];
		author = books[1];
		
		// reads integers from string values passed in
		length = Integer.parseInt(books[2]);
		rating = Integer.parseInt(books[3]);
		
	}
	// returns title
	public String getTitle(){
		return title;
		
	}
	// returns Author
	public String getAuthor(){
		return author;
		
	}
	// returns book length
	public int getLength(){
		return length;
		
	}
	//returns rating
	public int getRating(){
		return rating;
		
	}
	
}
