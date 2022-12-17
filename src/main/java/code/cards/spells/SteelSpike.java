package code.cards.spells;

import code.SpellweaverMod;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

public class SteelSpike extends AbstractSpellCard {

    public static final String ID = SpellweaverMod.makeID("SteelSpike");

    public SteelSpike() {
        super(ID, 2,CardType.ATTACK,CardRarity.SPECIAL,CardTarget.ENEMY);
        baseDamage = 0;
        damagePotency = 40;
        crumbling = true;
    }

    @Override
    public void upp() {
        damagePotency += 10;
    }

    @Override
    public void use(AbstractPlayer abstractPlayer, AbstractMonster abstractMonster) {
        dmg(abstractMonster, AbstractGameAction.AttackEffect.SLASH_HEAVY);
    }
}
