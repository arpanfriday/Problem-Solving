import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;
import java.util.TreeMap;

import javax.management.Query;

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
        parent = data;
        node.right = insert();
        parent = data;
        msg = "root";
        return node; // return root node
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

    void preOrderIterative(BinaryTree<Integer> root) {
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

    void levelOrder(BinaryTree<Integer> root) {
        // root node goes in a queue
        // step 1 = create a queue
        Queue<BinaryTree> queue = new LinkedList<>();
        queue.add(root);
        // step 2- traverse queue till it is not empty
        // 2.1- queue poll and get the node and then look for left and right child
        // 2.2- add them in qieie
        // repeat step 2
        while (!queue.isEmpty()) {
            BinaryTree<Integer> node = queue.poll();// we get the first element
            System.out.print(node.data + " , ");
            if (node.left != null)
                queue.add(node.left);
            if (node.right != null)
                queue.add(node.right);

        }
        System.out.println();
    }

    int height(BinaryTree<Integer> root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        return 1 + Math.max(leftHeight, rightHeight);
    }

    int countNodes(BinaryTree<Integer> root) {
        // If no node(reach to null) treat it as 0
        if (root == null)
            return 0;
        int counter = 1;
        counter += countNodes(root.left);
        counter += countNodes(root.right);
        return counter;
    }

    int maxLevel = 0;

    void printLeftView(BinaryTree<Integer> root, int level) {
        if (root == null) {
            return;
        }
        if (maxLevel < level) {
            System.out.println(root.data);
            maxLevel = level;
        }
        printLeftView(root.left, level + 1);
        printLeftView(root.right, level + 1);
    }

    void printLeftView2(BinaryTree<Integer> root) {
        // Perform in BFT (Level order)
        if (root == null) {
            return;
        }
        Queue<BinaryTree<Integer>> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int count = queue.size();
            for (int i = 0; i < count; i++) {
                BinaryTree<Integer> node = queue.poll();
                if (i == 0) {
                    System.out.println(node.data);
                }
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }
    }

    void verticalOrderHelper(BinaryTree<Integer> root, int distance, TreeMap<Integer, ArrayList<Integer>> map) {
        // termination case
        if (root == null) {
            return;
        }

        // stack build
        if (map.get(distance) == null) {
            // there is no such distance present (first time coming in map)
            // hence create a fresh list
            ArrayList<Integer> list = new ArrayList<>();
            list.add(root.data);
            map.put(distance, list);
        } else {
            // the key is already present in the map (fetch the key from the map)
            ArrayList<Integer> list = map.get(distance);
            list.add(root.data);
            map.put(distance, list);
        }
        // small problem
        verticalOrderHelper(root.left, distance - 1, map);
        verticalOrderHelper(root.right, distance + 1, map);
    }

    void verticalOrder(BinaryTree<Integer> root) {
        int distance = 0;
        TreeMap<Integer, ArrayList<Integer>> map = new TreeMap<>();
        verticalOrderHelper(root, distance, map);
        for (Map.Entry<Integer, ArrayList<Integer>> m : map.entrySet()) {
            System.out.println(m.getKey() + " " + m.getValue());
        }
    }
}

public class BinaryTreeDemo {
    public static void main(String[] args) {
        BinaryTreeOperations opr = new BinaryTreeOperations();
        BinaryTree<Integer> root = opr.insert();
        // opr.print(root);
        // opr.levelOrder(root);
        opr.verticalOrder(root);
    }
}
