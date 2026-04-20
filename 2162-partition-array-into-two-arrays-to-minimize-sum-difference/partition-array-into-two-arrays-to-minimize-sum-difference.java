class Solution {
    int n, target, total, m;
    public int minimumDifference(int[] nums) {
        n = nums.length; total = 0; m = n/2;
        for(int num: nums) total += num;
        int leftArr[] = Arrays.copyOfRange(nums, 0, m);
        int rightArr[] = Arrays.copyOfRange(nums, m, n);
        ArrayList<ArrayList<Integer>> left = new ArrayList<>();
        ArrayList<ArrayList<Integer>> right = new ArrayList<>();
        for(int i=0; i<=m; i++){
            left.add(new ArrayList<>());
            right.add(new ArrayList<>());
        }
        gen(0, 0, 0, leftArr, left);
        gen(0, 0, 0, rightArr, right);
        for(int i=0; i<=m; i++) Collections.sort(right.get(i));
        int ans = Integer.MAX_VALUE;
        for(int k=0; k<=m; k++){
            for(int s1: left.get(k)){
                ArrayList<Integer> rList = right.get(m-k);
                target = total/2 - s1;
                int idx = Collections.binarySearch(rList, target);
                if(idx < 0) idx = -idx - 1;
                if(idx < rList.size()){
                    int sum = s1 + rList.get(idx);
                    ans = Math.min(ans, Math.abs(total - 2*sum));
                }
                if(idx > 0){
                    int sum = s1 + rList.get(idx-1);
                    ans = Math.min(ans, Math.abs(total - 2*sum));
                }
            }

        }
        return ans;
    }
    public void gen(int i, int pick, int sum, int arr[], ArrayList<ArrayList<Integer>> res){
        if(i==arr.length){
            res.get(pick).add(sum);
            return;
        }
        gen(i+1, pick+1, sum+arr[i], arr, res);
        gen(i+1, pick, sum, arr, res);
    }
}