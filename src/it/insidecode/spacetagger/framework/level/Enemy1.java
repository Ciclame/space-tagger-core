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
 * Primo nemico del livello, molto semplice si muove in basso e
 * spara ad intervalli irregolari. Rappresenta il nemico di base
 * di tutto il livello.
 * 
 * @author Valentini.1612930
 *
 */
public class Enemy1 extends GfxEnemy
{
	private static Sound blasterSound = Gdx.audio.newSound(Gdx.files
			.internal((PropertiesManager.getParameter("blasterSound"))));
	private static float ENERGY_VALUE = 1;
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
	public Enemy1(Framework framework, Vector2 position) {
		super(framework, position, ENERGY_VALUE, SCORE_VALUE, DAMAGE_VALUE, SPEED_VALUE,
				PropertiesManager.getParameter("enemy1"),
				PropertiesManager.getParameter("boom3"));
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
		if(!isVisible())
			destroy();
	}
	
}
