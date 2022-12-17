package code.cards.sidecards;

import code.SpellweaverMod;
import code.cards.AbstractEasyCard;
import code.spellcraft.ElementManager;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

public class WaterChoice extends AbstractEasyCard {

    public static final String ID = SpellweaverMod.makeID("WaterChoice");
    public static final ElementManager.Elements element = ElementManager.Elements.WATER;

    public WaterChoice() {
        super(ID,-2,CardType.SKILL,CardRarity.SPECIAL,CardTarget.SELF);
    }

    @Override
    public void upp() {

    }

    @Override
    public void use(AbstractPlayer abstractPlayer, AbstractMonster abstractMonster) {

    }

    @Override
    public void onChoseThisOption() {
        eManager().addElementAction(element);
    }
}
