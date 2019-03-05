package menu;


import java.io.File;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import view.PluginFrame;

public class PluginFinderObservableTest {
	PluginFrame pluginFrame;
	File directoryPluginsClass;
	
	@Before
	public void setUp() throws Exception {
		pluginFrame = new PluginFrame("pluginsTest");
		directoryPluginsClass = new File("bin/plugins/ToUpperCase.class");
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testAddPlugin() {
		
	}

}
