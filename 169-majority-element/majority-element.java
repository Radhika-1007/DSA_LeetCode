class Solution {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> mp = new HashMap<>();
        int max = 0, ans = 0;
        for(int num: nums){
            mp.put(num, mp.getOrDefault(num, 0) + 1);
        }
        for(int key: mp.keySet()){
            if(mp.get(key) > max) {
                ans = key;
                max = mp.get(key);
            }    
        }
        return ans;
    }
}