package 排序数组;

public class Solution {

    public int[] sortArray(int[] nums){
        int length=nums.length;
        int left=0;
        int right=length-1;
        int[] ints = quickSort(nums, left, right);
        return ints;
    }
    public int[] quickSort(int[] nums, int left,int right){

        if (left>=right){
            return nums;
        }
        int temp=nums[left];
        int i=left;
        int j =right;
        while(i!=j){

            while(nums[j]>=temp &&i<j){
                j--;
            }
            while(nums[i]<=temp&& i<j){
                i++;
            }
            if (i<j){
                int t=nums[i];
                nums[i]=nums[j];
                nums[j]=t;
            }
            System.out.println(i);
            System.out.println(j);

        }
        nums[left]=nums[i];
        nums[i]=temp;

        quickSort(nums,left,i-1);
        quickSort(nums,i+1,right);
        return nums;
    }

    public static void main(String[] args) {
        int[] array = {5,2,3,1};
        int k = 2;
        Solution solution = new Solution();
        int[] kthLargest = solution.sortArray(array);
//        for (int t:kthLargest
//             ) {
//            System.out.println(t);
//        }
    }
}
