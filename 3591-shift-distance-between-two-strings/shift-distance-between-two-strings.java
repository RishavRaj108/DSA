class Solution {
    public long shiftDistance(String s, String t, int[] nextCost, int[] previousCost) {

        long[] nextPrefix = new long[53];
        long[] prevPrefix = new long[53];

        for(int i=0;i<52;i++){
            nextPrefix[i+1] = nextPrefix[i] + nextCost[i%26];
            prevPrefix[i+1] = prevPrefix[i] + previousCost[i%26];
        }

        long ans = 0;

        for(int i=0;i<s.length();i++){

            int a = s.charAt(i)-'a';
            int b = t.charAt(i)-'a';

            long forward;
            if(b>=a) forward = nextPrefix[b]-nextPrefix[a];
            else forward = nextPrefix[b+26]-nextPrefix[a];

            long backward;
            if(a>=b) backward = prevPrefix[a+1]-prevPrefix[b+1];
            else backward = prevPrefix[a+26+1]-prevPrefix[b+1];

            ans += Math.min(forward, backward);
        }

        return ans;
    }
}