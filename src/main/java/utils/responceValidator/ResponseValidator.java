package utils.responceValidator;

import io.restassured.response.Response;

public class ResponseValidator {

    public static void validateStatsCode(Response response){
        int statusCode = response.getStatusCode();
        String body = response.getBody().asString();

        if (statusCode >=200 && statusCode<=300){
            return;
        }

        switch (statusCode) {

                case 401:
                    System.out.println("Unauthorized (401): " + body);
                    break;
                case 403:
                    System.out.println("Forbidden (403): " + body);
                    break;
                case 404:
                    System.out.println("Not Found (404): " + body);
                    break;

                default:
                    System.out.println("API Error (" + statusCode + "): " + body);
            }
        }
    }

