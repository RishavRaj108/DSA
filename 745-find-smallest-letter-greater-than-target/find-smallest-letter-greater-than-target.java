class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        char ch = '*';
        for(int i = 0;i < letters.length;i++){
            if(letters[i] - target > 0){
                return letters[i];
            }
        }
        return letters[0];
    }
}