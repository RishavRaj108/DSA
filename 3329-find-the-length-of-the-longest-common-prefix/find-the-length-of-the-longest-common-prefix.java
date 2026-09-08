class Solution {
    class TrieNode{
        TrieNode[] no;
        TrieNode(){
            no = new TrieNode[10];
           for(int i = 0;i < 10;i++){
            no[i] = null;
        }
        }
    }

    public void insert(String s , TrieNode root){
        TrieNode curr = root;
        for(char ch : s.toCharArray()){
            int ind = ch - '0';
            if(curr.no[ind] == null){
                curr.no[ind] = new TrieNode();
            }
            curr = curr.no[ind];
        }
    }

    public int check(String str , TrieNode root){
        int cnt = 0;
        TrieNode curr = root;
        for(char ch : str.toCharArray()){
            int ind = ch - '0';
            if(curr.no[ind] != null){
                cnt++;
                curr = curr.no[ind];
            }else{
                return cnt;
            }
        }
        return cnt;
    }
    

    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        // create trie
        TrieNode root = new TrieNode();
        for(int n : arr1){
            insert("" + n , root);
        }

        int ans = 0;
        for(int n : arr2){
            ans = Math.max(ans ,  check("" + n, root));
        }
        return ans;
    }
}