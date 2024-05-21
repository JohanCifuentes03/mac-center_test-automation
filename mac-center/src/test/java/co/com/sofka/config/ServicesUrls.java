package co.com.sofka.config;

public class ServicesUrls {

    // Marvel API
    public static String PUBLIC_API_KEY = "b41d14e5440d6cc1519c67b31f64af68";
    public static String HASH = "d04d92d0727ab76f46b940883b00a3d0";
    public static String BASE_URL = "https://gateway.marvel.com";

    public static String GET_ALL_CHARACTERS_URL = "/v1/public/characters";
    public static String GET_SINGLE_COMIC_URL = "/v1/public/comics/{id}";


    // BASE URL http://gateway.marvel.com/v1/public/comics?ts=1&apikey=b41d14e5440d6cc1519c67b31f64af68&hash=d04d92d0727ab76f46b940883b00a3d0

    //  Soap service URL
    public static String SOAP_BASE_URL = "http://www.dneonline.com/";
    public static String SOAP_RESOURCE = "calculator.asmx";

    public static String SOAP_ADD_URL = "http://tempuri.org/Add";
    public static String SOAP_DIVIDE_URL = "http://tempuri.org/Divide";
    public static String SOAP_MULTIPLY_URL = "http://tempuri.org/Multiply";
    public static String SOAP_SUBTRACT_URL = "http://tempuri.org/Subtract";



}
