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
