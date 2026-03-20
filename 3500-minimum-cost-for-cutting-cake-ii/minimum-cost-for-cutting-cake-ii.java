class Solution {
    public long minimumCost(int m, int n, int[] hori, int[] verti) {
        Arrays.sort(hori);
        Arrays.sort(verti);

        int vertiBlock = 1;
        int horiBlock = 1;

        long cost = 0;
        int i = hori.length - 1, j = verti.length - 1;
        while(i >= 0 && j >= 0){
            if(hori[i] > verti[j]){
                cost += 1L * hori[i--] * vertiBlock;
                horiBlock++;
            }else{
                cost += 1L * verti[j--] * horiBlock;
                vertiBlock++; 
            }
        }

        while(i >= 0){
            cost += 1L * hori[i--] * vertiBlock;
            horiBlock++;
        }
        while(j >= 0){
            cost += 1L * verti[j--] * horiBlock;
            vertiBlock++; 
        }
        return cost;
    }
}