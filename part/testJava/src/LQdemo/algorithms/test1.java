package LQdemo.algorithms;

import java.util.Scanner;


public class test1 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        String str = sc.next();
        String[] want = str.split("-");
        String last = want[0] + '-';
        for (int i = 1; i < want.length; i++) {
            String temp = want[i];
            String unit;
            for (int j = 0; j < temp.length(); j += k) {
                if (j + k > temp.length()) {
                    unit = temp.substring(j);
                } else {
                    unit = temp.substring(j, j + k) + '-';
                }

                int numLower = 0;
                int numUpper = 0;
                for (int m = 0; m < unit.length(); m++) {
                    if ('A' <= unit.charAt(m) && unit.charAt(m) < 'Z') {
                        numUpper++;
                    } else if ('a' <= unit.charAt(m) && unit.charAt(m) < 'z') {
                        numLower++;
                    }
                }
                if (numUpper < numLower) {
                    last += unit.toLowerCase();
                } else if (numUpper > numLower) {
                    last += unit.toUpperCase();
                } else {
                    last += unit;
                }


            }
        }
        System.out.println(last);

    }

}
