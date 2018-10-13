package it.insidecode.spacetagger.framework.level;

import it.insidecode.spacetagger.PropertiesManager;
import it.insidecode.spacetagger.framework.Framework;
import it.insidecode.spacetagger.framework.GfxPowerUp;

import com.badlogic.gdx.math.Vector2;

public class EnergyPowerUp extends GfxPowerUp {

	private static float ENERGY = 1;

	private Framework framework;

	public EnergyPowerUp(Framework f, Vector2 center) {
		super(f, center, PropertiesManager.getParameter("energyPowerUp"));
		this.setCenter(center);
		this.framework = f;
	}

	@Override
	public void apply() {
		framework.getShip().setEnergy(framework.getShip().getEnergy() + ENERGY);
	}

}
