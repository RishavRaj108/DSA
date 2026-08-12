class Solution {
    public long minimumCost(int m, int n, int[] hCut, int[] vCut) {
        Arrays.sort(hCut);
        Arrays.sort(vCut);
        int hP = 1;
        int vP = 1;
        int i = m - 2;
        int j = n -2;
        long cost = 0L;
        m--;
        n--;
        while(i >= 0 && j >= 0){
           if(hCut[i] > vCut[j]){
             cost += 1L * hCut[i--] * vP;
             hP++;
           }else{
             cost += 1L * vCut[j--] * hP;
             vP++;
           }
        }
        while(i >= 0){
            cost += 1L * hCut[i--] * vP;
            hP++;
        }
        while( j >= 0){
            cost += 1L * vCut[j--] * hP;
             vP++;
        }
        return cost;
    }
}