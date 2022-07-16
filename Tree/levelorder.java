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
