class Solution {
    public int captureForts(int[] forts) {
        int last = -1, max = 0, n = forts.length;
        for(int i=0; i<n; i++){
            if(forts[i] != 0){
                if(last != -1 && forts[last] != forts[i]){
                    max = Math.max(i-last-1, max);
                }
                last = i;
            }
        }
        return max;
    }
}