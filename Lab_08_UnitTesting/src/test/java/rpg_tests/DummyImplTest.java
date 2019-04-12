
package rpg_tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import rplg_lab.AxeImpl;
import rplg_lab.DummyImpl;

import static rpg_tests.util.Constants.*;
import static rpg_tests.util.Constants.XP_POINTS;

public class DummyImplTest {
    private AxeImpl axeImpl;
    private DummyImpl dummyImpl;

    @Before
    public void initializeTestObjects() {
        this.axeImpl = new AxeImpl(ATTACK_POINTS - 1, DURRABILITY);
        this.dummyImpl = new DummyImpl(HEALTH_POINTS, XP_POINTS);
    }


    @Test
    public void dummyShouldLoseHealthIfAttacked() {
        int currentDummyHealth = dummyImpl.getHealth();
        dummyImpl.takeAttack(axeImpl.getAttackPoints());
        Assert.assertEquals(currentDummyHealth - axeImpl.getAttackPoints(), dummyImpl.getHealth());
    }

    @Test(expected = IllegalStateException.class)
    public void dummyShouldThrowExceptionIfDead() {
        DummyImpl dummyImpl = new DummyImpl(-HEALTH_POINTS, XP_POINTS);
        dummyImpl.takeAttack(axeImpl.getAttackPoints());
    }

    @Test
    public void deadDummyShouldGiveXP() {
        DummyImpl dummyImpl = new DummyImpl(-HEALTH_POINTS, XP_POINTS);
        int actual = dummyImpl.giveExperience();
        Assert.assertEquals(10, actual);
    }

    @Test(expected = IllegalStateException.class)
    public void aliveDummyShouldNotGiveXP() {
        this.dummyImpl.giveExperience();
    }
}
