/**
 *
 * You are given an array of non-overlapping intervals intervals where intervals[i] = [starti, endi] represent the start and the end of the ith interval and intervals is sorted in ascending order by starti. You are also given an interval newInterval = [start, end] that represents the start and end of another interval.
 *
 * Insert newInterval into intervals such that intervals is still sorted in ascending order by starti and intervals still does not have any overlapping intervals (merge overlapping intervals if necessary).
 *
 * Return intervals after the insertion.
 *
 * Note that you don't need to modify intervals in-place. You can make a new array and return it.
 *
 *
 * Example 1:
 *
 * Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
 * Output: [[1,5],[6,9]]
 * Example 2:
 *
 * Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
 * Output: [[1,2],[3,10],[12,16]]
 * Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].
 *
 */



public class MaximumProductSubarray {

    public static int[][] insert(int[][] intervals, int[] newInterval) {
        int n = intervals.length;
        Arrays.sort(intervals, (a,b) -> a[0]-b[0]);

        List<int[]> arr = new ArrayList<>();
        int newStart = 0, newEnd = 0;
        for(int i = 0; i < n; i++) {
            if(newInterval != null) {
                newStart = newInterval[0];
                newEnd = newInterval[1];
            }
            int currStart = intervals[i][0], currEnd = intervals[i][1];
            if(newInterval == null || newStart > currEnd) {
                // non-overlapping
                arr.add(new int[]{currStart, currEnd});
            }else if(newEnd < currStart) {
                // non-overlapping
                arr.add(new int[]{newStart, newEnd});
                arr.add(new int[]{currStart, currEnd});
                newInterval = null;
            }else {
                newInterval[0] = Math.min(newStart, currStart);
                newInterval[1] = Math.max(newEnd, currEnd);
            }
        }

        if(newInterval != null) {
            arr.add(new int[]{newInterval[0], newInterval[1]});
        }

        int newSz = arr.size();
        int[][] result = new int[newSz][2];
        for(int i = 0; i < arr.size(); i++) {
            result[i] = new int[]{arr.get(i)[0], arr.get(i)[1]};
        }

        return result;
    }


    public static void main(String[] args) {
        int[][] intervals = {{1,3},{6,9}};
        int[] newInterval = {2,5};
        System.out.println("The updated intervals after inserting the new interval : ");
        System.out.println(insert(intervals, newInterval));
    }
}
