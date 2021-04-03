package com.lq.lqproj.util;

import java.util.ArrayList;
import java.util.Arrays;



public class SortAlgorithm {


    /***************** 1-直接插入**** *******************
    step
        1:从第二个数开始，第i个数就是待插入的数
        2：从后往前，只要a[j]>待插入的数，则后移，一次循环、
        3：将待插入的数放到指定位置
     */
    public void insertSort(int[] a) {
        int len = a.length;//单独把数组长度拿出来，提高效率
        int insertNum;//要插入的数
        for (int i = 1; i < len; i++) {//因为第一次不用，所以从1开始
            insertNum = a[i];
            int j = i - 1;//序列元素个数
            while (j >= 0 && a[j] > insertNum) {//从后往前循环，将大于insertNum的数向后移动
                a[j + 1] = a[j];//元素向后移动
                j--;
            }
            a[j + 1] = insertNum;//找到位置，插入当前元素
        }
    }

    /** *********  2-希尔排序，是对直接插入排序的改进,将数组按照len间隔分成多个数组，每个数组再执行直接插入排序
   step
        1:按照len间隔分组，len/2
        2:对每个组实行直接插入排序
   */
    public void sheelSort(int[] a) {
        int len = a.length;//单独把数组长度拿出来，提高效率
        int insertNum;
        while (len != 0) {
            len = len / 2;
            for (int g = 0; g < len; g++) {//分组
                for (int i = g + len; i < a.length; i += len) {//元素从第二个开始
                    insertNum = a[i];//要插入的元素
                    int j = i - len;//k为有序序列最后一位的位数

                    while (j >= 0 && a[j] > insertNum) {//从后往前遍历
                        a[j + len] = a[j];
                        j -= len;//向前移动len位
                    }
                    a[j + len] = insertNum;//因为是已经减了len,所以要加上
                }
            }

        }
    }

    /***   3-简单选择排序**************************
    遍历整个序列，将最小的数放在最前面。
    遍历剩下的序列，将最小的数放在最前面。
    重复第二步，直到只剩下一个数。*/
    public void selectSort(int[] a) {
        int len = a.length;
        for (int i = 0; i < len; i++) {//循环次数
            int min = a[i];
            int minPosition = i;
            for (int j = i + 1; j < len; j++) {//找到最小的值和位置
                if (a[j] < min) {
                    min = a[j];
                    minPosition = j;
                }
            }
            a[minPosition] = a[i];//进行交换
            a[i] = min;
        }
    }

    /***    4-堆排序   ***************/
    public void heapSort(int[] arr) {
        for (int i = arr.length / 2 - 1; i >= 0; i--) {/*第一个非叶子结点 arr.length/2-1*/
            //从第一个非叶子结点从下至上，从右至左调整结构
            buildMaxHeap(arr, i, arr.length);
        }
        //2.调整堆结构+交换堆顶元素与末尾元素
        for (int j = arr.length - 1; j > 0; j--) {
            swap(arr, 0, j);//将堆顶元素与末尾元素进行交换
            buildMaxHeap(arr, 0, j);//重新对堆进行调整
        }
    }

    //交换方法
    private void swap(int[] data, int i, int j) {
        int tmp = data[i];
        data[i] = data[j];
        data[j] = tmp;
    }

    //对data数组从0到lastIndex建大顶堆
    private void buildMaxHeap(int[] arr, int i, int length) {
        int temp = arr[i];//先取出当前元素i
        for (int k = i * 2 + 1; k < length; k = k * 2 + 1) {//从i结点的左子结点开始，也就是2i+1处开始
            if (k + 1 < length && arr[k] < arr[k + 1]) {//如果左子结点小于右子结点，k指向右子结点
                k++;
            }
            if (arr[k] > temp) {//如果子节点大于父节点，将子节点值赋给父节点（不用进行交换）
                arr[i] = arr[k];
                i = k;
            } else {
                break;
            }
        }
        arr[i] = temp;//将temp值放到最终的位置
    }

    /******   5-冒泡排序************************************************
    从第一个数开始，依次往后比较，如果前面的数比后面的数大就交换，否则不作处理。
     这就类似烧开水时，壶底的水泡往上冒的过程。
    一个数与全部的比完之后，再进行下一轮  ***/
    public void bubbleSort(int[] a) {
        int len = a.length;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len - i - 1; j++) {//注意第二重循环的条件,因为肯定最大的一个已经到队尾了，就不用再比较了
                if (a[j] > a[j + 1]) {
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
        }
    }


 /****   6- 快速排序*************************
         选择第一个数为p，小于p的数放在左边，大于p的数放在右边。
        递归的将p左边和右边的数都按照第一步进行，直到不能递归。
        step
           1:选择一个基准，常为第一个数，
           2：right、left依次走动
           3：如果找到，则交换
           4：left=right时，交换基准值和这个值
           5:递归左和右两组
        */

    public void quickSort(int[] a, int start, int end) {

        if (start > end)
            return;
        int left, right, temp;
        temp = a[start]; //temp中存的就是基准数
        left = start;
        right = end;
        while (left != right) {
            //顺序很重要，要先从右边开始找,否则有可能在与基准交换的时候将大于基准的数交换了
            while (a[right] >= temp && left < right)
                right--;
            //再找右边的
            while (a[left] <= temp && left < right)
                left++;
            //交换两个数在数组中的位置
            if (left < right) {
                swap(a, left, right);
            }
        }
        //最终将基准数归位
        swap(a, start, left);
        quickSort(a, start, left - 1);//继续处理左边的，这里是一个递归的过程
        quickSort(a, left + 1, end);//继续处理右边的 ，这里是一个递归的过程
    }
     /***   7-归并排序   ********************************
    把前一半排序，把后一半排序，最后把两半归并到一个新的有序数组，最后拷贝到原数组
    */

    public void mergeSort(int[] a, int start, int end) {
        if (start >= end) {
            return;
        }
        int mid = start + (end - start) / 2;
        mergeSort(a, start, mid);
        mergeSort(a, mid + 1, end);
        merge(a, start, mid, end);
    }

    private static void merge(int[] a, int start, int mid, int end) {
        int pTemp = 0;
        int[] temp = new int[end - start + 1];
        int p1 = start, p2 = mid + 1;
        while (p1 <= mid && p2 <= end) {
            if (a[p1] < a[p2])
                temp[pTemp++] = a[p1++];
            else
                temp[pTemp++] = a[p2++];
        }
        while (p1 <= mid) {
            temp[pTemp++] = a[p1++];
        }
        while (p2 <= end) {
            temp[pTemp++] = a[p2++];
        }
        System.arraycopy(temp, 0, a, start + 0, temp.length);

    }
    /***   8-计数排序   ********************************
     -使用一个额外的数组C，其中第i个元素是待排序数组A中值等于i的元素的个数。然后根据数组C来将A中的元素排到正确的位置。
     1：找出待排序的数组中最大和最小的元素；
     2：统计数组中每个值为i的元素出现的次数，存入数组C的第i项；
     3：对所有的计数累加（从C中的第一个元素开始，每一项和前一项相加）；
     4：反向填充目标数组：将每个元素i放在新数组的第C(i)项，每放一个元素就将C(i)减去1。
     */

    public  int[] countingSort(int[] array) {
        if (array.length == 0) return array;
        int bias, min = array[0], max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max)
                max = array[i];
            if (array[i] < min)
                min = array[i];
        }
        bias = 0 - min;
        int[] bucket = new int[max - min + 1];
        Arrays.fill(bucket, 0);
        for (int i = 0; i < array.length; i++) {
            bucket[array[i] + bias]++;
        }
        int index = 0, i = 0;
        while (index < array.length) {
            if (bucket[i] != 0) {
                array[index] = i - bias;
                bucket[i]--;
                index++;
            } else
                i++;
        }
        return array;
    }

    /***   9-桶排序   ********************************
     是计数排序的升级版。假设输入数据服从均匀分布，将数据分到有限数量的桶里，每个桶再分别排序（有可能再使用别的排序算法或是以递归方式继续使用桶排序进行
     步骤1：人为设置一个BucketSize，作为每个桶所能放置多少个不同数值（例如当BucketSize==5时，该桶可以存放｛1,2,3,4,5｝这几种数字，但是容量不限，即可以存放100个3）；
     步骤2：遍历输入数据，并且把数据一个一个放到对应的桶里去；
     步骤3：对每个不是空的桶进行排序，可以使用其它排序方法，也可以递归使用桶排序；
     步骤4：从不是空的桶里把排好序的数据拼接起来。 

     */

    public  ArrayList<Integer> BucketSort(ArrayList<Integer> array, int bucketSize) {
        if (array == null || array.size() < 2)
            return array;
        int max = array.get(0), min = array.get(0);
        // 找到最大值最小值
        for (int i = 0; i < array.size(); i++) {
            if (array.get(i) > max)
                max = array.get(i);
            if (array.get(i) < min)
                min = array.get(i);
        }
        int bucketCount = (max - min) / bucketSize + 1;
        ArrayList<ArrayList<Integer>> bucketArr = new ArrayList<>(bucketCount);
        ArrayList<Integer> resultArr = new ArrayList<>();
        for (int i = 0; i < bucketCount; i++) {
            bucketArr.add(new ArrayList<Integer>());
        }
        for (int i = 0; i < array.size(); i++) {
            bucketArr.get((array.get(i) - min) / bucketSize).add(array.get(i));
        }
        for (int i = 0; i < bucketCount; i++) {
            if (bucketSize == 1) { // 如果带排序数组中有重复数字时
                for (int j = 0; j < bucketArr.get(i).size(); j++)
                    resultArr.add(bucketArr.get(i).get(j));
            } else {
                if (bucketCount == 1)
                    bucketSize--;
                ArrayList<Integer> temp = BucketSort(bucketArr.get(i), bucketSize);
                for (int j = 0; j < temp.size(); j++)
                    resultArr.add(temp.get(j));
            }
        }
        return resultArr;
    }
    /***   10-基数排序   ********************************
     基数排序是按照低位先排序，然后收集；再按照高位排序，然后再收集；依次类推，直到最高位。
     1-实现步骤
     步骤1：取得数组中的最大数，并取得位数；
     步骤2：arr为原始数组，从最低位开始取每个位组成radix数组；
     步骤3：对radix进行计数排序（利用计数排序适用于小范围数的特点）；

     */

    public static int[] RadixSort(int[] array) {
        if (array == null || array.length < 2)
            return array;
        // 1.先算出最大数的位数；
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            max = Math.max(max, array[i]);
        }
        int maxDigit = 0;
        while (max != 0) {
            max /= 10;
            maxDigit++;
        }
        int mod = 10, div = 1;
        ArrayList<ArrayList<Integer>> bucketList = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < 10; i++)
            bucketList.add(new ArrayList<Integer>());
        for (int i = 0; i < maxDigit; i++, mod *= 10, div *= 10) {
            for (int j = 0; j < array.length; j++) {
                int num = (array[j] % mod) / div;
                bucketList.get(num).add(array[j]);
            }
            int index = 0;
            for (int j = 0; j < bucketList.size(); j++) {
                for (int k = 0; k < bucketList.get(j).size(); k++)
                    array[index++] = bucketList.get(j).get(k);
                bucketList.get(j).clear();
            }
        }
        return array;
    }
}
