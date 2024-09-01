package com.desafio.pergunta3;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FaturamentoDiario {
    public static void main(String[] args) {
        String jsonFile = "src/main/resources/faturamento.json";

        try {
            String json = lerArquivo(jsonFile);
            JSONArray faturamentoArray = new JSONArray(json);
            List<Double> faturamentos = new ArrayList<>();
            double menorFaturamento = Double.MAX_VALUE;
            double maiorFaturamento = Double.MIN_VALUE;
            double somaFaturamentos = 0;
            int diasComFaturamento = 0;

            for (int i = 0; i < faturamentoArray.length(); i++) {
                JSONObject entry = faturamentoArray.getJSONObject(i);
                double faturamento = entry.getDouble("faturamento-diario");

                if (faturamento > 0) {
                    faturamentos.add(faturamento);
                    if (faturamento < menorFaturamento) {
                        menorFaturamento = faturamento;
                    }
                    if (faturamento > maiorFaturamento) {
                        maiorFaturamento = faturamento;
                    }
                    somaFaturamentos += faturamento;
                    diasComFaturamento++;
                }
            }
            double mediaMensal = somaFaturamentos / diasComFaturamento;
            int diasAcimaMedia = 0;
            for (double faturamento : faturamentos) {
                if (faturamento > mediaMensal) {
                    diasAcimaMedia++;
                }
            }

            System.out.printf("Menor valor de faturamento: %.2f%n", menorFaturamento);
            System.out.printf("Maior valor de faturamento: %.2f%n", maiorFaturamento);
            System.out.printf("Número de dias com faturamento acima da média: %d%n", diasAcimaMedia);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static String lerArquivo(String arquivo) throws IOException {
        File file = new File(arquivo);
        StringBuilder stringBuilder = new StringBuilder();
        try (Scanner scanner = new Scanner(new FileReader(file))) {
            while (scanner.hasNextLine()) {
                stringBuilder.append(scanner.nextLine());
            }
        }
        return stringBuilder.toString();
    }
}
