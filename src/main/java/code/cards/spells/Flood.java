package code.cards.spells;

import code.SpellweaverMod;
import code.powers.ChillPower;
import code.util.Wiz;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.VulnerablePower;
import com.megacrit.cardcrawl.powers.WeakPower;

public class Flood extends AbstractSpellCard {

    public static final String ID = SpellweaverMod.makeID("Flood");

    public Flood() {
        super(ID,2,CardType.SKILL,CardRarity.SPECIAL,CardTarget.ALL_ENEMY);
        baseMagicNumber = magicNumber = 0;
        magicPotency = 2;
    }

    @Override
    public void upp() {
        magicPotency += 1;
    }

    @Override
    public void use(AbstractPlayer abstractPlayer, AbstractMonster abstractMonster) {
        for (AbstractMonster m : AbstractDungeon.getMonsters().monsters) {
            Wiz.applyToEnemy(m, new ChillPower(m, magicNumber));
            Wiz.applyToEnemy(m, new WeakPower(m, magicNumber, false));
            Wiz.applyToEnemy(m, new VulnerablePower(m, magicNumber,false));
        }
    }
}
