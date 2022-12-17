package code.cards.spells;

import code.SpellweaverMod;
import code.powers.ChillPower;
import code.util.Wiz;
import com.evacipated.cardcrawl.mod.stslib.fields.cards.AbstractCard.ExhaustiveField;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

public class SummonSwamp extends AbstractSpellCard {

    public static final String ID = SpellweaverMod.makeID("SummonSwamp");

    public SummonSwamp() {
        super(ID,2,CardType.SKILL,CardRarity.SPECIAL,CardTarget.ALL);
        baseBlock = 0;
        blockPotency = 10;
        baseMagicNumber = magicNumber = 0;
        magicPotency = 2;
    }

    @Override
    public void upp() {
        blockPotency += 5;
        magicPotency += 1;
    }

    @Override
    public void use(AbstractPlayer abstractPlayer, AbstractMonster abstractMonster) {
        blck();
        Wiz.applyToAllEnemies((m) -> new ChillPower(m,magicNumber));
    }
}
