package cresla.entities.containers.modules;

import cresla.interfaces.AbsorbingModule;

abstract class AbsorbingModuleImpl extends Modules implements AbsorbingModule {
    private int heatAbsorbing;

    AbsorbingModuleImpl(int id, int heatAbsorbing) {
        super(id);
        this.heatAbsorbing = heatAbsorbing;
    }

    @Override
    public int getHeatAbsorbing() {
        return this.heatAbsorbing;
    }

    @Override
    public String toString() {
        return super.toString() + String.format("Heat Absorbing: %d", this.getHeatAbsorbing());
    }
}
