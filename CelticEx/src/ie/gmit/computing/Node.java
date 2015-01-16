package ie.gmit.computing;

public class Node {
	private String name;
	private Node parent;
	private Node[] children = new Node[0]; // An array of all this node's child nodes.

	public Node(String name, Node parent) {
		super();
		this.name = name;
		this.parent = parent;
	}


	public Node(String name, Node parent, Node[] children) {
		super();
		this.name = name;
		this.parent = parent;
		this.children = children;
	}

	public Node(String currentNode) {
		// TODO Auto-generated constructor stub
		this.name = currentNode;
	}


	public Node() {
		// TODO Auto-generated constructor stub
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void add (Node child, int index) //Adds the <code>child</code> node to this container making this its parent.
	  {
	    // Add the child to the list of children.
	    if ( index < 0 || index == children.length )  // then append
	    {
	    	Node[] newChildren = new Node[ children.length + 1 ];
	      System.arraycopy( children, 0, newChildren, 0, children.length );
	      newChildren[children.length] = child;
	      children = newChildren;
	    }
	    else if ( index > children.length )
	    {
	      throw new IllegalArgumentException("Cannot add child to index " + index + ".  There are only " + children.length + " children.");
	    }
	    else  // insert
	    {
	    	Node[] newChildren = new Node[ children.length + 1 ];
	      if ( index > 0 )
	      {
	        System.arraycopy( children, 0, newChildren, 0, index );
	      }
	      newChildren[index] = child;
	      System.arraycopy( children, index, newChildren, index + 1, children.length - index );
	      children = newChildren;
	    }
	    
	    // Set the parent of the child.
	    child.parent = this;
	  }
	
	public void add (Node child) //Adds the <code>child</code> node to this container making this its parent
	  {
	    add( child, -1 );
	  }
	
	/**
	   * Removes the child at position from the tree.
	   * 
	   *  index is the position of the child.  It should be between
	   *  0 (the first child) and the total number of children minus 1
	   *  (the last child).
	   * 
	   */
	  public Node remove (int index)
	  {
	    if ( index < 0 || index >= children.length ) throw new IllegalArgumentException("Cannot remove element with index " + index + " when there are " + children.length + " elements.");
	    
	    // Get a handle to the node being removed.
	    Node node = children[index];
	    node.parent = null;
	    
	    // Remove the child from this node.
	    Node[] newChildren = new Node[ children.length - 1 ];
	    if ( index > 0 )
	    {
	      System.arraycopy( children, 0, newChildren, 0, index );
	    }
	    if ( index != children.length - 1 )
	    {
	      System.arraycopy( children, index + 1, newChildren, index, children.length - index - 1 );
	    }
	    children = newChildren;
	    
	    return node;
	  }
	  
	  /**
	   * Removes this node from its parent.  This node becomes the root
	   * of a subtree where all of its children become first level
	   * nodes.
	   */
	  public void removeFromParent ()
	  {
	    if ( parent != null )
	    {
	      int position = this.index();
	      parent.remove( position );
	      parent = null;
	    }
	  }

	  /**
	   * Gets the parent node of this one.
	   * 
	   * return The parent of this node.  This will return 
	   *  if this node is the root node in the tree.
	   */
	  public Node getParent ()
	  {
	    return parent;
	  }
	
	   
	  public boolean isRoot () //Returns if this node is the root node in the tree or not.
	  {
	    if ( parent == null )
	    {
	      return true;
	    }
	    else
	    {
	      return false;
	    }
	  }
	  
	  public Node[] children ()
	  {
	    return children;
	  }
	  
	  public boolean hasChildren () //Returns if this node has children or if it is a leaf node.

	  {
	    if ( children.length == 0 )
	    {
	      return false;
	    }
	    else
	    {
	      return true;
	    }
	  }

	  /**
	   * Gets the position of this node in the list of siblings
	   * managed by the parent node.  This node can be obtained
	   * by this = parent.children[this.index()].
	   * 
	   * return The index of the child array of this node's
	   *  parent.  If this is the root node it will return -1.
	   */

	  public int index()
	  {
	    if ( parent != null )
	    {
	      for ( int i = 0; ; i++ )
	      {
	        Object node = parent.children[i];
	        
	        if ( this == node )
	        {
	          return i;
	        }
	      }
	    }
	    // Only ever make it here if this is the root node.
	    return -1;
	  }
	  
	  /**
	   * Gets this node's depth in the tree.  The root node will
	   * have a depth of 0, first-level nodes will have a depth
	   * of 1, and so on.
	   * 
	   * return The depth of this node in the tree.
	   */
	  public int depth ()
	  {
	    int depth = recurseDepth( parent, 0 );
	    return depth;
	  }

	  /**
	   * Recursive helper method to calculate the depth of a node.
	   * The caller should pass its parent and an initial depth of 0.
	   * 
	   * A recursive approach is used so that when a node that is
	   * part of a tree is removed from that tree, we do not need
	   * to recalculate the depth of every node in that subtree.
	   * 
	   *  node is the node to recursively check for its depth.
	   *  This should be set to <code>parent</code> by the caller.
	   *  depth is the depth of the current node (i.e. the
	   *  child of <code>node</code>).  This should be set to 0 by the
	   *  caller.
	   */
	  private int recurseDepth (Node node, int depth)
	  {
	    if ( node == null )  // reached top of tree
	    {
	      return depth;
	    }
	    else
	    {
	      return recurseDepth( node.parent, depth + 1 );
	    }
	  }

	  
	  /**
	   * A handle to the programmer assigned object encapsulated by this
	   * node.  This will be null when the user has not assigned
	   * any data to this node.
	   */
	  private Object m_userData;
	  
	  /**
	   * Attaches a user defined object to this node.  Only one
	   * object can be attached to a node.
	   */
	  public void setUserObject (Object userObject)
	  {
	    m_userData = userObject;
	  }
	  
	  /**
	   * Gets the user defined object attached to this node.  It
	   * must be cast back to what it was inserted as.  It is up
	   * to the developer to make this cast.
	   */
	  public Object getUserObject ()
	  {
	    return m_userData;
	  }
	}

