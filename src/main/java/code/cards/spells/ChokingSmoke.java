package code.cards.spells;

import code.SpellweaverMod;
import code.powers.ChokingSmokePower;
import code.util.Wiz;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

public class ChokingSmoke extends AbstractSpellCard {

    public static final String ID = SpellweaverMod.makeID("ChokingSmoke");

    public ChokingSmoke() {
        super(ID,2,CardType.SKILL, CardRarity.SPECIAL,CardTarget.SELF);
        baseMagicNumber = magicNumber = 0;
        magicPotency = 3;
        baseDamage = 0;
        damagePotency = 10;
    }

    @Override
    public void upp() {
        damagePotency += 4;
    }

    @Override
    public void use(AbstractPlayer abstractPlayer, AbstractMonster abstractMonster) {
        Wiz.applyToSelf(new ChokingSmokePower(abstractPlayer,damage, magicNumber));
    }
}
