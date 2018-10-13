package it.insidecode.spacetagger.framework.level;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;

import it.insidecode.spacetagger.framework.Framework;
import it.insidecode.spacetagger.framework.Scene;
import it.insidecode.spacetagger.logic.Direction;
import it.insidecode.spacetagger.logic.Enemy;
import it.insidecode.spacetagger.path.Type;
import it.insidecode.spacetagger.util.SimpleCallback;


/**
 * Ottava scena del livello.
 * 
 * @author Valentini.1612930
 *
 */
public class Scene8 extends Scene
{
	public static final String SCENE_NAME = "Scene 08";
	public static final int MAX_ENEMY = 16;
	
	private int enemies;
	
	/**
	 * Costruttore della scena che prende in input l'istanza
	 * corrente del framework. 
	 * 
	 * @param framework		istanza corrente del framework
	 */
	public Scene8(Framework framework) {
		super(framework);
	}
	
	@Override
	public void init() {
		Gdx.app.log(getName(), "init");
		int j = 0;
		
		for (int i=0; i<4; i++) {
			countDown(j, new SimpleCallback() {
				@Override
				public void onComplete() {
					Enemy4 e = new Enemy4(framework, new Vector2(430, 580));
					Enemy4 e1 = new Enemy4(framework, new Vector2(30,480));
					Enemy2 e2 = new Enemy2(framework, new Vector2(10, 600));
					Enemy2 e3 = new Enemy2(framework, new Vector2(480, 600));
					e.setSpeed(3f);
					e1.setSpeed(3f);
					e2.setSpeed(3f);
					e3.setSpeed(3f);
					e.setPath(new  PathEnemy4(true));
					e1.setPath(new  PathEnemy4(false));
					e2.setPath(new  PathEnemy2(Type.DOWNLEFT,false));
					e3.setPath(new  PathEnemy2(Type.DOWNRIGHT,true));
					e.activate();
					e1.activate();
					e2.activate();
					e3.activate();
					enemies+=4;
				}
			});
			j+=400;
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
		
		countDown(10000, new SimpleCallback() {

			@Override
			public void onComplete() {
				for(Enemy i:framework.getGameEngine().getEnemies())
					i.move(Direction.DOWN);
			}
		});
		
		super.update(delta);
	}
}
