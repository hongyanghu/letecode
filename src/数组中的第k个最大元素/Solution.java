package 数组中的第k个最大元素;


import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
    //冒泡排序
    public static int[] bubbleSort(int[] array) {
        if (array.length == 0) {
            return array;
        }
        boolean flag = true;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j + 1] < array[j]) {
                    int temp = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = temp;
                    flag = false;
                }
            }
            if (flag) {
                break;
            }
            flag = true;
        }
        return array;
    }

    //选择排序
    public static int[] selectionSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int min = i;
            for (int j = i; j < array.length; j++) {
                if (array[j] < array[min]) {
                    min = j;
                }
            }
            int temp = array[i];
            array[i] = array[min];
            array[min] = temp;
        }
        return array;
    }

    //插入排序
    public static int[] insertionSort(int[] array) {
        if (array.length == 0) {
            return array;
        }
        int current;
        for (int i = 0; i < array.length - 1; i++) {
            current = array[i + 1];
            int preIndex = i;
            while (preIndex >= 0 && current < array[preIndex]) {
                array[preIndex + 1] = array[preIndex];
                preIndex--;
            }
            array[preIndex + 1] = current;
        }
        return array;
    }

    //希尔排序
    public static int[] ShellSort(int[] array) {
        int len = array.length;
        int temp, gap = len / 2;
        while (gap > 0) {
            for (int i = gap; i < len; i++) {
                temp = array[i];
                int preIndex = i - gap;
                while (preIndex >= 0 && array[preIndex] > temp) {
                    array[preIndex + gap] = array[preIndex];
                    preIndex -= gap;
                }
                array[preIndex + gap] = temp;
            }
            gap = gap / 2;
        }
        return array;
    }

    //归并排序-2路归并
    public static int[] MergeSort(int[] array) {
        if (array.length < 2) {
            return array;
        }
        int mid = array.length / 2;
        int[] left = Arrays.copyOfRange(array, 0, mid);
        int[] right = Arrays.copyOfRange(array, mid, array.length);
        return merge(MergeSort(left), MergeSort(right));
    }

    //归并排序，将两段排序号的数组结合成一个排序的数组
    public static int[] merge(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];
        for (int index = 0, i = 0, j = 0; index < result.length; index++) {
            if (i > left.length) {
                result[index] = right[j++];
            } else if (j >= right.length) {
                result[index] = left[j++];
            } else if (left[i] > right[j]) {
                result[index] = right[j++];
            } else {
                result[index] = left[i++];
            }
        }
        return result;
    }


    //快速排序
    public static int[] QuickSort(int[] array, int start, int end) {
        if (array.length < 1 || start < 0 || end > array.length || start > end) {
            return null;
        }
        int smallIndex = partition(array, start, end);
        if (smallIndex > start) {
            QuickSort(array, start, smallIndex - 1);
        }
        if (smallIndex < end) {
            QuickSort(array, smallIndex + 1, end);
        }
        return array;
    }
    //快速排序算法
    public static int partition(int[] array, int start, int end) {
        int pivot = (int) (start + Math.random() * (end - start + 1));
        int smallIndex = start - 1;
        swap(array, pivot, end);
        for (int i = start; i < end; i++) {
            if (array[i] < array[end]) {
                smallIndex++;
                swap(array, i, smallIndex);
            }
        }
        return smallIndex;
    }
    //交换组内两个元素
    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    //堆排序算法
    public static int[] HeapSort(int[] array){
        int length=array.length;
        if (length<1)return array;
        //1.构建一个大顶堆
        buildMaxHeap(array,length);
        while(length>0){
            swap(array,0,length-1);
            length--;
            adjustHeap(array,0,length);
        }
        return array;
    }
    //建立大顶堆
    public static void buildMaxHeap(int[] array,int length){
        //从最后一个非叶子开始向上构造大顶堆
        for (int i =(length/2-1);i>=0;i--){
            adjustHeap(array,i,length);
        }
    }
    //调整是交换后的树满足大顶堆
    public static void adjustHeap(int[] array,int i,int length){
        int maxIndex = i;
        //如果有左子树，且左子树大于父节点，则将最大指针指向左子树
        if (i*2<length && array[i*2]>array[maxIndex]){
         maxIndex=i*2;
        }
        //如果有右子树，且右子树大于父节点，则将最大指针指向右子树
        if (i*2+1<length&&array[i*2+1]>array[maxIndex]){
            maxIndex = i*2+1;
        }
        if (maxIndex!=i){
            swap(array,maxIndex,i);
            adjustHeap(array,maxIndex,length);
        }
    }

    //计数排序
    public static int[] countSort(int[] array){
        if (array.length==0)return array;
        int bias,min=array[0],max=array[0];
        for (int i =1;i<array.length;i++){
            if (array[i]>max)
                max=array[i];
            if (array[i]<min)
                min=array[i];
        }
        bias=-min;
        int[] bucket=new int[max-min+1];
        Arrays.fill(bucket,0);
        //最有用的部分，将最小置于0桶
        for (int value : array) {
            bucket[value + bias]++;
        }
        int index=0,i=0;
        while(index<array.length){
            if (bucket[i]!=0){
                array[index]=i-bias;
                bucket[i]--;
                index++;
            }else{
                i++;
            }
        }
        return array;
    }

    //桶排序
    public static ArrayList<Integer> BucketSort(ArrayList<Integer> array,int bucketSize){
        if (array==null || array.size()<2){
            return array;
        }
        int max = array.get(0),min=array.get(0);
        // 找到最大值最小值
        for (Integer integer : array) {
            if (integer > max)
                max = integer;
            if (integer < min)
                min = integer;
        }
        int bucketCount=(max-min)/bucketSize+1;
        ArrayList<ArrayList<Integer>> bucketArr=new ArrayList<>(bucketCount);
        ArrayList<Integer> resultArr = new ArrayList<>();
        for (int i=0;i<bucketCount;i++){
            bucketArr.add(new ArrayList<Integer>());
        }
        for (Integer integer : array) {
            bucketArr.get((integer - min) / bucketSize).add(integer);
        }
        for (int i =0;i<bucketCount;i++){
            if (bucketSize==1){
                for (int j=0;i<bucketArr.get(i).size();j++){
                    resultArr.add(bucketArr.get(i).get(j));
                }
            }else{
                if (bucketCount==1){
                    bucketSize--;
                }
                ArrayList<Integer> temp = BucketSort(bucketArr.get(i),bucketSize);
                resultArr.addAll(temp);
            }
        }
        return resultArr;
    }

    public int findKthLargest(int[] nums, int k) {
        //冒泡排序
//        int[] ints = this.bubbleSort(nums);
        //选择排序
        int[] ints = selectionSort(nums);
        //插入排序
//        int[] ints1 = this.insertionSort(nums);
//        int[] ints= QuickSort(nums,0,nums.length);

        for (int i :
                ints) {
            System.out.println(i);
        }
        return ints[ints.length - k];
    }

    public static void main(String[] args) {
        int[] array = {3, 2, 1, 5, 6, 4};
        int k = 2;
//        Solution solution = new Solution();
//        int kthLargest = solution.findKthLargest(array, k);
//        System.out.println(kthLargest);


    }
}
