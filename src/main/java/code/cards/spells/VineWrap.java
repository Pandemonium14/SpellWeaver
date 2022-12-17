package code.cards.spells;

import code.SpellweaverMod;
import code.util.Wiz;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.ConstrictedPower;
import com.megacrit.cardcrawl.powers.ThornsPower;

public class VineWrap extends AbstractSpellCard {

    public static final String ID = SpellweaverMod.makeID("VineWrap");

    public VineWrap() {
        super(ID, 2, CardType.ATTACK,CardRarity.SPECIAL,CardTarget.ENEMY);
        baseMagicNumber=magicNumber = 0;
        magicPotency = 7;
        baseDamage = 0;
        damagePotency = 12;
    }

    @Override
    public void upp() {
        damagePotency += 4;
        magicPotency+=2;
    }

    @Override
    public void use(AbstractPlayer abstractPlayer, AbstractMonster abstractMonster) {
        dmg(abstractMonster, AbstractGameAction.AttackEffect.BLUNT_HEAVY);
        Wiz.applyToEnemy(abstractMonster, new ConstrictedPower(abstractMonster, abstractPlayer, magicNumber));
    }
}
