class Solution {
    public int minimumLevels(int[] possible) {
        int n = possible.length;
        int total = 0;
        for(int val : possible){
            if(val == 1){
                total += 1;
            }else{
                total -= 1;
            }
        }

        int score = 0;
        for(int i = 0;i < n - 1;i++){
            if(possible[i] == 1){
                score += 1;
            }else{
                score -= 1;
            }
            if(2 * score > total){
                return i + 1;
            }
        }
        return -1;
    }
}