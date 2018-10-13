package it.insidecode.spacetagger.framework.level;

import com.badlogic.gdx.math.Vector2;

import it.insidecode.spacetagger.PropertiesManager;
import it.insidecode.spacetagger.framework.Framework;
import it.insidecode.spacetagger.framework.GfxEnemy;
import it.insidecode.spacetagger.logic.DynamicPhysicsEntity;
import it.insidecode.spacetagger.util.Constants;

/**
 * Bomba sganciata dall'Enemy5 a tempo definito nella scena
 * @author Valentini.1612930
 */
public class Bomb extends GfxEnemy
{
	private static float ENERGY_VALUE = (float) 0.5;
	private static int SCORE_VALUE = 100;
	private static float DAMAGE_VALUE = .5f;
	private static float SPEED_VALUE = Constants.ENEMY_A_SPEED;

	/**
	 * Costruttore della bomba che prende in input l'istanza corrente del framework
	 * e un vettore che rappresenta la posizione del nemico.
	 * @param framework		istanza corrente del framework
	 * @param position		vettore posizione
	 */
	public Bomb(Framework framework, Vector2 position) {
		super(framework, position, ENERGY_VALUE, SCORE_VALUE, DAMAGE_VALUE, SPEED_VALUE,
				PropertiesManager.getParameter("bomb"),
				PropertiesManager.getParameter("explosion"));
	}
		
	@Override
	public void update(float delta) {
		super.update(delta);
	}
	
	@Override
	public void handleContact(DynamicPhysicsEntity x) {
		if(x instanceof Enemy5) return;
		super.handleContact(x);
	}
	
}