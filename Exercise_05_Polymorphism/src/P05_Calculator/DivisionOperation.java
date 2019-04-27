package P05_Calculator;

import java.util.ArrayList;
import java.util.List;

public class DivisionOperation implements Operation {
    private int result;
    private List<Integer> operands;

    public DivisionOperation() {
        this.result = 0;
        this.operands = new ArrayList<>();
    }

    @Override
    public void addOperand(int operand) {
        this.operands.add(operand);
        if (this.isCompleted()) {
            this.result = this.operands.get(0) / this.operands.get(1);
        }
    }

    @Override
    public int getResult() {
        return this.result;
    }

    @Override
    public boolean isCompleted() {
        return this.operands.size() == 2;
    }
}
