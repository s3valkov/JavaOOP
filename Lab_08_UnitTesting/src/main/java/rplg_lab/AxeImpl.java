package rplg_lab;

public class AxeImpl implements Axe {

    private int attackPoints;
    private int durabilityPoints;

    public AxeImpl(int attack, int durability) {
        this.attackPoints = attack;
        this.durabilityPoints = durability;
    }


    public void attack(Target target) {
        if (this.durabilityPoints <= 0) {
            throw new IllegalStateException("AxeImpl is broken.");
        }

        target.takeAttack(this.attackPoints);
        this.durabilityPoints -= 1;
    }

    public int getAttackPoints() {
        return this.attackPoints;
    }

    public int getDurabilityPoints() {
        return this.durabilityPoints;
    }
}
