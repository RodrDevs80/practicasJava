package org.example;


public  class  LogLevels {

    public String message(String logLine) {
        String[] partes =logLine.split(":",2);
        String level = partes[0];
        String message = partes[1];

         return message.trim();
    }

    public String logLevel(String logLine) {
        String[] partes=logLine.split(":",2);
        String level = partes[0];
        String replace=level.replace("[", " ").replace("]", " ");
        String message = partes[1];

        return replace.toLowerCase();
    }

    public String reformat(String logLine) {
        String[] partes =logLine.split(":",2);
        String level = partes[0];
        String message = partes[1];
        String replace= level.replace("[", " ").replace("]", " ");
        message = message.concat(" ("+replace.toLowerCase()+")");

         return message.trim();
    }

    public static String reformat1(String logLine) {
        String[] partes =  logLine.split(":",2);
        String level = partes[0];
        String message = partes[1];
        String replace = level.replace("[", "").replace("]", "");
        level.toLowerCase();
        message = message.concat(" ("+replace.toLowerCase()+")");
        throw new UnsupportedOperationException();

    }


}
