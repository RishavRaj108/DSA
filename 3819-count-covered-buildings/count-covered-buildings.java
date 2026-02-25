class Solution {
    public int countCoveredBuildings(int n, int[][] buildings) {
        Map<Integer , Integer> maxCol = new HashMap<>();
        Map<Integer , Integer> minCol = new HashMap<>();
        Map<Integer , Integer> maxRow = new HashMap<>();
        Map<Integer , Integer> minRow = new HashMap<>();

        for(int[] spot: buildings){
            int x = spot[0];
            int y = spot[1];

            maxCol.put(y ,Math.max(maxCol.getOrDefault(y , 0), x));
            minCol.put(y , Math.min(minCol.getOrDefault(y , x) , x));
            maxRow.put(x ,Math.max(maxRow.getOrDefault(x , 0), y));
            minRow.put(x , Math.min(minRow.getOrDefault(x , y) , y));
        }
        int cnt = 0;
        for(int[] spot: buildings){
            int x = spot[0];
            int y = spot[1];
            boolean top = false,right = false,left = false,bottom = false;

            if(maxCol.containsKey(y)){
                if(maxCol.get(y) > x)top = true;
                if(minCol.get(y) < x)bottom = true;
            }
            if(maxRow.containsKey(x)){
                if(maxRow.get(x) > y)right= true;
                if(minRow.get(x) < y)left = true;
            }
            if(top && right && left && bottom){
                cnt++;
            }
        }
        return cnt;
    }
}