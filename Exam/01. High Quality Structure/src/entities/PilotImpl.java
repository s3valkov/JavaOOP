package entities;

import entities.interfaces.Machine;
import entities.interfaces.Pilot;

import java.util.ArrayList;
import java.util.List;

public class PilotImpl implements Pilot {
    private String name;
    private List<Machine> machines;

    public PilotImpl(String name) {
        this.setName(name);
        machines = new ArrayList<>();
    }


    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void addMachine(Machine machine) {
        if (machine == null) {
            throw new NullPointerException("Null machine cannot be added to the pilot.");
        }
        machines.add(machine);
    }

    @Override
    public List<Machine> getMachines() {
        return machines;
    }

    @Override
    public String report() {

        StringBuilder sb = new StringBuilder();
        sb.append(this.name).append(" - ").append(getMachines().size()).append(" machines").append("\n");

        for (Machine machine : machines) {
            sb.append("- ").append(machine.getName()).append("\n");
            sb.append(machine).append("\n");
        }

        return sb.toString();
    }

    public void setName(String name) {
        if (name.equals(" ") || name.equals("")) {
            throw new IllegalArgumentException(" Pilot name cannot be null or empty string.");
        }

        this.name = name;
    }


}
