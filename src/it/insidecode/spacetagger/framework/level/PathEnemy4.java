package it.insidecode.spacetagger.framework.level;

import it.insidecode.spacetagger.path.LineDirection;
import it.insidecode.spacetagger.path.LinePath;
import it.insidecode.spacetagger.path.Path;

import com.badlogic.gdx.math.Vector2;

/**
 * Path specifico del nemico numero quattro creato a 
 * partire da path semplici concatenati tra loro.
 * 
 * @author Valentini.1612930
 *
 */
public class PathEnemy4 extends Path {
	private Path[] path;
	private Path delegate;
	private int current = 0;
	private static final int val=400;

	/**
	 * Costruttore che prende in input un booleano che rappresenta
	 * quale dei due path (speculari) dovrà essere assegnato al nemico.
	 * 
	 * @param b		booleano di scelta
	 */
	public PathEnemy4(boolean b) {
		super();
		if(b)
		{
			path = new Path[] { new LinePath(LineDirection.LEFT,val),new LinePath(LineDirection.RIGHT,val)};
			delegate = path[current];
		}
		else
		{
			path = new Path[] { new LinePath(LineDirection.RIGHT,val),new LinePath(LineDirection.LEFT,val)};
			delegate = path[current];
		}
	}
	

	@Override
	public Vector2 getNextPositionIncrement(float speed) {
		if (delegate.isComplete()) {
			if ((current + 1) >= path.length) {
				for (Path x : path)
					x.reset();
				current = -1;
			}
			delegate = path[++current];
		}
		return delegate.getNextPositionIncrement(speed);
	}

	@Override
	public boolean isComplete() {
		return current == path.length && delegate.isComplete();
	}

	@Override
	public float getX(float speed) {
		return 0;
	}

	@Override
	public float getY(float speed) {
		return 0;
	}

	@Override
	public void reset() {
		current = 0;
	}

}
