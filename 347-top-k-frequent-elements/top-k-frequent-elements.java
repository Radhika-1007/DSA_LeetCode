class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> freqmap = new HashMap<>();
        // mapping frequency in hashmap
        int n = nums.length;
        for(int num: nums){
            freqmap.put(num, freqmap.getOrDefault(num, 0) + 1);
        }
        // putting elements based on frequency
        List<Integer>[] bucket = new List[n+1]; // this is array of list
        for(int key: freqmap.keySet()){
            int freq = freqmap.get(key);
            if(bucket[freq] == null){
                bucket[freq] = new ArrayList<>();
            }
            bucket[freq].add(key);
        }
        //collecting top k elements from end 
        List<Integer> resultList = new ArrayList<>();
        for(int i=n; i>=0 && resultList.size() < k; i--){
            if(bucket[i] != null){
                resultList.addAll(bucket[i]);
            }
        }
        //list to array
        int result[] = new int[k];
        for(int i=0; i<k; i++){
            result[i] = resultList.get(i);
        }
        return result;
    }
}