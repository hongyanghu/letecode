package 三数之和;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int length=nums.length;
        List<List<Integer>> arrayLists = new ArrayList<>();

        for (int i=0;i<length;i++){
            if (i>0 &&nums[i-1]==nums[i]){
                continue;
            }

            int target=-nums[i];
            int t=length-1;

            for (int j =i+1;j<length;j++){

                if (j>i+1&&nums[j]==nums[j-1]){
                    continue;
                }else{
                    while (j<t&&nums[j]+nums[t]>target) {
                    t--;
                    }

                    if (nums[j]+nums[t]==target&&j<t){
                        ArrayList<Integer> arrayList = new ArrayList<>();
                        arrayList.add(nums[i]);
                        arrayList.add(nums[j]);
                        arrayList.add(nums[t]);
                        arrayLists.add(arrayList);
                    }
                }
            }
        }
        return arrayLists;
    }

    public static void main(String[] args) {

    }
}
