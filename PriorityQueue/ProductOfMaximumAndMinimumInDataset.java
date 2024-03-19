import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class ProductOfMaximumAndMinimumInDataset {
    public static void main(String[] args) {
        List<String> operations = new ArrayList<>();
        List<Integer> x = new ArrayList<>();

        
        operations.add("push");
        operations.add("push");
        operations.add("push");
        operations.add("push");
        x.add(328330709);
        x.add(570933073);
        x.add(578466200);
        x.add(589317647);
        
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b)->(b-a));
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((a,b)->(a-b));
        Map<Integer,Integer> map = new HashMap<>();
        int min =x.get(0) , max= x.get(0);

        map.put(x.get(0),map.getOrDefault(x,0)+1);
        List<Long> res = new ArrayList<>();
        res.add((long)min*max);
        minHeap.add(min);
        maxHeap.add(max);

        for(int i=1;i<x.size();i++) {
            if(operations.get(i).equals("pop")){
                map.put(x.get(i),map.get(x.get(i))-1);
                if(map.get(x.get(i)) == 0) map.remove(x.get(i));
            }
            else
            map.put(x.get(i),map.getOrDefault(x.get(i),0)+1);
            minHeap.add(x.get(i));
            maxHeap.add(x.get(i));

            while(!map.containsKey(minHeap.peek())) {
                minHeap.poll();
            }

            
            while(!map.containsKey(maxHeap.peek())) {
                maxHeap.poll();
            }

            res.add((long)minHeap.peek()*maxHeap.peek());
        }

        System.out.println(res);
        

    }
    
}
