package code.spellcraft;

import basemod.BaseMod;
import code.cards.spells.Wildfire;
import code.spellcraft.UI.ElementsPanel;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.colorless.Madness;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;

import java.util.ArrayList;

public class ElementManager {

    private final UnorderedArrayList<Elements> elements = new UnorderedArrayList<>();
    private final ElementsPanel panel = new ElementsPanel();
    private int wisps = 0;

    public boolean hasElement(Elements e) {
        return elements.contains(e);
    }

    public Elements getElement(int index) {
        if (elements.size() > index) {
            return elements.get(index);
        } else {
            return Elements.NULL;
        }
    }

    protected void addElement(Elements e) {
        BaseMod.logger.info("Adding a circle: " + e.name());
        elements.add(e);
        panel.addCircle(e, elements.size()-1);
        if (elements.size() == 3) {
            AbstractDungeon.actionManager.addToBottom(new CreateSpellAction(elements));
        }
    }

    public void addElementAction(Elements e) {
        AbstractDungeon.actionManager.addToBottom(new AddElementAction(e, 1));
    }

    public void addElementAction(Elements e, int amount) {
        AbstractDungeon.actionManager.addToBottom(new AddElementAction(e, amount));
    }

    public void addElementActionTop(Elements e, int amount) {
        AbstractDungeon.actionManager.addToTop(new AddElementAction(e, amount));
    }

    protected void clearElements() {
        elements.clear();
        panel.setCircles();
    }

    public void addWisp() {
        wisps++;
        panel.addWisp(wisps);
    }

    public int getWisps() {
        return wisps;
    }

    protected void clearWisps() {
        wisps = 0;
    }

    protected AbstractCard getInvokation(ArrayList<Elements> elements) {
        String fire = "";
        String water = "";
        String earth = "";
        String air = "";
        for (Elements e : elements) {
            switch(e) {
                case FIRE:
                    fire += "F";
                    break;
                case WATER:
                    water += "W";
                    break;
                case EARTH:
                    earth += "E";
                    break;
                case AIR:
                    air += "A";
                    break;
                default:
            }
        }
        String key = fire + water + earth + air;
        switch (key) {
            case ("FFF") :
                return new Wildfire();
            case ("FFW") :
                return new Madness();
            case ("FFE") :
                return new Madness();
            case ("FFA") :
                return new Madness();
            case ("FWW") :
                return new Madness();
            case ("FWE") :
                return new Madness();
            case ("FWA") :
                return new Madness();
            case ("FEE") :
                return new Madness();
            case ("FEA") :
                return new Madness();
            case ("FAA") :
                return new Madness();
            case ("WWW") :
                return new Madness();
            case ("WWE") :
                return new Madness();
            case ("WWA") :
                return new Madness();
            case ("WEE") :
                return new Madness();
            case ("WEA") :
                return new Madness();
            case ("WAA") :
                return new Madness();
            case ("EEE") :
                return new Madness();
            case ("EEA") :
                return new Madness();
            case ("EAA") :
                return new Madness();
            case ("AAA") :
                return new Madness();
            default:
                BaseMod.logger.info("no spell for this combination of elements");
                return new Madness();
        }
    }


















    public void update() {
        panel.update();
    }

    public void render(SpriteBatch sb) {
        panel.render(sb);
    }

    public static enum Elements {
        FIRE,
        WATER,
        AIR,
        EARTH,
        NULL
    }

    private String elementKey(Elements e) {
        switch(e) {
            case FIRE:
                return "F";
            case WATER:
                return "W";
            case EARTH:
                return "E";
            case AIR:
                return "A";
            default:
                return "N";
        }
    }
}
