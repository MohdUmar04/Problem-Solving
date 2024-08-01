// import java.util.List;
import java.util.stream.Collectors;

class Solution {
    public int countSeniors(String[] details) {          
        return (int) Arrays.stream(details)
            .filter(a -> Integer.parseInt((new StringBuilder(a)).substring(11, 13)) > 60).count();
            
    }
}