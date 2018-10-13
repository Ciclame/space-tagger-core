package it.insidecode.spacetagger.framework.level;

import it.insidecode.spacetagger.path.LineDirection;
import it.insidecode.spacetagger.path.Path;
import it.insidecode.spacetagger.path.LinePath;

import com.badlogic.gdx.math.Vector2;

/**
 * Path per il boss finale che, come suggerisce il nome, prende
 * spunto dalla lettera L dell'alfabeto per far muovere l'entità.
 * 
 * @author Valentini.1612930
 *
 */
public class LPath extends Path {

	private static final int val = 200;

	private Path[] path;
	private Path delegate;
	private int current = 0;

	/**
	 * Costruttore del path che prende in input un booleano che 
	 * rappresenta il tipo di path scelto: essi sono speculari e
	 * dipendono essenzialmente dalla posizione in cui il nemico 
	 * verrà creato.
	 * 
	 * @param b		booleano di scelta
	 */
	public LPath(boolean b) {
		super();
		if(b) {
		path = new Path[] { new LinePath(LineDirection.LEFT, val), new LinePath(LineDirection.DOWN, val), new LinePath(LineDirection.RIGHT,val) };
		delegate = path[current];
		}
		else {
			path = new Path[] { new LinePath(LineDirection.RIGHT, val), new LinePath(LineDirection.DOWN, val), new LinePath(LineDirection.LEFT,val) };
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
	protected float getX(float arg0) {
		return 0;
	}

	@Override
	protected float getY(float arg0) {
		return 0;
	}

}