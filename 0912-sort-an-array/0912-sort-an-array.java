class Solution {
    public static void  mergeSort(int[]nums,int si,int ei) {
        // Base case
        if(si>=ei) return;

        // kaam
        // firstly divide(means find mid)
        int mid = si+(ei-si)/2;
        mergeSort(nums,si,mid); // left part
        mergeSort(nums,mid+1,ei); // right part

        merge(nums,si,mid,ei);


    }

    public static void merge(int[]nums,int si,int mid,int ei) {
        // left(0,3)=4  right(4,6)=3  -> 6-0+1
        int[] temp = new int[ei-si+1];
        int i=si; // iterator for left part
        int j=mid+1; // iterator for right part
        int k=0; // iterator for temp arr

        while(i<=mid && j<=ei) {
            if(nums[i]<nums[j]) {
                temp[k] = nums[i];
                i++;
                k++;
            }
            else{
                temp[k] = nums[j];
                j++;
                k++;
            }
        }

        // remaining left part
        while(i<=mid) {
            temp[k] = nums[i];
            i++;
            k++;
        }

        // remaining right part
        while(j<=ei) {
            temp[k] = nums[j];
            j++;
            k++;
        }

        // copy back(temp to nums)
        for(int x=0;x<temp.length;x++) {
            nums[si+x] = temp[x];
        }
    }

    public int[] sortArray(int[] nums) {
        int n = nums.length;
        mergeSort(nums,0,n-1);
        return nums;
    }
}