package org.example.exceptions;

public class Main8 {
    public static void main(String[] args) throws Exception {
        try{
            uncheckedTwoExceptions(false);
        }catch (ArithmeticException | NullPointerException e) {
            System.out.println("Runtine Exception");
        }
    }
    //Many Catchs
    public static void ejemploVariosCatchs()  {
        try{
            checkedToExceptions(false);
        }catch (RuntimeException e) {
            System.out.println("Runtine Exception");
        } catch (Exception e) {
            System.out.println("Exception");
        }

    }
    private static void uncheckedTwoExceptions(boolean flag) throws Exception {
        if(flag){
            throw new ArithmeticException();
        }else {
            throw new NullPointerException();
        }
    }
    private static void checkedToExceptions(boolean flag) throws Exception {
            if(flag){
                throw new Exception();
            }else {
                throw new RuntimeException();
            }
    }
    //uso de finally
    private static void finall(){
        try {
            checkedExceptions();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }finally {
            System.out.println("End");
        }
    }
    //checked Exceptions
    private static void checkedExceptions() throws Exception{

        try {
            throw new Exception();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new Exception();
        }
    }
    //Unchecked Exceptions
    private static void  exampleArithmeticException(){
        //Arithmetic Exception
        double number=10/0;
    }
}
