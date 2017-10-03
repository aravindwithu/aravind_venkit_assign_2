//https://www.youtube.com/watch?v=M6lYob8STMI
package studentCoursesBackup.util;

import studentCoursesBackup.myTree.Node;
import studentCoursesBackup.util.Results;

public class TreeBuilder{

	private Node root_orig;
	private Node backup_Root_1;
	private Node backup_Root_2;

	public TreeBuilder(){
		root_orig = null;
		backup_Root_1 = null;
		backup_Root_2 = null;
	}

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

	private Node insertNode(Node root, Node newNode){
		/* If the tree is empty, return a new node */
        if (root == null) {
            root = newNode;
            return root;
        }
        /* Otherwise, recur down the tree */
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
        /* return the (unchanged) node pointer */
        return root;
	}

	public void printNodes(Results results_orig, Results backup_Results_1, Results backup_Results_2){
		System.out.println("orig");
		printNodes(root_orig, results_orig);
		System.out.println("backup1");
		printNodes(backup_Root_1, backup_Results_1);
		System.out.println("backup2");
		printNodes(backup_Root_2, backup_Results_2);
	}

	private void printNodes(Node currentNode, Results result){
		if(currentNode != null){
			printNodes(currentNode.getLeftChild(), result);
			if(0 != currentNode.getBNumber() && !currentNode.isCourseNull()){
				System.out.println(currentNode.getBNumber() + ":" + currentNode.getCourse());
				String resultStr = currentNode.getBNumber() + ":" + currentNode.getCourse();
				result.storeNewResult(resultStr);
			}			
			printNodes(currentNode.getRightChild(), result);
		}
	}

	public boolean deleteNode(int bNumber, String course){
		boolean result = deleteNode(root_orig, bNumber, course);
		return result;
	}

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