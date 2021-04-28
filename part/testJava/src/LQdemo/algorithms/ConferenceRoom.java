package LQdemo.algorithms;

import java.lang.reflect.Array;
import java.util.*;

/*
*/

/*
*/
public class ConferenceRoom {
    public int minMeetingRooms(int[][] intervals){
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        Queue minHeap=new PriorityQueue();
        minHeap.add(intervals[0][1]);

        for (int i = 1; i <intervals.length ; i++) {
            if(intervals[i][0]>=(int)minHeap.peek()){
                minHeap.poll();
                minHeap.add(intervals[i][1]);

            }else {
                minHeap.add(intervals[i][1]);
            }
        }
       return minHeap.size();
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int num=sc.nextInt();
        int colu=2;
        int[][] arr=new int[num][colu];
        for (int i = 0; i <num ; i++) {
            for (int j = 0; j <colu ; j++) {
                arr[i][j]=sc.nextInt();
            }

        }
        System.out.println(new ConferenceRoom().minMeetingRooms(arr));

        ;



    }

}
