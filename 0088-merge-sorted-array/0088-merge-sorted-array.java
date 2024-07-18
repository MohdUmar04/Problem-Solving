class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if(n == 0) return ;
        if(m==0) {
            for(int i=0;i<n;i++)
            nums1[i] = nums2[i];

            return;
        }
        
        int i=m-1, j=nums1.length-1;
        while(i>=0) {
            nums1[j] = nums1[i];
            nums1[i] = 0;
            i--;
            j--; 
        }

        i=0;
        j++;
        int k=0;
        while(i<n && j<nums1.length) {
            if(nums2[i] <= nums1[j])
                nums1[k++] = nums2[i++];
            else
                nums1[k++] = nums1[j++];
        } 
        while(i<n)
            nums1[k++] = nums2[i++];
        while( j<nums1.length)
            nums1[k++] = nums1[j++];

        

    }
}