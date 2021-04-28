package LQdemo.algorithms;

import java.util.ArrayList;
import java.util.Scanner;


public class test4 {


    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("输入数字的值： ");
        Integer num=sc.nextInt();
        StringBuilder str=new StringBuilder(Integer.toString(num));
        Integer max=0;
        for (int i = 0; i < str.length() ;i++) {
            StringBuilder temp=str.deleteCharAt(i);
            Integer tempnum=Integer.parseInt(temp.toString());
            if(tempnum>max){
                max=tempnum;
            }

        }
        System.out.println(max);



    }


}
