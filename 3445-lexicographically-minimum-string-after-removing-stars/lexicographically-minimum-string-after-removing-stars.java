class Solution {
    public String clearStars(String s) {
        List<Integer>[] group = new ArrayList[26];
        for(int i = 0;i < 26;i++){
            group[i] = new ArrayList<>();
        }
        StringBuilder sb = new StringBuilder();
        int[] flag = new int[s.length()];
        for(int i = 0;i < s.length();i++){
            char ch = s.charAt(i);
            if(ch != '*'){
                group[ch - 'a'].add(i);
            }else{
                // this cahr is *
                // remove the smallest char to its left
                flag[i] = 1;
                for(int j = 0;j < 26;j++){
                    if(group[j].size() > 0){
                        int ind = group[j].get(group[j].size() - 1);
                        group[j].remove(group[j].size() - 1);
                        flag[ind] = 1;
                        break;
                    }
                }
            }
        }
        for(int i = 0;i < flag.length;i++){
            if(flag[i] != 1){
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}