package it.insidecode.spacetagger.framework.level;

import it.insidecode.spacetagger.path.HalfCirclePath;
import it.insidecode.spacetagger.path.LineDirection;
import it.insidecode.spacetagger.path.Path;
import it.insidecode.spacetagger.path.Type;
import it.insidecode.spacetagger.path.LinePath;

import com.badlogic.gdx.math.Vector2;

/**
 * Path che, come suggrisce il nome, prende spunto dalla lettera
 * R dell'alfabeto per far muovere l'entità. Questo path sarà
 * usato solo dal boss finale.
 * 
 * @author Valentini.1612930
 *
 */
public class RPath extends Path {

	private static final int val = 100;

	private Path[] path;
	private Path delegate;
	private int current = 0;

	/**
	 * Costruttore del path che prende in input un booleano che
	 * rappresenta quale dei due path (speculari) dovrà essere
	 * assegnato al boss finale.
	 * 
	 * @param b		booleano di scelta
	 */
	public RPath(boolean b) {
		super();
		if(b) {
		path = new Path[] { new HalfCirclePath(Type.DOWNLEFT, val, val), new LinePath(LineDirection.DOWNRIGHT, 100) };
		delegate = path[current];
		}
		else {
			path = new Path[] { new HalfCirclePath(Type.DOWNRIGHT, val, val), new LinePath(LineDirection.DOWNLEFT, 100) };
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