package code;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.helpers.ImageMaster;

public class BlendingTable {

    private static int[] blendVars = {
            Gdx.gl20.GL_ZERO,
            Gdx.gl20.GL_ONE,
            Gdx.gl20.GL_SRC_COLOR,
            Gdx.gl20.GL_ONE_MINUS_SRC_COLOR,
            Gdx.gl20.GL_DST_COLOR,
            Gdx.gl20.GL_ONE_MINUS_DST_COLOR,
            Gdx.gl20.GL_SRC_ALPHA,
            Gdx.gl20.GL_ONE_MINUS_SRC_ALPHA,
            Gdx.gl20.GL_DST_ALPHA,
            Gdx.gl20.GL_ONE_MINUS_DST_ALPHA,
    };

    private static final Texture TEST_TEXTURE = ImageMaster.loadImage(SpellweaverMod.makeImagePath("TestTexture.png"));

    private static final Texture BACK_TEXTURE = ImageMaster.loadImage(SpellweaverMod.makeImagePath("WhiteBallBack.png"));

    private static final Texture BACK_BACK = ImageMaster.loadImage(SpellweaverMod.makeImagePath("Black.png"));

    public static void render(SpriteBatch sb) {
        float drawX = 0;
        float drawY = 0;
        sb.setBlendFunction(770, 771);
        sb.draw(BACK_BACK,0,0);

        for (int i : blendVars) {
            for (int j : blendVars) {
                sb.draw(BACK_TEXTURE, drawX, drawY);
                drawX += BACK_TEXTURE.getWidth();
            }
            drawX = 0;
            drawY += BACK_TEXTURE.getHeight();
        }
        float offset = (BACK_TEXTURE.getHeight() - TEST_TEXTURE.getHeight())/2f;
        drawX = offset;
        drawY = offset;
        for (int srcBlendVar : blendVars) {
            for (int dstBlendVar : blendVars) {
                sb.setBlendFunction(srcBlendVar, dstBlendVar);
                sb.draw(TEST_TEXTURE,drawX, drawY);
                drawX += BACK_TEXTURE.getWidth();
            }
            drawX = offset;
            drawY += BACK_TEXTURE.getHeight();
        }
        sb.setBlendFunction(770, 771);
    }

}
