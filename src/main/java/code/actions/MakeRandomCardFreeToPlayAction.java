package code.actions;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.CardQueueItem;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;

import java.util.ArrayList;

public class MakeRandomCardFreeToPlayAction extends AbstractGameAction {

    public MakeRandomCardFreeToPlayAction(int amount) {
        this.amount = amount;
    }

    @Override
    public void update() {
        ArrayList<AbstractCard> groupCopy = new ArrayList<>();
        for (AbstractCard abstractCard : AbstractDungeon.player.hand.group) {
            if (abstractCard.cost > 0 && abstractCard.costForTurn > 0 && !abstractCard.freeToPlayOnce) {
                groupCopy.add(abstractCard);
            }
        }
        for (CardQueueItem i : AbstractDungeon.actionManager.cardQueue) {
            if (i.card != null) {
                groupCopy.remove(i.card);
            }
        }
        AbstractCard c = null;
        int i = 0;
        while (!groupCopy.isEmpty() && i < amount) {
            c = groupCopy.get(AbstractDungeon.cardRandomRng.random(0, groupCopy.size() - 1));
            if (c != null) {
                c.setCostForTurn(0);
            }
            groupCopy.remove(c);
            i++;
        }
        isDone = true;
    }
}
