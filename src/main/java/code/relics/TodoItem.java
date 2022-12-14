package code.relics;

import code.TheSpellweaver;

import static code.SpellweaverMod.makeID;

public class TodoItem extends AbstractEasyRelic {
    public static final String ID = makeID("TodoItem");

    public TodoItem() {
        super(ID, RelicTier.STARTER, LandingSound.FLAT, TheSpellweaver.Enums.TODO_COLOR);
    }
}
