class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        int[] r = new int[]{0,0};
        Set<List<Integer>> set = new HashSet<>();
        int d = 0;
        int res = 0;
        for(int[] obs : obstacles){
            set.add(Arrays.asList(obs[0], obs[1]));
        }
        // System.out.println(set.contains(Arrays.asList(obstacles[0][0], obstacles[0][1])));
        // return -1;
        for(int i : commands)
        {
            int ch = i;
            if(i == -1){
                d = d+1;
                d = d%4;
            }
            else if( i == -2){
                d -= 1;
                if(d < 0) {
                    d = 3;
                }
            }
            else{
                int a = r[0];
                int b = r[1];
                switch(d) {
                    case 0:
                        while(ch-- > 0){
                            b= !set.contains(Arrays.asList(a,b+1))?b+1:b;
                        }
                    break;
                    case 1:
                        while(ch-- > 0){
                            a= !set.contains(Arrays.asList(a+1,b))?a+1:a;
                        }
                    break;
                    case 2:
                        while(ch-- > 0){
                            b= !set.contains(Arrays.asList(a,b-1))?b-1:b;
                        }
                    break;
                    case 3:
                        while(ch-- > 0){
                            a= !set.contains(Arrays.asList(a-1,b))?a-1:a;
                        }
                }
                // System.out.println(r[0] + "  "+ r[1]);
                r[0]=a;
                r[1]=b;
                res = Math.max(r[0]*r[0] + r[1]*r[1],res);
            }
        }
        return res;

   
    }
}