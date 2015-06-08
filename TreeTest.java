import java.util.Scanner;

public class TreeTest{
	public static String nodeValue = "12#3";
	public static void main(String[] args) {
		Tree<Integer> tree = new Tree<Integer>();
		tree.createTree();
		tree.printTree();
	}
}

class Tree<T> {
	
	private TreeNode<T> root;
	
	public Tree(){
	}
	
	public Tree(TreeNode<T> root) {
		this.root = root;
	}
	
	public void createTree() {
		root = buildTree(root);
	}

	public TreeNode<T> buildTree(TreeNode<T> node) {
		if(TreeTest.nodeValue.length()<=0)
			return node;
		String temp = TreeTest.nodeValue.substring(0, 1);
		if(temp.equals("#")) {
			TreeTest.nodeValue = TreeTest.nodeValue.substring(1);
			return null;
		}
		else {
			TreeTest.nodeValue = TreeTest.nodeValue.substring(1);
			node = new TreeNode<T>((T)temp);
			node.setLeft(buildTree(node.getLeft()));
			node.setRight(buildTree(node.getRight()));
			return node;
		}
	}
	
	public void printTree(){
		System.out.println(root.getValue());
		if(root.getLeft()!=null) {
			Tree left = new Tree(root.getLeft());
			left.printTree();
		}
		if(root.getRight()!=null) {
			Tree right = new Tree(root.getRight());
			right.printTree();
		}
		return;
	}
}

class TreeNode<T>{
	private TreeNode<T> left;
	private TreeNode<T> right;
	private T value;
	
	public TreeNode() {
	}
	
	public TreeNode(TreeNode<T> left, TreeNode<T> right,T value) {
		this.left = left;
		this.right = right;
		this.value = value;
	}
	
	public TreeNode(T value) {
		this(null, null, value);
	}
	
	public TreeNode<T> getLeft() {
		return this.left;
	}
	
	public TreeNode<T> getRight() {
		return this.right;
	}
	
	public void setLeft(TreeNode<T> left) {
		this.left = left;
	}
	
	public void setRight(TreeNode<T> right) {
		this.right = right;
	}
	
	public T getValue(){
		return value;
	}
	
	public void setValue(T value) {
		this.value = value;
	}

}