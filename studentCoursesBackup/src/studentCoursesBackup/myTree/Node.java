package studentCoursesBackup.myTree;

import java.util.ArrayList;

/*
* Node class.
* Created by Aravind Venkit for cs542 - Design patterns, Assignment 2.
* class to structure node structure.
*/
public class Node implements Cloneable{
	private int key;
	private String name;

	private Node leftChild;
	private Node rightChild;

	private ArrayList<Node> nodeList;

	private Node(){
	}

	public Node(int keyIn, String nameIn){
		key = keyIn;
		name  = nameIn;
		leftChild = new Node();
		rightChild = new Node();
		nodeList = new ArrayList<Node>();
	}
	//cloneNode
	public Object clone(){
		Node cloneNode = new Node();
		cloneNode = this;
		nodeList.add(cloneNode);
        return cloneNode;
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

	public void clearName(){
		name = "";
		for(Node backup_node : nodeList){
			backup_node.clearName(true);
		}
	}

	private void clearName(boolean isClear){
		if(isClear){
			name = "";
		}
	}

	public void setLeftChild(Node nodeIn){
		leftChild = nodeIn;
	}

	public void setRightChild(Node nodeIn){
		rightChild = nodeIn;
	}
}