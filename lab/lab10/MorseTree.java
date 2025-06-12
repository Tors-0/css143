import javax.security.auth.callback.CallbackHandler;
import javax.swing.tree.TreeNode;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
/*
 * MorseTree.java
 * CSS 162 Binary Search Tree Lab
 * Author: Rob Nash
 * 
 * This class reads in data from a text file ("data.txt") and populates a binary tree with an 
 * ordering constraint.  See the lab readme for more information, but in general, dots go right 
 * and dashes go left when constructing or traversing a morse code tree.  Search for //TODO
 * in the code to see what code you have to implement.
 * 
 * Start with the C'Tor and read each line in from the textfile first, calling add() for each 
 * {letter,morseCodeStr} pair.
 * 
 */

public class MorseTree {

		
	//2.1
	private class TreeNode<Character> {
		Character data;
		TreeNode<Character> left;
		TreeNode<Character> right;

		 public TreeNode(Character data, TreeNode<Character> left, TreeNode<Character> right) {
			 this.data = data;
			 this.left = left;
			 this.right = right;
		 }
	}


	//2.2 
	private TreeNode<Character> root;

	public MorseTree() {
		//open data.txt, add each line to the tree
		Scanner fin;
		try {
			fin = new Scanner(new FileInputStream("lab/lab10/data.txt"));
			while (fin.hasNextLine()) {
				char letter = fin.next().charAt(0);
				String seq = fin.next();
				fin.nextLine();
				add(seq, letter);
				System.out.printf("let: %c, code: %s\n", letter, seq);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public void add(String morseStr, char letter) {
		root = insertInSubtree(morseStr, letter, root);
	}

	private TreeNode<Character> insertInSubtree(String morseStr, char letter, TreeNode<Character> subtree) {
		if (subtree == null || morseStr.isEmpty()) {
			subtree = new TreeNode<>(letter, null, null);
		} else if (morseStr.charAt(0) == '.') {
			subtree.right = insertInSubtree(morseStr.substring(1), letter, subtree.right);
		} else if (morseStr.charAt(0) == '-') {
			subtree.left = insertInSubtree(morseStr.substring(1), letter, subtree.left);
		}
		
		return subtree;  //always the last line, always return the node you are working on
	}
	
	public Character translate(String morseStr) {
		return findInSubtree(morseStr, root);
	}
	
	//TODO: recursively comlpete this function.  Very similar to insertInSubtree()
	private Character findInSubtree(String morseStr, TreeNode subtree) {
		//base case 1 : subtree is null 
		//base case 2 : morseStr is of length 0
		//recursive case 1: the first char in morseStr is a '.', so recursively traverse tree
		//recursive case 2: the first char in the morseStr is a '-', so recurse accordingly
		return null;  //remove this
	}
	
	//TODO: Non-recursive function that calls other (recursive) functions
	public String translateString(String tokens) {
		String retVal = "";
		//build a scanner here using tokens as input
		//iterate over the tokens calling translate on each token (substring separated by a space)
		//	concat these characters and return them
		
		return retVal;
	}


	public String toMorseCode(Character c) {
		return toMorseCode(c, root, "");
		
	}
	public String toMorseCode(Character c, TreeNode node, String path) {
        // backtracking
        if (node == null) {
            return null;
        }

        if (c.equals(node.data)) {
            return path;
        }

        String result;
        result = toMorseCode(c, node.left, path + "-");
        if (result != null) {
            return result;
        }
        result = toMorseCode(c, node.right, path + ".");
        if (result != null) {
            return result;
        }

        return null;
    }

	
	public static void main(String[] args) {
		MorseTree mt = new MorseTree();  //builds our tree using data from a file

		System.out.println(mt.translate("..."));  //prints out S
		System.out.println(mt.translate("---"));  //prints out O
		System.out.println(mt.translate(".......-"));  //prints out null
		
		System.out.println(mt.translateString("... --- ..."));  //SOS
		
		System.out.println(mt.toMorseCode('S'));  //find where we are in the tree, remember path to root
	}

}
