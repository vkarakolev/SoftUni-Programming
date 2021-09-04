package rpg_lab;

import org.junit.Before;
import org.junit.Test;
import rpg_lab.interfaces.Target;
import rpg_lab.interfaces.Weapon;

import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class HeroTest {

    private static final String HERO_NAME = "someHeroName";
    private static final int TARGET_XP = 100;

    Weapon weapon;
    Hero hero;
    Target target;

    @Before
    public void setUp() {
        this.weapon = mock(Weapon.class);
        this.hero = new Hero(HERO_NAME, weapon);
        this.target = mock(Target.class);
    }

    @Test
    public void testHeroGainsExperienceWhenKillTarget() {
        when(this.target.isDead()).thenReturn(true);
        when(this.target.giveExperience()).thenReturn(TARGET_XP);

        this.hero.attack(target);

        assertEquals(TARGET_XP, this.hero.getExperience());
    }

    @Test
    public void testWhenHeroKillsTargetInventoryAddNewLoot() {
        when(this.target.isDead()).thenReturn(true);
        when(this.target.getLoot()).thenReturn(new Axe(37, 43));

        this.hero.attack(this.target);

        List<Weapon> inventory = this.hero.getInventory();
        assertEquals(1, inventory.size());

        Weapon loot = inventory.get(0);
        assertEquals(37, loot.getAttackPoints());
        assertEquals(43, loot.getDurabilityPoints());
    }

}