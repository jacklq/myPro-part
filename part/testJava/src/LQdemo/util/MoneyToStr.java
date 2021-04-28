package LQdemo.util;


public  class MoneyToStr{

    private static final String UNIT = "万千佰拾亿千佰拾万千佰拾元角分";
    private static final String NUM = "零壹贰叁肆伍陆柒捌玖";
    private static final double MAX_VALUE = 9999999999999.99D;

    public static String toMoneyStr(double input) {
        if (input < 0 || input > MAX_VALUE) {
            return "输入参数错误!";
        }
        String strValue = String.valueOf(Math.round(input * 100));

        int conNum = 0;

        int conUnit = UNIT.length() - strValue.length();
        String result = "";
        boolean isZero = false;
        for (; conNum < strValue.length(); conNum++, conUnit++) {
            char ch = strValue.charAt(conNum);
            if (ch == '0') {
                isZero = true;
                if (UNIT.charAt(conUnit) == '亿' || UNIT.charAt(conUnit) == '万' || UNIT.charAt(conUnit) == '元') {
                    result = result + UNIT.charAt(conUnit);
                    isZero = false;
                }
            } else {
                if (isZero) {
                    result = result + "零";
                    isZero = false;
                }
                result = result + NUM.charAt(Integer.parseInt(String.valueOf(ch))) + UNIT.charAt(conUnit);
            }
        }
//

        return result;
    }


    public static void main(String[] args) {
        MoneyToStr test3 = new MoneyToStr();
        double n1 = 22222222220.11;
        double n2 = 22222222220.11;
        System.out.println(test3.toMoneyStr(n1 + n2));
    }
}