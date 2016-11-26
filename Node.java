public class Node {
	//left node
    private Node left;
    //right node
    private Node right;
    //contents of the node
    private String contents;
    //count of instances
    private int count;

	/**
	 * Constructor - contents included
	 * @param Contents Contents to set to the new object
	 */
    public Node(String Contents) {
        contents = Contents;
        left = null;
        right = null;
        count = 1;
    }

    //Accessors
    /**
     * Get the contents of the Node
     * @return  Contents string
     */
    public String getContents() {
        return contents;
    }

	/**
	 * Get the left Node
	 * @return Node on left
	 */
    public Node getLeft() {
        return left;
    }

	/**
	 * Get the right Node
	 * @return Node on right
	 */
    public Node getRight() {
        return right;
    }

	/**
	 * Get the instance count
	 * @return Integer with instance count
	 */
    public int getCount() {
        return count;
    }

    //Mutators
    /**
     * Set the contents of the Node
     * @param Contents String contents of the node
     */
    public void setContents(String Contents) {
        contents = Contents;
    }

	/**
	 * Set the left Node
	 * @param NewLeft Node reference for left
	 */
    public void setLeft(Node NewLeft) {
        left = NewLeft;
    }

	/**
	 * Set the right Node
	 * @param NewRight Node reference for right
	 */
    public void setRight(Node NewRight) {
        right = NewRight;
    }

	/**
	 * Add an instance to the counter
	 */
    public void addInstance() {
        count++;
    }

    /**
     * Remove an instance from the counter
     */
    public void removeInstance() {
		count--;
	}

 //Compare
    /**
     * Compare node contents by Node
     * @param Comparison Node to compare with
     */
    public int compareTo(Node Comparison) {
        return contents.compareTo(Comparison.getContents());
    }

	/**
	 * Compare node contents by String
	 * @param Comparison String to compare with
	 */
    public int compareTo(String Comparison) {
        return contents.compareTo(Comparison);
    }

}