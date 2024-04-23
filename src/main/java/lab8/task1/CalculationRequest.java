package lab8.task1;

public class CalculationRequest {
    private final Object leftOperand;
    private final Object rightOperand;
    private final String operation;

    public CalculationRequest(Object leftOperand, Object rightOperand, String operation) {
        this.leftOperand = leftOperand;
        this.rightOperand = rightOperand;
        this.operation = operation;
    }


    public RequestType getRequestType() {

        if (this.leftOperand instanceof Boolean) {
            return RequestType.Boolean;
        } else if (this.leftOperand instanceof Integer) {
            return this.rightOperand instanceof Integer ? RequestType.Integer : RequestType.Double;
        } else if (this.leftOperand instanceof Double) {
            return RequestType.Double;
        }

        return RequestType.Undefined;
    }

    @Override
    public String toString() {
        return leftOperand + " " + operation + " " + rightOperand;
    }

    public Object getLeftOperand() {
        return leftOperand;
    }

    public Object getRightOperand() {
        return rightOperand;
    }

    public String getOperation() {
        return operation;
    }

    public enum RequestType {
        Undefined,
        Integer,
        Double,
        Boolean
    }
}
