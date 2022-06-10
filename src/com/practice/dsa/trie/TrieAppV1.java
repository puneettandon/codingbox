package com.practice.dsa.trie;

public class TrieAppV1 {

    public static void main(String[] args) {

        // Input keys (use only 'a' through 'z' and lower case)
        String keys[] = {"the", "a", "there", "answer", "any",
                "by", "bye", "their"};

        String output[] = {"Not present in trie", "Present in trie"};

        TrieV1 trie = new TrieV1();

        // insert in trie
        for(int i = 0;i<keys.length;i++){
            trie.insertInTrie(keys[i]);
        }

        // search in trie
        if(trie.searchInTrie("the") == true)
            System.out.println("the --- " + output[1]);
        else System.out.println("the --- " + output[0]);

        if(trie.searchInTrie("these") == true)
            System.out.println("these --- " + output[1]);
        else System.out.println("these --- " + output[0]);

        if(trie.searchInTrie("their") == true)
            System.out.println("their --- " + output[1]);
        else System.out.println("their --- " + output[0]);

        if(trie.searchInTrie("thei") == true)
            System.out.println("thei --- " + output[1]);
        else System.out.println("thei --- " + output[0]);




    }
}
