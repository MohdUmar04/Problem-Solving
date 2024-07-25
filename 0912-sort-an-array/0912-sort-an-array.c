

/**
 * Note: The returned array must be malloced, assume caller calls free().
 */
void MERGE(int A[],int p,int q,int r){
	int i,j,k,n1=q-p+1;
	int n2=r-q;
	int L[n1+2],R[n2+2];
    L[0]=-1;
    R[0]=-1;
	for(i=1;i<=n1;i++)
	L[i]=A[p+i-1];
	for(j=1;j<=n2;j++)
	R[j]=A[q+j];
	L[n1+1]=99999;
	R[n2+1]=99999;
	i=1;j=1;
	for(k=p;k<=r;k++)
	{
		if(L[i]<=R[j]){
			A[k]=L[i];
			i=i+1;
		}
		else{
			A[k]=R[j];
			j=j+1;
		}
	}
}
void MERGE_SORT(int A[],int p,int r)
{
	int q;
	if(p<r)
	{
	    q=((p+r)/2);
		MERGE_SORT(A,p,q);
		MERGE_SORT(A,q+1,r);
		MERGE(A,p,q,r);
	}
}
int* sortArray(int* nums, int n, int* returnSize){
      MERGE_SORT(nums,0,n-1);
    *returnSize=n;
    return nums;
}