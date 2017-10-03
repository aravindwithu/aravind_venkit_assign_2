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
			Node node_orig = findNode(root_orig, newKey);
			if(node_orig == null){
				node_orig = new Node(newKey, newName);
				root_orig = insertNode(root_orig, node_orig);
			}else{
				node_orig.setName(newName);
			}

			Node backup_Node_1 = findNode(backup_Root_1, newKey);
			if(backup_Node_1 == null){
				backup_Node_1 = node_orig.clone();			
				backup_Root_1 = insertNode(backup_Root_1, backup_Node_1);
				node_orig.addReference(backup_Node_1);
			}else{
				backup_Node_1.setName(newName);
			}

			Node backup_Node_2 = findNode(backup_Root_2, newKey);
			if(backup_Node_2 == null){
				backup_Node_2 = node_orig.clone();			
				backup_Root_2 = insertNode(backup_Root_2, backup_Node_2);
				node_orig.addReference(backup_Node_2);
			}else{
				backup_Node_2.setName(newName);
			}

			/*Node backup_Node_2 = findNode(backup_Root_2, newKey);
			if(backup_Node_2 == null){
				backup_Node_2 = node_orig.clone();
				backup_Root_2 = insertNode(backup_Root_2, backup_Node_2);
			}else{
				backup_Node_2.setName(newName);
			}*/
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
        /*else if(newNode.getKey() == root.getKey()){
        	root.setName(newNode.getName(0));
        }*/
 
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
			if(0 != currentNode.getKey() && "" != currentNode.getName()){
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
			currentNode.clearName(name);
			return true;
		}else{
			return false;
		}	
	}

	private Node findNode(Node root, int key){
		if(root == null){
			return null;
		}
		Node currentNode = root;
		while(currentNode.getKey() != key){
			if(key < currentNode.getKey()){
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

	/*public void preOrderTraverseTree(){
		preOrderTraverseTree(root_orig);
	}

	private void preOrderTraverseTree(Node currentNode){
		if(currentNode != null){
			if(0 != currentNode.getKey()){
				System.out.println(currentNode.getKey());
			}	
			preOrderTraverseTree(currentNode.getLeftChild());		
			preOrderTraverseTree(currentNode.getRightChild());
		}
	}

	public void postOrderTraverseTree(){
		postOrderTraverseTree(root_orig);
	}

	private void postOrderTraverseTree(Node currentNode){
		if(currentNode != null){	
			postOrderTraverseTree(currentNode.getLeftChild());		
			postOrderTraverseTree(currentNode.getRightChild());
			if(0 != currentNode.getKey()){
				System.out.println(currentNode.getKey());
			}
		}
	}

	public Node findNode(int key){
		Node currentNode = findNode(root_orig, key);
	}

	private Node findNode(Node root, int key){
		Node currentNode = root;
		while(currentNode.getKey() != key){
			if(key < currentNode.getKey()){
				currentNode = currentNode.getLeftChild();
			}else{
				currentNode = currentNode.getRightChild();
			}

			if(currentNode == null){
				return null;
			}
		}
		return currentNode;
	}*/
}