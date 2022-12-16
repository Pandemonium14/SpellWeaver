package code.cards.annex;

import basemod.abstracts.AbstractCardModifier;
import code.SpellweaverMod;
import code.actions.ReducePotencyAction;
import code.cards.spells.AbstractSpellCard;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.CardGroup;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

public class SpellCardMod extends AbstractCardModifier {

    public static final String ID = SpellweaverMod.makeID("SpellCardMod");

    @Override
    public String identifier(AbstractCard card) {
        return ID;
    }

    public SpellCardMod() {}

    @Override
    public boolean isInherent(AbstractCard card) {
        return true;
    }

    @Override
    public float modifyBaseDamage(float damage, DamageInfo.DamageType type, AbstractCard card, AbstractMonster target) {
        if (! (card instanceof AbstractSpellCard)) {
            return damage;
        } else {
            AbstractSpellCard spell = (AbstractSpellCard) card;
            return damage + 3 * spell.potency;
        }
    }

    @Override
    public float modifyBaseBlock(float block, AbstractCard card) {
        if (! (card instanceof AbstractSpellCard)) {
            return block;
        } else {
            AbstractSpellCard spell = (AbstractSpellCard) card;
            return block + 2 * spell.potency;
        }
    }

    @Override
    public float modifyBaseMagic(float magic, AbstractCard card) {
        if (! (card instanceof AbstractSpellCard)) {
            return magic;
        } else {
            AbstractSpellCard spell = (AbstractSpellCard) card;
            return magic + spell.potency;
        }
    }

    @Override
    public void atEndOfTurn(AbstractCard card, CardGroup group) {
        if (! (card instanceof AbstractSpellCard)) {
            return;
        } else {
            AbstractDungeon.actionManager.addToBottom(new ReducePotencyAction((AbstractSpellCard) card));
        }
    }

    @Override
    public AbstractCardModifier makeCopy() {
        return new SpellCardMod();
    }
}
