package cresla.entities.containers.modules;


  abstract class EnergyModuleImpl extends Modules implements cresla.interfaces.EnergyModule {
   private int energyOutput;

     EnergyModuleImpl(int id, int energyOutput) {
        super(id);
        this.energyOutput = energyOutput;
    }

      @Override
      public int getEnergyOutput() {
          return this.energyOutput;
      }

      @Override
      public String toString() {
          return super.toString() + String.format("Energy Output: %d",this.getEnergyOutput());
      }
  }
