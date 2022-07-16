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
