package org.tucno.appcliente.ejb.jaas;

import org.tucno.webpp.ejb.jaas.models.Producto;
import org.tucno.webpp.ejb.jaas.services.ServiceEjbRemote;

import javax.naming.InitialContext;

public class Main {
    public static void main(String[] args) {
        ServiceEjbRemote serviceEjbRemote = null;
        ServiceEjbRemote serviceEjbRemote2 = null;

//        final Properties env = new Properties();
//        env.put(Context.INITIAL_CONTEXT_FACTORY, "org.wildfly.naming.client.WildFlyInitialContextFactory");
//        env.put(Context.PROVIDER_URL, "http-remoting://localhost:8080");
//        env.put("jboss.naming.client.ejb.context", true);

        try {
            // Ya no es necesario especificar las propiedades de conexión al servidor de aplicaciones porque se encuentran en el archivo resources/jndi.properties
            InitialContext remoteContext = new InitialContext();
            serviceEjbRemote = (ServiceEjbRemote) remoteContext.lookup("ejb:/appejb-jakarta-javabeans-ejb-remote-jaas/ServiceEjb!org.tucno.webpp.ejb.jaas.services.ServiceEjbRemote?stateful");
            serviceEjbRemote2 = (ServiceEjbRemote) remoteContext.lookup("ejb:/appejb-jakarta-javabeans-ejb-remote-jaas/ServiceEjb!org.tucno.webpp.ejb.jaas.services.ServiceEjbRemote?stateful");

            String saludo = serviceEjbRemote.saludar("Tucno");
            String saludo2 = serviceEjbRemote2.saludar("Tucno2");

            System.out.println(saludo);
            System.out.println(saludo2);

            Producto producto = new Producto("Producto 4");
            Producto productoCreado = serviceEjbRemote.crear(producto);
            System.out.println(productoCreado);

            serviceEjbRemote.listar().forEach(System.out::println);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
