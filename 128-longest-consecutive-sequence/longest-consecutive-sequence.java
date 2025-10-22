class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0 || nums == null) return 0;
        HashSet<Integer> set = new HashSet<Integer>();
        for(int i: nums){
            set.add(i);
        }
        int longestSequence = 1;
        for(int i: set){
            if(!set.contains(i-1)){
                int currentNum = i;
                int currentLength = 1;
                while(set.contains(currentNum+1)){
                    currentNum++;
                    currentLength++;
                }
                longestSequence = Math.max(longestSequence, currentLength);
            }
        }
        return longestSequence;
    }
}