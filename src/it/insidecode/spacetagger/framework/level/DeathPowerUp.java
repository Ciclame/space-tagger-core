package it.insidecode.spacetagger.framework.level;

import it.insidecode.spacetagger.PropertiesManager;
import it.insidecode.spacetagger.framework.Framework;
import it.insidecode.spacetagger.framework.GfxPowerUp;

import com.badlogic.gdx.math.Vector2;

/**
 * Power-down "morte istantanea" che, come suggerito dal nome,
 * una volta raccolto distruggerà la navicella del giocatore.
 * 
 * @author Valentini.1612930
 *
 */
public class DeathPowerUp extends GfxPowerUp {

	private Framework framework;

	/**
	 * Costruttore del power-down che prende in input l'istanza
	 * corrente del framework e un vettore che rappresenta la
	 * posizione del power-down.
	 * 
	 * @param f		istanza corrente del framework
	 * @param center	vettore posizione centrale
	 */
	public DeathPowerUp(Framework f, Vector2 center) {
		super(f, center, PropertiesManager.getParameter("deathPowerUp"));
		this.setCenter(center);
		this.framework = f;
	}

	@Override
	public void apply() {
		framework.getShip().destroy();
	}

}
