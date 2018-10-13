package it.insidecode.spacetagger.framework.level;

import it.insidecode.spacetagger.PropertiesManager;
import it.insidecode.spacetagger.framework.Framework;
import it.insidecode.spacetagger.framework.GfxEnemy;
import it.insidecode.spacetagger.logic.Direction;
import it.insidecode.spacetagger.logic.DynamicPhysicsEntity;
import it.insidecode.spacetagger.logic.Ship;
import it.insidecode.spacetagger.logic.PowerUp;
import it.insidecode.spacetagger.util.Rectangle;
import it.insidecode.spacetagger.util.SimpleCallback;

import com.badlogic.gdx.math.Vector2;

public class Asteroid extends GfxEnemy {

	private static float ENERGY_VALUE = 3;
	private static int SCORE_VALUE = 500;
	private static float DAMAGE_VALUE = 2;
	private static float SPEED_VALUE = .5f;

	private static PowerUp p;

	private Framework framework;

	public Asteroid(final Framework framework, Vector2 position) {
		super(framework, position, ENERGY_VALUE, SCORE_VALUE, DAMAGE_VALUE,
				SPEED_VALUE, PropertiesManager.getParameter("asteroid"),
				PropertiesManager.getParameter("explosion"),
				new SimpleCallback() {

					@Override
					public void onComplete() {
						p.activate();
					}

				});
		this.framework = framework;
	}

	@Override
	public void update(float delta) {
		super.update(delta);
		move(Direction.DOWN);
	}

	@Override
	public void destroy() {
		p = new EnergyPowerUp(framework, getCenter());
		super.destroy();
	}

	@Override
	public boolean intersects(DynamicPhysicsEntity e) {
		if (e instanceof Ship)
			this.body = new Rectangle(0, 0, 0, 0);
		return super.intersects(e);
	}

}
