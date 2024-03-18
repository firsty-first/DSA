class Solution {
    static int ladoos(Node root, int home, int k) {
        HashMap<Node, Node> parentMap = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        Node homeNode = null;

        // Find the home node and populate the parent map
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            if (node.data == home)
                homeNode = node;

            if (node.left != null) {
                queue.offer(node.left);
                parentMap.put(node.left, node);
            }

            if (node.right != null) {
                queue.offer(node.right);
                parentMap.put(node.right, node);
            }
        }

        if (k == 0)
            return home;

        // Perform BFS from the home node within distance k
        queue.clear();
        queue.offer(homeNode);
        int sum = 0;
        int dis = 0;
        HashSet<Node> visited = new HashSet<>();

        while (!queue.isEmpty() && dis <= k) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                if (!visited.contains(node)) {
                    sum += node.data;
                    visited.add(node);

                    if (node.left != null && !visited.contains(node.left))
                        queue.offer(node.left);
                    if (node.right != null && !visited.contains(node.right))
                        queue.offer(node.right);
                    Node parent = parentMap.get(node);
                    if (parent != null && !visited.contains(parent))
                        queue.offer(parent);
                }
            }
            dis++;
        }
        return sum;
    }
}
