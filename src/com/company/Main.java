package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        //총 몇개의 숫자를 입력 받을 것인지
        int count = 0;
        int input = 0;
        count = sc.nextInt();

        if (count > 0) {

            Stack<Integer> stack = new Stack<>();
            Queue<Integer> su = new LinkedList<>();
            Queue<Character> pushpop = new LinkedList<>();

            for(int i = 0 ; i < count ; i++) {
                su.offer(sc.nextInt());
            }

            int nowpush = 1;

            while (!su.isEmpty()) {
                int now = su.poll();

                while (stack.isEmpty() || (!stack.isEmpty() && stack.peek() < now)) {
                    stack.push(nowpush);
                    pushpop.offer('+');
                    nowpush = nowpush +1;
                }

                if (!stack.isEmpty() && stack.peek() == now) {
                    stack.pop();
                    pushpop.offer('-');
                }else {
                    System.out.println("NO");
                    return;
                }
            }

            while (!pushpop.isEmpty()){
                System.out.println(pushpop.poll());
            }

        }else {
            System.out.println("NO");
        }
    }
}
