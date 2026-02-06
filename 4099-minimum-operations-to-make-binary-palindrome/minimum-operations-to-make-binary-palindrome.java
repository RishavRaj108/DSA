class Solution {

    public boolean isPal(String str){
        int i = 0;
        int j = str.length() - 1;
        while(i <= j){
            char chi = str.charAt(i);
            char chj = str.charAt(j);
            if(chi != chj){
              return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public int findMinOpr(int num){
        int opr1 = 0;
        int opr2 = 0;
        int ans = num;
        while(!isPal(Integer.toBinaryString(ans))){
            ans++;
            opr1++;
        }
        ans = num;
        while(!isPal(Integer.toBinaryString(ans))){
            ans--;
            opr2++;
        }
        return Math.min(opr1 , opr2);
    }

    public int[] minOperations(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        for(int i = 0;i < n;i++){
            int num = nums[i];
            if(isPal(Integer.toBinaryString(num)))continue;
            else{
                int minOpr = findMinOpr(num);
                ans[i] = minOpr;
            }
        }
        return ans;
    }
}