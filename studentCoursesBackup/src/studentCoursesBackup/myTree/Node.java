package studentCoursesBackup.myTree;

import java.util.ArrayList;
import studentCoursesBackup.myTree.ObserverI;
import studentCoursesBackup.myTree.SubjectI;

/**
* Node class.
* Created for cs542 - Design patterns, Assignment 2.
* class to structure node structure.
* @author Aravind Venkit
*/
public class Node implements Cloneable, SubjectI, ObserverI{
	private int bNumber;
	private ArrayList<String> courseList;

	private Node leftChild;
	private Node rightChild;

	private ArrayList<Node> nodeList;

	/**
	* Node private constructor to intialize Node class.
	*/
	private Node(){
	}

	/**
	* Node public constructor to intialize Node class.
	* Intializes the Node variables.
	*/
	public Node(int keyIn, String nameIn){
		bNumber = keyIn;
		courseList  = new ArrayList<String>();
		courseList.add(nameIn);
		leftChild = new Node();
		rightChild = new Node();
		nodeList = new ArrayList<Node>();
	}
	
	/**
	* clone method to clone the node.
	* performs deep copy to clone the node object.
	* @return Node (cloned node object).
	* @throws CloneNotSupportedException
	*/
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

	/**
	* addReference method to add backup node reference to the original node.
	* @param Node backup_node
	*/
	public void addReference(Node backup_node){
		nodeList.add(backup_node);
	}

	/**
	* getBNumber method returns bNumber.
	* @return int (bNumber)
	*/
	public int getBNumber(){
		return bNumber;
	}

	/**
	* isCourseNull method.
	* @return boolean (is course array list null or not)
	*/
	public boolean isCourseNull(){
		if(0<courseList.size()){
			return false;
		}
		return true;
	}

	/**
	* getCourse method.
	* @return String (comma seperated courses)
	*/
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

	/**
	* getCourse method.
	* @return String (single course based on index)
	*/
	public String getCourse(int index){
		if(isCourseNull()){
			return null;
		}
		if(index >= courseList.size()){
			return null;
		}
		return courseList.get(index);
	}

	/**
	* setCourse method.
	* adds course to course list
	* @param String nameIn
	*/
	public void setCourse(String nameIn){
		if(!courseList.contains(nameIn)){
			courseList.add(nameIn);
		}		
	}

	/**
	* getLeftChild method.
	* @return Node (leftChild node)
	*/
	public Node getLeftChild(){
		return leftChild;
	}

	/**
	* setLeftChild method.
	* @param Node nodeIn (sets the leftChild)
	*/
	public void setLeftChild(Node nodeIn){
		leftChild = nodeIn;
	}

	/**
	* getRightChild method.
	* @return Node (rightChild node)
	*/
	public Node getRightChild(){
		return rightChild;
	}

	/**
	* setLeftChild method.
	* @param Node nodeIn (sets the rightChild)
	*/
	public void setRightChild(Node nodeIn){
		rightChild = nodeIn;
	}

	/**
	* setLeftChild method.
	* clears the original node course and as subject node notifies the observer nodes.
	* @param String nameIn
	*/
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

	/**
	* notifyAll method.
	* called from subject node to notifies the observer nodes.
	* notifies the respective index in the course list.
	* @param int clearNameIndex
	*/
	public void notifyAll(int clearNameIndex){
		for(Node backup_node : nodeList){
			backup_node.update(clearNameIndex);
		}
	}

	/**
	* update method.
	* updates the respective index in the course list of observer nodes.
	* @param String nameIn
	*/
	public void update(int nameIndex){
		courseList.remove(nameIndex);
	}
}