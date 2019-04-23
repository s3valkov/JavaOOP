package cresla.entities.containers.modules;

import cresla.interfaces.Module;

abstract class Modules implements Module {
    private int id;

    Modules(int id) {
        this.id = id;
    }

    @Override
    public int getId() {
        return this.id;
    }

    @Override
    public String toString() {
        return String.format("%s Module - %d\n",
                this.getClass().getSimpleName()
                , this.getId());
    }
}
