package worldofzuul.items;

import java.awt.Graphics;
import worldofzuul.People.Player;
import worldofzuul.interfaces.IConsumable;

/**
 *
 * @author Jonas Bjørstorp & Frederik Bauer & Rasmus Willer
 */
public class EnergyDrink extends Item implements IConsumable {

    private final int ENERGY_RESTORE = 40;

    public EnergyDrink(float x,
                       float y,
                       int width,
                       int height) {
        super(x,
                y,
                width,
                height,
                "Energy drink",
                "A can of Monster. Yum!",
                10);
    }
    
    @Override
    public void consume(Player  p) {
        p.setEnergy(ENERGY_RESTORE + p.getEnergy());
    }
    
    @Override
    public void use(Player p) {
        consume(p);
    }
    
    // GAME LOOP METHODS
    
    @Override
    public void tick() {
    }

    @Override
    public void render(Graphics g) {
    }

}
