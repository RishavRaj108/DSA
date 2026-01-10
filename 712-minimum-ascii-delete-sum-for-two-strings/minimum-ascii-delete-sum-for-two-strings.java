class Solution {
    int n1 ,n2;
    public int minimumDeleteSum(String s1, String s2) {
        n1 = s1.length();
        n2 = s2.length();
        int[][] dp = new int[n1 + 1][n2 + 1];
        for(int[] row: dp){
            Arrays.fill(row , -1);
        }
        return findMin(0,0,s1,s2,dp);
    }
    public int findMin(int ind1 , int ind2,String s1,String s2,int[][] dp){
        if(s1.equals(s2))return 0;
        if(ind1 >= n1){
           int sum = 0;
           for(int i = 0;i < s2.length();i++){
            sum += s2.charAt(i);
           }
           return sum;
        }
        if(ind2 >= n2){
          int sum = 0;
           for(int i = 0;i < s1.length();i++){
            sum += s1.charAt(i);
           }
           return sum;
        }
        if(dp[ind1][ind2] != -1)return dp[ind1][ind2];
        
        // two posiblity 1) ind1 == ind2 move further
        // 2) ind1 != ind2 : 3 possiblity
        // remove ind1 , remove ind2 , remove ind1 and ind2 both 
          
        char ch1 = s1.charAt(0);
        char ch2 = s2.charAt(0);
        int mini = 100000000;
        if(ch1 == ch2){
            mini = Math.min(mini , findMin(ind1 + 1,ind2 + 1,s1.substring(1),s2.substring(1),dp));
        }else{
            int r_1 = (ch1) + findMin(ind1 + 1,ind2 ,s1.substring(1),s2,dp);
            int r_2 = (ch2) + findMin(ind1 ,ind2 + 1,s1,s2.substring(1),dp);
            mini = Math.min(mini , Math.min(r_1,r_2));
        }
        return dp[ind1][ind2] = mini;
    }
}