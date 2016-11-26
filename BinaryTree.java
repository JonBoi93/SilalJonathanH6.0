public class BinaryTree
{
	private Node root;

	/**
	 * Insert into the BinaryTree
	 * @param data Data to insert into the tree
	 */
	public void insert(String data) {
		//create a new node for the data
		Node newNode = new Node(data);
		//check if the tree is empty
		if (root == null) {
			root = newNode;
		} else {
			//loop node
			Node finder = root;
			//immediate parent node
			Node parent = null;
			//continue the loop (instead of break)
			boolean loop = true;
			//loop through the side of the tree
			while (loop) {
				//current parent is now the previous finder
				parent = finder;
				//get the comparison result (String)
				int compareResult = finder.compareTo(data);
				//check the comparison
				if (compareResult == 0) {
					//comparison result is equal
					//increment the found status
					finder.addInstance();
					loop = false;
				} else if (compareResult > 0) {
					//comparison result is greater, go left
					finder = finder.getLeft();
					if (finder == null) {
						//append the new node in
						parent.setLeft(newNode);
						loop = false;
					}
				} else {
					//comparison result is less, go right
					finder = finder.getRight();
					if (finder == null) {
						//append the new node in
						parent.setRight(newNode);
						loop = false;
					}
				}
			}
		}
	}
