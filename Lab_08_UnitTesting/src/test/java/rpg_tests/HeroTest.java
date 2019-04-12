package rpg_tests;

import fakes.FakeAxe;
import fakes.FakeTarget;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import rplg_lab.*;

import static rpg_tests.util.Constants.XP_POINTS;

public class HeroTest {

    @Test
    public void shouldReceiveXpWhenTargetDies() {
        Hero hero = new Hero(new FakeAxe(), "name");
        Target target = new FakeTarget();

        hero.attack(target);
        Assert.assertEquals(hero.getExperience(), XP_POINTS);
    }

    @Test
    public void shouldGetLootAfterTargetKill() {
        Axe loot = new FakeAxe();

        Hero hero = new Hero(new FakeAxe(), "name");
        Target target = Mockito.mock(Target.class);
        Mockito.when(target.isDead()).thenReturn(true);
        Mockito.when(target.getLoot()).thenReturn(loot);

        hero.attack(target);

        Assert.assertEquals(loot, hero.getInventory().get(0));

    }

}
