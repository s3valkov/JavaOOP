package rpg_tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import rplg_lab.AxeImpl;
import rplg_lab.DummyImpl;

import static rpg_tests.util.Constants.*;


public class AxeImplTest {
    private AxeImpl axeImpl;
    private DummyImpl dummyImpl;

    @Before
    public void initializeTestObjects() {
        this.axeImpl = new AxeImpl(ATTACK_POINTS, DURRABILITY);
        this.dummyImpl = new DummyImpl(HEALTH_POINTS, XP_POINTS);
    }

    @Test
    public void weaponShouldLoseDurabilityAfterAttack() {
        this.axeImpl.attack(dummyImpl);
        Assert.assertEquals("Wrong result!", DURRABILITY - 1, axeImpl.getDurabilityPoints());

    }

    @Test(expected = IllegalStateException.class)
    public void brokenAxeShouldNotAttack() {
        AxeImpl axeImpl = new AxeImpl(ATTACK_POINTS, -DURRABILITY);
        axeImpl.attack(dummyImpl);
    }
}
