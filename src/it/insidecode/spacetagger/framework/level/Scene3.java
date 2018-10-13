package it.insidecode.spacetagger.framework.level;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;

import it.insidecode.spacetagger.framework.Framework;
import it.insidecode.spacetagger.framework.Scene;
import it.insidecode.spacetagger.path.LineDirection;
import it.insidecode.spacetagger.path.LinePath;
import it.insidecode.spacetagger.util.SimpleCallback;


/**
 * Terza scena del livello
 * @author Valentini.1612930
 *
 */
public class Scene3 extends Scene
{

	public static final String SCENE_NAME = "Scene 03";
	public static final int MAX_ENEMY = 15;
	private int asteroids;
	
	/**
	 * Costruttore della scena che prende in input l'istanza
	 * corrente del framework. 
	 * 
	 * @param framework		istanza corrente del framework
	 */
	public Scene3(Framework framework) {
		super(framework);
	}
	
	public String getName() {
		return SCENE_NAME;
	}

	@Override
	public void init() {
		Gdx.app.log(getName(), "init");
		int j = 1000;
		
		for(int k=0; k<MAX_ENEMY; k++)
		{
			final int position1 = (int) (Math.random() * 400);
			countDown(j, new SimpleCallback() {
				@Override
				public void onComplete() {
					Asteroids e = new Asteroids(framework, new Vector2(position1, 600));
					e.setSpeed(1f);
					e.setPath(new LinePath(LineDirection.DOWN, 800));
					e.activate();
					asteroids++;
				}
			});
			j+=1000;
		}
		
	}
	
	@Override
	public void dispose() {
		Gdx.app.log(getName(), "dispose");
	}
	
	@Override
	public void update(float delta) {
		
		if (framework.getGameEngine().getEnemies().isEmpty() && asteroids==MAX_ENEMY) {
			EnergyPowerUp p = new EnergyPowerUp(framework, new Vector2(240, 650));
			p.activate();
			getLevel().goToNextScene();
		}	
		super.update(delta);
	}
}
