//https://www.youtube.com/watch?v=M6lYob8STMI
package studentCoursesBackup.util;

import studentCoursesBackup.myTree.Node;

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
		Node node_orig = new Node(newKey, newName);
		root_orig = insertNode(root_orig, node_orig);

		Node backup_Node_1 = (Node)node_orig.clone();
		backup_Root_1 = insertNode(backup_Root_1, backup_Node_1);
		
		Node backup_Node_2 = (Node)node_orig.clone();
		backup_Root_2 = insertNode(backup_Root_2, backup_Node_2);
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
 
        /* return the (unchanged) node pointer */
        return root;
	}

	public void printNodes(){
		System.out.println("orig");
		inOrderTraverseTree(root_orig);
		System.out.println("backup1");
		inOrderTraverseTree(backup_Root_1);
		System.out.println("backup2");
		inOrderTraverseTree(backup_Root_2);
	}

	private void printNodes(Node currentNode){
		if(currentNode != null){
			inOrderTraverseTree(currentNode.getLeftChild());
			if(0 != currentNode.getKey() && "" != currentNode.getName()){
				System.out.println(currentNode.getKey());
			}			
			inOrderTraverseTree(currentNode.getRightChild());
		}
	}

	public boolean deleteNode(int key){
		boolean result = deleteNode(root_orig, key);
		return result;
	}

	private boolean deleteNode(Node root, int key){
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
			currentNode.clearName();
			return true;
		}else{
			return false;
		}	
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