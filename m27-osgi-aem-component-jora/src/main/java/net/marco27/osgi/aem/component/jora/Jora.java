package net.marco27.osgi.aem.component.jora;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Dictionary;

import org.apache.felix.scr.annotations.Activate;
import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Property;
import org.apache.sling.commons.osgi.PropertiesUtil;
import org.osgi.framework.BundleContext;
import org.osgi.service.component.ComponentContext;

@Component(metatype = true, immediate = true, label = "Jora Component")
public class Jora {
    protected BundleContext bundleContext;

    private static final boolean DEFAULT_ENABLED = true;
    @Property(label = "Enable",
            description = "Enable the component",
            boolValue = Jora.DEFAULT_ENABLED)
    public static final String JORA_COMPONENT_ENABLED = "jora.component.enabled";
    private boolean isComponentEnabled = DEFAULT_ENABLED;

    private static final String DEFAULT_DATE_TIME_FORMATTER = "yyyy-MM-dd HH:mm:ss";
    @Property(label = "Date Time Formatter",
            description = "Date Time Formatter RegExp Pattern",
            value = Jora.DEFAULT_DATE_TIME_FORMATTER)
    public static final String DATE_TIME_FORMATTER = "jora.component.datetimeformatter.pattern";
    private String dateTimeFormatterPattern = DEFAULT_DATE_TIME_FORMATTER;

    @Activate
    protected void activate(BundleContext bundleContext, ComponentContext componentContext) {
        this.bundleContext = componentContext.getBundleContext();
        Dictionary<?, ?> properties = componentContext.getProperties();
        isComponentEnabled = PropertiesUtil.toBoolean(properties.get(Jora.JORA_COMPONENT_ENABLED),
                Jora.DEFAULT_ENABLED);
    }

    public String getJora() {
        if (isComponentEnabled) {
            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(dateTimeFormatterPattern);
            return now.format(formatter);
        }
        return null;
    }
}