class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> mp = new HashMap<>();
        int n = nums.length;
        for(int i=0; i<n; i++){
            mp.put(nums[i], mp.getOrDefault(nums[i], 0) + 1);
        }
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((a,b) -> a.getValue() - b.getValue());
        for(Map.Entry<Integer, Integer> entry: mp.entrySet()){
            pq.offer(entry);
            if(pq.size() > k) pq.poll();
        }
        
        int result[] = new int[k];
        for(int i=0; i<k; i++){
            result[i] = pq.poll().getKey();
        }
        return result;
    }
}