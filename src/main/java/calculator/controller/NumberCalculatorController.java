package calculator.controller;

import calculator.domain.expression.ExpressionFactory;
import calculator.domain.number.Number;

import java.io.*;

public class NumberCalculatorController {

    static boolean isServiceDone = false;
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) {
        while (!isServiceDone) {
            serveCalculator();
        }
    }

    private static void serveCalculator() {
        try {
            writer.write("계산하고자 하는 식을 입력하세요: ");
            writer.flush();

            String givenInput = reader.readLine();

            if (givenInput.isEmpty()) {
                isServiceDone = true;
                return;
            }

            Number result = ExpressionFactory.from(givenInput).compute();
            String resultString = Integer.toString(result.getValue());

            writer.write("계산 결과: " + resultString);
            writer.newLine();
            writer.flush();

        } catch (IOException e) {
            isServiceDone = true;
        }
    }
}
