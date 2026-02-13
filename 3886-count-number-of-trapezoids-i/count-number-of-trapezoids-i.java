class Solution {
    int mod = (int) 1e9 + 7;
    public int countTrapezoids(int[][] points) {
        Map<Integer , Integer> mp = new HashMap<>();
        for(int[] point : points){
            int y = point[1];
            mp.put(y, mp.getOrDefault(y , 0)+ 1);
        }

        long ans = 0;
        long prevLines = 0;
        for(int cnt : mp.values()){
            long lines =  (long)cnt * (cnt - 1) / 2 ;
            ans += (lines * prevLines)% mod;
            prevLines += lines;
            
        }
        return (int)(ans % mod);
    }
}