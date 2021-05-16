package 搜索旋转排序数组;

public class Solution {

    public int search(int[] nums, int target) {
        int left=0;
        int right=nums.length-1;
        if (nums.length == 0) {
            return -1;
        }
        if (nums.length == 1) {
            return nums[0] == target ? 0 : -1;
        }

        while(left<=right){
            int mid=(left+right)/2;
            if (target==nums[mid]){
                return mid;
            }
            if (nums[0]<nums[mid]){
                if (target<nums[mid]){
                    right=mid-1;
                }else{
                    left=mid+1;
                }
            }else{
                if (nums[mid]<target){
                    left=mid+1;
                }else{
                    right=mid-1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {

    }
}
