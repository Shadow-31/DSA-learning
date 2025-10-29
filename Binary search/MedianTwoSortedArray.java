
/*
 * 
 * LC 4- Median of Two Sorted Arrays
 * Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.

The overall run time complexity should be O(log (m+n)).

Example 1:

Input: nums1 = [1,3], nums2 = [2]
Output: 2.00000
Explanation: merged array = [1,2,3] and median is 2.
Example 2:

Input: nums1 = [1,2], nums2 = [3,4]
Output: 2.50000
Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
 * 
 * 
 */

public class MedianTwoSortedArray {

  public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
    int n = nums1.length, m = nums2.length;
    int nums[] = new int[n + m];
    int indx = 0;
    double ans = 0;

    int i = 0, j = 0;
    while (i < n && j < m) {
      if (nums1[i] <= nums2[j]) {
        nums[indx++] = nums1[i];
        i++;
      } else {
        nums[indx++] = nums2[j];
        j++;
      }
    }

    while (i < n) {
      nums[indx++] = nums1[i];
      i++;
    }

    while (j < m) {
      nums[indx++] = nums2[j];
      j++;
    }

    if ((n + m) % 2 == 0) {
      ans = 1.0 * (nums[(n + m) / 2 - 1] + nums[(n + m) / 2]) / 2;
    } else {
      ans = 1.0 * nums[(n + m) / 2];
    }

    return ans;
  }

  public static void main(String[] args) {
    int[] nums1 = {1,2};
    int[] nums2 = {3,4};
    System.out.println("Median of two sorted arrays : " + findMedianSortedArrays(nums1, nums2));
  }
}
