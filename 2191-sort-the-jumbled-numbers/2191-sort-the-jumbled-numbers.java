class Solution {
    public int[] sortJumbled(int[] mapping, int[] nums) {
        List<List<Integer>> lis = new ArrayList<>();

        for(int i : nums){
            String x= i+"";
            int v = 0;
            for(char c : x.toCharArray()) {
                v= v*10+mapping[(c-'0'+0)];
            }
            List<Integer> l = new ArrayList<>();
            l.add(v);
            l.add(i);
            lis.add(l);
        }

        Collections.sort(lis,(a,b) -> a.get(0)-b.get(0));
        int[] res = new int[lis.size()];
        int k=0;
        for(List<Integer> l : lis)
            res[k++]=l.get(1);
        
        return res;
    }
}