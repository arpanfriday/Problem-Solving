void postOrder(BinaryTree<Integer> root) {
    // parent , left, right
    if (root == null) {
        return;
    }
    postOrder(root.left); // small problem of the recursion
    postOrder(root.right);
    System.out.println(root.data);
}

void postOrderIterative(BinaryTree<Integer> root) {
    if (root == null) {
        return;
    }
    Stack<BinaryTree> stack = new Stack<>();
    ArrayList<Integer> list = new ArrayList<>();
    stack.push(root);
    while (!stack.empty()) {
        BinaryTree<Integer> node = stack.pop();
        list.add(node.data);
        if (node.left != null) {
            stack.push(node.left);
        }
        if (node.right != null) {
            stack.push(node.right);
        }
    }
    Collections.reverse(list);
    System.out.println(list);
}
