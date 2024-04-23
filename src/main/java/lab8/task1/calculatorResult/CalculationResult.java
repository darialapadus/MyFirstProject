package lab8.task1.calculatorResult;

import lab8.task1.CalculationRequest;

public interface CalculationResult {
    Object computeResult();
    CalculationRequest getRequest();
}
