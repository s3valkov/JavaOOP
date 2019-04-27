package entities;

import entities.interfaces.Fighter;

public class FighterImpl extends BaseMachine implements Fighter {
    private boolean aggressiveMode;
    private static final double attackPointsModifier = 50.0;
    private static final double deffencePointsModifier = 25.0;


    public FighterImpl(String name, double attackPoints, double defensePoints) {
        super(name, attackPoints, defensePoints, 100);
        this.aggressiveMode = true;
    }

    @Override
    public boolean getAggressiveMode() {
        return aggressiveMode;
    }

    @Override
    public void toggleAggressiveMode() {
        aggressiveMode = !aggressiveMode;
    }

    @Override
    public String toString() {
        String aggMode = "";
        if (aggressiveMode) {
            aggMode = "ON";
        } else {
            aggMode = "OFF";
        }

        String targets = "";
        if (getTargets() == null) {
            targets = "None";
        } else {
            targets = String.join(", ", getTargets());
        }
        return String.format("*Type: Fighter \n" +
                " *Health: %.2f\n" +
                " *Attack: %.2f\n" +
                " *Defense: %.2f\n" +
                " *Targets: %s\n" +
                " *Aggressive Mode(%s)", this.getAttackPoints(), this.getDefensePoints(), this.getTargets(),aggMode);
    }
}

