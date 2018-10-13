package it.insidecode.spacetagger.framework.level;

import java.util.ArrayList;
import java.util.Random;

import com.badlogic.gdx.math.Vector2;

import it.insidecode.spacetagger.PropertiesManager;
import it.insidecode.spacetagger.framework.Framework;
import it.insidecode.spacetagger.framework.GfxEnemy;
import it.insidecode.spacetagger.logic.DynamicPhysicsEntity;
import it.insidecode.spacetagger.path.LineDirection;
import it.insidecode.spacetagger.path.LinePath;
import it.insidecode.spacetagger.path.Path;
import it.insidecode.spacetagger.shots.Shot;
import it.insidecode.spacetagger.util.Constants;

/**
 * Boss finale: per ogni volta che verrà colpito resetterà la sua 
 * posizione, cambierà il suo path in modo casuale scegliendo in una
 * lista predefinita di path. Se il giocatore non riuscirà ad interrompere 
 * la sua avanzata verranno rilasciati una fila di power-down "morte istantanea".
 * @author Valentini.1612930
 *
 */
public class Boss extends GfxEnemy
{
	private static float ENERGY_VALUE = 10;
	private static int SCORE_VALUE = 10000;
	private static float DAMAGE_VALUE = .5f;
	private static float SPEED_VALUE = Constants.ENEMY_A_SPEED;
	private static final ArrayList <Path> PATHS = new ArrayList <>();


	/**
	 * Costruttore del boss che prende in input l'istanza corrente
	 * del framework e un vettore che rappresenta la posizione e 
	 * aggiunge i path alla lista.
	 * 
	 * @param framework    istanza corrente del framework
	 * @param position	   posizione su schermo
	 */
	public Boss(Framework framework, Vector2 position) {
		super(framework, position, ENERGY_VALUE, SCORE_VALUE, DAMAGE_VALUE, SPEED_VALUE,
				PropertiesManager.getParameter("snake"),
				PropertiesManager.getParameter("explosion"));
		PATHS.add(new LinePath(LineDirection.DOWN,1000));
		PATHS.add(new TypeSPath(true));
		PATHS.add(new TypeSPath(false));
		PATHS.add(new RPath(true));
		PATHS.add(new RPath(false));
		PATHS.add(new LPath(true));
		PATHS.add(new LPath(false));
	}
	
	@Override
	public void handleContact(DynamicPhysicsEntity x) {	
		if(x instanceof Shot)
		{
			this.setSpeed(getSpeed()+getSpeed()/5);
			this.setPosition(new Vector2(200,560));
			int k=new Random().nextInt(7);
			this.setPath(PATHS.get(k));
			}
		super.handleContact(x);
	} 
	
}
