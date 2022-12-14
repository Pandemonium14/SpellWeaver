package code.spellcraft.UI;

import code.SpellweaverMod;
import code.spellcraft.ElementManager;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Array;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.helpers.ImageMaster;

import java.util.ArrayList;

public class ElementsPanel {

    private ArrayList<ElementCircle> circles = new ArrayList<>();
    private static final TextureRegion[] textures = new TextureRegion[4];

    public void setCircles() {
        float pX = AbstractDungeon.player.drawX;
        float pY = AbstractDungeon.player.drawY;
        circles.clear();
        int i = 0;
        while (SpellweaverMod.elementManager.getElement(i) != ElementManager.Elements.NULL) {
            switch (SpellweaverMod.elementManager.getElement(i)) {
                case FIRE:
                    circles.add(new ElementCircle(Color.RED, textures[0], 0.5f + i * 0.1f, pX, pY + Settings.scale * (150f * pX + i * 20f)));
                    break;
                case WATER:
                    circles.add(new ElementCircle(Color.BLUE, textures[1], 0.5f + i * 0.1f, pX, pY + Settings.scale * (150f * pX + i * 20f)));
                    break;
                case EARTH:
                    circles.add(new ElementCircle(Color.GREEN, textures[2], 0.5f + i * 0.1f, pX, pY + Settings.scale * (150f * pX + i * 20f)));
                    break;
                case AIR:
                    circles.add(new ElementCircle(Color.WHITE, textures[3], 0.5f + i * 0.1f, pX, pY + Settings.scale * (150f * pX + i * 20f)));
                    break;
            }
        }
    }

    public void update() {
        for (ElementCircle c : circles) {
            c.update();
        }
    }

    public void render(SpriteBatch sb) {
        for (ElementCircle c : circles) {
            c.render(sb);
        }
    }

    static {
        textures[0] = new TextureRegion(ImageMaster.loadImage(SpellweaverMod.makeImagePath("ui/NormalCircle.png")));
        textures[1] = new TextureRegion(ImageMaster.loadImage(SpellweaverMod.makeImagePath("ui/NormalCircle.png")));
        textures[2] = new TextureRegion(ImageMaster.loadImage(SpellweaverMod.makeImagePath("ui/NormalCircle.png")));
        textures[3] = new TextureRegion(ImageMaster.loadImage(SpellweaverMod.makeImagePath("ui/NormalCircle.png")));
    }
}
