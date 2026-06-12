class Solution {
    public int earliestFinishTime(int[] start1, int[] end1, int[] start2, int[] end2) {
        // first the min 
        int firstLand = find(start1,end1,start2,end2);
        int firstWater = find(start2,end2,start1,end1);
        return Math.min(firstLand , firstWater);
    }
    public int find(int[] start1, int[] end1, int[] start2, int[] end2){
        int finish1 = Integer.MAX_VALUE;
        int n = start1.length;
        for(int i = 0;i < n;i++){
           finish1 = Math.min( finish1 , start1[i] + end1[i]);
        }
        int finish2 = Integer.MAX_VALUE;
        for(int i = 0;i < start2.length;i++){
            finish2 = Math.min(finish2 , Math.max(finish1 , start2[i]) + end2[i]);
        }
        return finish2;
    }
}