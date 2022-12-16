package code.cards.spells;

import code.SpellweaverMod;
import code.powers.ChillPower;
import code.util.Wiz;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.VulnerablePower;
import com.megacrit.cardcrawl.powers.WeakPower;

public class RockPillar extends AbstractSpellCard {

    public static final String ID = SpellweaverMod.makeID("RockPillar");

    public RockPillar() {
        super(ID,2,CardType.SKILL,CardRarity.SPECIAL,CardTarget.SELF);
        baseBlock = 0;
        blockPotency = 20;
        crumbling = true;
    }

    @Override
    public void upp() {
        blockPotency += 10;
    }

    @Override
    public void use(AbstractPlayer abstractPlayer, AbstractMonster abstractMonster) {
        blck();
        blck();
    }
}
