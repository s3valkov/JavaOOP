package rplg_lab;

import java.util.ArrayList;
import java.util.List;

public class DummyImpl implements Target {

    private int health;
    private int experience;
    private List<Axe> possibleLoot;

    public DummyImpl(int health, int experience) {
        this.health = health;
        this.experience = experience;
        this.possibleLoot = new ArrayList<Axe>();
    }


    public Axe getLoot() {
        return this.possibleLoot.get(0);
    }

    public int getHealth() {
        return this.health;
    }

    public void takeAttack(int attackPoints) {
        if (this.isDead()) {
            throw new IllegalStateException("DummyImpl is dead.");
        }

        this.health -= attackPoints;
    }

    public int giveExperience() {
        if (!this.isDead()) {
            throw new IllegalStateException("Target is not dead.");
        }

        return this.experience;
    }

    public boolean isDead() {
        return this.health <= 0;
    }
}