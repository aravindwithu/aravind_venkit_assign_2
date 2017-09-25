package studentCoursesBackup.myTree;

/*
* Node class.
* Created by Aravind Venkit for cs542 - Design patterns, Assignment 2.
* class to structure node structure.
*/
public class Node{
	private int key;
	private String name;

	private Node leftChild;
	private Node rightChild;

	private Node(){
	}

	public Node(int keyIn, String nameIn){
		key = keyIn;
		name  = nameIn;
		leftChild = new Node();
		rightChild = new Node();
	}

	public int getKey(){
		return key;
	}

	public String getName(){
		return name;
	}

	public Node getLeftChild(){
		return leftChild;
	}

	public Node getRightChild(){
		return rightChild;
	}

	public void setLeftChild(Node nodeIn){
		leftChild = nodeIn;
	}

	public void setRightChild(Node nodeIn){
		rightChild = nodeIn;
	}
}