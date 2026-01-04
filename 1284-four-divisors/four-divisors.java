class Solution {
    public int sumFourDivisors(int[] nums) {
        // return sum of divisors of the integers in that array that have exactly four divisors.
        // else return 0
        // find divisors of each element if no is = 4 add to resultant
        // else leave.

        // how to find divisors of a number.
        // brute -> from 1 to num start nums[n] % i == 0 divisor Save it to a list.
        // if(list size == 4 add to res)

        // better approch for divisors
        // iterate through loop from 1 to num / 2 and add num in the list reduce search space

        int n = nums.length;
        int res = 0;

        for(int i = 0;i < nums.length;i++){ // o(n)
            List<Integer> ls = new ArrayList<>(); // constant space at max 5
            int num = nums[i];
            ls.add(num);
            for(int j = 1;j <= (num/ 2);j++){ // o(n/2)
                if(num % j == 0){
                    ls.add(j);
                }else{
                    if(ls.size() > 4){
                        break;
                    }
                }
            }
            if(ls.size() == 4){
                for(int val : ls){ 
                    res += val;
                }
            }
        } 
        return res;
        // TC: o(n)
        // sc: o(1)
    }
}