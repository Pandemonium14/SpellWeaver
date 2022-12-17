package code.powers;

import code.SpellweaverMod;
import com.megacrit.cardcrawl.actions.common.ReducePowerAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.localization.PowerStrings;
import com.megacrit.cardcrawl.powers.AbstractPower;

public class ScaldPower extends AbstractEasyPower{

    public static final String ID = SpellweaverMod.makeID("ScaldPower");
    private static final PowerStrings strings = CardCrawlGame.languagePack.getPowerStrings(ID);

    public ScaldPower(AbstractCreature owner, int amount) {
        super(ID, strings.NAME, AbstractPower.PowerType.DEBUFF, true, owner, amount);
    }

    public void updateDescription() {
        this.description = strings.DESCRIPTIONS[0] + this.amount + strings.DESCRIPTIONS[1];
    }

    @Override
    public float atDamageReceive(float damage, DamageInfo.DamageType damageType, AbstractCard card) {
        return damageType == DamageInfo.DamageType.NORMAL ? damage + (float)this.amount : damage;
    }

    @Override
    public void atEndOfTurn(boolean isPlayer) {
        addToBot(new ReducePowerAction(owner,owner,this,1));
    }
}
