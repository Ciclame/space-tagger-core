package it.insidecode.spacetagger.framework.level;

import it.insidecode.spacetagger.PropertiesManager;
import it.insidecode.spacetagger.framework.Framework;
import it.insidecode.spacetagger.framework.GfxEnemy;
import it.insidecode.spacetagger.util.Constants;

import com.badlogic.gdx.math.Vector2;

public class EnemyA extends GfxEnemy {

	private static float ENERGY_VALUE = Constants.ENEMY_A_ENERGY;
	private static int SCORE_VALUE = 500;
	private static float DAMAGE_VALUE = .5f;
	private static float SPEED_VALUE = Constants.ENEMY_A_SPEED;

	public EnemyA(Framework framework, Vector2 position) {
		super(framework, position, ENERGY_VALUE, SCORE_VALUE, DAMAGE_VALUE,
				SPEED_VALUE, PropertiesManager.getParameter("enemyA"),
				PropertiesManager.getParameter("explosion"));
	}

}
