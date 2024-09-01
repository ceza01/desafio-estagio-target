package com.desafio.pergunta2;

import java.util.ArrayList;
import java.util.List;

public class Fibonacci {
    public static void main(String[] args) {
        boolean estaPresente = presenteFibo(610);
        System.out.println(estaPresente);
    }

    public static boolean presenteFibo(int num) {
        List<Integer> fibo = new ArrayList<>();
        fibo.add(0);
        fibo.add(1);

        if (num == 0 || num == 1) return true;

        while (true) {
            int nextNum = fibo.get(fibo.size() - 1) + fibo.get(fibo.size() - 2);
            if (nextNum == num) return true;
            if (nextNum > num) return false;
            fibo.add(nextNum);
//            System.out.println(fibo);
        }
    }
}