package code.spellcraft.UI;

import basemod.BaseMod;
import basemod.interfaces.PostRenderSubscriber;
import code.SpellweaverMod;
import code.spellcraft.ElementManager;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.Array;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.helpers.ImageMaster;

import java.util.ArrayList;

public class ElementsPanel {

    private ArrayList<ElementCircle> circles = new ArrayList<>();
    private static final TextureRegion[] textures = new TextureRegion[4];
    private static final Color[] colors = new Color[4];
    private ArrayList<Wisp> wisps = new ArrayList<>();
    private ArrayList<Wisp> wispsToRemove = new ArrayList<>();

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
                return new ElementCircle(colors[0], textures[0], 0.5f + i * 0.1f, pX, pY + Settings.scale * (300f + i * 40f));
            case WATER:
                return new ElementCircle(colors[1], textures[1], 0.5f + i * 0.1f, pX, pY + Settings.scale * (300f + i * 40f));
            case EARTH:
                return new ElementCircle(colors[2], textures[2], 0.5f + i * 0.1f, pX, pY + Settings.scale * (300f + i * 40f));
            case AIR:
                return new ElementCircle(colors[3], textures[3], 0.5f + i * 0.1f, pX, pY + Settings.scale * (300f + i * 40f));
        }
        BaseMod.logger.warn("null circle added !!!");
        return null;
    }

    public void addCircle(ElementManager.Elements e, int i) {
        circles.add(getCircle(e,i));
    }

    public void addWisp(int i) {
        float pX = AbstractDungeon.player.drawX;
        float pY = AbstractDungeon.player.drawY;
        wisps.add(new Wisp(pX,pY + Settings.scale * 300f,110f));
    }

    public void clearWisps() {
        wispsToRemove.addAll(wisps);
        wisps.clear();
    }

    public void update() {
        for (ElementCircle c : circles) {
            c.update();
        }
        for (Wisp wisp : wisps) {
            wisp.update();
        }
        for (Wisp wisp : wispsToRemove) {
            wisp.updateToRemove();
        }
    }

    public void render(SpriteBatch sb) {
        ArrayList<Wisp> W = new ArrayList<>();
        W.addAll(wisps);
        W.addAll(wispsToRemove);
        for (Wisp wisp : W) {
            if (MathUtils.sinDeg(30*wisp.duration) > 0) {
                wisp.render(sb);
            }
        }
        for (ElementCircle c : circles) {
            c.render(sb);
        }
        for (Wisp wisp : W) {
            if (MathUtils.sinDeg(30*wisp.duration) <=0) {
                wisp.render(sb);
            }
        }
    }

    static {
        textures[0] = new TextureRegion(ImageMaster.loadImage(SpellweaverMod.makeImagePath("ui/NormalCircle.png")),256,256);
        textures[1] = new TextureRegion(ImageMaster.loadImage(SpellweaverMod.makeImagePath("ui/NormalCircle.png")),256,256);
        textures[2] = new TextureRegion(ImageMaster.loadImage(SpellweaverMod.makeImagePath("ui/NormalCircle.png")),256,256);
        textures[3] = new TextureRegion(ImageMaster.loadImage(SpellweaverMod.makeImagePath("ui/NormalCircle.png")),256,256);
        Color fireRed = Color.RED.cpy();
        fireRed.r = 0.9f;
        colors[0] = fireRed;
        Color waterBlue = Color.BLUE.cpy();
        waterBlue.b = 0.9f;
        waterBlue.g = 0.1f;
        colors[1] = waterBlue;
        Color earthGreen = Color.GREEN.cpy();
        earthGreen.g = 0.8f;
        earthGreen.r = 0.2f;
        colors[2] = earthGreen;
        Color airWhite = Color.WHITE.cpy();
        airWhite.r = 0.9f;
        colors[3] = airWhite;
    }
}
