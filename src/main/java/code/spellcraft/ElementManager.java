package code.spellcraft;

import code.spellcraft.UI.ElementsPanel;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;

public class ElementManager {

    private final UnorderedArrayList<Elements> elements = new UnorderedArrayList<>();
    private final ElementsPanel panel = new ElementsPanel();

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
        elements.add(e);
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
}
