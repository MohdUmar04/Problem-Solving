class Solution {
    public int[] arrayRankTransform(int[] arr) {
        TreeSet<Integer> unqEle = new TreeSet<>();
        Map<Integer, Integer> numRankMp = new HashMap<>();
        for(var num : arr){
           unqEle.add(num);
        }
        int rank = 1;
        for(var ele : unqEle){
            numRankMp.put(ele, rank++);
        }
        int size = arr.length;
        int ranks[] =  new int[size];
        for(int indx = 0; indx < size; indx++){
            ranks[indx] = numRankMp.get(arr[indx]);
        }
        return ranks;
    }
}