package it.insidecode.spacetagger.framework.level;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;

import it.insidecode.spacetagger.framework.Framework;
import it.insidecode.spacetagger.framework.GfxText;
import it.insidecode.spacetagger.framework.Scene;
import it.insidecode.spacetagger.path.LineDirection;
import it.insidecode.spacetagger.path.LinePath;
import it.insidecode.spacetagger.util.SimpleCallback;

/**
 * La scena di morte, ovvero quella che rappresenta il fallimento
 * dell'impresa del giocatore. Verranno rilasciato una fila inevitabile 
 * di power-down "morte istantanea" con risata diabolica di sottofondo e
 * testo denigratorio a schermo.
 * 
 * @author Valentini.1612930
 *
 */
public class DeadScene extends Scene
{
	public static final String SCENE_NAME = "Scene 01";
	public static final int MAX_ENEMY = 10;
	private GfxText t = new GfxText(framework, "See you....", new SimpleCallback() {
		@Override
		public void onComplete() {
			return;
			}
		});
	
	public DeadScene(Framework framework) {
		super(framework);
	}
	
	public String getName() {
		return SCENE_NAME;
	}
	
	@Override
	public void init() {
		Gdx.app.log(getName(), "init");
		t.activate();
		int position=0;
		for(int k=0; k<MAX_ENEMY; k++) {
			DeathPowerUp p = new DeathPowerUp(framework, new Vector2(position, 650));
			p.setSpeed(2f);
			p.setPath(new LinePath(LineDirection.DOWN, 800));
			p.activate();
			position+=70;
		}
	}
		

	@Override
	public void dispose() {
		Gdx.app.log(getName(), "dispose");
	}
	
	@Override
	public void update(float delta) {
		super.update(delta);
	}
	
}
