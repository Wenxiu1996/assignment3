package Node;

public class Tree {
	Node root;
	

public Tree() {
	this.root=null;
}
public void put(int key,int val) {
	root=add(root,key,val);
}
private Node add(Node x,int key,int val) {
	if(x==null) {
		return new Node(key,val);
	}
	int cmp=key.compareTo(x.key);
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
public Node find(int key) {
	Node x=root;
	while(x!=null) {
		int cmp=key.compareTo(x.key);
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
public void update(int key,int value) {
	Node x=root;
	while(x!=null) {
		int cmp=key.compareTo(x.key);
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
	return null;
}
public void delete(int key) {
	Node current=root;
	Node parent=root;
	boolean isleft=true;
	while(current.key!=key) {
		parent=current;
		int  cmp=key.compareTo(current.key);
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