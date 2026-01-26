class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        int minDiff = Integer.MAX_VALUE;
        Arrays.sort(arr);
        int n = arr.length;
        for(int i = 1;i < n;i++){
            minDiff = Math.min(minDiff, arr[i] - arr[i - 1]);
        }
        List<List<Integer>> ans = new ArrayList<>();

        for(int i = 1;i < n;i++){
           int a = arr[i - 1];
           int b = arr[i];
           if(b-a == minDiff){
             List<Integer> ls = new ArrayList<>();
             ls.add(a);
             ls.add(b);
             ans.add(ls);
           }
        }
        return ans;
    }
}