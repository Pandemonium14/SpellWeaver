package code.cards.spells;

import code.SpellweaverMod;
import code.actions.MakeRandomCardFreeToPlayAction;
import com.megacrit.cardcrawl.actions.common.DrawCardAction;
import com.megacrit.cardcrawl.actions.common.MakeTempCardInHandAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

public class Cyclone extends AbstractSpellCard {

    public static final String ID = SpellweaverMod.makeID("Cyclone");

    public Cyclone() {
        super(ID, 1,CardType.SKILL, CardRarity.SPECIAL,CardTarget.SELF);
        baseMagicNumber = magicNumber = 0;
        magicPotency = 1;
    }

    @Override
    public void upp() {
        magicPotency++;
    }

    @Override
    public void use(AbstractPlayer abstractPlayer, AbstractMonster abstractMonster) {
        addToBot(new DrawCardAction(3));
        addToBot(new MakeRandomCardFreeToPlayAction(magicNumber));
    }
}
