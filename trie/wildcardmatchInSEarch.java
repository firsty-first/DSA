class Node
{
HashMap<Character,Node> links=new HashMap<>();
boolean flag=false;
Node (){}
Node get(char ch)
{
  return links.get(ch);
}
boolean containsKey(char ch)
{return links.containsKey(ch);}
boolean isEnd()
{return flag;}
void setEnd()
{
  flag=true;
}
void put(char ch, Node node)
{links.put(ch,node);}
}
class Pair {
        Node node;
        int index;

        Pair(Node node, int index) {
            this.node = node;
            this.index = index;
        }
    }
class WordDictionary {
Node root;
    public WordDictionary() {
        root=new Node();
    }
    
    public void addWord(String word) {
      Node node=root;
        int l=word.length();
        for(int i=0;i<l;i++)
        {
          if(!node.containsKey(word.charAt(i)))
          node.put(word.charAt(i),new Node());
          node=node.get(word.charAt(i));
        }
        node.setEnd();
    }
    
    public boolean search(String word) {
        Stack<Pair> stack = new Stack<>();
        stack.push(new Pair(root, 0));

        while (!stack.isEmpty()) {
            Pair pair = stack.pop();
            Node node = pair.node;
            int index = pair.index;

            if (index == word.length()) {
                if (node.isEnd()) {
                    return true;
                }
                continue;
            }

            char ch = word.charAt(index);
            if (ch == '.') {
                for (Node child : node.links.values()) {
                    stack.push(new Pair(child, index + 1));
                }
            } else {
                if (node.containsKey(ch)) {
                    stack.push(new Pair(node.get(ch), index + 1));
                }
            }
        }
        return false;
    }
  //  public boolean search(String word) {Node node=root;
  //       return searchInNode(word, node);
  //   }

    private boolean searchInNode(String word, Node node) {
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (ch == '.') {
                // If the current character is '.', check all possible nodes at this level
                for (char x : node.links.keySet()) {
                    if (searchInNode(word.substring(i + 1), node.get(x))) {
                        return true;
                    }
                }
                return false;
            } else {
                // If the character is not '.', check the corresponding node
                if (!node.containsKey(ch)) {
                    return false;
                }
                node = node.get(ch);
            }
        }
        return node.isEnd();
    }
}

