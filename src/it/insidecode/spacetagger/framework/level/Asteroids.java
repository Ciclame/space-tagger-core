package it.insidecode.spacetagger.framework.level;

import it.insidecode.spacetagger.PropertiesManager;
import it.insidecode.spacetagger.framework.Framework;
import it.insidecode.spacetagger.framework.GfxEnemy;
import it.insidecode.spacetagger.logic.Direction;
import com.badlogic.gdx.math.Vector2;

/**
 * Asteroide semplice
 * @author Valentini.1612930
 */
public class Asteroids extends GfxEnemy {

	private static float ENERGY_VALUE = 3;
	private static int SCORE_VALUE = 1000;
	private static float DAMAGE_VALUE = 5;
	private static float SPEED_VALUE = .3f;

	/**
	 * Costruttore dell'asteroide che prende in input l'istanza corrente
	 * del framework e un vettore che rappresenta la posizione.
	 * 
	 * @param framework    istanza corrente del framework
	 * @param position	   posizione su schermo
	 */
	public Asteroids(final Framework framework, Vector2 position) {
		super(framework, position, ENERGY_VALUE, SCORE_VALUE, DAMAGE_VALUE,
				SPEED_VALUE, PropertiesManager.getParameter("myAsteroid"),
				PropertiesManager.getParameter("explosion"));
	}

	@Override
	public void update(float delta) {
		super.update(delta);
		move(Direction.DOWN);
	}

}
