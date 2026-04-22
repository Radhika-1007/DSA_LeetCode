class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        HashSet<Integer> st = new HashSet<>();
        for(int num: nums)st.add(num);
        int ls = 0;
        for(int i: st){
            if(!st.contains(i-1)){
                int curr = i;
                int count = 1;
                while(st.contains(curr+1)){
                    curr++;
                    count++;
                }
                ls = Math.max(ls, count);
            }
        }
        return ls;

    }
}