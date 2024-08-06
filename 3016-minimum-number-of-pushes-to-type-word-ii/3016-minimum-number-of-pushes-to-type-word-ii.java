class Solution {
    public int minimumPushes(String word) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();  
        HashMap<Character,Integer> map = new HashMap<>();  
        TreeMap<Character,Integer> mp = new TreeMap<>();  
        for(char c : word.toCharArray())
            mp.put(c,mp.getOrDefault(c,0)+1);
        List<Character> lis = new LinkedList<>();
        for(var m : mp.keySet())
            lis.add(0,m);

        boolean[] freq = new boolean[26];
        for(int i =0; i< 8 ; i++) pq.add(0);
        for(char c : lis) {
            if(!freq[c-'a'+0]) {
                int v = pq.poll();
                map.put(c,v+1);
                pq.add(v+1);
                freq[c-'a'+0] = true;
            }
        }    
        int res = 0;
        for(char c : word.toCharArray())
            res += map.get(c);
        return res;
    }
}