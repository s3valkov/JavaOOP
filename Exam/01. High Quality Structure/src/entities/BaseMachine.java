package entities;

import entities.interfaces.Machine;
import entities.interfaces.Pilot;

import java.util.Collection;
import java.util.List;

abstract class BaseMachine implements Machine {
    private String name;
    private Pilot pilot;
    private double attackPoints;
    private double defensePoints;
    private double healthPoints;
    private List<String> targets;


    BaseMachine(String name, double attackPoints, double defensePoints, double healthPoints) {
        this.setName(name);
        this.attackPoints = attackPoints;
        this.defensePoints = defensePoints;
        this.healthPoints = healthPoints;
    }


    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String name) {
        if (name.equals("") || name.equals(" ")) {
            throw new IllegalArgumentException("Machine name cannot be null or empty.");
        }

        this.name = name;
    }

    @Override
    public Pilot getPilot() {
        return pilot;
    }

    @Override
    public void setPilot(Pilot pilot) {
        if (pilot == null) {
            throw new NullPointerException("Pilot cannot be null.");
        }
        this.pilot = pilot;
    }

    @Override
    public double getHealthPoints() {
        return this.healthPoints;
    }

    @Override
    public void setHealthPoints(double healthPoints) {

    }

    @Override
    public double getAttackPoints() {
        return this.attackPoints;
    }

    @Override
    public double getDefensePoints() {
        return this.defensePoints;
    }

    @Override
    public List<String> getTargets() {
        return targets;
    }

    @Override
    public void attack(String target) {
        if (target == null) {
            throw new IllegalArgumentException("Attack target cannot be null or empty string.");
        }

        targets.add(target);
    }

    @Override
    public String toString() {
        String targets = "";
        if (getTargets() == null) {
            targets = "None";
        } else {
            targets = String.join(", ", getTargets());
        }
        return String.format("*Type: %s \n" +
                " *Health: %.2f\n" +
                " *Attack: %.2f\n" +
                " *Defense: %.2f\n" +
                " *Targets: %s\n", this.getName(), this.getAttackPoints(), this.getDefensePoints(), this.getTargets());
    }
}
