package Hashmap;
Hashmap
import java.util.HashMap;
import java.util.Map;
  
public class Occurence {
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,20,8,8,1,2,5,8,0};
        int[] query = new int[]{100,4,2};
        int x=8;

        int[] res = new int[query.length];
        Map<Integer,Integer> map =new HashMap<>();

        for(int i=0;i< arr.length ; i++){
            if(arr[i]==x)
            map.put(map.size()+1,i+1);
        }
        
        for(int j = 0; j< query.length;j++){
            res[j]=map.getOrDefault(query[j], -1);
            System.out.println(res[j]);
        }
        
    }
}
