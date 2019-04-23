package cresla.entities.containers.reactors;

import cresla.interfaces.Reactor;

public class CryoReactor extends Reactors {
    private int cryoProductionIndex;


    public CryoReactor(int id, int addPar, int capacity) {
        super(id, capacity);
        this.cryoProductionIndex = addPar;

    }

    @Override
    public long getTotalEnergyOutput() {
        return super.getTotalEnergyOutput() * cryoProductionIndex ;
    }
}
