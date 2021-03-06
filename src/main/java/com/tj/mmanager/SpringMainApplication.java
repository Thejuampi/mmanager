
package com.tj.mmanager;

import org.apache.log4j.Logger;
import org.dellroad.stuff.vaadin.SpringContextApplication;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.aspectj.EnableSpringConfigured;
import org.springframework.web.context.ConfigurableWebApplicationContext;

import com.tj.mmanager.base.view.screen.MainScreen;
import com.vaadin.ui.Window;

@SuppressWarnings("serial")
@EnableAutoConfiguration
@EnableSpringConfigured
public class SpringMainApplication extends SpringContextApplication implements BeanFactoryAware, InitializingBean, DisposableBean {

    protected transient Logger log = Logger.getLogger(this.getClass());

    @Autowired
    MainScreen mainScreen;
    
    private BeanFactory beanFactory;

	@SuppressWarnings("unused")
	private String someProperty;

    public SpringMainApplication() {
        this.log.info(this.getClass().getSimpleName() + " constructor invoked");
    }
    
    @Lookup
    MainScreen getMainScreen(){
    	return mainScreen;
    }

    @Override
    public void initSpringApplication(ConfigurableWebApplicationContext context) {
        this.log.info("initializing application...");

        // Example of creating a @VaadinConfigurable bean
        this.log.info(this.getClass().getSimpleName() + " invoking new VaadinConfigurableBean()");
//        this.vaadinConfigurableBean = new VaadinConfigurableBean();  // bean is @VaadinConfigurable, so the aspect will autowire it
        setTheme("applayout");
        Window mainWindow = new Window("PRUEBA");
        this.setMainWindow(mainWindow);
        mainWindow.addComponent(getMainScreen());
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) {
        this.log.info(this.getClass().getSimpleName() + ".setBeanFactory() invoked");
        this.beanFactory = beanFactory;
    }

    @Override
    public void afterPropertiesSet() {
        this.log.info(this.getClass().getSimpleName() + ".afterPropertiesSet() invoked");
    }

    @Override
    public void destroy() {
        this.log.info(this.getClass().getSimpleName() + ".destroy() invoked");
    }

    @Override
    public void destroySpringApplication() {
        this.log.info(this.getClass().getSimpleName() + ".destroySpringApplication() invoked");
    }

    public String info() {
        return this.getClass().getSimpleName() + "@" + Integer.toHexString(this.hashCode())
          + "\n  beanFactory=" + (this.beanFactory != null ? this.beanFactory.toString().replaceAll(",", ",\n    ") : null);
//          + "\n  vaadinConfigurableBean=" + this.vaadinConfigurableBean
//          + "\n  someProperty=" + this.someProperty;
    }

    public void setSomeProperty(String someProperty) {
        this.someProperty = someProperty;
    }
}

