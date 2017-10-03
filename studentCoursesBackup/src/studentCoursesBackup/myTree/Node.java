package studentCoursesBackup.myTree;

import java.util.ArrayList;
import studentCoursesBackup.myTree.ObserverI;
import studentCoursesBackup.myTree.SubjectI;

/*
* Node class.
* Created by Aravind Venkit for cs542 - Design patterns, Assignment 2.
* class to structure node structure.
*/
public class Node implements Cloneable, SubjectI, ObserverI{
	private int key;
	private ArrayList<String> nameList;

	private Node leftChild;
	private Node rightChild;

	private ArrayList<Node> nodeList;

	private Node(){
	}

	public Node(int keyIn, String nameIn){
		key = keyIn;
		nameList  = new ArrayList<String>();
		nameList.add(nameIn);
		leftChild = new Node();
		rightChild = new Node();
		nodeList = new ArrayList<Node>();
	}
	//cloneNode
	public Node clone() throws CloneNotSupportedException {
		Node cloneNode = new Node();

		cloneNode.key = key;
		cloneNode.nameList  = new ArrayList<String>();
		for(String name : nameList){
			cloneNode.nameList.add(name);
		}

		cloneNode.leftChild = new Node();
		cloneNode.rightChild = new Node();
		cloneNode.nodeList = new ArrayList<Node>();

		return cloneNode;
	}



	public void addReference(Node backup_node){
		nodeList.add(backup_node);
	}

	public int getKey(){
		return key;
	}

	public String getName(){
		String result = "";
		for(String name : nameList){
			result += (name + ",");
		}
		result = result.substring(0, (result.length() -1));
		return result;
	}

	public String getName(int index){
		if(index >= nameList.size()){
			return null;
		}
		return nameList.get(index);
	}

	public void setName(String nameIn){
		nameList.add(nameIn);
	}

	public Node getLeftChild(){
		return leftChild;
	}

	public void setLeftChild(Node nodeIn){
		leftChild = nodeIn;
	}

	public Node getRightChild(){
		return rightChild;
	}

	public void setRightChild(Node nodeIn){
		rightChild = nodeIn;
	}

	public void clearName(String nameIn){
		boolean isCleared = false;
		for(int i = 0; i<nameList.size(); i++){
			if(nameList.get(i) == nameIn){
				nameList.remove(i);
				isCleared = true;
				break;
			}
		}
		notifyAll(isCleared);
	}

	public void notifyAll(boolean isCleared){
		if(isCleared){
			for(Node backup_node : nodeList){
				backup_node.update(nameList);
			}
		}
	}

	public void update(ArrayList<String> nameListIn){
		nameList = nameListIn;
	}
}