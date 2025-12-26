class Solution {
    public int lengthOfLIS(int[] nums) {
        ArrayList<Integer> tails = new ArrayList<>();
        for(int num: nums){
            int idx = Collections.binarySearch(tails, num);
            if(idx < 0) idx = -(idx+1);
            if(idx == tails.size()) tails.add(num);
            else tails.set(idx, num);
        }
        return tails.size();
    }
}