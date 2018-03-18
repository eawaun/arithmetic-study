package com.eawaun.offer.trie;

public class TrieOperation {
    public static void addTrieNode(TrieNode root, String word) {
        if (word == null || "".equals(word)) {
            return;
        }

        int charValue = word.charAt(0) - 'a';

        if (root.getChildNodes()[charValue] == null) {
            root.getChildNodes()[charValue] = new TrieNode();
            root.getChildNodes()[charValue].setValue(word.charAt(0));
        }

        String nextWord = word.substring(1);
        if (nextWord.length() == 0) {
            root.getChildNodes()[charValue].setFreq(root.getChildNodes()[charValue].getFreq() + 1);
        }

        addTrieNode(root.getChildNodes()[charValue], nextWord);
    }

    public static int countWord(TrieNode root, String word) {
        if (word == null || "".equals(word)) {
            return 0;
        }

        int charValue = word.charAt(0) - 'a';

        String nextWord = word.substring(1);

        if (nextWord.length() == 0) {
            return root.getChildNodes()[charValue].getFreq();
        }

        return countWord(root.getChildNodes()[charValue], nextWord);
    }


    public static void main(String[] args) {
        TrieNode root = new TrieNode();
        addTrieNode(root, "go");
        addTrieNode(root, "go");
        addTrieNode(root, "golang");

        System.out.println(countWord(root, "golang"));
    }
}
