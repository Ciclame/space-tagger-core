package it.insidecode.spacetagger.framework.level;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;

import it.insidecode.spacetagger.framework.Framework;
import it.insidecode.spacetagger.framework.Scene;
import it.insidecode.spacetagger.path.LineDirection;
import it.insidecode.spacetagger.path.LinePath;
import it.insidecode.spacetagger.util.SimpleCallback;


/**
 * Settima scena del livello.
 * 
 * @author Valentini.1612930
 *
 */
public class Scene7 extends Scene
{
	public static final String SCENE_NAME = "Scene 07";
	public static final int MAX_ENEMY = 20;
	
	private int enemies;
	
	/**
	 * Costruttore della scena che prende in input l'istanza
	 * corrente del framework. 
	 * 
	 * @param framework		istanza corrente del framework
	 */
	public Scene7(Framework framework) {
		super(framework);
	}
	
	@Override
	public void init() {
		Gdx.app.log(getName(), "init");
		int j = 0;
		for(int k=0; k<MAX_ENEMY; k++)
		{
			final int position = (int) (Math.random() * 400);
			countDown(j, new SimpleCallback() {
				@Override
				public void onComplete() {
					Enemy1 e = new Enemy1(framework, new Vector2(position, 600));
					e.setSpeed(2f);
					e.setPath(new LinePath(LineDirection.DOWN, 800));
					e.activate();
					enemies++;
				}
			});
			if(k%2==0)
			{
			countDown(j, new SimpleCallback() {

				@Override
				public void onComplete() {
					Asteroids e = new Asteroids(framework, new Vector2(position, 600));
					e.setSpeed(1f);
					e.setPath(new LinePath(LineDirection.DOWN, 800));
					e.activate();
				}
				
			});
			}
			j+=800;
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