package code.spellcraft;

import basemod.BaseMod;
import code.SpellweaverMod;
import code.actions.AddSpellToHandAction;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.cards.AbstractCard;

import java.util.ArrayList;

public class CreateSpellAction extends AbstractGameAction {

    private final ArrayList<ElementManager.Elements> elements;

    public CreateSpellAction(ArrayList<ElementManager.Elements> elements) {
        this.elements = elements;
    }

    @Override
    public void update() {
        AbstractCard spell;
        if (elements.size() == 3) {
            spell = SpellweaverMod.elementManager.getInvokation(elements);
            addToTop(new AddSpellToHandAction(spell, SpellweaverMod.elementManager.getWisps()));
            SpellweaverMod.elementManager.clearWisps();
            SpellweaverMod.elementManager.clearElements();
        } else {
            BaseMod.logger.info("Tried to make a spell from not 3 elements");
            isDone = true;
        }
    }
}
