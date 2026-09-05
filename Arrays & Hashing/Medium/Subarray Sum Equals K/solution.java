
class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> prefixSumCount = new HashMap<>();
        prefixSumCount.put(0, 1); 

        int count = 0;
        int sum = 0;

        for (int num : nums) {
            sum += num;
          
            if (prefixSumCount.containsKey(sum - k)) {
                count += prefixSumCount.get(sum - k);
            }
            prefixSumCount.merge(sum, 1, Integer::sum);
        }

        return count;
    }
}