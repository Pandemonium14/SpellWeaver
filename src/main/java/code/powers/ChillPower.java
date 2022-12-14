package code.powers;

import code.SpellweaverMod;
import com.megacrit.cardcrawl.actions.common.ReducePowerAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.localization.PowerStrings;

public class ChillPower extends AbstractEasyPower {

    public static final String ID = SpellweaverMod.makeID("ChillPower");
    private static final PowerStrings strings = CardCrawlGame.languagePack.getPowerStrings(ID);

    public ChillPower(AbstractCreature owner, int amount) {
        super(ID, strings.NAME, PowerType.DEBUFF, true, owner, amount);
    }

    public void updateDescription() {
        this.description = strings.DESCRIPTIONS[0] + this.amount + strings.DESCRIPTIONS[1];
    }

    public float atDamageGive(float damage, DamageInfo.DamageType type) {
        return type == DamageInfo.DamageType.NORMAL ? damage - (float)this.amount : damage;// 93 94
    }

    @Override
    public void atEndOfTurn(boolean isPlayer) {
        addToBot(new ReducePowerAction(owner,owner,this,1));
    }
}
