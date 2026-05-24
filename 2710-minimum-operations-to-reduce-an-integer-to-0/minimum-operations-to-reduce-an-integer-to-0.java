class Solution {
    public int minOperations(int n) {
        int[] power = new int[32];

        for(int i = 0;i < 32;i++){
            power[i] = (1 << i);
        }

        // at each step we have to get the mion diff for that no
        int rem = n;
        int cnt = 0;
        while(rem != 0){
            cnt++;
            int ind = find(rem , power);
            rem = Math.abs(rem - power[ind]);
        }
        return cnt;
    }
    public int find(int val , int[] power){
        int diff = Integer.MAX_VALUE;
        int ind = 0;
        for(int i = 0;i < power.length;i++){
            int d = Math.abs(val - power[i]);
            if(diff > d){
                diff = d;
                ind = i;
            }
        }
        return ind;
    }
}