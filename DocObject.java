/*
 * DocObject.java
 * 
 * Version:
 * $id$
 * Revisions:
 * $Log: DocObject.java,v $
 * Revision 1.3  2014/10/02 03:01:32  yc7816
 * last version for submit
 *
 * 
 */

/**
 * @Author's Login ID: yc7816
 * @Name: Yihao Cheng
 * An element in a document. DocObjects form a tree. Some implementors can have multiple children; others wrap a single other DocObject,
 * whereas the TextObject class is a leaf -- no children.
 */
public interface DocObject {

	public String generateHTML();
	public long characterCount();
	public boolean contains(String s);
	public java.util.List<DocObject> children();
	public void replace(DocObject oldObj, DocObject newObj);
	public void replace(String oldS, String newS);
	public void addChild(int before, DocObject dObj);
	public boolean isRoot();

}
