class Solution {
    public List<Integer> zigzagTraversal(int[][] grid) {
        // m * n grid + integers
        // traverse in zig zag 
        // how 
        int m = grid.length;
        int n = grid[0].length;

        int r = 0, c = n - 1;

        boolean trav = true;
        List<Integer> res = new ArrayList<>();
        for(int[] row: grid){
            if(trav){
                int i = 0;
                while(i < n){
                    res.add(row[i]);
                    i+= 2;
                }
                trav = false;
            }else{
                int i = n - 2;
                if(n % 2 == 0)i = n - 1;
                else i = n - 2;
                while(i > 0){
                    res.add(row[i]);
                    i -= 2;
                }
                trav = true;
            }
        }
        return res;
    }
}