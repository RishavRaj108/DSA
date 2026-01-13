class Solution {
    public int[] countMentions(int number, List<List<String>> events) {

        Collections.sort(events , (a,b) ->{
            int t1 = Integer.parseInt(a.get(1));
            int t2 = Integer.parseInt(b.get(1));
            if(t1 != t2)return t1 - t2;

            if(a.get(0).equals(b.get(0)))return 0;
            return a.get(0).equals("OFFLINE")? -1 : 1;
        });

        int[] mentions = new int[number];
        HashSet<Integer> online = new HashSet<>();
        for(int i = 0;i < number;i++){
            online.add(i);
        }
        int[] backOnlineTime = new int[number];

        Arrays.fill(backOnlineTime , -1);

        for(List<String> event : events){
            int time = Integer.parseInt(event.get(1));
            for(int i = 0;i < number;i++){
                if(backOnlineTime[i] != -1 && backOnlineTime[i] <= time){
                    online.add(i);
                    backOnlineTime[i] = -1;
                }
            }
       

            if(event.get(0).equals("MESSAGE")){
                if(event.get(2).equals("ALL")){
                    for(int i = 0;i < number;i++)mentions[i]++;
                }else if(event.get(2).equals("HERE")){
                    for(int i : online){
                        mentions[i]++;
                    }
                }else{
                    String[] ids = event.get(2).split(" ");
                    for(int i = 0;i < ids.length;i++){
                        int id = Integer.parseInt(ids[i].substring(2));
                        mentions[id]++;
                    }
                }
            }else{// offline
              int id = Integer.parseInt(event.get(2));
              online.remove(id);
              backOnlineTime[id] = time + 60;
            }
        }
        return mentions;
    }
}