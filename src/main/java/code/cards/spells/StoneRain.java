package code.cards.spells;

import code.SpellweaverMod;
import code.util.Wiz;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.NextTurnBlockPower;

public class StoneRain extends AbstractSpellCard {

    public static final String ID = SpellweaverMod.makeID("StoneRain");

    public StoneRain() {
        super(ID,2,CardType.ATTACK,CardRarity.SPECIAL,CardTarget.ALL_ENEMY);
        isMultiDamage = true;
        baseDamage = 0;
        damagePotency = 3;
        baseMagicNumber = magicNumber = 0;
        magicPotency = 2;
    }

    @Override
    public void upp() {
        magicPotency += 1;
    }

    @Override
    public void use(AbstractPlayer abstractPlayer, AbstractMonster abstractMonster) {
        for (int i = 0 ; i < magicNumber ; i++) {
            allDmg(AbstractGameAction.AttackEffect.BLUNT_LIGHT);
        }
    }
}
