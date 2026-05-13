class Solution {
    public int punishmentNumber(int n) {
        int ans = 0;

        for(int i = 1;i <= n;i++){
            int val = i * i;
            if(possible(val , i)){
                ans += val;
            }
        }
        return ans;
    }
    public boolean possible(int val , int i){
        String str = "" + val;

        return find(str,0,0, i);
    }
    public boolean find(String str,int ind , int s,int n){
        if(ind == str.length()){
            if(s == n){
                return true;
            }
            return false;
        }

        for(int i= ind;i < str.length();i++){
            String sub = str.substring(ind , i + 1);
            int val = Integer.parseInt(sub);
            if(find(str , i + 1,s + val,n)){
                return true;
            }
        }

        return false;
    }
}