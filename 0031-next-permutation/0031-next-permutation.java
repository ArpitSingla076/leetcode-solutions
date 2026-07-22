class Solution {
    public void swap(int[]nums,int a,int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int pivot=-1;

        // finding pivot ele
        for(int i=n-2;i>=0;i--) {
            if(nums[i]<nums[i+1]) {
                pivot = i;
                break;
            }
        }

        // if(pivot==-1) {
        //     Arrays.sort(nums);
        //     return;
        // }

        if(pivot==-1) {
            int i=0;
            int j=n-1;
            while(i<j) {
                swap(nums,i,j);
                i++;
                j--;
            }
            return;
        }

        // find rightmost ele > pivot and swap them
        for(int i=n-1;i>pivot;i--) {
            if(nums[i]>nums[pivot]) {
                swap(nums,i,pivot);
                break;
            }
        }

        // reverse pivot+1 to n-1;
        int i=pivot+1;
        int j=n-1;
        while(i<j) {
            swap(nums,i,j);
            i++;
            j--;
        }
    }
}