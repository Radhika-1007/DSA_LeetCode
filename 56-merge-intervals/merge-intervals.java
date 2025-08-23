class Solution {
    public int[][] merge(int[][] intervals) {
        if(intervals.length<=1) return intervals;
        List<int[]> result = new ArrayList<>();
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0], b[0]));
        int[] current = intervals[0];
        result.add(current);
        for(int i=1; i<intervals.length; i++){
            int interval[] = intervals[i];
            if(interval[0] <= current[1]){
                current[1] = Math.max(current[1], interval[1]);
            }
            else {
                current = interval;
                result.add(current);
            }    
        }
        return result.toArray(new int[result.size()][]);
    }
}