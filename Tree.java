package Node;

public class Tree {
	Node root;
	public class Node {
		Key key;
		Value value;
		Node left;
		Node right;
		
	public class Key{
		int key;
		public int compareTo(int b) {
			if(key<b) {
				return -1;
			}
			else if(key>b) {
				return 1;
			}
			else {
				return 0;
			}
		}
		
	}
	public class Value{int value;}
	public Node(Key key,Value value) {
		this.left=null;
		this.right=null;
		this.key=key;
		this.value=value;
	}

	}


    public Tree() {
	this.root=null;
    }
    public void put(Tree.Node.Key key,Tree.Node.Value val) {
	root=add(root,key,val);
    }
    private Node add(Node x,Tree.Node.Key key,Tree.Node.Value val) {
	if(x==null) {
		return new Node(key,val);
	}
	int cmp=key.compareTo(x.key.key);
	if(cmp>0) {
		x.right=add(x.right,key,val);
	}
	else if (cmp<0) {
		x.left=add(x.left,key,val);
	}
	else {
		x.value=val;
	}
	return x;
}
public Node find(Tree.Node.Key key) {
	Node x=root;
	while(x!=null) {
		int cmp=key.compareTo(x.key.key);
		if(cmp<0) {
			x=x.left;
		}
		else if(cmp>0) {
			x=x.right;
		}
		else {
			return x;
		}
	}
	return null;
}
public void update(Tree.Node.Key key,int value) {
	Node x=root;
	while(x!=null) {
		int cmp=key.compareTo(x.key.key);
		if(cmp<0) {
			x=x.left;
		}
		else if(cmp>0) {
			x=x.right;
		}
		else {
			x.value.value=value;
		}
	}
	
}
public void delete(Tree.Node.Key key) {
	Node current=root;
	Node parent=root;
	boolean isleft=true;
	while(current.key.key!=key.key) {
		parent=current;
		int  cmp=key.compareTo(current.key.key);
		if(cmp<0) {
			isleft=true;
			current=current.left;
		}
		else if(cmp>0) {
			isleft=false;
			current=current.right;
		}
	}
	if(current.left==null&&current.right==null) {
		if(current==root) 
			root=null;
		else {
			if(isleft=true) {
				parent.left=null;
			}
			else
				parent.right=null;
		}	
	}
	else if(current.right==null) {
		if(current==root) {
			root=null;
		}
		else {
			if(isleft==true) {
				parent.left=current.left;
			}
			else {
				parent.right=current.left;
			}
		}
	}
	else if(current.left==null) {
		if(current==root) {
			root=null;
		}
		else {
			if(isleft==true) {
				parent.left=current.right;
			}
			else {
				parent.right=current.right;
			}
		}
	}
}
}