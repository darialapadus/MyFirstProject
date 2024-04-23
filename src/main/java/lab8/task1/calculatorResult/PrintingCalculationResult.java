package lab8.task1.calculatorResult;

import lab8.task1.CalculationRequest;
import lab8.task1.DatabaseManager;

public class PrintingCalculationResult implements CalculationResult {

    private final CalculationResult calculationResult;

    public PrintingCalculationResult(CalculationResult calculationResult) {
        this.calculationResult = calculationResult;
    }

    @Override
    public Object computeResult() {
        Object result = calculationResult.computeResult();
        CalculationRequest request = calculationResult.getRequest();
        String requestType = request.getRequestType().toString(); // Convertim tipul cererii în șir de caractere
        DatabaseManager.saveCalculationResult(requestType, request.getLeftOperand().toString(), request.getRightOperand().toString(), request.getOperation(), result.toString());
        System.out.println("Operation " + request + " has result " + result);
        return result;
    }

    @Override
    public CalculationRequest getRequest() {
        return calculationResult.getRequest();
    }
}
