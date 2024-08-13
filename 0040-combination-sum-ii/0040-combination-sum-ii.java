/*lass Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        
    }
}*/
class Solution {

    List<List<Integer>> res=new ArrayList<>();

    int t;

    public void solve(int[] candidates,int idx,int sum,List<Integer> subset)

    {

        if(sum==t)

        {

            res.add(new ArrayList<>(subset));

            return ;

        }

        if(sum>t)

        return ;

        if(idx>=candidates.length)

        return ;

        for(int i=idx;i<candidates.length;i++)

        {

            if(i!=idx && candidates[i]==candidates[i-1]) continue;

            if(candidates[i]>t) continue;

            subset.add(candidates[i]);

            solve(candidates,i+1,sum+candidates[i],subset);

            subset.remove(subset.size()-1);

        }

    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        t=target;

        Arrays.sort(candidates);

        solve(candidates,0,0,new ArrayList<>());

        return res;

    }

}
