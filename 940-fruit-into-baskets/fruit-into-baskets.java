class Solution {
    public int totalFruit(int[] fruits) {
        Map<Integer, Integer> mp = new HashMap<>();
        int n = fruits.length, left = 0, max = 0;
        for(int right = 0; right<n; right++){
            mp.put(fruits[right], mp.getOrDefault(fruits[right], 0)+1);
           while(mp.size() > 2){
                mp.put(fruits[left], mp.get(fruits[left])-1);
                if(mp.get(fruits[left]) == 0) mp.remove(fruits[left]);
                left++;
           }
           max = Math.max(max, right - left+1);
        }
        return max;
    }
}