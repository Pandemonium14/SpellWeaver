package code.cards.spells;

import code.SpellweaverMod;
import code.util.Wiz;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.StrengthPower;

public class LavaSurge extends AbstractSpellCard {

    public static final String ID = SpellweaverMod.makeID("LavaSurge");

    public LavaSurge() {
        super(ID, 2, CardType.ATTACK, CardRarity.SPECIAL, CardTarget.ALL_ENEMY);
        baseMagicNumber = magicNumber = 0;
        baseDamage = 0;
        damagePotency = 15;
        magicPotency = 5;
        isMultiDamage = true;
    }

    @Override
    public void upp() {
        damagePotency += 4;
        magicPotency += 1;
    }

    @Override
    public void use(AbstractPlayer abstractPlayer, AbstractMonster abstractMonster) {
        allDmg(AbstractGameAction.AttackEffect.FIRE);
        for (AbstractMonster m : AbstractDungeon.getMonsters().monsters) Wiz.applyToEnemy(m, new StrengthPower(m, -magicNumber));
    }
}
