package LQdemo.algorithms;

import java.util.Scanner;

/*https://blog.csdn.net/qq_42185999/article/details/105763355*/
/*
牛顿迭代法。设f(x)=x3-y, 求f(x)=0时的解x，即为y的立方根。
根据牛顿迭代思想，xn+1=xn-f(xn)/f'(xn)即x=x-(x3-y)/(3*x2)=(2*x+y/x/x)/3;
*/
public class findCubeRoot {

    private static double getCubeRoot(double input) {

        if (input == 0)
            return 0;
        double x0, x1;
        x0 = input;
        x1 = (2 * x0 / 3) + (input / (x0 * x0 * 3));//利用迭代法求解
        while (Math.abs(x1 - x0) > 0.000001) {
            x0 = x1;
            x1 = (2 * x0 / 3) + (input / (x0 * x0 * 3));
        }
        return x1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double a = sc.nextDouble();
        double cubeRoot = getCubeRoot(a);
        System.out.printf("%.1f\n", cubeRoot);

    }

}
