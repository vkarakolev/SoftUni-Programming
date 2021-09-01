package rpg_lab;

import org.junit.Test;

import static org.junit.Assert.*;

public class AxeTest {

    @Test
    public void testAxeLosesDurabilityAfterEachAttack() {
        Axe axe = new Axe(10, 10);
        Dummy dummy = new Dummy(100, 100);

        axe.attack(dummy);

        assertEquals(9, axe.getDurabilityPoints());
    }

    @Test (expected = IllegalStateException.class)
    public void testAttackWithBrokenWeapon() {
        Axe axe = new Axe(10, 0);
        axe.attack(new Dummy(100, 100));
    }
}