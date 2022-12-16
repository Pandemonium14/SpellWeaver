package code.actions;

import basemod.BaseMod;
import code.cards.spells.AbstractSpellCard;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ExhaustSpecificCardAction;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;

public class ReducePotencyAction extends AbstractGameAction {

    private final AbstractSpellCard spell;

    public ReducePotencyAction(AbstractSpellCard spell) {
        this.spell = spell;
    }

    @Override
    public void update() {
        spell.potency--;
        int p = spell.potency;
        if (shouldExhaustForStat(spell.baseDamage,p,3) || shouldExhaustForStat(spell.baseBlock,p,2) || shouldExhaustForStat(spell.baseMagicNumber,p,1)) {
            BaseMod.logger.info("Potency is " + p + ", BaseDamage is " + spell.baseDamage + ", bD-3*p is " + (spell.baseDamage - (3*p)));
            addToTop(new ExhaustSpecificCardAction(spell, AbstractDungeon.player.hand));
        }
        isDone = true;
    }

    private boolean shouldExhaustForStat(int stat, int potency, int factor) {
        return stat > 0 && (stat - potency*factor) <= 0;
    }
}
