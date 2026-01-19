class Solution {
        public int minimumArrayLength(int[] arr) {
        int m = arr[0], count = 0;
        for (int a: arr)  m = Math.min(m, a); 
        for (int x : arr)  if (x % m > 0)  return 1;
        for (int a : arr)  if (a == m)  count++;
        return (count + 1) / 2;
    }
}