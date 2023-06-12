import java.util.TreeMap;

public class LC_implementTriePrefixTree {
    /**
     * 力扣实现Trie（前缀树）
     */
    class Trie {
        private class Node {
            public boolean isWord;
            public TreeMap<Character, Node> next;

            public Node(boolean isWord) {
                this.isWord = isWord;
                next = new TreeMap<>();
            }

            public Node() {
                this(false);
            }
        }
        
        private Node root;
        private int size;
        
        public Trie() {
            root = new Node();
            size = 0;
        }
        
        public int getSize() {
            return size;
        }
        
        public void insert(String word) {
            Node cur = root;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if(cur.next.get(c) == null)
                    cur.next.put(c, new Node());
                cur = cur.next.get(c);
            }
            
            if(!cur.isWord) {
                cur.isWord = true;
                size++;
            }
        }
        
        public boolean search(String word) {
            Node cur = root;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if(cur.next.get(c) == null)
                    return false;
                cur = cur.next.get(c);
            }
            return cur.isWord;
        }
        
        public boolean startsWith(String prefix) {
            Node cur = root;
            for (int i = 0; i < prefix.length(); i++) {
                char c = prefix.charAt(i);
                if(cur.next.get(c) == null)
                    return false;
                cur = cur.next.get(c);
            }
            return true;
        }
    }
}
