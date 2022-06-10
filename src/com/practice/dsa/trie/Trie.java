package com.practice.dsa.trie;

public class Trie {

    TrieNode root = new TrieNode();

    public void insertInTrie(String key) {
        int level;
        int length = key.length();
        int index ;

        TrieNode pCrawl = root;
        for(level = 0; level < length;level++){
            index = key.charAt(level) -'a';
            if(pCrawl.children[index] == null)
                pCrawl.children[index] = new TrieNode();

            pCrawl = pCrawl.children[index];
        }
        pCrawl.isEndOfWord = true;
    }

    public boolean searchInTrie(String word) {

        int level;
        int length = word.length();
        int index;
        TrieNode pCrawl = root;

        for(level = 0;level < length;level++){
            index = word.charAt(level) - 'a';
            if (pCrawl.children[index] == null)
                return false;
            pCrawl = pCrawl.children[index];
        }
        return (pCrawl.isEndOfWord);
    }
}
