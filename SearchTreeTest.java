import java.io.File;
import java.io.FileNotFoundException;
import java.io.FilenameFilter;
import java.util.Scanner;

public class SearchTreeTest {
	public static void main(String args[]) {
		BinaryTree bt = new BinaryTree();
		//testBT(bt);
		insertFile(bt);
		System.out.println("-------------------------------------");
		System.out.println("Printing tree from input");
		bt.print();
	}

