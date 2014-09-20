package com.tj.mmanager.base.view;

import org.springframework.beans.factory.annotation.Configurable;

import com.tj.mmanager.base.view.screen.MainScreen;
import com.vaadin.Application;
import com.vaadin.ui.Window;

public class MainApplication extends Application {
    private static final long serialVersionUID = -2719039325987214154L;

    //private Window window;
    private MainScreen mainScreen;

    @Override
    public void init() {
	setTheme("applayout");
	final Window window = new Window("mmanager");
	setMainWindow(window);
	//@SuppressWarnings("unused")
	SpringContextHelper helper = new SpringContextHelper(this);
	mainScreen = (MainScreen) helper.getBean("mainScreen");
	window.addComponent(mainScreen);
    }

}
