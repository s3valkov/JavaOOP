package entities;

import core.interfaces.MachineFactory;
import core.interfaces.PilotFactory;
import core.interfaces.MachinesManager;

import entities.interfaces.Fighter;
import entities.interfaces.Machine;
import entities.interfaces.Pilot;
import entities.interfaces.Tank;

import java.util.HashMap;
import java.util.Map;

public class MachinesManagerImpl implements MachinesManager {
    private PilotFactory pilotFactory;
    private MachineFactory machineFactory;
    private Map<String, Pilot> pilots;
    private Map<String, Machine> machines;
    private Map<String, Machine> machinesWith;


    public MachinesManagerImpl(PilotFactory pilotFactory, MachineFactory machineFactory, Map<String, Pilot> pilots, Map<String, Machine> machines) {
        this.pilotFactory = pilotFactory;
        this.machineFactory = machineFactory;
        this.pilots = pilots;
        this.machines = machines;
        this.machinesWith = new HashMap<>();

    }


    @Override
    public String hirePilot(String name) {

        if (pilots.containsKey(name)) {
            return String.format("Pilot %s is hired already", name);
        }

        Pilot pilot = new PilotImpl(name);
        pilotFactory.createPilot(name);
        pilots.put(name, pilot);
        return "Pilot " + name + " hired";
    }

    @Override
    public String manufactureTank(String name, double attackPoints, double defensePoints) {
        if (machines.containsKey(name)) {
            return String.format("Machine %s is manufactured already", name);
        }

        Machine machine = new TankImpl(name, attackPoints, defensePoints);
        machines.put(name, machine);
        machineFactory.createTank(name, attackPoints, defensePoints);
        return String.format("Tank %s manufactured - attack: %.2f; defense: %.2f", name, attackPoints, defensePoints);
    }

    @Override
    public String manufactureFighter(String name, double attackPoints, double defensePoints) {
        if (machines.containsKey(name)) {
            return String.format("Machine %s is manufactured already", name);
        }
        Machine machine = new FighterImpl(name, attackPoints, defensePoints);
        machines.put(name, machine);
        machineFactory.createFighter(name, attackPoints, defensePoints);
        return String.format("Fighter %s manufactured - attack: %.2f; defense: %.2f", name, attackPoints, defensePoints);
    }

    @Override
    public String engageMachine(String selectedPilotName, String selectedMachineName) {
        String msg = "";

        if (pilots.containsKey(selectedPilotName) && machines.containsKey(selectedMachineName) && !machinesWith.containsKey(selectedMachineName)) {
            machinesWith.put(selectedMachineName, machines.get(selectedMachineName));
            pilots.get(selectedPilotName).addMachine(machines.get(selectedMachineName));
            msg = String.format("Pilot %s engaged machine %s", selectedPilotName, selectedMachineName);
        } else if (!pilots.containsKey(selectedPilotName)) {
            msg = String.format("Pilot %s could not be found", selectedPilotName);
        } else if (!machines.containsKey(selectedMachineName)) {
            msg = String.format("Machine %s could not be found", selectedMachineName);
        } else {
            msg = String.format("Machine %s is already occupied", selectedMachineName);
        }


        return msg;
    }

    @Override
    public String attackMachines(String attackingMachineName, String defendingMachineName) {
        String msg = "";
        double result = 0;
        if (machines.containsKey(attackingMachineName) && machines.containsKey(defendingMachineName)) {
            if (machines.get(defendingMachineName).getHealthPoints() > machines.get(attackingMachineName).getAttackPoints()) {
                result = machines.get(defendingMachineName).getHealthPoints() - machines.get(attackingMachineName).getAttackPoints();
            }

            msg = String.format("Machine %s was attacked by machine %s - current health: %.2f", defendingMachineName
                    , attackingMachineName
                    , result);
        } else if (!machines.containsKey(defendingMachineName)) {
            msg = String.format("Machine %s could not be found", defendingMachineName);
        } else {
            msg = String.format("Machine %s could not be found", attackingMachineName);
        }

        return msg;
    }

    @Override
    public String pilotReport(String pilotName) {

        return pilots.get(pilotName).report();
    }

    @Override
    public String toggleFighterAggressiveMode(String fighterName) {

        return String.format("Fighter %s toggled aggressive mode", fighterName);
    }

    @Override
    public String toggleTankDefenseMode(String tankName) {

        return String.format("Tank %s toggled aggressive mode", tankName);

    }
}
