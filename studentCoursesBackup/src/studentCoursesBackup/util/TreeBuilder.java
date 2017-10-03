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

	public void insertNode(int newKey, String newName){
		try{
			Node node_orig = new Node(newKey, newName);
			root_orig = insertNode(root_orig, node_orig);
			
			Node backup_Node_1 = node_orig.clone();			
			backup_Root_1 = insertNode(backup_Root_1, backup_Node_1);
			node_orig.addReference(backup_Node_1);

			Node backup_Node_2 = node_orig.clone();			
			backup_Root_2 = insertNode(backup_Root_2, backup_Node_2);
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
      	if (newNode.getKey() < root.getKey()){
            root.setLeftChild(insertNode(root.getLeftChild(), newNode));
        }
    	else if (newNode.getKey() > root.getKey()){
            root.setRightChild(insertNode(root.getRightChild(), newNode));
        }
        else if(newNode.getKey() == root.getKey()){
        	if(!newNode.isNameNull()){
        		root.setName(newNode.getName(0));
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
			if(0 != currentNode.getKey() && !currentNode.isNameNull()){
				System.out.println(currentNode.getKey() + ":" + currentNode.getName());
				String resultStr = currentNode.getKey() + ":" + currentNode.getName();
				result.storeNewResult(resultStr);
			}			
			printNodes(currentNode.getRightChild(), result);
		}
	}

	public boolean deleteNode(int key, String name){
		boolean result = deleteNode(root_orig, key, name);
		return result;
	}

	private boolean deleteNode(Node root, int key, String name){
		Node currentNode = root;
		while(currentNode.getKey() != key){
			if(key < currentNode.getKey()){
				currentNode = currentNode.getLeftChild();
			}else{
				currentNode = currentNode.getRightChild();
			}

			if(currentNode == null){
				return false;
			}
		}
		if(currentNode != null){
			System.out.println("clear key found is "+ currentNode.getKey());
			currentNode.clearName(name);
			return true;
		}else{
			return false;
		}	
	}
}