package entities;

import entities.interfaces.Tank;

public class TankImpl extends BaseMachine implements Tank {
    private boolean defenseMode;
    private static final double attackPointsModifier = 40.0;
    private static final double deffencePointsModifier = 30.0;


    public TankImpl(String name, double attackPoints, double defensePoints) {
        super(name, attackPoints, defensePoints, 200);
        this.defenseMode = true;
    }



    @Override
    public boolean getDefenseMode() {
        return defenseMode;
    }

    @Override
    public void toggleDefenseMode() {
        defenseMode = !defenseMode;
    }

}
