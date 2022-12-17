package code.cards.spells;

import code.SpellweaverMod;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.AttackDamageRandomEnemyAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

public class Thunderstrike extends AbstractSpellCard {

    public static final String ID = SpellweaverMod.makeID("Thunderstrike");

    public Thunderstrike() {
        super(ID, 2,CardType.ATTACK,CardRarity.SPECIAL, CardTarget.ALL_ENEMY);
        baseDamage = 0;
        damagePotency = 8;
        baseMagicNumber = magicNumber = 0;
        magicPotency = 2;
    }

    @Override
    public void upp() {
        damagePotency += 2;
        magicPotency += 1;
    }

    @Override
    public void use(AbstractPlayer abstractPlayer, AbstractMonster abstractMonster) {
        for(int i = 0; i < this.magicNumber; ++i) {// 34
            this.addToBot(new AttackDamageRandomEnemyAction(this, AbstractGameAction.AttackEffect.LIGHTNING));// 35
        }
    }
}
