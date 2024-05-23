public class Trie {
  static class Node {
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
static Node root;
    Trie() {
        //Write your code here
        root=new Node();
    }



    public static void insert(String word) {
        //Write your code here
        Node node=root;
        for(int i=0;i<word.length();i++)
        {
            if(!node.containsKey(word.charAt(i)))
            node.put(word.charAt(i),new Node());
            node=node.get(word.charAt(i));
        }
        node.setEnd();
    }


    //Returns if the word is in the trie

    public static boolean search(String word) {
        //Write your code here
          Node node=root;
        for(int i=0;i<word.length();i++)
        {
            if(!node.containsKey(word.charAt(i)))
                return false;
                node=node.get(word.charAt(i));
        }
        return node.isEnd();
    }

    
    //Returns if there is any word in the trie that starts with the given prefix

    public static boolean startsWith(String word) {
       Node node=root;
        for(int i=0;i<word.length();i++)
        {
            if(!node.containsKey(word.charAt(i)))
                return false;
                node=node.get(word.charAt(i));
        }
        return true;
    }
}
