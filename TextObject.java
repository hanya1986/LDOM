/*
 * TextObject.java
 * 
 * Version:
 * $id$
 * Revisions:
 * $Log: TextObject.java,v $
 * Revision 1.5  2014/10/02 03:01:33  yc7816
 * last version for submit
 *
 * 
 */
import java.util.ArrayList;
import java.util.List;

/**
 * @Author's Login ID: yc7816
 * @Name: Yihao Cheng
 * This class represents DocObjects consisting of completely plain text.
 */

public class TextObject implements DocObject {
	/**
	 * Declare the List into ArrayList and create an object.
	 */
    private String text;
    List<DocObject> child = new ArrayList<DocObject>();
    
    /**
     * Create a text object.
     * @param text
     */
	public TextObject(String text) {
		this.text = text;
	}
	
	/**
	 * Convert this subtree of the document into plain-text HTML
	 * @return String
	 */
	public String generateHTML(){
		   return text;	
	}
	
	/**
	 * Count that how many characters are in this subtree of the document except whitespace.
	 * @return 0;
	 * @return text length minus counter
	 */
	public long characterCount(){
		int counter = 0;
		if(text == null){
		    return 0;
		}
		else{
			for (int i = 0; i < text.length(); i++){
				if (text.charAt(i) == ' '){
					counter++;
				}
			}
			return text.length() - counter;
		}
	}
	
	/**
	 * Search for a given character sequence in this subtree of the document
	 * @param s
	 * @return boolean
	 * @return boolean
	 */
	public boolean contains(String s){
			if(text.toLowerCase().contains(s.toLowerCase())){
			    return true;
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
		if(this == oldObj){
			oldObj = newObj;
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
	 * the TextObject's internal string from the constructor.
	 * @return String
	 */
	public String getText(){
	    return "\""+ text +"\"";
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
		text = text.replaceAll(oldS, newS);
	}
		
}

