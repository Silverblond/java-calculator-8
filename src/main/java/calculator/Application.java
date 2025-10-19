package calculator;

import calculator.controller.CalculatorController;
import calculator.domain.StringCalculator;
import calculator.view.InputView;
import calculator.view.OutputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        StringCalculator stringCalculator = new StringCalculator();

        CalculatorController controller = new CalculatorController(inputView, outputView, stringCalculator);

        controller.run();
    }
}
