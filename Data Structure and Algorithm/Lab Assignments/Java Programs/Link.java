class Link
   {
   public int iData;              // data item (key)
   public Link next;              // next link in list
// -------------------------------------------------------------
   public Link(int id, Link newNext) // constructor
      {
      iData = id;
      next = newNext;
      }
// -------------------------------------------------------------
   public void displayLink()      // display ourself
      {
      System.out.print("{" + iData + "} ");
      }
   }  // end class Link
