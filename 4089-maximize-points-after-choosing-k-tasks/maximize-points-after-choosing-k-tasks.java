class Solution {
    public long maxPoints(int[] tech1, int[] tech2, int k) {
        int n = tech1.length;
        List<int[]> ls = new ArrayList<>();
        // array will store the diff and index
        for(int i = 0;i < n;i++){
            int diff = tech1[i] - tech2[i];
            ls.add(new int[]{diff , i});
        }

        Collections.sort(ls , (a,b) -> b[0] - a[0]);

        long profit = 0;

        for(int i = 0;i < k;i++){
            int[] val = ls.get(i);
            int ind = val[1];
            profit += tech1[ind];
        }
        for(int i = k;i < n;i++){
            int[] val = ls.get(i);
            if(val[0] > 0){
                profit += tech1[val[1]];
            }else{
                profit += tech2[val[1]];
            }
        }

        return profit;
    }
}