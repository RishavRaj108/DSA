class Solution {
    public long numOfSubsequences(String s) {
        long L = 0;
        long LC = 0;
        long CT = 0;
        long totalT = 0;
        long LCT = 0;
        long C = 0;
        for(char ch : s.toCharArray()){
            if(ch == 'T')totalT++;
        }
        for(char ch : s.toCharArray()){
            if(ch == 'L')L++;
            if(ch == 'C'){
                LC += L;
                C++;
            }
            if(ch == 'T'){
                LCT += LC;
                CT += C;
            }
        }

        long gainL = CT;
        long gainT = LC;

        long gainC = 0;
        long leftL = 0;
        long rightT = totalT;

        for(char ch : s.toCharArray()){
            gainC = Math.max(gainC , leftL * rightT);
            if(ch == 'L')leftL++;
            if(ch == 'T')rightT--;
        }
        gainC = Math.max(gainC , leftL * rightT);
        return LCT + Math.max(gainC , Math.max(gainT , gainL));
    }
}