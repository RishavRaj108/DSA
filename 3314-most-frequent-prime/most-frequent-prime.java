class Solution {
    int[][] dirs = {{-1,-1}, {-1,0},{-1,1},{0,1},{1,1},{1,0},{1,-1},{0,-1}};
    int[][] mat;
    Map<Integer,Integer> mp;
    public int mostFrequentPrime(int[][] mat) {
        mp = new HashMap<>();
        this.mat = mat;
        for(int i = 0;i < mat.length;i++){
            for(int j = 0;j < mat[0].length;j++){
               findPrimeCnt(i,j);
            }
        }

        // now map is having the prime no
        int res = -1;
        int maxi = 0;
        for(int val : mp.keySet()){
            if(mp.get(val) > maxi){
                res = val;
                maxi = mp.get(val);
            }
            if(mp.get(val) == maxi){
                res = Math.max(res , val);
            }
        } 
        return res;
    }
    public void findPrimeCnt(int r,int c){
        // now for this cell we can move in 8 dirs and for each dirs we need to generate all nos possibler
        int n = mat.length;
        int m = mat[0].length;
        // here i have to check whether it is prime or not 
        int num = mat[r][c];
        if(isPrime(num) && num > 10){
            mp.put(num , mp.getOrDefault(num , 0) + 1);
        }

        for(int[] dir : dirs){
            int nr = r + dir[0];
            int nc = c + dir[1];
            int newNo = num;
            while(nr < n && nc < m && nr >= 0 && nc >= 0){
                 newNo = newNo * 10 + mat[nr][nc];
                 if(isPrime(newNo) && newNo > 10){
                    mp.put(newNo , mp.getOrDefault(newNo , 0) + 1);
                 }
                nr += dir[0];
                nc += dir[1];
            }
        }
    }
    public boolean isPrime(int num){
        for(int i = 2;i * i <= num;i++){
            if(num % i == 0){
                return false;
            }
        }
        return true;
    }
}