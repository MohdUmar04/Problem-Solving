class Solution {
    public String kthDistinct(String[] arr, int k) {
        LinkedHashSet<String> str = new LinkedHashSet<>();
        Set<String> vis = new HashSet<>();
        for(String s : arr) {
            if( vis.contains(s)) {
                str.remove(s);
            }
            else{
                str.add(s);
            }
            vis.add(s);
        }
        int i =0;

        for(String s: str) {
            ++i;
            if(i==k) return s;
        }
        return "";
        
    }
}