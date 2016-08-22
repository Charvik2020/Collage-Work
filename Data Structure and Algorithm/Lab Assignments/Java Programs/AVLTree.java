// File: AVLTree.java

import java.util.*;

/**
 *  
 * TODO: Fill in the following information
 *
 * Student:
 *     Family Name   :
 *     Given Name    :
 *     Student ID    :
 *
 * Implementation of an AVL Tree (once you fill in the missing code).
 *  
 */


public class AVLTree
{
  /** Root of the AVL tree. */
  protected Node root;

  /**
   * The constructor creating a binary search tree with just
   * a <code>null</code>, which is the root.
   */
  public AVLTree()
  {
    root = null;
  }
  
  
  /**
   * Searches the tree for a node with a given key. If such a 
   * node exists, prints the value of that node. 
   *
   * @param k The key being searched for.
   * @return The data under the key k
   * An exception NoSuchElementException is thrown if no node exists.
   */
  public int search(int k)
  {
    Node node = search(root,k);
    System.out.println(" " + node.printNode());
    return node.data;
  } //search

  /**
   * Searches the subtree rooted at a given node for a node with a
   * given key.  
   * 
   * @param node Root of the subtree.
   * @param k The key being searched for.
   * @return A reference to a <code>Node</code> object with key
   * <code>k</code> if such a node exists.
   * An exception NoSuchElementException is thrown if no node exists.
   */
  protected Node search(Node node, int k)
  {
    while ((node != null) && (k != node.key)) {
            if (k < node.key)
                node = node.left;
            else
                node = node.right;
     } //while

      if (node != null){
     return node;
        }
      else {
           throw new NoSuchElementException("Not Found");
      }
  } //search

  /**
   * Returns the node with the minimum key in the subtree rooted at
   * a node.
   *
   * @param x Root of the subtree.
   * @return A <code>Node</code> object with the minimum key in the
   * tree, or the sentinel <code>nil</code> if the tree is empty.
   */
  protected Node treeMinimum(Node x)
  {
    while (x.left != null)
      x = x.left;
    
    return x;
  } //treeMinimum
  
  /**
   * Returns the successor of a given node in an inorder walk of the
   * tree.
   *
   * @param node The node whose successor is returned.
   * @return If <code>node</code> has a successor, it is returned.
   * Otherwise, return the sentinel <code>null</code>.
   */
  protected Node successor(Node node)
  {
    Node x = node;
    
    if (x.right != null)
      return treeMinimum(x.right);
    
    Node y = x.parent;
    while (y != null && x == y.right) {
      x = y;
      y = y.parent;
    }
    
    return y;
  } //successor
  
  /**
   * Performs single left rotation.
   * @param A Node around which the rotation takes place
   */ 
   protected void singleLeftRotation(Node A)
   {
     // TODO : Implement rotation;	   
   }//singleLeftRotation
   
   /**
   * Performs single right rotation.
   * @param A Node around which the rotation takes place
   */ 
   protected void singleRightRotation(Node A)
   {
     // TODO : Implement rotation;	   
   }//singleRightRotation
   
   /**
   * Performs double right left rotation.
   * @param A Node around which the rotation takes place
   */ 
   protected void doubleRightLeftRotation(Node A)
   {
     // TODO : Implement rotation;	   
   }//doubleRightLeftRotation
   
   /**
   * Performs double left right rotation.
   * @param A Node around which the rotation takes place
   */ 
   protected void doubleLeftRightRotation(Node A)
   {
     // TODO : Implement rotation;	   
   }//doubleLeftRightRotation
   
   /** Balances a right-heavy or left-heavy unbalanced tree.
    * This function should check for the nature of the imbalance
    * and call the appropriate rotation functions. In addition, after
    * rotations are performed,
    * it should update the balance factors of the rotated nodes accordingly. 
    * @param A The root of the unbalanced tree.
    * @return The new root of the tree
    */
   protected Node balance(Node A)
   {
     //TODO: Implement balancing
     return null; 
   }
   
  /**
   * Inserts a key and a data item into the tree, creating a new 
   * node for this key and data pair.
   *
   * @param key, data: Key and Data to be inserted into the tree.
   */
  public void insert(int key, int data)
  {
    Node z = new Node(key, data);
    treeInsert(z);
  } //insert
  
  /**
   * Inserts a node into the tree.
   *
   * @param z The node to insert.
   */
  protected void treeInsert(Node z)
  {
    Node y = null;
    Node x = root;
    
    while (x != null) {
      y = x;
      if (z.key <= x.key)
        x = x.left;
      else
        x = x.right;
    } //while
    
    z.parent = y;
    if (y == null)
      root = z;  // the tree had been empty
    else {
      if (z.key <= y.key)
        y.left = z;
      else
        y.right = z;
    }//else

    //TODO: Insert code to update balance factors and 
    //perform rotations if necessary. 
    
  } //treeInsert

  /**
   * Removes a node with the given key from the tree.
   * It is assumed that there is at most one node with the given
   * key present in the tree.
   *
   * @param k The key to be removed.
   */
  public void deleteKey(int k)
  {
    Node node = (Node) search(root, k);
    if (node != null)
      delete(node);
    else
      throw new NoSuchElementException("Not Found");
  } //deleteKey

  /**
   * Removes a node from the tree.
   *
   * @param node The node to be removed.
   * do nothing when deleting a null node <code>null</code>.
   *
   */
  protected void delete(Node node)
  {
    // TODO: Alter and add code to this function to support
    // AVL deletions

    Node z = node;
    
    // Make sure that there is no attempt to delete a null node
    if (z == null)
      throw new NoSuchElementException("empty node");
    
    Node x;   // Replaces z as the subtree's root
    
    if (z.left == null){   // has no left child
      x = z.right;
    }
    else if (z.right == null) // has no right child
      x = z.left;
    else {                 // has two children 
      x = (Node) successor(z); // replace z with its successor  
      delete(x); // Delete the node where the successor was 
      
      // Splice out z and put x in its place by fixing links
      // with children.
      x.left = z.left; 
      x.right = z.right;
      if (x.left != null) x.left.parent = x;
      if (x.right != null) x.right.parent = x;
    } //else
    
    // Fix links between the parent of the subtree and x.
    if (x != null)
      x.parent = z.parent;
    if (root == z)
      root = x;
    else{
      if (z == z.parent.left)
          z.parent.left = x;
      else
          z.parent.right = x;
    } //else

    // TODO: Insert code to update balance factors and
    // rebalance tree

  } //delete     


  /**
   * Print the whole tree.
   *
   */
  public void print() {
    printHelper(root,"");
    System.out.print("\n");
  } //print
  
  /**
   * Print the tree rooted at <code>root</code>, with indent preceding 
   * all output lines.
   * The tree is printed rotated by 90 degrees.  
   * If there is no node at a given position of the tree, the 
   * character 'x' is printed. 
   *
   * @param root The root of the tree to be printed.
   * @param indent The number of spaces to go before output lines.
   *
   * WARNING: DO NOT MODIFY THIS METHOD!!!
   */
  protected static void printHelper(Node n, int indent) {
    
    String blanks="";
    for (int i=0;i<indent;++i) blanks=blanks+" ";
    
    if (n == null) {
      System.out.println(blanks+"x");
      return;
    }
    
    
    printHelper(n.right, indent+n.printNode().length());
    System.out.println(blanks+n.printNode());
    printHelper(n.left, indent+n.printNode().length());
   
  }//printHelper
  
  /**
   * Print the tree rooted at <code>root</code>, with indent preceding 
   * all output lines.
   * The tree is printed rotated by 90 degrees. Bars ("|")are 
   * added to indicate the parent node edges. It is memory-intensive,
   * so for large trees the integer version is recommended. 
   * If there is no node at a given position of the tree, the 
   * character 'x' is printed. 
   *
   * @param root The root of the tree to be printed.
   * @param indent The number of spaces to go before output lines.
   *
   * WARNING: DO NOT MODIFY THIS METHOD!!!
   */
  private static void printHelper(Node n, String indent) {
    
   
    if (n == null) {
      System.out.println(indent+"x");
      return;
    }
   
    String blanks="";
    for (int i=0;i<n.printNode().length();++i) blanks=blanks+" ";
    String barandblanks="|";
    for (int i=0;i<n.printNode().length()-1;++i) barandblanks = barandblanks+" ";

    if (n.parent == null) //root
    {
      printHelper(n.right, indent+blanks);
      System.out.println(indent+"*"+n.printNode());
      printHelper(n.left, indent+blanks);
      return;
    } 
    
    if (n.parent.left == n)
    {
      printHelper(n.right, indent+barandblanks);
      System.out.println(indent+"|"+n.printNode());
      printHelper(n.left, indent+blanks);
    } else
    {
      printHelper(n.right, indent+blanks);
      System.out.println(indent+"|"+n.printNode());
      printHelper(n.left, indent+barandblanks);
    }
  }//printHelper

}
