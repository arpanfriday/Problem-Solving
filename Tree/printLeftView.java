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
