package LQdemo;

import java.util.*;

public class testtemp {
    public int[] divingBoard(int shorter, int longer, int k) {
        if (k == 0) {
            return new int[0];
        }
        if (shorter == longer) {
            return new int[]{k * shorter};
        }
        int[] length = new int[k + 1];
        for (int i = 0; i <= k; i++) {
            length[i] = longer * i + shorter * (k - i);
        }
        return length;

    }

    public int validSubarrays(int[] nums) {
        Stack stack = new Stack();
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            stack.clear();
            stack.push(nums[i]);

            count++;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] <= nums[j]) {
                    stack.push(nums[j]);
                    count++;
                } else {
                    break;
                }
            }
        }
        return count;
    }

    public int trap(int[] height) {
        Stack<Integer> stack = new Stack();
        int num = 0;
        int sum = 0;
        while (num < height.length) {
            stack.clear();
            int first = height[num];
            int firstIndex = num;

            int addnum = height[num];
            stack.push(height[num++]);

            while (num < height.length) {
                if (height[num] <= stack.peek()) {
                    addnum += height[num];
                    stack.push(height[num++]);
                } else {

                    break;
                }


            }
            num--;
            int tallmin = Math.min(first, height[num]);
            sum = sum + tallmin * (num - firstIndex - 1) - addnum;

        }
        return sum;

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int count = 0;
        int len = s.length();
        int half = 0;
        if (len % 2 == 1) {
            half = len / 2 + 1;
        } else {
            half = len / 2;
        }
        char[] arr = new char[len];
        for (int i = 0; i < half; i++) {
            arr[count++] = s.charAt(i);

        }
        for (int j = half - 2; j >= 0; j--) {
            arr[count++] = arr[j];
        }


        char[] arrB = new char[len];
        int countB = 0;
        for (int i = len; i >= half; i--) {
            arrB[countB++] = (s.charAt(i - 1));

        }
        for (int j = half - 2; j >= 0; j--) {
            arrB[countB++] = arrB[j];
        }

        int disA = Math.abs(Integer.parseInt(String.valueOf(arr)) - Integer.parseInt(s));
        int disB = Math.abs(Integer.parseInt(String.valueOf(arrB)) - Integer.parseInt(s));
        if (disA < disB) {
            System.out.println(Integer.parseInt(String.valueOf(arr)));
        }
        if (disA > disB) {
            System.out.println(Integer.parseInt(String.valueOf(arrB)));
        }
        if (disA == disB) {
            if (Integer.parseInt(String.valueOf(arr)) < Integer.parseInt(String.valueOf(arrB))) {
                System.out.println(Integer.parseInt(String.valueOf(arr)));
                System.out.println(Integer.parseInt(String.valueOf(arrB)));
            } else if (Integer.parseInt(String.valueOf(arr)) > Integer.parseInt(String.valueOf(arrB))) {
                System.out.println(Integer.parseInt(String.valueOf(arrB)));
                System.out.println(Integer.parseInt(String.valueOf(arr)));
            } else {
                System.out.println("error");
            }

        }
    }
}


//       testtemp testtemp=new testtemp();
//        int[] nums=new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
//        System.out.println(testtemp.trap(nums));

//        Random random = new Random();
//        Boolean[] bool=new Boolean[]{false,false,false};
//        List list=new ArrayList();
//        int num;
//        for (int i = 0; i < 3; i++) {
//            do {
//                // 如果产生的数bai相同继续循环
//                num = random.nextInt(122-97+1)+97;
//            } while (bool[i]);
//            bool[i] = true;
//            list.add((char)num);
//        }
//        System.out.println(list);

