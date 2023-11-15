package org.singleton;

public class DatabaseConnector {
    private static DatabaseConnector databaseConnector;
    private DatabaseConnector(){
        System.out.println("Creando Objeto");
    }

    public static synchronized DatabaseConnector getInstance(){
        if (databaseConnector==null){
            databaseConnector=new DatabaseConnector();
        }
        return databaseConnector;
    }

    public void connectDbase(){
        System.out.println("Conectando -> Base de Datos = " + databaseConnector);
    }
    public void disconnectDbase(){
        System.out.println("Desconectando -> Base de Datos = " + databaseConnector);
    }

}
