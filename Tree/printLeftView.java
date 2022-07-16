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
