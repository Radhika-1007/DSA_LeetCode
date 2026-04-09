class Solution {
    public long makeSubKSumEqual(int[] arr, int k) {
        int n = arr.length;
        int g = gcd(n, k);
        long ans = 0;

        for (int i = 0; i < g; i++) {
            List<Integer> group = new ArrayList<>();

            // build one cycle
            for (int j = i; ; j = (j + k) % n) {
                group.add(arr[j]);
                if ((j + k) % n == i) break;
            }

            Collections.sort(group);
            int median = group.get(group.size() / 2);

            for (int val : group) {
                ans += Math.abs(val - median);
            }
        }

        return ans;
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}