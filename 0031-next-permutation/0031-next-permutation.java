class Solution {
    public void nextPermutation(int[] nums) {
        // find the pivot ele
        int n = nums.length;
        int pivot = -1;
        for(int i=n-2;i>=0;i--) {
            if(nums[i]<nums[i+1]) {
                pivot = i;
                break;
            }
        }
        if(pivot==-1) {
            Arrays.sort(nums);
            return;
        } 

        // find the rightmost ele > pivot
        for(int i=n-1;i>pivot;i--) {
            if(nums[i]>nums[pivot]) {
                // swap them 
                // int temp = nums[i];
                // nums[i] = nums[pivot];
                // nums[pivot] = temp;
                swap(nums,i,pivot);
                break;
            }
        }
        // now reverse the pivot+1 to n-1
        int i=pivot+1;
        int j=n-1;
        while(i<=j) {
            // int temp = nums[i];
            // nums[i]=nums[j];
            // nums[j]=temp;
            swap(nums,i,j);
            i++;
            j--;
        }
    }

    public void swap(int[]nums,int a,int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}