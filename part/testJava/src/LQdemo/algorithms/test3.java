package LQdemo.algorithms;


public class test3 {

    public String moneyToString(double input) {
        String strNum = "亿千百拾万千百拾元角分";
        String strHan = "零壹贰叁肆伍陆柒捌玖";
        String result = "";
        int money = (int) (input * 100);
        int len = strNum.length() - 1;
        boolean flag = true;

        while (money > 0) {
            if (money == 1000) {
                result = "拾元整" + result;
                money = 0;
            } else {
                if (money % 100 == 0 && len == strNum.length() - 1) {
                    result = "" + "整" + result;
                    len = len - 2;
                    money = money / 100;
                } else {
                    if (money % 10 == 0 && flag) {
                        result = "" + strHan.charAt(0) + result;
                        flag = false;
                        len--;
                        money = money / 10;
                    } else {
                        if (money % 10 == 0 && !flag) {
                            len--;
                            money = money / 10;
                        } else if (money % 10 != 0) {
                            result = "" + strHan.charAt(money % 10) + strNum.charAt(len) + result;
                            len--;
                            money = money / 10;
                        }
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        test3 test3 = new test3();
        double n1 = 222.11;
        double n2 = 222.11;
        System.out.println(test3.moneyToString(n1 + n2));

    }
}