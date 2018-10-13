package it.insidecode.spacetagger.framework.level;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.math.Vector2;

import it.insidecode.spacetagger.PropertiesManager;
import it.insidecode.spacetagger.framework.Framework;
import it.insidecode.spacetagger.framework.GfxText;
import it.insidecode.spacetagger.framework.Scene;
import it.insidecode.spacetagger.path.LineDirection;
import it.insidecode.spacetagger.path.LinePath;
import it.insidecode.spacetagger.util.SimpleCallback;

/**
 * Scena finale in cui compare il boss di fine livello: appena comparsa, 
 * ci sarà una scritta che indicherà l'arrivo del boss(palese citazione
 * al Signore degli Anelli).
 * @author Valentini.1612930
 *
 */
public class BossStage extends Scene
{
	private static Sound evilLaugh = Gdx.audio.newSound(Gdx.files
			.internal((PropertiesManager.getParameter("evilLaugh"))));
	public static final String SCENE_NAME = "Scene 01";
	public static final int MAX_ENEMY = 1;
	private Boss b;
	private GfxText t = new GfxText(framework, "YOU \nSHALL \nNOT \nPASS !", new SimpleCallback() {
							@Override
							public void onComplete() {
								return;
								}
							});
	
	
	
	/**
	 * Costruttore della scena che prende in input l'istanza
	 * corrente del framework.
	 * @param framework		istanza corrente del framework
	 */
	public BossStage(Framework framework) {
		super(framework);
	}
	
	public String getName() {
		return SCENE_NAME;
	}
	
	@Override
	public void init() {
		Gdx.app.log(getName(), "init");
		framework.getShip().setBeam(false);
		t.activate();
		Boss e = new Boss(framework, new Vector2(200,560));
		e.setSpeed(2f);
		e.setPath(new LinePath(LineDirection.DOWN,200));
		e.activate();
		b=e;
	}
		

	@Override
	public void dispose() {
		Gdx.app.log(getName(), "dispose");
	}
	
	@Override
	public void update(float delta) {
		
		if(!b.isVisible()) {
			countDown(1500, new SimpleCallback() {

				@Override
				public void onComplete() {
						evilLaugh.play();
						getLevel().goToScene(9);
				}
			});
			
		}
		if(b.getEnergy()==0) {
			framework.restart();
		}
		super.update(delta);
	}
	
}