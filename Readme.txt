[Date: 09/25/2017]
[By: Aravindhan Venkituswamy]

Assuming you are in the directory containing this README:
got to studentCoursesBackup directory then,

## To clean:
ant -buildfile src/build.xml clean

-----------------------------------------------------------------------
## To compile: 
ant -buildfile src/build.xml all

-----------------------------------------------------------------------
## To run by specifying arguments from command line 
## We will use this to run your code
ant -buildfile src/build.xml run -Darg0=FIRST -Darg1=SECOND -Darg2=THIRD -Darg3=FOURTH -Darg4=FIFTH

-----------------------------------------------------------------------

## To create tarball for submission
ant -buildfile src/build.xml tarzip or tar -zcvf studentCoursesBackup.tar.gz studentCoursesBackup

-----------------------------------------------------------------------

Provide justification for Data Structures used in this assignment in
term of Big O complexity (time and/or space)

Used Binary Search Tree - BST 
Insert: O(n)	
Delete: O(n)
Search: O(n)	

Observer pattern:
When the original node the subject gets updated the subject will notify all other observes(backup nodes). The observer intern will update respective backup node.

-----------------------------------------------------------------------

Provide list of citations (urls, etc.) from where you have taken code
(if any).
http://www.geeksforgeeks.org/binary-search-tree-set-1-search-and-insertion/
https://www.youtube.com/watch?v=nZ76x13Nm8Q
