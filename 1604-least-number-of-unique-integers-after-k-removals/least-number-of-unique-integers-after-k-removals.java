class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        int n = arr.length;
        // map -> num and count
        // and remove the num with least count
        Map<Integer, Integer> mp = new HashMap<>();
        // this map will store the position of num in arrayList

        List<int[]> ls = new ArrayList<>();
        for(int i = 0;i < n;i++){
            int num = arr[i];
            if(mp.containsKey(num)){
                int ind = mp.get(num);
                ls.get(ind)[1]++;
            }else{
                mp.put(num , ls.size());
                ls.add(new int[]{num , 1});
            }
        }
        Collections.sort(ls , (a,b) -> a[1] - b[1]);

        for(int i = 0;i < ls.size();i++){
            int[] num = ls.get(i);
            int cnt = num[1];
            if(k >= cnt){
                k -= cnt;
            }else{
                return ls.size() - i;
            }
        }
       return 0;
    }
}