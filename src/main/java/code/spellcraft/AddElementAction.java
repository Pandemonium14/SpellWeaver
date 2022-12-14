package code.spellcraft;

import code.SpellweaverMod;
import code.spellcraft.ElementManager;
import com.megacrit.cardcrawl.actions.AbstractGameAction;

public class AddElementAction extends AbstractGameAction {

    private final ElementManager.Elements element;

    public AddElementAction(ElementManager.Elements e, int amount) {
        element = e;
        this.amount = amount;
    }

    @Override
    public void update() {
        for (int i = 0; i < amount; i++) {
            SpellweaverMod.elementManager.addElement(element);
        }
        isDone = true;
    }
}
