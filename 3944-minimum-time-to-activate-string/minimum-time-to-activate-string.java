class Solution {
    public int minTime(String s, int[] order, int k) {
        int n = order.length;
        int low = 0;
        int high = n-1;
        int res = -1;
        while(low <= high){
            int mid = low + (high - low)/2;
            if(isPossible(mid , order,k)){
                res = mid;
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return res;
    }
    public boolean isPossible(int pos , int[] order,int k){
        int n = order.length;
        List<Integer> ls = new ArrayList<>();
        for(int i = 0;i <= pos;i++){
            ls.add(order[i]);
        }
        ls.add(-1);
        ls.add(n);
        Collections.sort(ls);
        long cnt = 0;
        long total = (1L * n * (n + 1))/2; 
        
        for(int i = 1;i < ls.size();i++){
            int prev = ls.get(i - 1);
            int curr = ls.get(i);
            int size = curr - prev - 1;
            if(size > 0){
                cnt += (1L * size * (size + 1))/2;
            }
        }
        return (total - cnt) >= k;
    }
}