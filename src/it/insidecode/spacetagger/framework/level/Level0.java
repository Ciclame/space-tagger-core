package it.insidecode.spacetagger.framework.level;

import com.badlogic.gdx.math.Vector2;

import it.insidecode.spacetagger.PropertiesManager;
import it.insidecode.spacetagger.framework.Framework;
import it.insidecode.spacetagger.framework.Level;
import it.insidecode.spacetagger.graphics.ParallaxBackground;

/**
 * Classe che rappresenta il livello di gioco.
 * 
 * @author Valentini.1612930
 *
 */
public class Level0 extends Level {

	public static final String LEVEL_NAME = "Outer Space";
	public static final float SHIP_ENERGY = 15.0f;
	
	/**
	 * Costruttore del livello che prende in input l'istanza 
	 * corrente del framework e invoca il super-costruttore 
	 * su di essa e su tutte le scene del livello. Inoltre, 
	 * setta anche la musica e il background del livello.
	 * 
	 * @param framework		istanza corrente del framework 
	 */
	public Level0(Framework framework) {
		super(framework,new Scene1(framework),new Scene2(framework),new Scene3(framework),new Scene4(framework),new Scene5(framework)
		,new Scene6(framework),new Scene7(framework),new Scene8(framework),new BossStage(framework),new DeadScene(framework));
		this.setStageMusic((PropertiesManager.getParameter("musicStage")));
	}

	@Override
	public String getName() {
		return LEVEL_NAME;
	}
	
	@Override
	public void init() {
		framework.getGameEngine().setBackground(new ParallaxBackground(PropertiesManager.getParameter("myBackground"),true));
		framework.getEnergyBar().setMaxEnergy(SHIP_ENERGY);
		framework.getEnergyBar().setMaxValue(framework.getEnergyBar().getMaxEnergy());
		framework.setShip(new MyShip(framework, new Vector2(210,130)));
		framework.getShip().setMaxEnergy(framework.getEnergyBar().getMaxEnergy());
		framework.getShip().setEnergy(framework.getShip().getMaxEnergy());
		framework.getGameEngine().getScoreManager().reset();
		super.init();
	}

}
