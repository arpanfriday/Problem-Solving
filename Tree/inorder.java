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
