from typing import List
import heapq
from collections import Counter

class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        if not nums or k == 0:
            return []
        
        count = Counter(nums)
        
        # Use index as tiebreaker to avoid comparison issues
        heap = []
        for idx, (num, freq) in enumerate(count.items()):
            heapq.heappush(heap, (freq, idx, num))
            if len(heap) > k:
                heapq.heappop(heap)
        
        # Extract numbers from heap
        return [num for freq, idx, num in heap]

if __name__ == "__main__":
    nums = [1, 1, 1, 2, 2, 3]
    k = 2
    out = Solution().topKFrequent(nums, k)
    print("Top k frequent:", out)  # Output: [1, 2] or [2, 1]
