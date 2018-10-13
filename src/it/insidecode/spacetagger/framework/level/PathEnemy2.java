package it.insidecode.spacetagger.framework.level;

import it.insidecode.spacetagger.path.LineDirection;
import it.insidecode.spacetagger.path.LinePath;
import it.insidecode.spacetagger.path.Path;
import it.insidecode.spacetagger.path.Type;

import com.badlogic.gdx.math.Vector2;

/**
 * Path specifico del secondo nemico creato dalla concatenazione
 * di vari path.
 * 
 * @author Valentini.1612930
 *
 */
public class PathEnemy2 extends Path {
	private static final int val=400;
	private static final int val1=90;
	private static final int val2=240;
	
	private Path[] path;
	private Path delegate;
	private int current = 0;

	/**
	 * Costruttore del path che prende in input un'enumerazione e un booleano b
	 * che rappresenta quale dei due path (speculari) dovrà essere assegnato al 
	 * nemico.
	 * 
	 * @param type		direzione del path
	 * @param b			booleano di scelta
	 */
	public PathEnemy2(Type type,boolean b) {
		super();
		if(b)
		{
		path = new Path[] { new LinePath(LineDirection.DOWNLEFT,val/4),
				new LinePath(LineDirection.DOWNRIGHT, val1), new LinePath(LineDirection.LEFT,val), new LinePath(LineDirection.DOWNRIGHT,val/2),
				new LinePath(LineDirection.RIGHT,val/2), new LinePath(LineDirection.LEFT,val2), new LinePath(LineDirection.DOWN,val)};
		delegate = path[current];
		}
		else
		{
			path = new Path[] { new LinePath(LineDirection.DOWNRIGHT,val/4),
					new LinePath(LineDirection.DOWNLEFT, val1), new LinePath(LineDirection.RIGHT,val), new LinePath(LineDirection.DOWNLEFT,val/2),
					new LinePath(LineDirection.LEFT,val/2), new LinePath(LineDirection.RIGHT,val2), new LinePath(LineDirection.DOWN,val)};
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
