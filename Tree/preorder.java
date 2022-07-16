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
