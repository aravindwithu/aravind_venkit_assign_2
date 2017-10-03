package studentCoursesBackup.myTree;

/**
* Observer1 class.
* Created by Aravind Venkit for cs542 - Design patterns.
* ObserverI interface to update the observer nodes (backup nodes).
* @author Aravind Venkit
*/
public interface ObserverI{
	// Method to update the observer nodes (backup nodes).
	public void update(int nameIndex);
}