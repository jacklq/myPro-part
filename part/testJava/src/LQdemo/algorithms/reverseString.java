package LQdemo.algorithms;

import java.util.Scanner;

/*将一个字符串str的内容颠倒过来，并输出。str的长度不超过100个字符。 如：输入“I am a student”，输出“tneduts a ma I”。*/
public class reverseString {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

//                String str = sc.nextLine();//next()是遇到空格；nextLine()是遇到回车
//                StringBuilder sb = new StringBuilder(str);
//                System.out.println(sb.reverse().toString());

//            int a=sc.nextInt();
//            int b=sc.nextInt();
        String str = sc.nextLine();
        StringBuilder sb = new StringBuilder(str);
        System.out.println(sb.reverse().toString());
        System.out.println("abbaa");

    }

}
