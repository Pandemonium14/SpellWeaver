package code.cards.spells;

import code.SpellweaverMod;
import code.powers.ChillPower;
import code.util.Wiz;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.ConstrictedPower;

public class IceAge extends AbstractSpellCard {

    public static final String ID = SpellweaverMod.makeID("IceAge");

    public IceAge() {
        super(ID, 2, CardType.SKILL,CardRarity.SPECIAL,CardTarget.ALL_ENEMY);
        baseMagicNumber=magicNumber = 0;
        magicPotency = 1;
    }

    @Override
    public void upp() {
        magicPotency+=1;
    }

    @Override
    public void use(AbstractPlayer abstractPlayer, AbstractMonster abstractMonster) {
        Wiz.applyToAllEnemies((m) -> new ChillPower(m, magicNumber));
        Wiz.applyToAllEnemies((m) -> new ChillPower(m, magicNumber));
    }

}
