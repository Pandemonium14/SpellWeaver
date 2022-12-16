package code.spellcraft.UI;

import code.SpellweaverMod;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Interpolation;
import com.megacrit.cardcrawl.helpers.ImageMaster;

public class WispParticle {

    private static final TextureRegion TEXTURE = new TextureRegion(ImageMaster.loadImage(SpellweaverMod.makeImagePath("ui/WispParticle.png")));

    private float x;
    private float y;
    protected float duration;
    protected float scale;
    private Color color;

    private final float MAX_SCALE =0.6f;
    protected final float START_DECAY_DUR = 0.3f;
    private final float DECAY_RATE = 0.3f;
    private final float dY = 1f;

    public WispParticle(float x, float y) {
        this.x = x;
        this.y = y;
        scale = 0;
        duration = 0;
        color = Color.WHITE.cpy();
        color.a = 0;
    }

    public void update() {
        if (duration > START_DECAY_DUR) {
            color.a = Interpolation.fade.apply(0.5f, 0f, (duration - START_DECAY_DUR) / START_DECAY_DUR * DECAY_RATE);
            scale = Interpolation.sineIn.apply(MAX_SCALE, 0f, (duration - START_DECAY_DUR) / START_DECAY_DUR * DECAY_RATE);

            y += dY;
        } else {
            color.a = Interpolation.fade.apply(0f, 0.5f, (duration) / START_DECAY_DUR);
            scale = Interpolation.fade.apply(0f, MAX_SCALE, (duration) / START_DECAY_DUR);
        }
        duration += Gdx.graphics.getDeltaTime();
    }

    public void render(SpriteBatch sb) {
        sb.setColor(color);
        sb.draw(TEXTURE, x - TEXTURE.getRegionWidth() * scale * 0.5f, y - TEXTURE.getRegionHeight() * scale * 0.5f, 0,0,128,128,scale,scale,0);
    }
}
