import java.util.ArrayList;
import java.util.List;

public class CuttingMetal {
    
    public static void main(String[] args) {
        int costPerCut = 1, salePrice =10;
        List<Integer> lengths = new ArrayList<>();
        lengths.add(30);
        lengths.add(59);
        lengths.add(110);

        int profit = 0;
        int min = lengths.get(0);
        for(int i : lengths)
        min =Math.min(min, i);

        for(int i=1;i<=min;i++){
            if(min%i == 0){
                int count = 0, cuts =0;
                for(int j=0;j<lengths.size();j++)
                {
                    count+=(lengths.get(j)/i);
                    cuts += lengths.get(j)%i !=0 ? lengths.get(j)/i :  lengths.get(j)/i+1;
                }

                profit = Math.max(profit,count * salePrice*i-costPerCut*cuts);


            }
        }
        System.out.println(profit);
        
    }
    
}
