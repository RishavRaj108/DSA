class Solution {
    public long numOfSubsequences(String s) {
        // Count of:
        long L = 0;      // L   -> subsequences "L"
        long LC = 0;     // LC  -> subsequences "LC"
        long LCT = 0;    // LCT -> subsequences "LCT"
        long C = 0;      // C  -> number of C's seen
        long CT = 0;     // CT -> subsequences "CT"
        long totalT = 0; // Total T's in the string
        // Count total T's
        for(char ch : s.toCharArray()) {
            if(ch == 'T') totalT++;
        }
        // Count existing LCT, LC and CT subsequences
        for(char ch : s.toCharArray()) {
            if(ch == 'L') {
                // Every L can start a future LC or LCT
                L++;
            }
            else if(ch == 'C') {
                // Every previous L can pair with this C
                LC += L;
                // Count C for future CT calculations
                C++;
            }
            else if(ch == 'T') {
               // Every previous LC can become LCT
                LCT += LC;
                // Every previous C can become CT
                CT += C;
            }
        }
        // Insert L at the beginning
        // New L can pair with every existing CT
        long gainL = CT;
        // Insert T at the end
        // Every existing LC can use this T
        long gainT = LC;
        // Best gain by inserting C
        long gainC = 0;
        // Number of L's before insertion point
        long leftL = 0;
        // Number of T's after insertion point
        long rightT = totalT;
        for(char ch : s.toCharArray()) {
            // If C is inserted here:
            // (#L on left) * (#T on right)
            gainC = Math.max(gainC, leftL * rightT);
            if(ch == 'L') leftL++;
            if(ch == 'T') rightT--;
        }
        // Check insertion after the last character
        gainC = Math.max(gainC, leftL * rightT);
        // Existing LCT + best possible gain
        return LCT + Math.max(gainC, Math.max(gainL, gainT));
    }
}