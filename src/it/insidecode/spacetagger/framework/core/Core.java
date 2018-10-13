package it.insidecode.spacetagger.framework.core;

import it.insidecode.spacetagger.framework.Level;
import it.insidecode.spacetagger.framework.level.Level0;

public class Core {
	
	public static Class<? extends Level> getLevel()
	{
		return (Level0.class);
	}

}
