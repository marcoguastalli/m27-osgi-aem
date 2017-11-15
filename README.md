# m27-osgi-aem
M27 OSGi AEM Hello World Bundle Consumer

## AEM 6.2
- cd ~/dev/myStash/aem62-servers
- mvn cq-start

###### DEPLOY into AEM SERVERS
- mvn clean install -Pserver-package-deploy -Dcq.server=http://localhost:6200
- mvn clean install -Pserver-package-deploy -Dcq.server=http://localhost:6201