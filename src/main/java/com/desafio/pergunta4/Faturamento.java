package com.desafio.pergunta4;

public class Faturamento {
    private static final int FATURAMENTO_TOTAL = 18075998;
    private static final int VALOR_SP = 6783643;
    private static final int VALOR_RJ = 3667866;
    private static final int VALOR_MG = 2922988;
    private static final int VALOR_ES = 2716548;
    private static final int VALOR_OUTROS = 1984953;

    public static void main(String[] args) {
        System.out.printf("%.2f%%\n",calcularPorcentagem(VALOR_SP));
        System.out.printf("%.2f%%\n",calcularPorcentagem(VALOR_RJ));
        System.out.printf("%.2f%%\n",calcularPorcentagem(VALOR_MG));
        System.out.printf("%.2f%%\n",calcularPorcentagem(VALOR_ES));
        System.out.printf("%.2f%%\n",calcularPorcentagem(VALOR_OUTROS));
    }
    public static double calcularPorcentagem(int valor){
        double porcentagem = valor * 100 / (double)FATURAMENTO_TOTAL;
        return porcentagem;
    }
}