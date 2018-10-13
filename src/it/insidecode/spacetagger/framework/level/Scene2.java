package it.insidecode.spacetagger.framework.level;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;

import it.insidecode.spacetagger.framework.Framework;
import it.insidecode.spacetagger.framework.Scene;
import it.insidecode.spacetagger.path.Type;
import it.insidecode.spacetagger.util.SimpleCallback;


/**
 * Seconda scena del livello.
 * 
 * @author Valentini.1612930
 *
 */
public class Scene2 extends Scene
{
	public static final String SCENE_NAME = "Scene 02";
	public static final int MAX_ENEMY = 20;
	private int enemies;
	
	/**
	 * Costruttore della scena che prende in input l'istanza
	 * corrente del framework. 
	 * 
	 * @param framework		istanza corrente del framework
	 */
	public Scene2(Framework framework) {
		super(framework);
	}
	
	@Override
	public void init() {
		Gdx.app.log(getName(), "init");
		int j = 0;
		
		for (int i=0; i<MAX_ENEMY/2; i++) {
			
			countDown(j, new SimpleCallback() {
				@Override
				public void onComplete() {
					Enemy2 e = new Enemy2(framework, new Vector2(10, 600));
					e.setSpeed(3f);
					e.setPath(new  PathEnemy2(Type.DOWNLEFT,false));
					e.activate();
					Enemy2 e1 = new Enemy2(framework, new Vector2(480, 600));
					e1.setSpeed(3f);
					e1.setPath(new  PathEnemy2(Type.DOWNRIGHT,true));
					e1.activate();
					enemies+=2;
				}
			});
			j+=500;
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
