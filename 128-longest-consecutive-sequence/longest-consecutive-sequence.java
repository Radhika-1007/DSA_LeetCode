class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        HashSet<Integer> set = new HashSet<>();
        int longestSequence = 1;
        
        for(int num: nums){
            set.add(num);
        }
        for(int num: set){
            if(!set.contains(num-1)){
                int currentNum = num;
                int currentLength = 1;
            
            while(set.contains(currentNum + 1)){
                currentNum++;
                currentLength++;
            }
            longestSequence = Math.max(longestSequence, currentLength);
            }
        }
        return longestSequence;
    }
}