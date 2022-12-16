package code.actions;

import code.SpellweaverMod;
import com.megacrit.cardcrawl.actions.AbstractGameAction;

public class GainWispAction extends AbstractGameAction {

    public GainWispAction(int amount) {
        this.amount = amount;
    }

    @Override
    public void update() {
        for (int i = 0; i < amount; i++) {
            SpellweaverMod.elementManager.addWisp();
        }
        isDone = true;
    }
}
