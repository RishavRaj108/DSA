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
        int n = mouArr.length();
        int low = 0, high = n - 1;

        while (low < high) {
            int mid = low + (high - low) / 2;

            if (mouArr.get(mid) < mouArr.get(mid + 1)) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        int peak = low;
        low = 0;
        high = peak;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int num = mouArr.get(mid);
            if (num == target)
                return mid;
            if (num < target)
                low = mid + 1;
            else
                high = mid - 1;
        }
        low = peak;
        high = n - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int num = mouArr.get(mid);
            if (num == target)
                return mid;
            if (num > target)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return -1;
    }
}