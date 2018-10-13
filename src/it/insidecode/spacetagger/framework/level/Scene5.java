package it.insidecode.spacetagger.framework.level;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;

import it.insidecode.spacetagger.framework.Framework;
import it.insidecode.spacetagger.framework.Scene;
import it.insidecode.spacetagger.util.SimpleCallback;


/**
 * Quinta scena del livello.
 * 
 * @author Valentini.1612930
 *
 */
public class Scene5 extends Scene
{
	public static final String SCENE_NAME = "Scene 05";
	public static final int MAX_ENEMY = 2;
	private int enemies;
	
	/**
	 * Costruttore della scena che prende in input l'istanza
	 * corrente del framework. 
	 * 
	 * @param framework		istanza corrente del framework
	 */
	public Scene5(Framework framework) {
		super(framework);
	}
	
	@Override
	public void init() {
		Gdx.app.log(getName(), "init");
		int j = 500;
		
		for (int i=0; i<MAX_ENEMY; i++) {
			
			countDown(j, new SimpleCallback() {
				@Override
				public void onComplete() {
					Enemy5 e = new Enemy5(framework, new Vector2(10, 500));
					e.setSpeed(3f);
					e.setPath(new  PathEnemy4(false));
					e.activate();
					enemies++;
				}
			});
			j+=1500;
		}	
	}
	
	@Override
	public void dispose() {
		Gdx.app.log(getName(), "dispose");	
	}

	@Override
	public String getName() {
		return SCENE_NAME;
	}

	@Override
	public void update(float delta) {
		if(framework.getGameEngine().getEnemies().isEmpty() && enemies==MAX_ENEMY) 
			getLevel().goToNextScene();
		super.update(delta);
	}
}
