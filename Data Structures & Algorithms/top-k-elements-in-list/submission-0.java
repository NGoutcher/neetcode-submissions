class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> hMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if(hMap.containsKey(nums[i])) {
                hMap.put(nums[i], hMap.get(nums[i]) + 1);
            } else {
                hMap.put(nums[i], 1);
            }
        }

        List<Integer>[] buckets = new List[nums.length + 1];
        for(int i = 0; i < buckets.length; i++) {
            buckets[i] = new ArrayList<>();
        }

        for(Map.Entry<Integer, Integer> entry : hMap.entrySet()) {
            int num = entry.getKey();
            int count = entry.getValue();

            buckets[count].add(num);
        }

        int[] result = new int[k];
        int index = 0;
        for(int i = buckets.length - 1; i >= 0; i--) {
            for(int num : buckets[i]) {
                result[index] = num;
                index++;

                if(index == k) {
                    return result;
                }
            }
        }

        return result;
    }
}
