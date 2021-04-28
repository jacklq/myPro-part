package LQdemo.algorithms;

import java.util.*;

/*链接：https://www.nowcoder.com/questionTerminal/e605ba77112b425889bee3f40481fe93?orderByHotValue=1&page=1&onlyReference=false
来源：牛客网

找出几个候选答案然后比较差值（最多为4个）

长度为1，#长度为1，直接减一返回
开头为1，9~~9为一个候选答案 例：100001，答案为99999
开头为9，10~~01为一个候选答案 例：99999，答案为100001
如果本身对称，则把最中间的一个（或两个）位数减（如果0则加）一
例：123321，答案为122221
例：120021，答案为121121
如果不对称：
-把前半部分逆序替换掉后半部分 例：1223，答案为1221

-把最中间的一个（或两个）位数加一 例：1291，答案为1331，而非1221
-把最中间的一个（或两个）位数减一 例：1800，答案为1771，而非1881
*/

/*
*/
public class CloseSymmetryNum {
    public String symmetryStr(String str){
        if(str.length()%2==0){/*偶数*/
            String forward=str.substring(0,str.length()/2);
            StringBuilder sb = new StringBuilder(forward);
            String back=sb.reverse().toString();
            return forward+back;
        }else{/*奇数*/
            String forward=str.substring(0,str.length()/2+1);
            StringBuilder sb = new StringBuilder(str.substring(0,str.length()/2));
            String back=sb.reverse().toString();
            return forward+back;
        }

    }
    public String symmetryByLeft(String str){/*获取字符串的逆串*/
            StringBuilder sb = new StringBuilder(str);
            String back=sb.reverse().toString();
            return back;

    }
    public Boolean isSymmetryStr(String str){
        StringBuilder sb = new StringBuilder(str);
        String revStr=sb.reverse().toString();
        if(revStr.equals(str)){
            return true;
        }else{
            return  false;
        }
    }


    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int input=sc.nextInt();
        String str=String.valueOf(input);
        if(str.length()==1){
            System.out.println(String.valueOf(Integer.parseInt(str)-1));
        }
        ArrayList<String> arrayList=new ArrayList();
        CloseSymmetryNum closeSymmetryNum=new CloseSymmetryNum();
        //开头为1，9~~9为一个候选答案 例：100001，答案为99999
        //开头为9，10~~01为一个候选答案 例：99999，答案为100001
        if(str.charAt(0)=='1'){
            arrayList.add(obeNum(str.length()-1,"9"));
        }else if (str.charAt(0)=='9'){
            arrayList.add(obeNum(str.length()-1,"1"));
        }

        //如果本身对称，则把最中间的一个（或两个）位数减（如果0则加）一
        if(closeSymmetryNum.isSymmetryStr(str)){/*是对称*/
            String mid=String.valueOf(str.charAt(str.length()/2-1));
            if(mid.compareTo("0")>0){/*大于0则减1*/
                leftsub1(str, arrayList, closeSymmetryNum);
            }else{/*等于0则加1*/
                leftAdd1(str, arrayList, closeSymmetryNum);
            }

        }else{/*是不对称*/
            //如果不对称：
            //-把前半部分逆序替换掉后半部分 例：1223，答案为1221
            //
            //-把最中间的一个（或两个）位数加一 例：1291，答案为1331，而非1221
            //-把最中间的一个（或两个）位数减一 例：1800，答案为1771，而非1881
            String temp=closeSymmetryNum.symmetryStr(str);//把前半部分逆序替换掉后半部分
            arrayList.add(temp);
            leftsub1(str, arrayList, closeSymmetryNum);
            leftAdd1(str, arrayList, closeSymmetryNum);
        }
        int min=Integer.MAX_VALUE;
        String result="";
        for (int i = 0; i < arrayList.size(); i++) {
            int cha=Math.abs(Integer.parseInt(arrayList.get(i))-Integer.parseInt(str));
            if(cha<min){
                min=cha;
                result=arrayList.get(i);
            }
        }

        System.out.println( result);

    }
//开头为1，9~~9为一个候选答案 例：100001，答案为99999
//开头为9，10~~01为一个候选答案 例：99999，答案为100001
    public static String obeNum(int loop,String num) {
        String temp="";
        if(num.equals("9")){//例：100001，答案为99999
            for (int i = 0; i <loop ; i++) {
                temp+=num;
            }

        }else if(num.equals("1")){//99999，答案为100001
            temp+=num;
            for (int i = 0; i <loop ; i++) {
                temp+="0";
            }
            temp+=num;
        }
        return temp;
    }
    //左半部分加一
    public static void leftAdd1(String str, ArrayList arrayList, CloseSymmetryNum closeSymmetryNum) {
        String left=str.substring(0,(str.length()+1)/2);
        int leftNum=Integer.parseInt(left);
        String leftNumStr=String.valueOf(leftNum+1);
        String newStr=leftNumStr+str.substring((str.length()+1)/2);
        String temp=closeSymmetryNum.symmetryStr((newStr));
        arrayList.add(temp);
    }
    //左半部分減一
    public static void leftsub1(String str, ArrayList arrayList, CloseSymmetryNum closeSymmetryNum) {
        String left=str.substring(0,(str.length()+1)/2);
        int leftNum=Integer.parseInt(left);
        String leftNumStr=String.valueOf(leftNum-1);
        String newStr=leftNumStr+str.substring((str.length()+1)/2);
        String temp=closeSymmetryNum.symmetryStr((newStr));
        arrayList.add(temp);
    }

}
