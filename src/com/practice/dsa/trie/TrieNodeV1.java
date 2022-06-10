package com.practice.dsa.trie;

import java.util.HashMap;
import java.util.Map;

public class TrieNodeV1 {

    Map<Character,TrieNodeV1> next;
    boolean isEnd;

    public TrieNodeV1() {
        this.next = new HashMap<>();
        this.isEnd = false;
    }

}
