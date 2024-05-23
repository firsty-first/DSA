import java.util.*; 

class Node {
    // Array to store links to child nodes,
    // each index represents a letter
    Node[] links = new Node[26];
    // Flag indicating if the node
    // marks the end of a word
    boolean flag = false;

    // Check if the node contains
    // a specific key (letter)
    boolean containsKey(char ch) {
        return links[ch - 'a'] != null;
    }

    // Insert a new node with a specific
    // key (letter) into the Trie
    void put(char ch, Node node) {
        links[ch - 'a'] = node;
    }

    // Get the node with a specific
    // key (letter) from the Trie
    Node get(char ch) {
        return links[ch - 'a'];
    }

    // Set the current node
    // as the end of a word
    void setEnd() {
        flag = true;
    }

    boolean isEnd() {
        return flag;
    }
}

class Trie {
    Node root;

    public Trie() {
        root = new Node();
    }

    public void insert(String word) {
        Node node = root;
        for (int i = 0; i < word.length(); i++) {
            if (!node.containsKey(word.charAt(i))) {
                node.put(word.charAt(i), new Node());
            }
            node = node.get(word.charAt(i));
        }
        node.setEnd();
    }

    public Node searchPrefix(String word) {
        Node node = root;
        for (int i = 0; i < word.length(); i++) {
            if (!node.containsKey(word.charAt(i))) {
                return null;
            }
            node = node.get(word.charAt(i));
        }
        return node;
    }

    public boolean search(String word) {
        Node node = searchPrefix(word);
        return node != null && node.isEnd();
    }
    
    public List<String> getWordsWithPrefix(Node node, String prefix) {
        List<String> result = new ArrayList<>();
        dfs(node, prefix, result);
        return result;
    }
    
    private void dfs(Node node, String prefix, List<String> result) {
        if (node == null) return;
        if (node.isEnd()) result.add(prefix);
        for (char c = 'a'; c <= 'z'; c++) {
            if (node.containsKey(c)) {
                dfs(node.get(c), prefix + c, result);
            }
        }
    }
}

class Solution {
    Trie trie;

    public Solution() {
        trie = new Trie();
    }

    public void insert(String word) {
        trie.insert(word);
    }

    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        for (String product : products) {
            insert(product);
        }

        List<List<String>> ans = new ArrayList<>();
        Node node = trie.root;
        String prefix = "";

        for (char ch : searchWord.toCharArray()) {
            prefix += ch;
            if (node != null && node.containsKey(ch)) {
                node = node.get(ch);
                List<String> suggestions = trie.getWordsWithPrefix(node, prefix);
                Collections.sort(suggestions);
                if (suggestions.size() > 3) {
                    suggestions = suggestions.subList(0, 3);
                }
                ans.add(suggestions);
            } else {
                ans.add(new ArrayList<>());
                node = null;
            }
        }

        return ans;
    }
}
