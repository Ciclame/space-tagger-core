package it.insidecode.spacetagger.framework.level;

import java.util.Random;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.math.Vector2;

import it.insidecode.spacetagger.PropertiesManager;
import it.insidecode.spacetagger.framework.Framework;
import it.insidecode.spacetagger.framework.GfxEnemy;
import it.insidecode.spacetagger.shots.Shot;
import it.insidecode.spacetagger.util.Constants;

/**
 * Quarto nemico, in ordine di apparizione, che possiede anch'esso un
 * path composto e sparerà ad intervalli irregolari.
 * 
 * @author Valentini.1612930
 *
 */
public class Enemy4 extends GfxEnemy
{

	private static Sound blasterSound = Gdx.audio.newSound(Gdx.files
			.internal((PropertiesManager.getParameter("blasterSound"))));
	private static float ENERGY_VALUE = (float) 1;
	private static int SCORE_VALUE = 500;
	private static float DAMAGE_VALUE = .2f;
	private static float SPEED_VALUE = Constants.ENEMY_A_SPEED;
	private static int TIME = 1000;

	private int timer = TIME;

	/**
	 * Costruttore del nemico che prende in input l'istanza corrente
	 * del framework e il vettore che rappresenta la posizione del 
	 * nemico.
	 * 
	 * @param framework		istanza del framework
	 * @param position		posizione a schermo
	 */
	public Enemy4(Framework framework, Vector2 position) {
		super(framework, position, ENERGY_VALUE, SCORE_VALUE, DAMAGE_VALUE, SPEED_VALUE,
				PropertiesManager.getParameter("enemy4"),
				PropertiesManager.getParameter("boom"));
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
		if(!isVisible() )
			destroy();
	}
	
}
