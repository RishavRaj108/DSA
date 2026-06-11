class Solution {
    public int maxStarSum(int[] vals, int[][] edges, int k) {
       Map<Integer, List<Integer>> mp = new HashMap<>();
       int n = vals.length;
       for(int i = 0;i < n;i++){
        mp.put(i , new ArrayList<>());
       } 

       for(int [] edge : edges){
        int u = edge[0];
        int v = edge[1];
        mp.get(u).add(vals[v]);
        mp.get(v).add(vals[u]);
       }
       int maxi = Integer.MIN_VALUE;
       for(int key : mp.keySet()){
          
          int sum = vals[key];
          List<Integer> ls = new ArrayList<>(mp.get(key));
          Collections.sort(ls , Collections.reverseOrder());
          for(int i = 0;i < ls.size();i++){
            
            if(i == k)break;
            if(ls.get(i) < 0)break;
            sum += ls.get(i);
          }
          maxi = Math.max(maxi , sum);
       }
       return maxi;
    }
}