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

/**
	 * Print Nodes out in order from the most left bottom node
	 */
	public void print() {
		if (root == null) {
			System.out.println("Tree is empty");
		} else {
			System.out.print("Root is ");
			printNode(root);
			printInorder(root);
		}
	}

	/**
		 * Recursive function to print out the Nodes in order
		 * @param start Starting node to print
		 */
		private void printInorder(Node start) {
			if(start!=null) {
				//go down the left side of this node
				printInorder(start.getLeft());
				printNode(start);
				//go down the right side of this node
				printInorder(start.getRight());
			}
	}

	/**
		 * Print an individual Node
		 * @param item Node item to print
		 */
		private void printNode(Node item) {
			if (item != null) {
				System.out.println(item.getContents() + " " + item.getCount());
			}
		}

		/**
		 * Get the successor node for the current delete tree
		 * @param deleteNode Node to delete
		 */
		private Node getSuccessor(Node deleteNode){
			Node finder = null;
			Node parent = null;
			Node current = deleteNode.getRight();

			while (current != null) {
				parent = finder;
				finder = current;
				current = current.getLeft();
			}

			if (finder != deleteNode.getRight()) {
				parent.setLeft(finder.getRight());
				finder.setRight(deleteNode.getRight());
			}

			return finder;
		}

		/**
		 * Find if the string is in the tree
		 * @param data Data to find
		 * @return If the data was found or not
		 */
		public boolean search(String data) {
			//essentially a copy of what delete does to find the node
			Node parent = root;
			Node finder = root;

			int currentCompare = 0;
			do {
				currentCompare = finder.compareTo(data);
				if (currentCompare != 0) {
					parent = finder;
					if(currentCompare > 0){
						finder = finder.getLeft();
					} else {
						finder = finder.getRight();
					}
					if(finder == null){
						return false;
					}
				}
			} while (currentCompare != 0);
			return true;
	}

	/**
		 * Delete the node if it exists
		 * @param data String data to delete
		 * @return Deleted - true
		 */
		public boolean delete(String data) {
			Node parent = root;
			Node finder = root;
			boolean contentsLesser = false;
			int currentCompare = 0;
			do {
				currentCompare = finder.compareTo(data);
				//System.out.println("'" + finder.getContents() + "'.compareTo('" + data + "') = " + currentCompare);
				if (currentCompare != 0) {
					parent = finder;
					if(currentCompare > 0){
						contentsLesser = true;
						finder = finder.getLeft();
					} else {
						contentsLesser = false;
						finder = finder.getRight();
					}
					if(finder == null){
						return false;
					}
				}
		} while (currentCompare != 0);

		//found the node
				if (finder.getCount() <= 1) {
					//delete the node
					if (finder.getLeft() == null && finder.getRight() == null) {
						//*Node has no children - simplest case
						if(finder==root){
							root = null;
						}
						if (contentsLesser ==true){
							parent.setLeft(null);
						} else {
							parent.setRight(null);
						}
					} else if (finder.getRight() == null) {
						//*Node has one child - easy case
						if (finder==root) {
							root = finder.getLeft();
						} else if (contentsLesser) {
							parent.setLeft(finder.getLeft());
						} else {
							parent.setRight(finder.getLeft());
						}
					} else if (finder.getLeft()==null) {
						//*Node has one child - easy case
						if (finder==root) {
							root = finder.getRight();
						} else if (contentsLesser) {
							parent.setLeft(finder.getRight());
						} else {
							parent.setRight(finder.getRight());
						}
					} else if (finder.getLeft() != null && finder.getRight() != null) {
						//*Node has two children - difficult case, need to find the successor Node
						Node successor = getSuccessor(finder);
						if (finder == root) {
							root = successor;
						} else if (contentsLesser) {
							parent.setLeft(successor);
						} else {
							parent.setRight(successor);
						}
						successor.setLeft(finder.getLeft());
					}
				} else {
					//decrease the count
					finder.removeInstance();
				}

				return true;
			}
}