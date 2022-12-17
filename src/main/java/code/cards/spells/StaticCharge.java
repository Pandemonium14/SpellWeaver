package code.cards.spells;

import code.SpellweaverMod;
import code.powers.ScaldPower;
import code.util.Wiz;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.ThornsPower;

public class StaticCharge extends AbstractSpellCard {

    public static final String ID = SpellweaverMod.makeID("StaticCharge");

    public StaticCharge() {
        super(ID, 1, CardType.SKILL,CardRarity.SPECIAL,CardTarget.SELF);
        baseMagicNumber=magicNumber = 0;
        magicPotency = 5;
    }

    @Override
    public void upp() {
        magicPotency+=3;
    }

    @Override
    public void use(AbstractPlayer abstractPlayer, AbstractMonster abstractMonster) {
        Wiz.applyToSelf(new ThornsPower(abstractPlayer, magicNumber));
    }
}
