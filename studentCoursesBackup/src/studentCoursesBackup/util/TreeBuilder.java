package studentCoursesBackup.util;

import studentCoursesBackup.myTree.Node;

public class TreeBuilder{

	private Node root;
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

	public TreeBuilder(){

	}
}