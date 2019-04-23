package cresla.entities.containers.reactors;

public class HeatReactor extends Reactors {
    private int heatReductionIndex;


    public HeatReactor(int id, int addPar, int capacity) {
        super(id, capacity);
        this.heatReductionIndex = addPar;
    }

    @Override
    public long getTotalHeatAbsorbing() {
        return super.getTotalHeatAbsorbing() + heatReductionIndex;
    }


}

