import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

//Builds a BST using the book properties
public class RecommendTree {
	
	BST recommendST = new BST(); 
	
	RecommendTree(String[][] fileInfo) {	
		int rootIndex = fileInfo.length / 2;
		
		//defines the root of the BST
		recommendST.put(rootIndex, fileInfo[rootIndex][0]);
		
		//populates the BST
		for (int i = 0; i < fileInfo.length; i++){
			if (i != rootIndex){
				recommendST.put(i, fileInfo[i][0]);
			}
		}	
	}
	
	//gets the value at the key from the BST
	public String get(int Key){
		return recommendST.get(Key);
	}
	
}
