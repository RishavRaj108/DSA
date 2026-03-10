class Solution {
    public boolean check(int num1 , int num2){
        String s1 = "" + num1;
        String s2 = "" + num2;

        while(s1.length() < s2.length()){
            s1 = "0" + s1;
        }
        while(s1.length() > s2.length()){
            s2 = "0" + s2;
        }
        if(s1.equals(s2)){
            return true;
        }
        List<Integer> ls = new ArrayList<>();
        int cnt = 0;
        for(int i = 0;i < s1.length();i++){
            char ch1 = s1.charAt(i);
            char ch2 = s2.charAt(i);

            if(ch1 == ch2)continue;

            ls.add(i);
            cnt++;
            if(cnt > 2)return false;
        }
        if(cnt == 2){
            int a = ls.get(0);
            int b = ls.get(1);
            char[] chars = s1.toCharArray();
            char temp = chars[a];
            chars[a] = chars[b];
            chars[b] = temp;
            return s2.equals(new String(chars));
        }
        return false;
    }
    public int countPairs(int[] nums) {
        int n = nums.length;
        int res =0;
        for(int i = 0;i < n;i++){
            for(int j = i + 1;j < n;j++){
                if(check(nums[i] , nums[j])){
                    res++;
                }
            }
        }
        return res;
    }
}