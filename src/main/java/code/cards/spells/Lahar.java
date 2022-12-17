package code.cards.spells;

import code.SpellweaverMod;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

public class Lahar extends AbstractSpellCard {

    public static final String ID = SpellweaverMod.makeID("Lahar");

    public Lahar() {
        super(ID, 2, CardType.ATTACK, CardRarity.SPECIAL, CardTarget.ALL);
        baseBlock = 0;
        blockPotency = 10;
        baseDamage = 0;
        damagePotency = 5;
        isMultiDamage = true;
    }

    @Override
    public void upp() {
        blockPotency += 3;
        damagePotency += 2;
    }

    @Override
    public void use(AbstractPlayer abstractPlayer, AbstractMonster abstractMonster) {
        blck();
        allDmg(AbstractGameAction.AttackEffect.BLUNT_HEAVY);
        allDmg(AbstractGameAction.AttackEffect.BLUNT_HEAVY);
        allDmg(AbstractGameAction.AttackEffect.BLUNT_HEAVY);
    }
}
