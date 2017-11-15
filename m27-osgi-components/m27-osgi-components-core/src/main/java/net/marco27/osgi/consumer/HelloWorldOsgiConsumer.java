package net.marco27.osgi.consumer;

import java.util.Dictionary;

import org.apache.felix.scr.annotations.Activate;
import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Property;
import org.apache.felix.scr.annotations.Reference;
import org.apache.sling.commons.osgi.PropertiesUtil;
import org.osgi.framework.BundleContext;
import org.osgi.service.component.ComponentContext;

import net.marco27.osgi.helloworld.HelloWorldOsgiService;

@Component(metatype = true, immediate = true, label = "Hello OSGi Component")
@Property(name = HelloWorldOsgiConsumer.PROPERTY_NAME, value = { HelloWorldOsgiConsumer.PROPERTY_DEFAULT_VALUE })
public class HelloWorldOsgiConsumer {

    protected BundleContext bundleContext;

    protected static final String PROPERTY_NAME = "osgiPropertyName";
    protected static final String PROPERTY_DEFAULT_VALUE = "osgiPropertyValue";

    private String privateProperty;

    @Reference
    private HelloWorldOsgiService helloWorldOsgiService;

    @Activate
    protected void activate(BundleContext bundleContext, ComponentContext componentContext) {
        this.bundleContext = componentContext.getBundleContext();
        Dictionary<?, ?> properties = componentContext.getProperties();
        this.privateProperty = PropertiesUtil.toString(properties.get(PROPERTY_NAME), PROPERTY_DEFAULT_VALUE);

        helloWorldOsgiService.helloWorldOsgi();
    }
}