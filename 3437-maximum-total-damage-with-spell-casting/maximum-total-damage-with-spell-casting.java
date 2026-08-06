class Solution {
    Map<Integer , Long> totalDamage;
    List<Integer> vals;
    long[] memo;
    public long maximumTotalDamage(int[] power){
        totalDamage = new HashMap<>();
        for(int i = 0;i < power.length;i++){
            int pow = power[i];
            totalDamage.put(pow , totalDamage.getOrDefault(pow , 0L) + pow);
        }
        int n = totalDamage.size();
        vals = new ArrayList<>(totalDamage.keySet());
        Collections.sort(vals);
        memo = new long[n];
        Arrays.fill(memo , -1);
        return find(n - 1);
    }
    public long find(int ind){
        if(ind < 0)return 0;
        if(memo[ind] != -1)return memo[ind];
        long skip = find(ind -1);
        long take = totalDamage.get(vals.get(ind));
        int nextValid = binarySrch(vals , ind);
        if(nextValid != -1){
            take += find(nextValid);
        }
        return memo[ind] = Math.max(skip , take);
    }
    public int binarySrch(List<Integer> vals , int ind){
        int high = ind - 1;
        int low = 0;
        int allowed = vals.get(ind) - 2;
        int ans = -1;
        while(low <= high){
            int mid = low + (high - low)/2;
            if(vals.get(mid) < allowed){
                ans = mid;
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }
        return ans;
    }
}


