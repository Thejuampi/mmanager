package com.tj.mmanager.base.view;

import com.tj.mmanager.base.view.screen.MainScreen;
import com.vaadin.Application;
import com.vaadin.ui.Window;

public class MainApplication extends Application {
    private static final long serialVersionUID = -2719039325987214154L;

    private Window window;

    @Override
    public void init() {
	setTheme("applayout");
	window = new Window("mmanager");
	setMainWindow(window);
	window.addComponent(new MainScreen());
    }

}
