package LQdemo;

import java.net.SocketOption;
import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class severalSort {


    /*直接插入
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

    //    希尔排序，是对直接插入排序的改进,将数组按照len间隔分成多个数组，每个数组再执行直接插入排序
   /* step
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

    //    简单选择排序
   /* 遍历整个序列，将最小的数放在最前面。
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

    //    堆排序
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

    //    冒泡排序
    /*从第一个数开始，依次往后比较，如果前面的数比后面的数大就交换，否则不作处理。这就类似烧开水时，壶底的水泡往上冒的过程。。*/
    /*一个数与全部的比完之后，再进行下一轮*/
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


//    快速排序
    /*选择第一个数为p，小于p的数放在左边，大于p的数放在右边。
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
    //    归并排序
    /*
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

    public static void main(String[] args) {

        int[] array = {7, 6, 8, 2, 5, 9};

        severalSort temp = new severalSort();
//        temp.insertSort(array);
//        temp.sheelSort(array);
//        temp.selectSort(array);
//        temp.quickSort(array,0,4);
//        temp.quickSort(array,0,5);
//        temp.mergeSort(array,0,5);
        temp.heapSort(array);
        System.out.println(Arrays.toString(array));

    }
}
