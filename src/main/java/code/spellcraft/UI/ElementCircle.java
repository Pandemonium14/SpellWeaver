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
import com.badlogic.gdx.math.MathUtils;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.helpers.ImageMaster;
import com.megacrit.cardcrawl.vfx.AbstractGameEffect;

import java.util.Set;

public class ElementCircle {

    private static final TextureRegion GLOW = new TextureRegion(ImageMaster.loadImage(SpellweaverMod.makeImagePath("ui/CircleGlow.png")));

    protected float x;
    protected float y;
    protected float scale;
    protected float angle;
    protected TextureRegion texture;
    protected Color color;

    public ElementCircle(Color color, TextureRegion texture, float scale, float x, float y) {
        this.color = color;
        this.texture = texture;
        this.scale = scale;
        this.x = x;
        this.y = y;
    }

    public void update() {
        angle += 15f * Gdx.graphics.getDeltaTime();
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

}
