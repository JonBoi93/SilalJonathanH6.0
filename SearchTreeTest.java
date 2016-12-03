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

    /**
     * Use regular expression to clean out all non-alphanumeric input
     * @param input Input to clean
     * @return cleaned from input
     */
    public static String CleanInput(String input) {
        return input.replaceAll("[^A-Za-z0-9]","");
    }

	/**
	 * Insert data from the file
	 * @param filen File containing string data you would like to insert into the BinarySearchTree
	 * @param bst BinarySearchTree that you would like to insert into
	 */
	private static void insertFromFile(File filen, BinaryTree bt) {
		int words = 0;
		int lines = 0;
		Scanner sc2 = null;
		try {
			if (filen != null)
				sc2 = new Scanner(filen);
			else return;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		//read each line
		while (sc2.hasNextLine()) {
			Scanner s2 = new Scanner(sc2.nextLine());
			//for each line, read each word
			while (s2.hasNext()) {
				String s = s2.next();
				if (s.compareTo("") != 0) {
					words++;
					//insert a lower case version of the word
					bt.insert(CleanInput(s.toLowerCase()));
				}
			}
			lines++;
		}
		System.out.println("Inserted " + words + " words from " + lines + " lines");
	}
/**
	 * Static test of the binary search tree - used before file input
	 */
	private static void testBT(BinaryTree bt) {
		bt.insert("bart");
		bt.insert("bart");
		bt.insert("art");
		bt.insert("lart");
		bt.print();
		System.out.println("Find bart " + bt.search("bart"));
		bt.delete("bart");
		System.out.println("Delete bart 1");
		bt.print();
		System.out.println("Delete bart 2");
		bt.delete("bart");
		System.out.println("Find bart " + bt.search("bart"));
		bt.print();
		bt.delete("art");
		bt.delete("lart");
		bt.print();
	}
}


