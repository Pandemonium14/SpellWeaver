package code.cards.spells;

import code.SpellweaverMod;
import code.powers.ScaldPower;
import code.util.Wiz;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

public class ScaldingWave extends AbstractSpellCard {

    public static final String ID = SpellweaverMod.makeID("ScaldingWave");

    public ScaldingWave() {
        super(ID, 2, CardType.SKILL,CardRarity.SPECIAL,CardTarget.ALL);
        baseMagicNumber=magicNumber = 0;
        magicPotency = 2;
        baseBlock = 0;
        blockPotency = 10;
    }

    @Override
    public void upp() {
        magicPotency++;
        blockPotency+=5;
    }

    @Override
    public void use(AbstractPlayer abstractPlayer, AbstractMonster abstractMonster) {
        blck();
        for (AbstractMonster m : AbstractDungeon.getMonsters().monsters) {
            Wiz.applyToEnemy(m, new ScaldPower(m, magicNumber));
        }
    }
}
