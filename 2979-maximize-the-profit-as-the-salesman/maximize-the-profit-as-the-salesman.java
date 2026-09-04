class Solution {
    int[] dp;
    int no;
    public int maximizeTheProfit(int n, List<List<Integer>> offers) {
        no = n;
        int m = offers.size();
        dp = new int[m];
        Arrays.fill(dp , -1);
        Collections.sort(offers , (a,b) -> a.get(0) - b.get(0));
        return find(0,offers);
    }
    public int find(int ind , List<List<Integer>> offers){
        if(ind >= offers.size())return 0;
        if(dp[ind] != -1)return dp[ind];

        int start = offers.get(ind).get(0);
        int end = offers.get(ind).get(1);
        int gold = offers.get(ind).get(2);

        int profit = 0;

        // take this ind 
        int next = findSafe(offers , ind);
        int value = next != -1? find(next,offers): 0;
        profit = gold + value;
        // skip 
        profit = Math.max(profit , find(ind + 1 , offers));

        return dp[ind] = profit;
    }
    public int findSafe(List<List<Integer>> offers , int ind){
        int s = ind + 1;
        int e = offers.size() - 1;
        int val = offers.get(ind).get(1);
        int ans = -1;
        while(s <= e){
          int mid = s + (e - s)/2;
          if(offers.get(mid).get(0) > val){
            ans = mid;
            e = mid - 1;
          }else{
            s = mid + 1;
          }
        }
        return ans;
    }
}