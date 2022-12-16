package code.actions;

import basemod.BaseMod;
import code.cards.spells.AbstractSpellCard;
import com.badlogic.gdx.math.MathUtils;
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
        if (!spell.crumbling) {
            spell.damagePotency-=3;
            spell.blockPotency-=2;
            spell.magicPotency-=1;
        } else {
            spell.damagePotency/=2;
            spell.blockPotency/=2;
            spell.magicPotency/=2;
        }

        if (shouldExhaustForStat(spell.baseDamage, spell.damagePotency) || shouldExhaustForStat(spell.baseBlock, spell.blockPotency) || shouldExhaustForStat(spell.baseMagicNumber, spell.magicPotency)) {
            addToTop(new ExhaustSpecificCardAction(spell, AbstractDungeon.player.hand));
        }
        isDone = true;
    }

    private boolean shouldExhaustForStat(int stat, int potency) {
        return stat == 0 && potency == 0;
    }
}
