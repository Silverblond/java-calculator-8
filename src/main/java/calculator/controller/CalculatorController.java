package calculator.controller;

import calculator.domain.StringCalculator;
import calculator.view.InputView;
import calculator.view.OutputView;

public class CalculatorController {
    private final InputView inputView;
    private final OutputView outputView;
    private final StringCalculator stringCalculator;

    public CalculatorController(InputView inputView, OutputView outputView, StringCalculator stringCalculator) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.stringCalculator = stringCalculator;
    }

    public void run() {
        String input = inputView.getInput();
        int result = stringCalculator.calculateString(input);
        outputView.printResult(result);
    }
}
