package LQdemo.algorithms;

import java.util.Scanner;

/*https://blog.csdn.net/qq_42185999/article/details/105763355*/
/*求最大公约数有两种方法： 更相减损法和辗转相处法 。最小公倍数在求出最大公约数后 两个数相乘除以最大公约数就是最小公倍数。
更相减损法
更相减损法是拿两个数中的较大值减去较小值，然后在减数、被减数、差之间选取两个较小值继续相减，直到减数和被减数相等，得出的数就是最大公约数。

辗转相除法
用较大数除以较小数，再用出现的余数（第一余数）去除除数，再用出现的余数（第二余数）去除第一余数，如此反复，直到最后余数是0为止。
如果是求两个数的最大公约数，那么最后的除数就是这两个数的最大公约数。
*/
public class findMaxMultiple {

    static int getMaxYue(int a, int b) {
        int cha = a - b;
        while (cha != b) {
            if (cha > b) {
                a = cha;
            } else {
                a = b;
                b = cha;
            }
            cha = a - b;
        }
        return b;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int yue;
        if (a > b) {
            yue = getMaxYue(a, b);
        } else {
            yue = getMaxYue(b, a);
        }
        int bei = a * b / yue;
        System.out.println(bei);

    }

}
