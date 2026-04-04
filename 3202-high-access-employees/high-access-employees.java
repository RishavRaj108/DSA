class Solution {
    public List<String> findHighAccessEmployees(List<List<String>> acceT) {
        List<String> ans = new ArrayList<>();

        Map<String , List<Integer>> mp = new HashMap<>();
        
        for(List<String> emp : acceT){
            String employ = emp.get(0);
            int time = Integer.parseInt(emp.get(1));
            mp.computeIfAbsent(employ , k -> new ArrayList<>()).add(time);
        }

        for(String emp : mp.keySet()){
            List<Integer> time = mp.get(emp);
            if(time.size() < 3)continue;

            Collections.sort(time);
            for(int i = 0;i < time.size();i++){
                int curr = time.get(i);
                // i have to change this curr time to one hour more
                int min = curr % 100 + 59;
                int hour = curr / 100;
                if(min > 60){
                    hour++;
                    min = min - 60;
                }
                int maxT = hour * 100 + min;
                if(i + 2 <= time.size() - 1){
                    // now check whether it falls in given condition or not
                    int n1 = time.get(i + 1);
                    int n2 = time.get( i + 2);
                    if(n1 <= maxT && n2 <= maxT ){
                        ans.add(emp);
                        break;
                    }
                }
            }
        }
        return ans;
    }
}