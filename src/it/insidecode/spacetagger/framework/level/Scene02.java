package it.insidecode.spacetagger.framework.level;

import it.insidecode.spacetagger.framework.Framework;
import it.insidecode.spacetagger.framework.Scene;
import it.insidecode.spacetagger.path.VerticalCosPath;
import it.insidecode.spacetagger.util.SimpleCallback;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;

public class Scene02 extends Scene {
	public static final String SCENE_NAME = "Scene 0";

	public Scene02(Framework framework) {
		super(framework);
	}

	public String getName() {
		return SCENE_NAME;
	}

	@Override
	public void init() {
		Gdx.app.log(getName(), "init");

		EnemyA e = new EnemyA(framework, new Vector2(200, 650));
		e.setPath(new VerticalCosPath(100, 100, 700));
		e.activate();

		countDown(1500, new SimpleCallback() {
			@Override
			public void onComplete() {
				EnemyA e = new EnemyA(framework, new Vector2(150, 650));
				e.setSpeed(2f);
				e.setPath(new VerticalCosPath(100, 100, 700));
				e.activate();
				Asteroid a = new Asteroid(framework, new Vector2(200, 650));
				a.activate();
			}
		});

		countDown(1800, new SimpleCallback() {
			@Override
			public void onComplete() {
				EnemyA e = new EnemyA(framework, new Vector2(250, 650));
				e.setSpeed(2.5f);
				e.setPath(new VerticalCosPath(100, 100, 700));
				e.activate();
			}
		});

		countDown(4500, new SimpleCallback() {
			@Override
			public void onComplete() {
				EnemyA e = new EnemyA(framework, new Vector2(150, 650));
				e.setSpeed(2f);
				e.setPath(new CompositePath2(80, 80));
				e.activate();
			}
		});

		countDown(4800, new SimpleCallback() {
			@Override
			public void onComplete() {
				EnemyA e = new EnemyA(framework, new Vector2(350, 650));
				e.setSpeed(2f);
				e.setPath(new CompositePath2(100, 100));
				e.activate();
			}
		});

		countDown(5100, new SimpleCallback() {
			@Override
			public void onComplete() {
				EnemyA e = new EnemyA(framework, new Vector2(250, 650));
				e.setSpeed(2.5f);
				e.setPath(new CompositePath2(80, 80));
				e.activate();
			}
		});
	}

	@Override
	public void dispose() {
		Gdx.app.log(getName(), "dispose");

	}

	public void update(float delta) {
		if (framework.getGameEngine().getEnemies().isEmpty())
			getLevel().goToNextScene();

		super.update(delta);
	}

}
