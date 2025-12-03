class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length, idx = 0;
        int res[] = new int[n-k+1];
        Deque<Integer> dq = new ArrayDeque<>();
        for(int i=0; i<n; i++){
            //maintaining decreasing order
            while(!dq.isEmpty() && nums[dq.peekLast()] < nums[i]){
                dq.pollLast();
            }
            //pushing current index
            dq.offerLast(i);
            //removing from front if outside window
            if(dq.peekFirst() <= i-k){
                dq.pollFirst();
            }
            //once window size reached k adding max
            if(i >= k-1){
                res[idx++] = nums[dq.peekFirst()];
            }
        }
        return res;
    }
}