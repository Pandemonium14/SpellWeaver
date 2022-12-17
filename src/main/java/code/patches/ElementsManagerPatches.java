package code.patches;


import code.SpellweaverMod;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.evacipated.cardcrawl.modthespire.lib.SpirePatch2;
import com.evacipated.cardcrawl.modthespire.lib.SpirePostfixPatch;
import com.megacrit.cardcrawl.characters.AbstractPlayer;

public class ElementsManagerPatches {


    @SpirePatch2(clz = AbstractPlayer.class, method = "render")
    public static class renderElements {
        @SpirePostfixPatch
        public static void postfix(SpriteBatch sb) {
            SpellweaverMod.elementManager.render(sb);
        }
    }

    @SpirePatch2(clz = AbstractPlayer.class, method = "update")
    public static class updateElements {
        @SpirePostfixPatch
        public static void postfix() {
            SpellweaverMod.elementManager.update();
        }
    }
}
