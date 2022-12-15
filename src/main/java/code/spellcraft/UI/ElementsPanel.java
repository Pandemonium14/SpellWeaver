package code.spellcraft.UI;

import basemod.BaseMod;
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

        circles.clear();
        int i = 0;
        while (SpellweaverMod.elementManager.getElement(i) != ElementManager.Elements.NULL) {
            circles.add(getCircle(SpellweaverMod.elementManager.getElement(i), i));
            i++;
        }
    }

    private ElementCircle getCircle(ElementManager.Elements e, int i) {
        float pX = AbstractDungeon.player.drawX;
        float pY = AbstractDungeon.player.drawY;
        switch (SpellweaverMod.elementManager.getElement(i)) {
            case FIRE:
                return new ElementCircle(Color.RED, textures[0], 0.5f + i * 0.1f, pX, pY + Settings.scale * (300f + i * 40f));
            case WATER:
                return new ElementCircle(Color.BLUE, textures[1], 0.5f + i * 0.1f, pX, pY + Settings.scale * (300f + i * 40f));
            case EARTH:
                return new ElementCircle(Color.GREEN, textures[2], 0.5f + i * 0.1f, pX, pY + Settings.scale * (300f + i * 40f));
            case AIR:
                return new ElementCircle(Color.WHITE, textures[3], 0.5f + i * 0.1f, pX, pY + Settings.scale * (300f + i * 40f));
        }
        BaseMod.logger.warn("null circle added !!!");
        return null;
    }

    public void addCircle(ElementManager.Elements e, int i) {
        circles.add(getCircle(e,i));
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
        textures[0] = new TextureRegion(ImageMaster.loadImage(SpellweaverMod.makeImagePath("ui/NormalCircle.png")),256,256);
        textures[1] = new TextureRegion(ImageMaster.loadImage(SpellweaverMod.makeImagePath("ui/NormalCircle.png")),256,256);
        textures[2] = new TextureRegion(ImageMaster.loadImage(SpellweaverMod.makeImagePath("ui/NormalCircle.png")),256,256);
        textures[3] = new TextureRegion(ImageMaster.loadImage(SpellweaverMod.makeImagePath("ui/NormalCircle.png")),256,256);
    }
}
