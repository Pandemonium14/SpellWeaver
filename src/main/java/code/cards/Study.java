package code.cards;

import code.SpellweaverMod;
import code.cards.sidecards.AirChoice;
import code.cards.sidecards.EarthChoice;
import code.cards.sidecards.FireChoice;
import code.cards.sidecards.WaterChoice;
import com.megacrit.cardcrawl.actions.watcher.ChooseOneAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import java.util.ArrayList;

public class Study extends AbstractEasyCard {

    public static final String ID = SpellweaverMod.makeID("Study");

    public Study() {
        super(ID,0,CardType.SKILL,CardRarity.BASIC,CardTarget.SELF);
        exhaust = true;
    }

    @Override
    public void upp() {
        exhaust = false;
    }

    @Override
    public void use(AbstractPlayer abstractPlayer, AbstractMonster abstractMonster) {
        ArrayList<AbstractCard> choices = new ArrayList<>();
        choices.add(new FireChoice());
        choices.add(new WaterChoice());
        choices.add(new EarthChoice());
        choices.add(new AirChoice());
        addToBot(new ChooseOneAction(choices));
    }
}
