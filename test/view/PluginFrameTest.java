package view;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class PluginFrameTest {
	PluginFrame pluginFrame;
	
	@Before
	public void setUp() throws Exception {
		pluginFrame = new PluginFrame("pluginsTest");
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testInit() {
		assertNotNull(pluginFrame.menu_file);
		assertNotNull(pluginFrame.menu_help);
		assertNotNull(pluginFrame.menu_tools);
		assertNotNull(pluginFrame.menuBar);
		assertNotNull(pluginFrame.textArea);
	}

}
