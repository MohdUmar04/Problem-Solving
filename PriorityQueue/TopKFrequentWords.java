import java.util.*;
class TopKFrequentWords {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        for(String z: words)
        {
            map.put(z,map.getOrDefault(z,0)+1);
        }
        int s;
        List<String> t= new ArrayList<>();
        PriorityQueue<Map.Entry<String, Integer>> minheap=new PriorityQueue<>((p1,p2)->p2.getValue()-p1.getValue());
        minheap.addAll(map.entrySet());
        List<String> st= new ArrayList<>();
        int i=0;
        while(i<k)
        {
            if(minheap.size()>0)
            {
                s=(minheap.peek()).getValue();
                t.clear();
                t.add((minheap.poll()).getKey());
            while(i<k&&minheap.size()>0&&(s==(minheap.peek()).getValue()))
            {
                t.add((minheap.poll()).getKey());
            }
            Collections.sort(t);
            }
            if(i+t.size()<k)
            {
                i=i+t.size();
                st.addAll(t);
            }
            else
            {
                for(int l=0;l<t.size();l++)
                {
                    i++;
                    if(i<=k)
                    st.add(t.get(l));
                }
            }
        }
        return st;
    }
}