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

	public Node(int keyIn, String nameIn){
		key = keyIn;
		name  = nameIn;
		leftChild = new Node();
		rightChild = new Node();
	}
}