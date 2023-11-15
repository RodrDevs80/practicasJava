package org.example.ejemploSimpleVariablesAtomicas;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public class Main6 {
    private static Map<String,Double> pricesByAirline;

    public static void main(String[] args) {
        init();
        String from="BCN";
        String to="JFK";

        Double lowestPrice=getPriceLow(from,to);
        Double avgPrice=getPriceAvg(from,to);

        System.out.println("Lowest Price: "+ lowestPrice );
        System.out.println("AVG Price: "+ avgPrice );
    }
    private static Double getPriceAvg(String from,String to){
        AtomicReference<Double> totalPrice=new AtomicReference<>(0.0);
        AtomicInteger count=new AtomicInteger(0);
        pricesByAirline.keySet().stream().parallel().forEach(airline->{
            Double price = getPriceTrip(airline, from, to);
            Double result=totalPrice.get()+price;
            count.incrementAndGet();
            totalPrice.set(result);
        });
        double avgPrice = totalPrice.get() / count.get();
        return avgPrice;
    }
    private static Double getPriceLow(String from,String to){
        AtomicReference<Double> lowestPrice=new AtomicReference<>(null);
        pricesByAirline.keySet().stream().parallel().forEach(airline->{
            Double price = getPriceTrip(airline, from, to);
            if (lowestPrice.get() ==null || price< lowestPrice.get()){
                lowestPrice.set(price);
            }
        });
           return lowestPrice.get();
    }
    private static void init(){
        pricesByAirline= new HashMap<>();
        pricesByAirline.put("American Airline",550.0);
        pricesByAirline.put("US Airways",610.0);
        pricesByAirline.put("Qatar Airways",590.0);
        pricesByAirline.put("Delta Airlines",540.0);
        pricesByAirline.put("Singapore Airlines",612.0);
        pricesByAirline.put("Cathay Pacific Airways",550.0);
        pricesByAirline.put("Sky Airline",540.0);
        pricesByAirline.put("Copa Airlines Colombia",610.0);
        pricesByAirline.put("Avianca",580.0);
        pricesByAirline.put("LATAM Airlines Group",600.0);
        pricesByAirline.put("Aeromexico",740.0);
        pricesByAirline.put("Aerolineas Argentinas",940.0);
    }
    private static Double getPriceTrip(String airline,String from,String to){
        return  pricesByAirline.get(airline);
    }
}
