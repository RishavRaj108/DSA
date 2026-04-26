class Solution {
    public int minimumIndex(List<Integer> nums) {
        int n = nums.size();
        
        int domnt = 0;
        int cnt = 0;
        for(int num : nums){
            if(cnt == 0){
                domnt = num;
                cnt = 1;
            }else{
                if(num == domnt){
                    cnt++;
                }else{
                    cnt--;
                }
            }
        }
        cnt = 0;
        for(int num : nums){
            if(num == domnt){
                cnt++;
            }
        }
        // now we are having dom and cnt of dom
        // at each index we can try spliting
        int cntDom = 0;
        for(int i = 0;i < n - 1;i++){
            int num = nums.get(i);
            if(num == domnt){
                cntDom++;
            }

            // now get cnt of left split and right split dom
            int left = cntDom;
            int leftS = (i + 1)/2;
            int right = cnt - cntDom;
            int rightS = (n - 1 - i)/2;

            if(left > leftS && right > rightS){
                return i;
            } 
        }
        return -1;
    }
}