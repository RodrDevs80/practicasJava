import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        //Streams /Lambda
        List<String> cities= new ArrayList<>();
        cities.add("Londres");
        cities.add("New York");
        cities.add("Tokyo");
        cities.add("Barcelona");
        cities.add("Buenos Aires");
        cities.add("Bogota");
        cities.add("Ciudad de Mexico");
        cities.add("Lima");
       /* System.out.println("----------------------------");
        System.out.println("for tradicional");
        for (int i=0;i< cities.size();i++){
            System.out.println(cities.get(i));
        }
        System.out.println("----------------------------");
        for (String city:cities){
            System.out.println(city);
        }
        System.out.println("----------------------------");
        System.out.println("for Lambda");

        cities.forEach(city->System.out.println(city));

        System.out.println("----------------------------");
        System.out.println(":: referencia a metodos 2 ejemplos");
        System.out.println("1");
        cities.forEach(Main::printCity);
        System.out.println("2");*/
        //cities.stream().forEach(System.out::println);
        //System.out.println("----------------------------");
        //cities.stream().parallel().forEach(System.out::println);

        //cities.stream().filter(city->city.startsWith("B")).forEach(System.out::println);

        //cities.stream().filter(Main::flilterCity).forEach(System.out::println);

        //cities.stream().filter(city->city.startsWith("B"))
                //.filter(city->city.contains("n"))
                //.forEach(System.out::println);

        List<String> filterCity = cities.stream().filter(city -> city.startsWith("B"))
                .filter(city -> city.contains("n"))
                .collect(Collectors.toList());
        filterCity.forEach(Main::printCity);

    }
     public static void printCity(String city){
        System.out.println(city);
     }
     public static boolean flilterCity(String city){
        return city.startsWith("B");
     }
}