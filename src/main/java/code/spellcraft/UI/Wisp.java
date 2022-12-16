package code.spellcraft.UI;

import basemod.BaseMod;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;

import java.util.ArrayList;

public class Wisp {

    private float centerX;
    private float centerY;
    private float pointerX;
    private float pointerY;
    private float centerDistance;
    protected float duration;
    private float timer;
    private ArrayList<WispParticle> particles = new ArrayList<>();

    private final float initialDistance;

    private static final float eccentricity = 0.4f;
    private static final float timerMax = 0.05f;

    public Wisp(float x, float y, float distance) {
        centerDistance = initialDistance = distance;
        centerX = x;
        centerY = y;
        duration = 0;
        timer = 0;
    }

    public void update() {
        pointerX = centerX + centerDistance*MathUtils.cosDeg(30*duration);
        pointerY = centerY + centerDistance*0.4f*MathUtils.sinDeg(30*duration);

        duration += Gdx.graphics.getDeltaTime();
        timer += Gdx.graphics.getDeltaTime();
        if (timer >= timerMax) {
            particles.add(new WispParticle(pointerX, pointerY));
            timer = 0;
            BaseMod.logger.info("==== Spawning particle, " + particles.size() +"total");
        }
        if (particles.size() > 0) {
            WispParticle oldestParticle = particles.get(0);
            if (oldestParticle.duration > oldestParticle.START_DECAY_DUR && oldestParticle.scale <= 0.1f) particles.remove(0);
        }
        for (WispParticle particle : particles) {
            particle.update();
        }
    }

    public void render(SpriteBatch sb) {
        for (WispParticle particle : particles) {
            particle.render(sb);
        }
    }
}
