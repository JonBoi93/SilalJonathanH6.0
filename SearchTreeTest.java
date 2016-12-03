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
/**
	 * Insert data from a file unknown - provide a directory listing
	 * @param bst BinarySearchTree that you would like to insert into
	 */
	private static void insertFile(BinaryTree bt) {
		File f = new File("."); // current directory
		System.out.println(f.getName());

		//Use a filenamefilter to find only files with *.txt
		FilenameFilter textFilter = new FilenameFilter() {
			public boolean accept(File dir, String name) {
				String lowercaseName = name.toLowerCase();
				if (lowercaseName.endsWith(".txt")) {
					return true;
				} else {
					return false;
				}
			}
		};

		//get a list of files with that filter
		File allfiles[] = f.listFiles(textFilter);
		if (allfiles.length > 0) {
			Scanner kybd = new Scanner(System.in);
			//loop until the person gets a number that is in the active list
			while (true) {
				int userInput = 0;
				System.out.println("Directory listing *.txt");
				//list the files by name and index
				for (int i = 0; i < allfiles.length; i++) {
					System.out.println(" " + i + " - " + allfiles[i].getName());
				}
				System.out.print("Enter your choice: ");
				userInput = kybd.nextInt();
				//verify user input
				if (userInput >= 0 && userInput < allfiles.length) {
					//insert the file into the BinarySearchTree using the file
					// number indicated by the user
					insertFromFile(allfiles[userInput], bt);
					break;
				}
			}
		} else {
			System.out.println("Cannot find a .txt file in the current working directory");
		}
	}

