package org.example;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        LogLevels logLevels = new LogLevels();

        String message1= logLevels.message("[ERROR]: Invalid operation");
        String message2= logLevels.message("[WARNING]:  Disk almost full\r\n");
        String loglevel = logLevels.logLevel("[ERROR]: Invalid operation");
        String reformat = logLevels.reformat("[INFO]: Operation completed");

        System.out.println(message1);
        System.out.println(message2);
        System.out.println(loglevel);
        System.out.println(reformat);


        String inputString = " [ ERROR ] ";
        String outputString = inputString.replace("[", "").replace("]", "");

        System.out.println(outputString);


    }
}