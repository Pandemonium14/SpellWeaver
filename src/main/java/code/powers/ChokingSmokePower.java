package code.powers;

import code.SpellweaverMod;
import code.util.Wiz;
import com.evacipated.cardcrawl.mod.stslib.powers.abstracts.TwoAmountPower;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ReducePowerAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.localization.PowerStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.AbstractPower;

public class ChokingSmokePower extends TwoAmountPower {

    public static final String POWER_ID = SpellweaverMod.makeID("ChokingSmokePower");
    private static final PowerStrings strings = CardCrawlGame.languagePack.getPowerStrings(POWER_ID);

    public ChokingSmokePower(AbstractCreature owner, int damage, int duration) {
        name = strings.NAME;
        ID = POWER_ID;
        this.amount = duration;
        this.amount2 = damage;
        this.owner = owner;

        type = PowerType.BUFF;
        isTurnBased = false;

        loadRegion("fumes");
    }

    public void updateDescription() {
        this.description = strings.DESCRIPTIONS[0] + this.amount + strings.DESCRIPTIONS[1] + strings.DESCRIPTIONS[2];
    }

    @Override
    public void atEndOfTurn(boolean isPlayer) {
        for (AbstractMonster m:  AbstractDungeon.getMonsters().monsters) {
            Wiz.thornDmg(m, amount2, AbstractGameAction.AttackEffect.NONE);
        }
        addToBot(new ReducePowerAction(owner,owner,this,1));
    }
}
