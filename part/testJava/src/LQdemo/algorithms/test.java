package LQdemo.algorithms;

import java.util.ArrayList;
import java.util.Scanner;


public class test {

    private   String reverseStr(String str){
        StringBuilder sb = new StringBuilder(str);
        return  sb.reverse().toString();
    }
    private   String blank(int num){
        StringBuffer space= new StringBuffer();
        for(int i= 0;i<num;i++)
        {
            space.append(" ");
        }
        return  space.toString();
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("输入数字的值： ");
        Integer level=sc.nextInt();
        if(level<0||level>10){
            System.out.println("输入参数超界，请输入0-10");
        }else{
            String str="";

            ArrayList arrayList=new ArrayList();
            for(int i=1;i<=level;i++){
                str=str+i;
                String restr=new test().reverseStr(str);
                String blank=new test().blank(level-i);
                arrayList.add(blank+str+restr.substring(1)+blank);

            }
            for (int j=0;j<level;j++){
                System.out.println(arrayList.get(j));
            }
        }



    }


}
