package lab8.task1.calculatorResult;

import lab8.task1.CalculationRequest;

public abstract class AbstractCalculationResult implements CalculationResult {
    private final CalculationRequest request;

    public AbstractCalculationResult(CalculationRequest request) {
        this.request = request;
    }

    @Override
    public CalculationRequest getRequest() {
        return request;
    }
}
