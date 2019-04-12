package fakes;

import rplg_lab.Axe;
import rplg_lab.Target;

import static rpg_tests.util.Constants.XP_POINTS;

public class FakeTarget implements Target {
    public int getHealth() {
        return 0;
    }

    public void takeAttack(int attackPoints) {

    }

    public int giveExperience() {
        return XP_POINTS;
    }

    public boolean isDead() {
        return true;
    }

    public Axe getLoot() {
        return null;
    }
}
