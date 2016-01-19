
public class BST {
	
	private Node root;
	// root of BST
	private class Node
	{
		private int key;
		private String val;
		private Node left, right;
		private int N;

		public Node(int key, String val, int N)
		{ this.key = key; this.val = val; this.N = N; }
	}
		
	public int size()
	{ return size(root);}
	
	//returns the size of the BST
	private int size(Node x)
	{
		if (x == null) return 0;
		else
		return x.N;
	}
	
	//gets the value stored at the key
	public String get(int key)
	{ return get(root, key);}
	
	private String get(Node x, int key)
	{ 
		if (x == null) return null;
		if (key < x.key) return get(x.left, key);
		else if (key > x.key) return get(x.right, key);
		else return x.val;
	}
	
	//puts the value into the BST at the key
	public void put(int key, String val)
	{ root = put(root, key, val); }
	
	private Node put(Node x, int key, String val)
	{
		if (x == null) return new Node(key, val, 1);
		if (key < x.key) x.left = put(x.left, key, val);
		else if (key > x.key) x.right = put(x.right, key, val);
		else x.val = val;
		x.N = size(x.left) + size(x.right) + 1;
		return x;
	}
}
