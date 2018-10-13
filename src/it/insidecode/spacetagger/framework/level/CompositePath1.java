package it.insidecode.spacetagger.framework.level;

import it.insidecode.spacetagger.path.HalfCirclePath;
import it.insidecode.spacetagger.path.LineDirection;
import it.insidecode.spacetagger.path.LinePath;
import it.insidecode.spacetagger.path.Path;
import it.insidecode.spacetagger.path.Type;

import com.badlogic.gdx.math.Vector2;

public class CompositePath1 extends Path {

	private static final int sinHeight = 100;
	private static final int sinWidth = 150;

	private Path[] path;
	private Path delegate;
	private int current = 0;

	public CompositePath1(Type type) {
		super();
		path = new Path[] { new HalfCirclePath(type, sinHeight, sinWidth),
				new LinePath(LineDirection.DOWN, 0) };
		delegate = path[current];
	}

	@Override
	public Vector2 getNextPositionIncrement(float speed) {
		if (delegate.isComplete()) {
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
