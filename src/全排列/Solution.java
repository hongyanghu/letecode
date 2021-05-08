package 全排列;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        List<Integer> output = new ArrayList<>();
        for (int num : nums) {
            output.add(num);
        }
        backwarp(lists,output,0,output.size());
        return lists;
    }

    /**
     *
     * @param lists 最终返回的数据
     * @param output 每一次排列后回溯的数组
     * @param first 当前插入位置
     * @param size 一共的长度
     */
    private void backwarp(List<List<Integer>> lists, List<Integer> output, int first, int size) {
        if (first==size){
            //此处需要进行深拷贝 直接添加output，此output存在于堆,会一致变化，不行用指向
//            lists.add(output);
            lists.add(new ArrayList<>(output));
        }else{
            for (int i = first;i<size;i++){
                //当前插入位置的右边，全部是待选数
                Collections.swap(output,first,i);
                //插入第first+1个位置
                backwarp(lists,output,first+1,size);
                //回溯，放入i+1个数
                Collections.swap(output,first,i);
            }
        }
    }

    public static void main(String[] args) {
        int[] nums={1,2,3};
        Solution solution = new Solution();
        List<List<Integer>> permute = solution.permute(nums);
        for (List<Integer> per:permute
             ) {
            for (int i :per
                 ) {
                System.out.println(i);
            }
        }
    }
}
