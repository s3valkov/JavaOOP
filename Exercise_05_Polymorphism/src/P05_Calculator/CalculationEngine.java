package P05_Calculator;

public class CalculationEngine {
    private int result;
    private Operation currentOperation;
    private MemoryRecaller recaller;

    public CalculationEngine(){
        this.result = 0;
        this.currentOperation = null;
        this.recaller = new MemoryRecaller();
    }

   public void pushNumber(int number) {
        if (this.currentOperation != null) {
            currentOperation.addOperand(number);

            if (currentOperation.isCompleted()) {
                this.result = currentOperation.getResult();
                this.currentOperation = null;
            }
        } else {
            this.result = number;
        }
    }

    void pushOperation(Operation operation) {
//        if(operation == null){
//            return;
//        }

        if (operation instanceof Memory){
            this.recaller.addOperand(this.result);
            return;
        }

        if (operation instanceof MemoryRecaller){
            this.pushNumber(this.recaller.getResult());
        }

        if (operation.isCompleted()) {
            this.pushNumber(operation.getResult());
        } else {
            this.currentOperation = operation;
            this.pushNumber(this.result);
        }
    }

    int getCurrentResult() {
        return this.result;
    }
}
