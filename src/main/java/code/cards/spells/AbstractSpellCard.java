package code.cards.spells;

import basemod.helpers.CardModifierManager;
import code.cards.AbstractEasyCard;
import code.cards.annex.SpellCardMod;
import com.megacrit.cardcrawl.cards.AbstractCard;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractSpellCard extends AbstractEasyCard {


    public int damagePotency;
    public int blockPotency;
    public int magicPotency;
    public boolean crumbling = false;

    public AbstractSpellCard(String cardID, int cost, CardType type, CardRarity rarity, CardTarget target) {
        super(cardID, cost, type, rarity, target);
        selfRetain = true;
        exhaust = true;
        CardModifierManager.addModifier(this, new SpellCardMod());
    }


    @Override
    public AbstractCard makeStatEquivalentCopy() {
        AbstractCard copy = super.makeStatEquivalentCopy();
        ((AbstractSpellCard) copy).damagePotency = damagePotency;
        ((AbstractSpellCard) copy).blockPotency = blockPotency;
        ((AbstractSpellCard) copy).magicPotency = magicPotency;
        return copy;
    }

    @Override
    public List<String> getCardDescriptors() {
        ArrayList<String> list = new ArrayList<>();
        list.add("Spell");
        return list;
    }
}
