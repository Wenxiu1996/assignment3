package Node;

public class Tree {
	private Node root;
	private class Node {
		private Key key;
		private Value value;
		private Node left;
		private Node right;
		public Key getKey() {
			return key;
		}
		public void setKey(Key key) {
			this.key=key;
		}
		public Value getValue() {
			return value;
		}
		public void setValue(Value value) {
			this.value=value;
		}
		public Node(Key key,Value value) {
			this.left=null;
			this.right=null;
			this.key=key;
			this.value=value;
		}
	}
	private class Key{
		private int key;
		public int getKey() {
			return key;
		}
		public void setKey(int key) {
			this.key=key;
		}
		public Key(int key) {
			this.key=key;
		}
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
	

	


    public Tree() {
	this.root=null;
    }
    public void put(Key key,Value val) {
	root=add(root,key,val);
    }
    private Node add(Node x,Key key,Value val) {
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
public Value find(Key key) {
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
			return x.value;
		}
	}
	return null;
}
public void update(Key key,Value value) {
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
			x.value=value;
		}
	}
	
}
public void delete(Key key) {
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