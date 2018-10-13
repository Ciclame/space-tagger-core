package it.insidecode.spacetagger.framework.level;

import it.insidecode.spacetagger.PropertiesManager;
import it.insidecode.spacetagger.logic.Enemy;
import it.insidecode.spacetagger.framework.Framework;
import it.insidecode.spacetagger.framework.GfxEnemy;
import it.insidecode.spacetagger.logic.DynamicPhysicsEntity;
import it.insidecode.spacetagger.path.LineDirection;
import it.insidecode.spacetagger.path.LinePath;
import it.insidecode.spacetagger.shots.Shot;
import it.insidecode.spacetagger.util.Constants;

import java.util.Random;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.math.Vector2;

public class EnemyB extends GfxEnemy {

	private static Sound blasterSound = Gdx.audio.newSound(Gdx.files
			.internal((PropertiesManager.getParameter("blasterSound"))));
	private static float ENERGY_VALUE = Constants.ENEMY_B_ENERGY;
	private static int SCORE_VALUE = 400;
	private static float DAMAGE_VALUE = 1;
	private static float SPEED_VALUE = Constants.ENEMY_B_SPEED;

	private static int TIME = 1000;

	private int timer = TIME;

	public EnemyB(Framework framework, Vector2 position) {
		super(framework, position, ENERGY_VALUE, SCORE_VALUE, DAMAGE_VALUE,
				SPEED_VALUE, PropertiesManager.getParameter("enemyB"),
				PropertiesManager.getParameter("explosion"));
	}

	@Override
	public Shot shoot() {
		blasterSound.play();
		return super.shoot();
	}

	@Override
	public void update(float delta) {
		super.update(delta);
		if ((timer += delta) > TIME) {
			timer = -new Random().nextInt(2000);
			if (isAlive())
				shoot();
		}
	}
	
	@Override
	public void handleContact(DynamicPhysicsEntity e)
	{
		super.handleContact(e);
	}

	@Override
	public boolean intersects(DynamicPhysicsEntity e) {
		if (e instanceof Enemy)
			setPath(new LinePath(LineDirection.LEFT, 300));
		return super.intersects(e);
	}

}
