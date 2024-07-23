class Solution {
    public int[] frequencySort(int[] nums) {

        HashMap<Integer,Integer> map = new HashMap<>();
        // String[][] str = new String[10];

        // str[0] = new int[5];

        for(int i: nums)
            map.put(i,map.getOrDefault(i,0)+1);
        
        Integer[] boxedNums = Arrays.stream(nums).boxed().toArray(Integer[]::new);
        Arrays.sort(boxedNums, (a, b) -> map.get(a) != map.get(b)? map.get(a) - map.get(b) : b-a);

        int k=0;
        for(int i : boxedNums)
            nums[k++]=i;
        return nums;
        
    }
}