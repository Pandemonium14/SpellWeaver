package code.spellcraft.UI;

import code.spellcraft.ElementManager;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class ElementCircle {

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
        angle += 0.5 * Gdx.graphics.getDeltaTime();
    }

    public void render(SpriteBatch sb) {
        sb.setColor(color);
        sb.draw(texture,x,y,x,y, texture.getRegionWidth(), texture.getRegionHeight(), scale, scale * 0.3f, angle);
    }
}
