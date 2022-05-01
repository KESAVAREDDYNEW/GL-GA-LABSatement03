package labSession3;
import java.util.*;
class Node{
	int nodeData;
	Node leftNode, rightNode;
	Node(int nodeData){
		this.nodeData=nodeData;
		leftNode=null;
		rightNode=null;
	}
}
public class SumInBst {
	public Node insert(Node root, int key) {
		if (root == null)
			return new Node(key);
		if(key<root.nodeData)
			root.leftNode = insert(root.leftNode,key);
		else
			root.rightNode=insert(root.rightNode, key);
		return root;
	}
public boolean findPairForSum(Node root, int sum,HashSet<Integer>set) {
	if(root==null)
		return false;
	if(findPairForSum (root.leftNode,sum,set))
		return true;
	if(set.contains(sum-root.nodeData)) {
		System.out.println("Pair is found"+(sum-root.nodeData)+","+(root.nodeData));
		return true;
	}
	else
		set.add(root.nodeData);
	return findPairForSum(root.rightNode, sum,set);
}
public void findPairWithGivenSum(Node root, int sum) {
	HashSet<Integer> set = new HashSet<Integer>();
	if(!findPairForSum(root,sum,set)) 
		System.out.println("Pairs do not exit");
		
	}
public static void main (String[] args) {
	Node root = null;
	SumInBst findSP= new SumInBst();
	root = findSP.insert(root, 40);
	root = findSP.insert(root, 20);
	root = findSP.insert(root, 60);
	root = findSP.insert(root, 10);
	root = findSP.insert(root, 30);
	root = findSP.insert(root, 50);
	root = findSP.insert(root, 70);
	int sum;
	Scanner sc= new Scanner(System.in);
	System.out.println(" Please enter the sum value to find pair in BST:");
	sum= sc.nextInt();
	findSP. findPairWithGivenSum(root,sum);
	sc.close();
}
}

