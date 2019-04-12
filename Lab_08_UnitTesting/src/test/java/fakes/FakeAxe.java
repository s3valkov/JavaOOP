package fakes;

import rplg_lab.Axe;
import rplg_lab.AxeImpl;
import rplg_lab.DummyImpl;
import rplg_lab.Target;

import static rpg_tests.util.Constants.ATTACK_POINTS;

public class FakeAxe implements Axe {


    public void attack(DummyImpl target) {
        ///...
    }

    public void attack(Target target) {

    }

    public int getAttackPoints() {
        return ATTACK_POINTS;
    }

    public int getDurabilityPoints() {
        return 0;
    }
}
