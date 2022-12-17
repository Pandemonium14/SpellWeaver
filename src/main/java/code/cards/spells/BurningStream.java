package code.cards.spells;

import code.SpellweaverMod;
import code.powers.ScaldPower;
import code.util.Wiz;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

public class BurningStream extends AbstractSpellCard {

    public static final String ID = SpellweaverMod.makeID("BurningStream");

    public BurningStream() {
        super(ID, 2, CardType.SKILL, CardRarity.SPECIAL, CardTarget.ALL_ENEMY);
        baseMagicNumber = magicNumber = 0;
        magicPotency = 4;
    }

    @Override
    public void upp() {
        magicPotency+=2;
    }

    @Override
    public void use(AbstractPlayer abstractPlayer, AbstractMonster abstractMonster) {
        for (AbstractMonster m : AbstractDungeon.getMonsters().monsters) Wiz.applyToEnemy(m, new ScaldPower(m,magicNumber));
    }
}
