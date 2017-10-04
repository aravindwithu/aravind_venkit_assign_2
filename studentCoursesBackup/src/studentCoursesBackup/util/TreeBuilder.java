//https://www.youtube.com/watch?v=M6lYob8STMI
package studentCoursesBackup.util;

import studentCoursesBackup.myTree.Node;
import studentCoursesBackup.util.Results;

/**
* TreeBuilder class.
* Created for cs542 - Design patterns, Assignment 2.
* class to structure node structure.
* @author Aravind Venkit
*/
public class TreeBuilder{

	/**
	*Declares the root object for original, backup 1 and backup 2 trees.
	*/
	private Node root_orig;
	private Node backup_Root_1;
	private Node backup_Root_2;

	/**
	* TreeBuilder constructor to intialize TreeBuilder class.
	* Intializes the root object for original, backup 1 and backup 2 trees to null.
	*/
	public TreeBuilder(){
		root_orig = null;
		backup_Root_1 = null;
		backup_Root_2 = null;
	}

	/**
	* insertNode public method.
	* To create and clone respective Nodes and to insert the same in BST structure.
	* BST - Binary Search Tree.
	* 1st creates the original node.
	* 2nd creates 2 clones for backup1 and backup2.
	* 3rd Inserts the original and cloned nodes to the BST structure using private InsertNode method.
	* 4th addes the cloned backup nodes to the node array list for reference in original node.
	* @param newBNumber.
	* @param newCourse.
	*/
	public void insertNode(int newBNumber, String newCourse){
		try{
			Node node_orig = new Node(newBNumber, newCourse);
			Node backup_Node_1 = node_orig.clone();	
			Node backup_Node_2 = node_orig.clone();

			root_orig = insertNode(root_orig, node_orig);
			backup_Root_1 = insertNode(backup_Root_1, backup_Node_1);
			backup_Root_2 = insertNode(backup_Root_2, backup_Node_2);

			node_orig.addReference(backup_Node_1);
			node_orig.addReference(backup_Node_2);
		}
		catch(Exception ex){
			System.err.println(ex.getMessage());// prints the error message.
	    	ex.printStackTrace();// prints stack trace.
	    	System.exit(0);
		}
	}

	/**
	* insertNode private method.
	* To creates BST structure with given new node the root node.
	* BST - Binary Search Tree.
	* 1st If root is empty then stores the new node in the root and returns the node.
	* 2nd if bNumber of new node os less than bNumber of root node then inserts the new node as left child of the root.
	* 3rd if bNumber of new node os greater than bNumber of root node then inserts the new node as right child of the root.
	* 4th if bNumber of new node os equal bNumber of root node then setCourse method from Node class is called to set the new course to the respective node.
	* 5th insertNode method is called recursively to add the nodes in BST chain structure.
	* 6th recursive function terminates once the node is inserted in BST structure or course is set. 
	* @param root of the respective tree.
	* @param newNode created or cloned node.
	* @see http://www.geeksforgeeks.org/binary-search-tree-set-1-search-and-insertion/
	* @return Node (root);
	*/
	private Node insertNode(Node root, Node newNode){
        if (root == null) {
            root = newNode;
            return root;
        }
      	if (newNode.getBNumber() < root.getBNumber()){
            root.setLeftChild(insertNode(root.getLeftChild(), newNode));
        }
    	else if (newNode.getBNumber() > root.getBNumber()){
            root.setRightChild(insertNode(root.getRightChild(), newNode));
        }
        else if(newNode.getBNumber() == root.getBNumber()){
        	if(!newNode.isCourseNull()){
        		root.setCourse(newNode.getCourse(0));
        	}
        }
        return root;
	}

	/**
	* printNodes public method.
	* To write tree data to result array list.
	* @param results_orig.
	* @param backup_Results_1.
	* @param backup_Results_2.
	*/
	public void printNodes(Results results_orig, Results backup_Results_1, Results backup_Results_2){
		printNodes(root_orig, results_orig);
		printNodes(backup_Root_1, backup_Results_1);
		printNodes(backup_Root_2, backup_Results_2);
	}

	/**
	* printNodes private method.
	* To write tree data to result array list.
	* @param currentNode
	* @param result
	*/
	private void printNodes(Node currentNode, Results result){
		if(currentNode != null){
			printNodes(currentNode.getLeftChild(), result);
			if(0 != currentNode.getBNumber() && !currentNode.isCourseNull()){
				//System.out.println(currentNode.getBNumber() + ":" + currentNode.getCourse());
				String resultStr = currentNode.getBNumber() + ":" + currentNode.getCourse();
				result.storeNewResult(resultStr);
			}			
			printNodes(currentNode.getRightChild(), result);
		}
	}

	/**
	* deleteNode public method.
	* Deletes the node from tree (Only updates and remove course)
	* @param bNumber
	* @param course
	* @return boolean value indicates node is deleted or not.
	*/
	public boolean deleteNode(int bNumber, String course){
		boolean result = deleteNode(root_orig, bNumber, course);
		return result;
	}

	/**
	* deleteNode private method.
	* Deletes the node from tree (Only updates and remove course)
	* @param bNumber
	* @param course
	* @return boolean value indicates node is deleted or not.
	*/
	private boolean deleteNode(Node root, int bNumber, String course){
		Node currentNode = root;
		while(currentNode.getBNumber() != bNumber){
			if(bNumber < currentNode.getBNumber()){
				currentNode = currentNode.getLeftChild();
			}else{
				currentNode = currentNode.getRightChild();
			}

			if(currentNode == null){
				return false;
			}
		}
		if(currentNode != null){
			currentNode.clearCourse(course);
			return true;
		}else{
			return false;
		}	
	}

	/**
	* deleteNode private method.
	* Searches the given bNumber and returns the node from tree.
	* @param root
	* @param bNumber
	* @return boolean value indicates node is deleted or not.
	*/
	public Node searchNode(Node root, int bNumber){
		Node currentNode = root;
		while(currentNode.getBNumber() != bNumber){
			if(bNumber < currentNode.getBNumber()){
				currentNode = currentNode.getLeftChild();
			}else{
				currentNode = currentNode.getRightChild();
			}

			if(currentNode == null){
				return null;
			}
		}
		return currentNode;
	}
}