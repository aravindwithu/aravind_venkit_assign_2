package studentCoursesBackup.myTree;

/**
* Subject1 class.
* Created by Aravind Venkit for cs542 - Design patterns.
* SubjectI interface to notify all the observer nodes (backup nodes) to be updated.
* @author Aravind Venkit
*/
public interface SubjectI{
	/**
	* notifyAll method.
	* called from subject node to notifies the observer nodes.
	* notifies the respective index in the course list.
	* @param clearNameIndex
	*/
	public void notifyAll(int clearNameIndex);
}