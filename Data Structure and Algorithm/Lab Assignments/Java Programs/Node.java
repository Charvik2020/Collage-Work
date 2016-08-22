// File: Node.java

/**
 *  
 * Class for storing a node of an AVL tree
 *
 * DO NOT SUBMIT THIS FILE
 **/


public class Node
  {
    /** The key stored in the node. */
    public int key;
    
    /** The data stored in the node. */
    public int data;
    
    /** The node's parent. */
    public Node parent;
     
    /** The node's balanceFactor. */
    public int bf;
    
    /** The node's left child. */
    public Node left;
    
    /** The node's right child. */
    public Node right;
    
    /**
     * Initializes a node with the key and the data and makes other pointers
     * null. The Balance Factor is initialized to be 0. 
     *
     * @param key  Key of the new node. 
     * @param data Data to save in the node.
     */
    public Node(int key, int data)
    {
      this.key = key;
      this.data = data;
      this.parent = null;
      this.left = null;
      this.right = null;
      this.bf = 0;
    } //Node
    
    /**
     * Returns the node as a <code>String</code>.
     */
    public String printNode()
    {
      if (this == null)
        return "x";
      else
        return key + "," + data + "(" + bf + ")";
    }//printNode
  }
