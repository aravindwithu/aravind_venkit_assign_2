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
	private int bNumber;
	private ArrayList<String> courseList;

	private Node leftChild;
	private Node rightChild;

	private ArrayList<Node> nodeList;

	private Node(){
	}

	public Node(int keyIn, String nameIn){
		bNumber = keyIn;
		courseList  = new ArrayList<String>();
		courseList.add(nameIn);
		leftChild = new Node();
		rightChild = new Node();
		nodeList = new ArrayList<Node>();
	}
	//cloneNode
	public Node clone() throws CloneNotSupportedException {
		Node cloneNode = new Node();

		cloneNode.bNumber = bNumber;
		cloneNode.courseList  = new ArrayList<String>();
		for(String course : courseList){
			cloneNode.courseList.add(course);
		}

		cloneNode.leftChild = new Node();
		cloneNode.rightChild = new Node();

		return cloneNode;
	}

	public void addReference(Node backup_node){
		nodeList.add(backup_node);
	}

	public int getBNumber(){
		return bNumber;
	}

	public boolean isCourseNull(){
		if(0<courseList.size()){
			return false;
		}
		return true;
	}

	public String getCourse(){
		String result = "";
		if(!isCourseNull()){
			for(String course : courseList){
				result += (course + ",");
			}
			result = result.substring(0, (result.length() -1));
		}
		return result;
	}

	public String getCourse(int index){
		if(isCourseNull()){
			return null;
		}
		if(index >= courseList.size()){
			return null;
		}
		return courseList.get(index);
	}

	public void setCourse(String nameIn){
		if(!courseList.contains(nameIn)){
			courseList.add(nameIn);
		}		
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

	public void clearCourse(String nameIn){
		int nameIndex = -1;
		for(int i = 0; i<courseList.size(); i++){
			if(nameIn.equals(courseList.get(i))){
				courseList.remove(i);
				nameIndex = i;
				break;
			}
		}
		if(nameIndex != -1){
			notifyAll(nameIndex);
		}
	}

	public void notifyAll(int clearNameIndex){
		for(Node backup_node : nodeList){
			backup_node.update(clearNameIndex);
		}
	}

	public void update(int nameIndex){
		courseList.remove(nameIndex);
	}
}