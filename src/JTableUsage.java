import java.awt.FlowLayout;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class JTableUsage extends JFrame{
	DefaultTableModel model;
	JTable table;
	
	// set titles for all columns
	String col[] = {"Title","Author","Length","Rating"};

	public JTableUsage(){
		
	}
	
	public void start(int flag) throws FileNotFoundException{
		
		model = new DefaultTableModel(col,20);
		table=new JTable(model){
			
			// sets Cells so they are not editable
			public boolean isCellEditable(int arg0, int arg1){
				return false;}};
			
			JScrollPane pane = new JScrollPane(table);
			
			// other steps for creating JTable and default operations
			add(pane);
			setTitle("Bookotron 9001");
			setVisible(true);
			setSize(500,400);
			setLayout(new FlowLayout());
			setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			
			// creating new scanner to read text file input
			Scanner input = new Scanner(new File("data/Input.txt"));	
			
			// creating 2D array for later use with books
			String[][] books = new String[20][5];
				
			
			
				// adding books and information into 2D array
				for(int i=0; i<books.length; i++){
						
						String[] book = input.nextLine().split(",");
						books[i] = book;
					}
				
				// creates book objects so getting methods can be used
				
				Book book1 = new Book(books[0]);
				Book book2 = new Book(books[1]);
				Book book3 = new Book(books[2]);
				Book book4 = new Book(books[3]);
				Book book5 = new Book(books[4]);
				Book book6 = new Book(books[5]);
				Book book7 = new Book(books[6]);
				Book book8 = new Book(books[7]);
				Book book9 = new Book(books[8]);
				Book book10 = new Book(books[9]);
				Book book11 = new Book(books[10]);
				Book book12 = new Book(books[11]);
				Book book13 = new Book(books[12]);
				Book book14 = new Book(books[13]);
				Book book15 = new Book(books[14]);
				Book book16 = new Book(books[15]);
				Book book17 = new Book(books[16]);
				Book book18 = new Book(books[17]);
				Book book19 = new Book(books[18]);
				Book book20 = new Book(books[19]);
				
				Book[] list = new Book[20];
				
				list[0]=book1;
				list[1]=book2;
				list[2]=book3;
				list[3]=book4;
				list[4]=book5;
				list[5]=book6;
				list[6]=book7;
				list[7]=book8;
				list[8]=book9;
				list[9]=book10;
				list[10]=book11;
				list[11]=book12;
				list[12]=book13;
				list[13]=book14;
				list[14]=book15;
				list[15]=book16;
				list[16]=book17;
				list[17]=book18;
				list[18]=book19;
				list[19]=book20;
				
				// switch cases for different sorts to be used
				switch (flag){
				case 1 : BookLengthInsertionSort.insertionSort(list);
						break;
				case 2 : BookRatingSelectionSort.selectionSort(list);
						break;
				case 3 : ThreeQuickAuthor.sortAuthor(list);
						break;
				case 4 : ThreeQuickTitle.sort(list);
						break;
				}
				
			
			// puts books into JTable cells
			for(int i=0; i<books.length;i++){
			
			table.setValueAt(list[i].getTitle(),i,0);
			table.setValueAt(list[i].getAuthor(),i,1);
			table.setValueAt(list[i].getLength(),i,2);
			table.setValueAt(list[i].getRating(),i,3);
			}

			
			
			
		}
	}
	


