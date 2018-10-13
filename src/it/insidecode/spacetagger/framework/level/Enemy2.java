package it.insidecode.spacetagger.framework.level;

import com.badlogic.gdx.math.Vector2;

import it.insidecode.spacetagger.PropertiesManager;
import it.insidecode.spacetagger.framework.Framework;
import it.insidecode.spacetagger.framework.GfxEnemy;
import it.insidecode.spacetagger.util.Constants;

/**
 * Secondo nemico, in ordine di apparizione, del livello. La sua 
 * caratteristica peculiare è quella di non sparare e di avere
 * un path composto.
 * 
 * @author Valentini.1612930
 *
 */
public class Enemy2 extends GfxEnemy
{
	private static float ENERGY_VALUE = 1;
	private static int SCORE_VALUE = 250;
	private static float DAMAGE_VALUE = .5f;
	private static float SPEED_VALUE = Constants.ENEMY_A_SPEED;

	/**
	 * Costruttore del nemico che prende in input l'istanza corrente
	 * del framework e il vettore che rappresenta la posizione del 
	 * nemico.
	 * 
	 * @param framework		istanza del framework
	 * @param position		posizione a schermo
	 */
	public Enemy2(Framework framework, Vector2 position) {
		super(framework, position, ENERGY_VALUE, SCORE_VALUE, DAMAGE_VALUE, SPEED_VALUE,
				PropertiesManager.getParameter("enemy2"),
				PropertiesManager.getParameter("boom2"));
	}
	
	@Override
	public void update(float delta) {
		super.update(delta);
		if(!isVisible())
			destroy();
	}
}
