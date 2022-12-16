package code.actions;

import code.cards.spells.AbstractSpellCard;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.MakeTempCardInHandAction;
import com.megacrit.cardcrawl.cards.AbstractCard;

public class AddSpellToHandAction extends AbstractGameAction {

    private AbstractCard spell;
    private int wisps;

    public AddSpellToHandAction(AbstractCard spell, int wisps) {
        this.spell = spell;
        this.wisps = wisps;
    }

    @Override
    public void update() {
        if (spell instanceof AbstractSpellCard) {
            AbstractSpellCard cSpell = (AbstractSpellCard) spell;
            cSpell.potency += wisps;
            addToTop(new MakeTempCardInHandAction(cSpell));
        } else {
            addToTop(new MakeTempCardInHandAction(spell));
        }
        isDone = true;
    }
}
