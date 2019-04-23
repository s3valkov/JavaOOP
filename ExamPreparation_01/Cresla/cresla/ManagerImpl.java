package cresla;

import cresla.entities.containers.ModuleContainer;
import cresla.entities.containers.modules.CooldownSystem;
import cresla.entities.containers.modules.CryogenRod;
import cresla.entities.containers.reactors.CryoReactor;
import cresla.entities.containers.reactors.HeatReactor;
import cresla.interfaces.AbsorbingModule;
import cresla.interfaces.EnergyModule;
import cresla.interfaces.Manager;
import cresla.interfaces.Reactor;

import java.util.*;

public class ManagerImpl implements Manager {
    private LinkedHashSet<Integer> idSetter;
    private HashMap<Integer, Reactor> reactors;
    private HashMap<Integer, AbsorbingModule> absModule;
    private HashMap<Integer, EnergyModule> energyModule;
    private ModuleContainer container;
    private int cryoCount;
    private int heatCount;
    private int energyCount;
    private int absorbingCount;

    public ManagerImpl() {
        this.idSetter = new LinkedHashSet<>();
        this.reactors = new HashMap<>();
        this.absModule = new HashMap<>();
        this.energyModule = new HashMap<>();
        this.cryoCount = 0;
        this.heatCount = 0;
        this.energyCount = 0;
        this.absorbingCount = 0;
    }

    @Override
    public String reactorCommand(List<String> arguments) {
        Reactor reactor = null;
        String result = "";
        switch (arguments.get(1)) {
            case "Cryo":
                reactor = new CryoReactor(idSetter.size() + 1, Integer.parseInt(arguments.get(2)), Integer.parseInt(arguments.get(3)));
                result = String.format("Created Cryo Reactor - %d", reactor.getId());
                cryoCount++;
                break;
            case "Heat":
                reactor = new HeatReactor(idSetter.size() + 1, Integer.parseInt(arguments.get(2)), Integer.parseInt(arguments.get(3)));
                result = String.format("Created Heat Reactor - %d", reactor.getId());
                heatCount++;
                break;
            default:
                break;
        }
        container = new ModuleContainer(Integer.parseInt(arguments.get(3)));
        idSetter.add(idSetter.size() + 1);
        reactors.put(reactor.getId(), reactor);
        return result;
    }

    @Override
    public String moduleCommand(List<String> arguments) {
        String result = "";
        Reactor currentReactor = reactors.get(Integer.parseInt(arguments.get(1)));

        switch (arguments.get(2)) {
            case "CryogenRod":
                EnergyModule module = new CryogenRod(idSetter.size() + 1, Integer.parseInt(arguments.get(3)));
                result = String.format("Added CryogenRod - %d to Reactor - %s", module.getId(), arguments.get(1));
                currentReactor.addEnergyModule(module);
                container.addEnergyModule(module);
                energyModule.put(module.getId(), module);
                energyCount++;
                break;
            case "CooldownSystem":
                AbsorbingModule module1 = new CooldownSystem(idSetter.size() + 1, Integer.parseInt(arguments.get(3)));
                result = String.format("Added CooldownSystem - %d to Reactor - %s", module1.getId(), arguments.get(1));
                currentReactor.addAbsorbingModule(module1);
                container.addAbsorbingModule(module1);
                absModule.put(module1.getId(), module1);
                absorbingCount++;
                break;
            case "HeatProcessor":
                AbsorbingModule module2 = new CooldownSystem(idSetter.size() + 1, Integer.parseInt(arguments.get(3)));
                result = String.format("Added HeatProcessor - %d to Reactor - %s", module2.getId(), arguments.get(1));
                container.addAbsorbingModule(module2);
                currentReactor.addAbsorbingModule(module2);
                absModule.put(module2.getId(), module2);
                absorbingCount++;
                break;
        }


        idSetter.add(idSetter.size() + 1);

        return result;
    }

    @Override
    public String reportCommand(List<String> arguments) {
        String result = "";
        if (reactors.containsKey(Integer.parseInt(arguments.get(1)))) {
            result = reactors.get(Integer.parseInt(arguments.get(1))).toString();
        } else {
            if (absModule.containsKey(Integer.parseInt(arguments.get(1)))) {
                result = absModule.get(Integer.parseInt(arguments.get(1))).toString();
            } else {
                result = energyModule.get(Integer.parseInt(arguments.get(1))).toString();
            }
        }

        return result;
    }

    @Override
    public String exitCommand(List<String> arguments) {

        StringBuilder builder = new StringBuilder();
        builder.append("Cryo Reactors").append(": ").append(cryoCount).append("\n");
        builder.append("Heat Reactors").append(": ").append(heatCount).append("\n");
        builder.append("Energy Modules").append(": ").append(energyCount).append("\n");
        builder.append("Absorbing Modules").append(": ").append(absorbingCount).append("\n");
        builder.append("Total Energy Output: ").append(container.getTotalEnergyOutput()).append("\n");
        builder.append("Total Heat Absorbing: ").append(container.getTotalHeatAbsorbing());

        return builder.toString();
    }
}
