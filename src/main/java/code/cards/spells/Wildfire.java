package code.cards.spells;

import code.SpellweaverMod;
import code.util.Wiz;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

public class Wildfire extends AbstractSpellCard {

    public static final String ID = SpellweaverMod.makeID("Wildfire");

    public Wildfire() {
        super(ID,2,CardType.ATTACK, CardRarity.SPECIAL,CardTarget.ALL_ENEMY);
        baseDamage = 0;
        damagePotency = 4;
    }

    @Override
    public void upp() {
        damagePotency += 2;
    }

    @Override
    public void use(AbstractPlayer abstractPlayer, AbstractMonster abstractMonster) {
        allDmg(AbstractGameAction.AttackEffect.FIRE);
        allDmg(AbstractGameAction.AttackEffect.FIRE);
        allDmg(AbstractGameAction.AttackEffect.FIRE);
        allDmg(AbstractGameAction.AttackEffect.FIRE);
    }
}
