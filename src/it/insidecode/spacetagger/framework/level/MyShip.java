package it.insidecode.spacetagger.framework.level;

import com.badlogic.gdx.math.Vector2;

import it.insidecode.spacetagger.PropertiesManager;
import it.insidecode.spacetagger.framework.Framework;
import it.insidecode.spacetagger.framework.GfxShip;
import it.insidecode.spacetagger.graphics.Animation;
import it.insidecode.spacetagger.graphics.AnimationType;

/**
 * Classe che rappresenta la navicella che accompagnerà
 * il giocatore durante tutto il livello.
 * 
 * @author Valentini.1612930
 *
 */
public class MyShip extends GfxShip
{
	  private static  Animation animIdle = Animation.createAnimation(PropertiesManager.getParameter("myShipIdle"), AnimationType.NORMAL);
	  private static  Animation animFromLeft = Animation.createAnimation(PropertiesManager.getParameter("myShipFromLeft"), AnimationType.NORMAL);
	  private static  Animation animFromRight = Animation.createAnimation(PropertiesManager.getParameter("myShipFromRight"), AnimationType.NORMAL);
	  private static  Animation animLeft =  Animation.createAnimation(PropertiesManager.getParameter("myShipLeft"), AnimationType.NORMAL);
	  private static  Animation animRight =  Animation.createAnimation(PropertiesManager.getParameter("myShipRight"), AnimationType.NORMAL);
	  private static  Animation deadAnim =  Animation.createAnimation(PropertiesManager.getParameter("explosion"), AnimationType.NORMAL);
      
	/**
	 * Costruttore della navicella che prende in input l'istanza corrente del framework ù
	 * e un vettore che rappresenta la posizione iniziale della navicella. Inoltre, si
	 * occupa di settare tutte le varie animazioni della navicella. 
	 * 
	 * @param framework		istanza corrente del frameowrk
	 * @param v				vettore posizione iniziale della navicella
	 */
	public MyShip(Framework framework, Vector2 v) {
		super(framework, v, animIdle, animFromLeft, animFromRight, animLeft, animRight, deadAnim);
	}

}
