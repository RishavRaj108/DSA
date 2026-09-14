    class Solution {
        long maxi = 0;
        int cnt = 0;
        public int countHighestScoreNodes(int[] parents) {
            int n = parents.length;

            List<List<Integer>> adj = new ArrayList<>();
            for(int i = 0;i < n;i++){
                adj.add(new ArrayList<>());
            }
            for(int i = 1;i < n;i++){
                adj.get(parents[i]).add(i);
            }
            int total = n;
            find(0 , adj , total);
            return cnt;
        }
        public int find(int node, List<List<Integer>> adj,int total){

            List<Integer> ls = adj.get(node);
            int left = -1;
            int right = -1;
            for(int val : ls){
                if(left == -1)
                left = find(val , adj,total);
                else right =find(val , adj,total);
            }

            int rem = total - 1;
            if(left != -1){
            rem -= left;
            }
            if(right != -1){
                rem -= right;
            }
            long score = Math.max(rem , 1);
            if(left > 0) score = score * left;
            if(right > 0)score = score * right;
            if(maxi < score){
                maxi = score;
                cnt = 1;
            }else if(maxi == score){
                cnt++;
            }

            if(right == -1)right = 0;
            if(left == -1)left = 0;
            return 1 + right + left;
        }
    }












