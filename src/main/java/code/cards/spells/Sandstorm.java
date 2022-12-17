package code.cards.spells;

import code.SpellweaverMod;
import code.powers.ChillPower;
import code.util.Wiz;
import com.megacrit.cardcrawl.cards.green.DodgeAndRoll;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.NextTurnBlockPower;
import com.megacrit.cardcrawl.powers.VulnerablePower;
import com.megacrit.cardcrawl.powers.WeakPower;

public class Sandstorm extends AbstractSpellCard {

    public static final String ID = SpellweaverMod.makeID("Sandstorm");

    public Sandstorm() {
        super(ID,2,CardType.SKILL,CardRarity.SPECIAL,CardTarget.SELF);
        baseBlock = 0;
        blockPotency = 10;
    }

    @Override
    public void upp() {
        blockPotency += 3;
    }

    @Override
    public void use(AbstractPlayer abstractPlayer, AbstractMonster abstractMonster) {
        blck();
        Wiz.applyToSelf(new NextTurnBlockPower(abstractPlayer,block));
    }
}
