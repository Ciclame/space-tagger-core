package it.insidecode.spacetagger.framework.level;

import java.util.Random;

import com.badlogic.gdx.math.Vector2;

import it.insidecode.spacetagger.PropertiesManager;
import it.insidecode.spacetagger.framework.Framework;
import it.insidecode.spacetagger.framework.GfxEnemy;
import it.insidecode.spacetagger.path.LineDirection;
import it.insidecode.spacetagger.path.LinePath;
import it.insidecode.spacetagger.util.Constants;

/**
 * Quinto nemico, in ordine di apparizione, che si muoverà a destra e 
 * a sinistra nella parte alta dello schermo e rilascerà ad intervalli
 * irregolari dei nemici "bomba".
 * 
 * @author Valentini.1612930
 *
 */
public class Enemy5 extends GfxEnemy

{
	private static float ENERGY_VALUE = (float) 10;
	private static int SCORE_VALUE = 4000;
	private static float DAMAGE_VALUE = 10;
	private static float SPEED_VALUE = Constants.ENEMY_A_SPEED;
	private static int TIME = 1000;

	private int timer = TIME;
	private Framework framework;
	private Bomb e;

	/**
	 * Costruttore del nemico che prende in input l'istanza corrente
	 * del framework e il vettore che rappresenta la posizione del 
	 * nemico.
	 * 
	 * @param framework		istanza del framework
	 * @param position		posizione a schermo
	 */
	public Enemy5(Framework framework, Vector2 position) {
		super(framework, position, ENERGY_VALUE, SCORE_VALUE, DAMAGE_VALUE, SPEED_VALUE,
				PropertiesManager.getParameter("enemy5"),
				PropertiesManager.getParameter("boom2"));
		this.framework=framework;
	}
	
	@Override
	public void update(float delta) {
		super.update(delta);
		if ((timer += delta) > TIME) {
			timer = -new Random().nextInt(1000);
			if (isAlive())
			{
				e = new Bomb(framework,new Vector2(getCenter()));
				e.setSpeed(3f);
				e.setPath(new  LinePath(LineDirection.DOWN, 800));
				e.activate();
			}
		}
		if(!isVisible() )
			destroy();
	}
	
}
