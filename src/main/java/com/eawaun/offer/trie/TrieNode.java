package com.eawaun.offer.trie;

public class TrieNode {

    public TrieNode() {
        this.childNodes = new TrieNode[26];
    }

    private TrieNode[] childNodes;

    private int freq;

    private char value;

    public TrieNode[] getChildNodes() {
        return childNodes;
    }

    public int getFreq() {
        return freq;
    }

    public void setFreq(int freq) {
        this.freq = freq;
    }

    public char getValue() {
        return value;
    }

    public void setValue(char value) {
        this.value = value;
    }
}
