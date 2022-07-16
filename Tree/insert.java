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
