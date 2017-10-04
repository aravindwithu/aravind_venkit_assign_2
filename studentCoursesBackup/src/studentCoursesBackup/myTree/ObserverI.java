package studentCoursesBackup.myTree;

/**
* Observer1 class.
* Created by Aravind Venkit for cs542 - Design patterns.
* ObserverI interface to update the observer nodes (backup nodes).
* @author Aravind Venkit
*/
public interface ObserverI{
	/**
	* update method.
	* updates the respective index in the course list of observer nodes.
	* @param String nameIn
	*/
	public void update(int nameIndex);
}