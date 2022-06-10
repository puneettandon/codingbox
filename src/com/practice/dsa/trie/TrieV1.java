package com.practice.dsa.trie;

public class TrieV1 {

    TrieNodeV1 root = new TrieNodeV1();


    public void insertInTrie(String word) {
        TrieNodeV1 curr = root;
       for(int i = 0;i<word.length();i++){
           char ch = word.charAt(i);
           if(curr.next.get(ch) == null){
               curr.next.put(ch,new TrieNodeV1());
           }
           curr = curr.next.get(ch);
       }
       curr.isEnd = true;
    }

    public boolean searchInTrie(String word) {
        TrieNodeV1 curr = root;
        for(int i = 0;i<word.length();i++){
            char ch = word.charAt(i);
            if(curr.next.get(ch) == null)
                return false;
            curr = curr.next.get(ch);
        }
        return curr.isEnd;
    }
}
