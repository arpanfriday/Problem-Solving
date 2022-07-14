import java.util.Scanner;
import java.util.Stack;

class BinaryTree<T> {
    T data;
    BinaryTree<T> left; // left child reference
    BinaryTree<T> right; // right child reference

    BinaryTree(T data) {
        this.data = data;
        // default left and right are null
    }
}

class BinaryTreeOperations {
    String msg = "root";
    Scanner sc = new Scanner(System.in);
    int parent = -1;

    BinaryTree<Integer> insert() {
        System.out.println("Enter the data for " + msg + " node and parent is " + parent + ": \nTo exit enter -1");
        int data = sc.nextInt();

        // termination case
        if (data == -1) {
            return null;
        }
        // create a parent node (root Node)
        BinaryTree<Integer> node = new BinaryTree<>(data);
        parent = data;
        msg = "left";
        node.left = insert();
        msg = "right";
        node.right = insert();
        msg = "root";
        return node; // return root at the end
    }

    void print(BinaryTree<Integer> currentNode) {
        // termination case
        if (currentNode == null) {
            return;
        }
        String output = "";
        output += currentNode.data + " => ";
        if (currentNode.left != null) {
            output += "Left : " + currentNode.left.data + " , ";
        }
        if (currentNode.right != null) {
            output += "Right : " + currentNode.right.data + " , ";
        }
        System.out.println(output);
        print(currentNode.left);
        print(currentNode.right);
    }

    void preOrder(BinaryTree<Integer> root) {
        // parent , left, right
        if (root == null) {
            return;
        }
        System.out.println(root.data);
        preOrder(root.left); // small problem of the recursion
        preOrder(root.right);
    }

    void preOrderIterative(BinaryTree<T> root) {
        if (root == null) {
            return;
        }
        // Step 1- start with a stack and push the first node in the stack
        Stack<BinaryTree> stack = new Stack<>();
        stack.push(root);
        // Step 2- Keep popping the element till stack is empty
        // pop and print it
        // put the right child first in a stack and then put the left child in the stack
        // The benifit of above is left is on top
        // ensure that left and right is not null
        // Step 3- Repeat
        while (!stack.empty()) {
            BinaryTree<Integer> node = stack.pop();
            System.out.print(node.data + " ");
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
    }

    void inOrder(BinaryTree<Integer> root) {
        // parent , left, right
        if (root == null) {
            return;
        }
        inOrder(root.left); // small problem of the recursion
        System.out.println(root.data);
        inOrder(root.right);
    }

    void inorderIterative(BinaryTree<Integer> root) {
        Stack<BinaryTree<Integer>> stack = new Stack<>();
        BinaryTree<Integer> temp = null;
        temp = root;
        while (temp != null || !stack.empty()) {
            while (temp != null) {
                stack.push(temp);
                temp = temp.left;
            }
            temp = stack.pop();
            System.out.print(temp.data + " ");
            temp = temp.right;
        }
    }

    void postOrder(BinaryTree<Integer> root) {
        // parent , left, right
        if (root == null) {
            return;
        }
        postOrder(root.left); // small problem of the recursion
        postOrder(root.right);
        System.out.println(root.data);
    }
}

public class BinaryTreeDemo {
    public static void main(String[] args) {
        BinaryTreeOperations opr = new BinaryTreeOperations();
        BinaryTree<Integer> root = opr.insert();
        opr.print(root);
    }
}
