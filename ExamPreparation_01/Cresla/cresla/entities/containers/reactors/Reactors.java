package cresla.entities.containers.reactors;

import cresla.entities.containers.ModuleContainer;
import cresla.interfaces.AbsorbingModule;
import cresla.interfaces.EnergyModule;
import cresla.interfaces.Reactor;

abstract class Reactors implements Reactor {
    private int id;
    private int capacity;
    private ModuleContainer container;

    Reactors(int id, int capacity) {
        this.id = id;
        this.capacity = capacity;
        this.container = new ModuleContainer(this.capacity);
    }

    @Override
    public long getTotalEnergyOutput() {

        return container.getTotalEnergyOutput();
    }

    @Override
    public long getTotalHeatAbsorbing() {
        return container.getTotalHeatAbsorbing();
    }

    @Override
    public int getModuleCount() {
        return container.getModuleByInputCount();
    }

    @Override
    public void addEnergyModule(EnergyModule energyModule) {
        container.addEnergyModule(energyModule);
    }

    @Override
    public void addAbsorbingModule(AbsorbingModule absorbingModule) {
        container.addAbsorbingModule(absorbingModule);
    }

    @Override
    public int getId() {
        return this.id;
    }

    @Override
    public String toString() {
        return String.format("%s - %d\nEnergy Output: %d\nHeat Absorbing: %d\nModules:%d"
                , this.getClass().getSimpleName()
                , this.getId()
                , this.getTotalEnergyOutput()
                , this.getTotalHeatAbsorbing()
                , this.getModuleCount());
    }
}
