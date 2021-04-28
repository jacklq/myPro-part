package LQdemo.algorithms;

import java.util.Arrays;
import java.util.Scanner;


public class continueNum {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
       String str=sc.next();
       String[] numStr=str.split(",");
       if(numStr.length!=5){
           System.out.println("Oh My God");
       }else{
           int[] num=new int[5];
           int count=0;
           for (int i = 0; i <numStr.length ; i++) {
               if(Integer.parseInt(numStr[i])!=0){
                   num[i]=Integer.parseInt(numStr[i]);
               }else {
                   num[i]=0;
                   count++;//0的個數
               }
           }
           int[] numNone=new int[5-count];
           int k=0;
           for (int i = 0; i <num.length ; i++) {
               if(num[i]!=0){
                   numNone[k++]=num[i];//不含0的数组
               }
           }
           Arrays.sort(numNone);
           int jiange=0;
           int normal=0;
           for (int i = 0; i <numNone.length-1 ; i++) {
               if(numNone[i+1]-numNone[i]==3){//间隔两个0
                   jiange=jiange+2;
               }
               if(numNone[i+1]-numNone[i]==2){//间隔一个0
                   jiange++;
               }else if(numNone[i+1]-numNone[i]==1){
                   normal++;
               }

           }
            if(jiange==2){
                normal++;
            }
           if(jiange!=count){
               System.out.println("Oh My God!");
           }else if(1+normal+count==5){
               System.out.println("So Lucky!");
           }else {
               System.out.println("Oh My God!");
           }

       }


    }

}
