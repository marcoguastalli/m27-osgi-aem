package net.marco27.osgi.aem.component.helloworld;

import java.util.Dictionary;

import org.apache.felix.scr.annotations.Activate;
import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Property;
import org.apache.sling.commons.osgi.PropertiesUtil;
import org.osgi.framework.BundleContext;
import org.osgi.service.component.ComponentContext;

@Component(metatype = true, immediate = true, label = "Hello OSGi Name Component")
@Property(name = HelloWorldOsgiName.PROPERTY_NAME, value = { HelloWorldOsgiName.PROPERTY_DEFAULT_VALUE })
public class HelloWorldOsgiName {

    protected BundleContext bundleContext;

    protected static final String PROPERTY_NAME = "osgiPropertyName";
    protected static final String PROPERTY_DEFAULT_VALUE = "osgiPropertyValue";

    private String propertyName;

    @Activate
    protected void activate(BundleContext bundleContext, ComponentContext componentContext) {
        this.bundleContext = componentContext.getBundleContext();
        Dictionary<?, ?> properties = componentContext.getProperties();
        this.propertyName = PropertiesUtil.toString(properties.get(PROPERTY_NAME), PROPERTY_DEFAULT_VALUE);
    }

    public String sayHello() {
        return "Hello " + propertyName;
    }
}