package it.insidecode.spacetagger.framework.level;

import it.insidecode.spacetagger.framework.Framework;
import it.insidecode.spacetagger.framework.Scene;
import it.insidecode.spacetagger.path.LineDirection;
import it.insidecode.spacetagger.path.LinePath;
import it.insidecode.spacetagger.util.SimpleCallback;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;

public class Scene01 extends Scene {
	public static final String SCENE_NAME = "Scene 0";

	private EnemyB enemy1;

	public Scene01(Framework framework) {
		super(framework);
	}

	public String getName() {
		return SCENE_NAME;
	}

	@Override
	public void init() {
		Gdx.app.log(getName(), "init");

		EnemyB e = new EnemyB(framework, new Vector2(200, 650));
		e.setSpeed(2f);
		e.setPath(new LinePath(LineDirection.DOWN, 700));
		e.activate();
		enemy1 = e;

		countDown(2500, new SimpleCallback() {
			@Override
			public void onComplete() {
				if (enemy1.isAlive())
					enemy1.shoot();
			}
		});

		countDown(1000, new SimpleCallback() {
			@Override
			public void onComplete() {
				EnemyB e = new EnemyB(framework, new Vector2(100, 650));
				e.setSpeed(2f);
				e.setPath(new LinePath(LineDirection.DOWN, 700));
				e.activate();

				e = new EnemyB(framework, new Vector2(300, 650));
				e.setSpeed(2f);
				e.setPath(new LinePath(LineDirection.DOWN, 700));
				e.activate();
			}
		});

		countDown(2000, new SimpleCallback() {
			@Override
			public void onComplete() {
				EnemyB e = new EnemyB(framework, new Vector2(50, 650));
				e.setSpeed(2f);
				e.setPath(new LinePath(LineDirection.DOWN, 700));
				e.activate();

				e = new EnemyB(framework, new Vector2(350, 650));
				e.setSpeed(2f);
				e.setPath(new LinePath(LineDirection.DOWN, 700));
				e.activate();
			}
		});

		countDown(2500, new SimpleCallback() {
			@Override
			public void onComplete() {
				EnemyB e = new EnemyB(framework, new Vector2(200, 650));
				e.setPath(new LinePath(LineDirection.DOWN, 700));
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
