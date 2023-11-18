package utils;

public class APIPayLoad {

    String example;
    public static String createLoginPayLoad(){

        String createPayLoad="{\n" +
                "    \"name\": \"Aziz\",\n" +
                "    \"job\": \"Teacher\"\n" +
                "}";
        return createPayLoad;

    }

    public static String loginPayLoad(){
        String loginPayLoad="{\n" +
                "    \"email\": \"eve.holt@reqres.in\",\n" +
                "    \"password\": \"cityslicka\"\n" +
                "}";
        return loginPayLoad;
    }


}
