package LQdemo.algorithms;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

/*有些数的素因子只有 3，5，7，请设计一个算法找出第 k 个数。
注意，不是必须有这些素因子，而是必须不包含其他的素因子。
例如，前几个数按顺序应该是 1，3，5，7，9，15，21。
*/
/*每一个magic number乘以3，5，7也是一个magic number，
通过优先队列，每次取出最小的一个，然后乘以3，5，7得到的值放入队列中，
注意处理重复的数据，比如35和53为重复数据。
*/
public class findNumK {
    public int findNumK(int k){
        ArrayList<Long> arrayList=new ArrayList();
        Queue<Long> queue=new PriorityQueue();
        queue.add(1L);
        while(true){
            Long vlaue=queue.poll();/*计算过的就不能再算了，所以要删除*/
            if(!arrayList.contains(vlaue)){
                arrayList.add(vlaue);
                queue.add(3*vlaue);
                queue.add(5*vlaue);
                queue.add(7*vlaue);

            }
            if(arrayList.size()==k){
                return vlaue.intValue();
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int input=sc.nextInt();
        findNumK findNumK=new findNumK();
        int k=findNumK.findNumK(input);
        System.out.println(k);



    }

}
