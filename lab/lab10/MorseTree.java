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
		if (subtree == null) {
			subtree = new TreeNode<>(null, null, null);
		}
		if (morseStr.isEmpty()) {
			subtree.data = letter;
		} else {
			if (morseStr.charAt(0) == '.') {
				subtree.right = insertInSubtree(morseStr.substring(1), letter, subtree.right);
			} else if (morseStr.charAt(0) == '-') {
				subtree.left = insertInSubtree(morseStr.substring(1), letter, subtree.left);
			}
		}
		
		return subtree;  //always the last line, always return the node you are working on
	}
	
	public Character translate(String morseStr) {
		return findInSubtree(morseStr, root);
	}

	private Character findInSubtree(String morseStr, TreeNode<Character> subtree) {
		if (subtree == null) return null;
		if (morseStr.isEmpty()) return subtree.data;
		if (morseStr.charAt(0) == '.') return findInSubtree(morseStr.substring(1), subtree.right);
		else return findInSubtree(morseStr.substring(1), subtree.left);
	}

	public String translateString(String tokens) {
		StringBuilder retVal = new StringBuilder();
		String[] tokenList = tokens.split(" ");
		for (String token : tokenList) {
			retVal.append(translate(token));
		}
		return retVal.toString();
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
