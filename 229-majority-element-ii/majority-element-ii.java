class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length, freq = n/3;
        HashMap<Integer, Integer> mp = new HashMap<>();
        for(int num: nums){
            mp.put(num, mp.getOrDefault(num, 0) +1);
        }
        List<Integer> ans = new ArrayList<>();
        for(int key: mp.keySet()){
            int val = mp.get(key);
            if(val > freq) ans.add(key);
        }
        return ans;
    }
}