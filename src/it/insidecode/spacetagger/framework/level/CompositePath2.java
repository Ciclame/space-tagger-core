package it.insidecode.spacetagger.framework.level;

import it.insidecode.spacetagger.path.LineDirection;
import it.insidecode.spacetagger.path.LinePath;
import it.insidecode.spacetagger.path.Path;

import com.badlogic.gdx.math.Vector2;

public class CompositePath2 extends Path {

	private Path[] path;
	private Path delegate;
	private int current = 0;

	public CompositePath2(int val1, int val2) {
		path = new Path[] { new LinePath(LineDirection.DOWN, val1),
				new LinePath(LineDirection.RIGHT, val2),
				new LinePath(LineDirection.DOWN, val1),
				new LinePath(LineDirection.LEFT, val2) };
		delegate = path[current];
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

	@Override
	public boolean isComplete() {
		return current == path.length && delegate.isComplete();
	}

}
