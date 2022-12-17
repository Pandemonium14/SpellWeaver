package code.patches;

import basemod.BaseMod;
import basemod.patches.com.megacrit.cardcrawl.cards.AbstractCard.RenderCustomDynamicVariable;
import code.cards.spells.AbstractSpellCard;
import com.badlogic.gdx.graphics.Color;
import com.evacipated.cardcrawl.modthespire.lib.*;
import com.evacipated.cardcrawl.modthespire.patcher.PatchingException;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.helpers.FontHelper;
import javassist.CannotCompileException;
import javassist.CtBehavior;

import java.util.ArrayList;

@SpirePatch2(clz = RenderCustomDynamicVariable.Inner.class, method = "myRenderDynamicVariable")
public class NumberColorsPatch {

    private static final Color DCOLOR = new Color(1f,0.55f,0.15f,1f);
    private static final Color BCOLOR = new Color(0.15f,0.75f,0.15f, 1f);
    private static final Color MCOLOR = new Color(0.9f,0.4f,0.9f,1f);

    private static class Locator extends SpireInsertLocator {
        public int[] Locate(CtBehavior ctMethodToPatch) throws CannotCompileException, PatchingException {
            Matcher finalMatcher = new Matcher.MethodCallMatcher(FontHelper.class, "renderRotatedText");
            return LineFinder.findInOrder(ctMethodToPatch, new ArrayList<Matcher>(), finalMatcher);
        }
    }

    @SpireInsertPatch(locator = Locator.class, localvars = {"c"})
    public static void colorForSpells(Object __obj_instance,String key, @ByRef Color[] c) {
        AbstractCard card = (AbstractCard) __obj_instance;
        if (card instanceof AbstractSpellCard) {
            switch (key) {
                case "D":
                    c[0] = DCOLOR;
                    break;
                case "B":
                    c[0] = BCOLOR;
                    break;
                case "M":
                    c[0] = MCOLOR;
                    break;
            }
        }
    }

}
