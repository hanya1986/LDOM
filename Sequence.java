/*
 * Sequence.java
 * 
 * Version:
 * $id$
 * Revisions:
 * $Log: Sequence.java,v $
 * Revision 1.4  2014/10/02 03:01:32  yc7816
 * last version for submit
 *
 * 
 */
import java.util.ArrayList;
import java.util.List;

/**
 * @Author's Login ID: yc7816
 * @Name: Yihao Cheng
 * A simple ordered sequence of DocObjects. This is used to string things together into a paragraph or just the body of a list item.
 */

public class Sequence implements DocObject {
	/**
	 * Declare the List into ArrayList and create an object.
	 */
	List<DocObject> child = new ArrayList<DocObject>();
	/**
	 * Create a empty constructor
	 */
	public Sequence(){}
	
	/**
	 * Convert this subtree of the document into plain-text HTML
	 * @return String
	 */
	public String generateHTML(){
		String returnValue = "";
		for(int i = 0; i <child.size(); i++){
			returnValue = returnValue + child.get(i).generateHTML();
		}
		return  returnValue;	
	}
	
	/**
	 * Count that how many characters are in this subtree of the document except whitespace.
	 * @return counter
	 */
	public long characterCount(){
		int counter = 0;
		for (int i = 0; i < child.size(); i++){
			DocObject obj = child.get(i);
            counter += obj.characterCount(); 
		}
		return counter;
	}
	
	/**
	 * Search for a given character sequence in this subtree of the document
	 * @param s
	 * @return boolean
	 * @return boolean
	 */
	public boolean contains(String s){
		for(int i = 0; i < child.size();i++){
			DocObject obj = child.get(i);
			if(obj.contains(s)){
		        return true;
		    }
		}
			return false;
	}
	
	/**
	 * Find out the subtrees of this document
	 * @return ArrayList child
	 */
	public java.util.List<DocObject> children(){
		return child;
	}
	
	/**
	 * Replace all occurrences of the search object with a new object. 
	 * The equality operator "==" (not the equals method) is used to identify the search object in the document tree. 
	 * The assignment operator (not a copying operation) is used to insert the new object. 
	 * If this node's type is one that does not have children, this method is a no-op.
	 * @param oldObj
	 * @param newObj
	 */
	public void replace(DocObject oldObj, DocObject newObj){
		for (int i = 0; i < child.size(); i++){
			DocObject Obj = child.get(i);
			if(Obj == oldObj){
		         child.set(i, newObj);
			}
			Obj.replace(oldObj, newObj);
		}
	}
	
	/**
	 * Insert a new document object node into the list of children of this node. 
	 * If this node's type is one that does not have children, or that has a fixed number of children when created,
	 * a BadChildException (a descendant of RuntimeException) will occur.
	 * @param before
	 * @param dObj
	 * @throws BadChildException
	 */
	public void addChild(int before, DocObject dObj) throws BadChildException{
		if(dObj.characterCount()== 0){
		    throw new BadChildException();
		}
		child.add(before, dObj);
	}
	
	/**
	 * To Check if it is the root of the tree
	 * @return boolean
	 */
	public boolean isRoot(){
		return false;
	}
	
	/**
	 * Replace all occurrences of the search string with a new string. As in the contains method, 
	 * the search string must exist completely within one document object node.
	 * If this node's type is one that does not have children, this method is a no-op.
	 * @param oldS
	 * @param newS
	 */
	public void replace(String oldS, String newS){
		for (int i = 0; i < child.size(); i++){
			DocObject Obj = child.get(i);
			Obj.replace(oldS, newS);			
		}
	}
}