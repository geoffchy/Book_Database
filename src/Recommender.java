
import java.awt.FlowLayout;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Recommender {

	private int ratingIndex = 3;
	private int highRating = 10;

	//Finds highly rated books and rates it using the BST of books
	public Recommender() throws IOException{
		
		//Gets book information from textfile
		ArrayList<String[]> data = new ArrayList<>();
		String line = "";
		String[] input = {};
		
		BufferedReader br = new BufferedReader(new FileReader("data/Input.txt"));
		while ((line = br.readLine()) != null) {
			input = line.split(",");
			data.add(input);
		}
		br.close();
		
		//Stores the the text file information in a 2D String array
		String[][] fileInfo = new String[data.size()][input.length];
		
		for (int i = 0; i < data.size(); i++){
			fileInfo[i] = data.get(i);
		}
		
		RecommendTree recommend = new RecommendTree(fileInfo);
		
		ArrayList<Integer> indexList = new ArrayList();
		
		//Finds keys for all books that have 10 rating
		for (int i = 1; i < fileInfo.length; i++){
			if(Integer.parseInt(fileInfo[i][ratingIndex]) == highRating) indexList.add(i);
		}
		
		//Stores all the books with high rating in another 2D String array
		String[][] results = new String[indexList.size()][4];
		for(int j = 0; j < indexList.size(); j++){
			results[j][0] = recommend.get(indexList.get(j));
			results[j][1] = fileInfo[(indexList.get(j))][1];
			results[j][2] = fileInfo[(indexList.get(j))][2];
			results[j][3] = fileInfo[(indexList.get(j))][3];
		}
		
		//Displays recommended information in a table
		toTable recTable = new toTable();
		recTable.start(results);	
	}
	
	//Responsible for organizing the data in a table and displaying the data
	private class toTable extends JFrame {
		
		private static final long serialVersionUID = 1L;
		DefaultTableModel model;
		JTable table;
		String col[] = {"Title","Author","Length","Rating"};
		
		public toTable(){
		}
		
		public void start(String[][] data){
			
			model = new DefaultTableModel(data, col);
			table = new JTable(model){
				private static final long serialVersionUID = 1L;
				public boolean isCellEditable(int arg0, int arg1){return false;}};
				
				JScrollPane pane = new JScrollPane(table);
				add(pane);
				setTitle("Recommended Books");
				setVisible(true);
				setSize(500,400);
				setLayout(new FlowLayout());
				setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		}
	
	}
	
}
