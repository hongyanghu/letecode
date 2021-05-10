package 两数之和;

import java.util.HashMap;
import java.util.Hashtable;

public class Solution {
    public int[] twoSum(int[] nums,int target){
        Hashtable<Integer,Integer> hashtable  = new Hashtable<>();
        for (int i=0;i<nums.length;i++){
            if (hashtable.containsKey(target-nums[i])){
                return new int[]{hashtable.get(target-nums[i]),i};
            }
            hashtable.put(nums[i],i);
        }
        return new int[0];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] ints = {2,7,11,15};
        int[] ints1 = solution.twoSum(ints, 9);

    }
}
