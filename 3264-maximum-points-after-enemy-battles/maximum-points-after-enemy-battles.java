class Solution {
    public long maximumPoints(int[] enemy, int curren){
        // gain max points
        // 2 oprs
        // opr 1 can be performed only in unmarked enemy
        // 

        // sort the enemyEn then gain one point by performing opr 1 on least val
        int n = enemy.length;

        Arrays.sort(enemy);

        long points = 0;
        long current = curren;

        while(current >= enemy[0]){
            points += current / enemy[0];
            current = current % enemy[0];
        }

        if(enemy.length == 1)return points;
        if(points == 0)return 0;

        for(int i = 1;i < n;i++){
            current += enemy[i];
        }

        while(current >= enemy[0]){
            points += current / enemy[0];
            current = current % enemy[0];
        }

        return points;
    }
}