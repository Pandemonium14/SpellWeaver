package code.actions;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.RemoveSpecificPowerAction;
import com.megacrit.cardcrawl.cards.blue.Barrage;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.powers.AbstractPower;

import java.util.ArrayList;

public class RemoveRandomDebuffAction extends AbstractGameAction {

    public RemoveRandomDebuffAction(int amount) {
        this.amount = amount;
    }

    @Override
    public void update() {
        ArrayList<AbstractPower> powers = AbstractDungeon.player.powers;
        ArrayList<AbstractPower> debuffs = new ArrayList<>();
        for (AbstractPower p : powers) {
            if (p.type == AbstractPower.PowerType.DEBUFF) debuffs.add(p);
        }
        int removedDebuffs = 0;
        while (debuffs.size() != 0 && removedDebuffs < amount) {
            int r = AbstractDungeon.cardRandomRng.random(debuffs.size()-1);
            addToBot(new RemoveSpecificPowerAction(AbstractDungeon.player,AbstractDungeon.player, debuffs.remove(r)));
            removedDebuffs++;
        }
        isDone = true;
    }
}
