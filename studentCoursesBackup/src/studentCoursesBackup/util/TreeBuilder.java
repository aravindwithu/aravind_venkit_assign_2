//https://www.youtube.com/watch?v=M6lYob8STMI
package studentCoursesBackup.util;

import studentCoursesBackup.myTree.Node;

public class TreeBuilder{

	private Node root_original;
	private Node root_backup1;
	private Node root_backup2;

	public TreeBuilder(){
		root_original = null;
		root_backup1 = null;
		root_backup2 = null;
	}

	public void insertNode(int newKey, String newName){
		Node node_original = new Node(newKey, newName);
		insertNode(root_original, node_original);
		Node node_backup1 = (Node)newNode.clone();
		insertNode(root_backup1, node_backup1);
		Node node_backup2 = (Node)newNode.clone();
		insertNode(root_backup2, node_backup2);
	}

	private void insertNode(Node root, Node newNode){
		if(root == null){
			root = newNode;
		}else{
			Node currentNode = root;
			Node parentNode;
			while(true){
				parentNode = currentNode;
				if(newKey < currentNode.getKey()){
					currentNode = currentNode.getLeftChild();
					if(currentNode == null){
						parentNode.setLeftChild(newNode); 
						return;
					}
				}else{
					currentNode = currentNode.getRightChild();
					if(currentNode == null){
						parentNode.setRightChild(newNode); 
						return;
					}
				}
			}
		}
	}

	public void inOrderTraverseTree(){
		inOrderTraverseTree(root_original);
		inOrderTraverseTree(root_backup1);
		inOrderTraverseTree(root_backup2);
	}

	private void inOrderTraverseTree(Node currentNode){
		if(currentNode != null){
			inOrderTraverseTree(currentNode.getLeftChild());
			if(0 != currentNode.getKey()){
				System.out.println(currentNode.getKey());
			}			
			inOrderTraverseTree(currentNode.getRightChild());
		}
	}

	public void preOrderTraverseTree(){
		preOrderTraverseTree(root_original);
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
		postOrderTraverseTree(root_original);
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
		Node currentNode = findNode(root_original, key);
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
	}

	public boolean deleteNode(int key){
		boolean result = deleteNode(root_original, key);
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
}