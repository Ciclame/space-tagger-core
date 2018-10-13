package it.insidecode.spacetagger.framework.level;

import it.insidecode.spacetagger.framework.Framework;
import it.insidecode.spacetagger.framework.Scene;
import it.insidecode.spacetagger.logic.Direction;
import it.insidecode.spacetagger.logic.Enemy;
import it.insidecode.spacetagger.path.LineDirection;
import it.insidecode.spacetagger.path.LinePath;
import it.insidecode.spacetagger.util.SimpleCallback;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;

/**
 * Quarta scena del livello.
 * 
 * @author Valentini.1612930
 *
 */
public class Scene4 extends Scene
{
	public static final String SCENE_NAME = "Scene 04";
	public static final int MAX_ENEMY = 16;
	private int enemies;
	
	/**
	 * Costruttore della scena che prende in input l'istanza
	 * corrente del framework. 
	 * 
	 * @param framework		istanza corrente del framework
	 */
	public Scene4(Framework framework) {
		super(framework);
	}
	
	@Override
	public void init() {
		Gdx.app.log(getName(), "init");
		int j = 0;
		
		for (int i=0; i<MAX_ENEMY/4; i++) {
			countDown(j, new SimpleCallback() {
				@Override
				public void onComplete() {
					Enemy4 e = new Enemy4(framework, new Vector2(480, 580));
					Enemy4 e1 = new Enemy4(framework, new Vector2(0, 580));
					e.setSpeed(3f);
					e1.setSpeed(3f);
					e.setPath(new  PathEnemy4(true));
					e1.setPath(new  PathEnemy4(false));
					e.activate();
					e1.activate();
					enemies+=2;
				}
			});
			j+=400;
		}

		
		countDown(6000, new SimpleCallback() {
			@Override
			public void onComplete() {
				int k=0;
				for(int i=0; i<5; i++)
				{
					Enemy4 e = new Enemy4(framework, new Vector2(k, 640));
					e.setSpeed(1.5f);
					e.setPath(new  LinePath(LineDirection.DOWN, 5));
					e.activate();
					enemies++;
					k+=110;
				}			
			}
		});
		
		countDown(8000, new SimpleCallback() {
			@Override
			public void onComplete() {
				int k=110;
				for(int i=0; i<3; i++)
				{
					Enemy4 e = new Enemy4(framework, new Vector2(k, 640));
					e.setSpeed(1.5f);
					e.setPath(new  LinePath(LineDirection.DOWN, 5));
					e.activate();
					enemies++;
					k+=110;
				}			
			}
		});
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
		countDown(3000, new SimpleCallback() {

			@Override
			public void onComplete() {
				for(Enemy i:framework.getGameEngine().getEnemies())
				{
					i.move(Direction.DOWN);
				}
			}
		});
		super.update(delta);
	}
}