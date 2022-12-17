package code.cards.spells;

import code.SpellweaverMod;
import code.util.Wiz;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.DrawCardNextTurnPower;
import com.megacrit.cardcrawl.powers.EnergizedPower;

public class SteamScreen extends AbstractSpellCard {

    public static final String ID = SpellweaverMod.makeID("SteamScreen");

    public SteamScreen() {
        super(ID, 2,CardType.SKILL,CardRarity.SPECIAL,CardTarget.SELF);
        magicNumber = baseMagicNumber = 0;
        magicPotency = 2;
    }

    @Override
    public void upp() {
        magicPotency++;
    }

    @Override
    public void use(AbstractPlayer abstractPlayer, AbstractMonster abstractMonster) {
        Wiz.applyToSelf(new DrawCardNextTurnPower(abstractPlayer,magicNumber));
        Wiz.applyToSelf(new EnergizedPower(abstractPlayer, magicNumber));
    }
}
