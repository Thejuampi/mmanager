package com.tj.mmanager.base.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.tj.mmanager.base.view.screen.MainScreen;
import com.vaadin.Application;
import com.vaadin.ui.Window;

@Component
@Scope("prototype")
public class MainApplication extends Application {
    private static final long serialVersionUID = -2719039325987214154L;

    private Window window;
    @Autowired
//    private MainScreen mainScreen;

    @Override
    public void init() {
	setTheme("applayout");
	window = new Window("mmanager");
	setMainWindow(window);
	//@SuppressWarnings("unused")
	//SpringContextHelper helper = new SpringContextHelper(this);
	//mainScreen = (MainScreen) helper.getBean("mainScreen");
	//window.addComponent(mainScreen);
    }

}
