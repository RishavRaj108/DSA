class Solution {
    public int sum(int num) {
        int ans = 0;
        while (num > 0) {
            ans += num % 10;
            num = num / 10;
        }
        return ans;
    }

    public int find(int[] nums , int[][] arr){
        // now main part
        // logic
        // use map to store the index of nums
        Map<Integer, Integer> pos = new HashMap<>();
        for(int i = 0;i < nums.length;i++){
            pos.put(nums[i] , i);
        }
        int n = nums.length;
        boolean[] vis = new  boolean[n];
        int ans = 0;

        for(int i = 0;i < n;i++){
            if(vis[i] || nums[i] == arr[i][1]){
                continue;
            }

            int cycle = 0;
            int j = i;
            while(!vis[j]){
                vis[j] = true;
                j = pos.get(arr[j][1]);
                cycle++;
            }
            if(cycle > 1)ans += cycle - 1;
        }
        return ans;
    }

    public int minSwaps(int[] nums) {
        int n = nums.length;
        int[][] arr = new int[n][2];
        for(int i = 0;i < n;i++){
            arr[i][0] = sum(nums[i]);
            arr[i][1] = nums[i];
        }

        Arrays.sort(arr , (a,b) ->{if(a[0] != b[0]) return a[0] - b[0];
        return a[1] - b[1];});
        
        return find(nums , arr);
    }
}