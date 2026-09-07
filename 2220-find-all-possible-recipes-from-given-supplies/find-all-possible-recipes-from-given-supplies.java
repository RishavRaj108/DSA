class Solution {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        int n = recipes.length;
        Map<String , List<String>> adj = new HashMap<>();
        Map<String , Integer> index = new HashMap<>();
        for(int i = 0;i < n;i++){
            String s = recipes[i];
            adj.put(s , new ArrayList<>());
            index.put(s , i);
        }
        int[] indegree = new int[n];
        Set<String> avalable = new HashSet<>();
        for(String s : supplies){
            avalable.add(s);
        }
        for(int i = 0;i < n;i++){
           String s = recipes[i];
           for(String str : ingredients.get(i)){
            if(avalable.contains(str))continue;
            else if(index.containsKey(str)){
                adj.get(str).add(s);
                indegree[i]++;
            }else{
                indegree[i]++;
            }
           }
        }
        List<String> res = new ArrayList<>();
        Queue<String> q = new LinkedList<>();
        for(int i = 0;i < n;i++){
           if(indegree[i] == 0){
            q.add(recipes[i]);
            res.add(recipes[i]);
           }
        }

        while(!q.isEmpty()){
            String s = q.poll();

            for(String str : adj.get(s)){
                indegree[index.get(str)]--;
                int ind =index.get(str);
                if(indegree[ind] == 0){
                  q.add(str);
                  res.add(str);
                }
            }
        }

        return res;
    }
}