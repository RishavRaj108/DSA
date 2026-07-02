/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */
 
class Solution {
    public int findInMountainArray(int target, MountainArray mouArr) {
       int n =  mouArr.length();

       int low = 0;
       int high = n - 1;
       int peak = 0;
       while(low <= high){
         int mid = low + (high - low)/2;
         if(high - low + 1 < 3 && (mid == 0 || mid == n - 1)){
            if(mid == 0){
                peak = 1;
            }else{
                peak = n - 2;
            }
            break;
         }
         int prev = mouArr.get(mid - 1);
         int curr = mouArr.get(mid);
         int next = mouArr.get(mid + 1);
         if(prev < curr && curr < next)low = mid + 1;
         else if(curr < prev && curr > next)high = mid - 1;
         else if(curr > prev && curr > next){
            peak = mid;
            break;
         }
       }
    //    return peak;
       // now i need to earch in both the space
       low = 0;
       high = peak;
       while(low <= high){
        int mid = low + (high - low)/ 2;
        int num = mouArr.get(mid);
        if(num == target)return mid;
        if(num < target)low = mid + 1;
        else high = mid - 1;
       }
       low = peak;
       high = n - 1;
       while(low <= high){
        int mid = low + (high - low)/2;
        int num = mouArr.get(mid);
        if(num == target)return mid;
        if(num > target)low = mid + 1;
        else high = mid - 1;
       }
       return - 1;
    }
}