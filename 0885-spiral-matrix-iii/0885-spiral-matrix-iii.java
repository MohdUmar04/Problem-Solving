class Solution {
    public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
        List<int[]> res=new ArrayList<>();
        int c=1;
        int[][] mat = new int[rows][cols];
        while(res.size()<rows*cols){
          
            int k=0;
                while(k++<c){
                    // res.add(new int[]{rStart,cStart++});
                    try{    if(mat[rStart][cStart]==0)
                        res.add(new int[]{rStart,cStart});}
                    catch( Exception e) {

                    }
                    cStart++;
                }
                k=0;
                while(k++<c){
                    // res.add(new int[]{rStart++,cStart});
                    try{    if(mat[rStart][cStart]==0)
                        res.add(new int[]{rStart,cStart});}
                    catch( Exception e) {

                    }
                    rStart++;
                }
                k=0;
                while(k++<=c){
                    // res.add(new int[]{rStart,cStart--});
                    try{    if(mat[rStart][cStart]==0)
                        res.add(new int[]{rStart,cStart});}
                    catch( Exception e) {

                    }
                    cStart--;
                }
                k=0;
                while(k++<=c){
                    // res.add(new int[]{rStart--,cStart});
                    try{    if(mat[rStart][cStart]==0)
                        res.add(new int[]{rStart,cStart});}
                    catch( Exception e) {

                    }
                    rStart--;
                }

            c++;
            c++;
        }
    int l=0;
    mat = new int[res.size()][2];
    for(int[] r : res){
        mat[l++]=r;
    }
    return mat;

    }
}