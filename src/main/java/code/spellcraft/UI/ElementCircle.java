package code.spellcraft.UI;

import basemod.BaseMod;
import code.SpellweaverMod;
import code.spellcraft.ElementManager;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.FrameBuffer;
import com.badlogic.gdx.math.Affine2;
import com.badlogic.gdx.math.Interpolation;
import com.badlogic.gdx.math.MathUtils;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.helpers.ImageMaster;
import com.megacrit.cardcrawl.vfx.AbstractGameEffect;

import java.util.Set;

public class ElementCircle {

    private static final TextureRegion GLOW = new TextureRegion(ImageMaster.loadImage(SpellweaverMod.makeImagePath("ui/CircleGlow.png")));
    private static final float SPAWN_ANIM_DUR = 0.7f;
    private static final float END_ANIM_DUR = 0.5f;

    private static final TextureRegion[] textures = new TextureRegion[4];
    private static final Color[] colors = new Color[4];

    protected float x;
    protected float y;
    protected float targetY;
    protected float targetScale;
    protected float scale;
    protected float angle;
    protected TextureRegion texture;
    protected Color color;
    private float duration;
    protected ElementManager.Elements element;
    private float startEndScale;

    public ElementCircle(ElementManager.Elements element, float scale, float x, float y) {
        this.targetScale = scale;
        this.x = x;
        this.y = y - 5f*Settings.scale;
        targetY = y;
        this.scale = 0;
        duration = 0;
        this.element = element;
        switch (element) {
            case FIRE:
                color = colors[0];
                texture = textures[0];
                break;
            case WATER:
                color = colors[1];
                texture = textures[1];
                break;
            case EARTH:
                color = colors[2];
                texture = textures[2];
                break;
            case AIR:
                color = colors[3];
                texture = textures[3];
                break;
        }
    }

    public void update() {
        y += (targetY - y) * Gdx.graphics.getDeltaTime()*1.5f;
        angle += 15f * Gdx.graphics.getDeltaTime();
        duration += Gdx.graphics.getDeltaTime();
        if (duration > SPAWN_ANIM_DUR) {
            scale += (targetScale - scale) * Gdx.graphics.getDeltaTime()*1.5f;
        } else {
            scale = Interpolation.fade.apply(0f,targetScale,duration/SPAWN_ANIM_DUR);
        }
    }

    public void updateToRemove() {
        angle += 15f * Gdx.graphics.getDeltaTime();
        if (duration > 0) {
            duration = 0;
            startEndScale = scale;
        }
        duration -= Gdx.graphics.getDeltaTime();
        scale = startEndScale * Interpolation.fade.apply(0, startEndScale, duration + END_ANIM_DUR);
    }

    public void render(SpriteBatch sb) {
        sb.setColor(color);

        Affine2 affine = new Affine2();
        affine.translate(x, y);
        affine.scale(scale, 0.4f * scale);
        affine.rotate(angle);
        Affine2 glowAffine = new Affine2(affine);
        affine.translate(-128,-128);
        glowAffine.translate(-256,-256);

        sb.setBlendFunction(770, 1);

        sb.draw(texture,256,256, affine);
        sb.draw(GLOW,512,512, glowAffine);

        sb.setBlendFunction(770, 771);
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
