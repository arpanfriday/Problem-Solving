int countNodes(BinaryTree<Integer> root) {
    // If no node(reach to null) treat it as 0
    if (root == null)
        return 0;
    int counter = 1;
    counter += countNodes(root.left);
    counter += countNodes(root.right);
    return counter;
}
