//https://www.youtube.com/watch?v=M6lYob8STMI
package studentCoursesBackup.util;

import studentCoursesBackup.myTree.Node;

public class TreeBuilder{

	private Node root;

	public TreeBuilder(){
		root = null;
	}

	public void insertNode(int newKey, String newName){
		Node newNode = new Node(newKey, newName);

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

	public void deleteNode(int deleteKey){
		
	}

	public void inOrderTraverseTree(){
		inOrderTraverseTree(root);
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
		preOrderTraverseTree(root);
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
		postOrderTraverseTree(root);
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
		return currentNode
	}
}