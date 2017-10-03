package studentCoursesBackup.myTree;

/**
* Subject1 class.
* Created by Aravind Venkit for cs542 - Design patterns.
* SubjectI interface to notify all the observer nodes (backup nodes) to be updated.
* @author Aravind Venkit
*/
public interface SubjectI{
	// Method to notify all the observer nodes (backup nodes) to be updated.
	public void notifyAll(int clearNameIndex);
}