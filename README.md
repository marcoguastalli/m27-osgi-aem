# MARCO27 OSGi AEM Component HelloWorld Bundle

## AEM 6.2
- cd ~/dev/myStash/aem62-servers
- mvn cq-start

## mvn clean install
    - open http://localhost:6200/system/console/bundles
## Install/Update..
    - Start Bundle
    - Refresh Package
    - from /Users/marcoguastalli/dev/repository/git/m27-osgi-aem/m27-osgi-aem-component-helloworld/target/m27-osgi-aem-component-helloworld-1.0.0-SNAPSHOT.jar
      - Install/Update

###### http://localhost:6200/system/console/bundles
   - Filter by net.marco27.osgi.m27-osgi-aem-component-helloworld

###### http://localhost:6200/system/console/components
   - Search for net.marco27.osgi.aem.component.helloworld.HelloWorldOsgiConsumer

###### http://localhost:6200/system/console/configMgr
    - Search for