package code.cards.spells;

import code.SpellweaverMod;
import code.actions.RemoveRandomDebuffAction;
import code.powers.ChillPower;
import code.util.Wiz;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

public class NaturesBlessing extends AbstractSpellCard {

    public static final String ID = SpellweaverMod.makeID("NaturesBlessing");

    public NaturesBlessing() {
        super(ID, 2, CardType.SKILL,CardRarity.SPECIAL,CardTarget.SELF);
        baseMagicNumber=magicNumber = 0;
        magicPotency = 1;
    }

    @Override
    public void upp() {
        magicPotency+=1;
    }

    @Override
    public void use(AbstractPlayer abstractPlayer, AbstractMonster abstractMonster) {
        addToBot(new RemoveRandomDebuffAction(magicNumber));
    }
}
