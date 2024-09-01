package com.desafio.pergunta5;

public class InverteString {
    public static void main(String[] args) {
        String frase = "Target Sistemas";
        String fraseInversa = "";
        for (int i = 0; i < frase.length(); i++){
            fraseInversa = frase.charAt(i) + fraseInversa;
        }
        System.out.println(fraseInversa);
    }
}
