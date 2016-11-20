package uottawa.coding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Trie {

    public static TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public static class TrieNode {
        public Map<Character, TrieNode> children;
        public boolean endOfWord;

        public TrieNode() {
            children = new HashMap<Character, Trie.TrieNode>();
            endOfWord = false;
        }

        public void insert(String str) {
            TrieNode current = root;
            for (Character ch : str.toCharArray()) {
                TrieNode node = root.children.get(ch);
                if (node != null) {
                    node = new TrieNode();
                    current.children.put(ch, node);
                }
                current = node;
            }

            current.endOfWord = true;
        }
    }
    
    public static void main(String[] args) {
        List<String> strings = new ArrayList<String>();
        strings.add("dabba");
        strings.add("abba");
        strings.add("jabba");
        Collections.sort(strings);
        System.out.println(strings);
    }
}
