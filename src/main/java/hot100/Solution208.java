package hot100;

import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Solution208 {
    Solution208[] childs;
    boolean isEnd;

    public Solution208() {
        childs = new Solution208[26];
        isEnd = false;
    }

    public void insert(String word) {
        Solution208 curTrie = this;
        for(char curChar: word.toCharArray()){
            if(curTrie.childs[curChar - 'a'] == null){
                curTrie.childs[curChar - 'a'] = new Solution208();
            }
            curTrie = curTrie.childs[curChar - 'a'];
        }
        curTrie.isEnd = true;
    }


    public boolean search(String word) {
        Solution208 curTrie = this;
        for(char curChar: word.toCharArray()){
            if(curTrie.childs[curChar - 'a'] == null){
                return false;
            }
            curTrie = curTrie.childs[curChar - 'a'];
        }
        return curTrie.isEnd;
    }

    public boolean startsWith(String prefix) {
        Solution208 curTrie = this;
        for(char curChar: prefix.toCharArray()){
            if(curTrie.childs[curChar - 'a'] == null){
                return false;
            }
            curTrie = curTrie.childs[curChar - 'a'];
        }
        return true;
    }
}
