class Solution {
    public boolean check(String str , String word){
        for(int i = 0;i < str.length();i++){
            if(str.charAt(i) != word.charAt(i)){
                return false;
            }
        }
        return true;
    }
    public int minimumTimeToInitialState(String word, int k) {
        String str = word;
        int n = word.length();
        int cnt = 0;
        while(str.length() > 0){

            if(str.length() >= k){
                str = str.substring(k);
                cnt++;
                if(check(str , word)){
                    return cnt;
                }
            }else{
                cnt++;
                break;
            }
        }
        return cnt;
    }
}