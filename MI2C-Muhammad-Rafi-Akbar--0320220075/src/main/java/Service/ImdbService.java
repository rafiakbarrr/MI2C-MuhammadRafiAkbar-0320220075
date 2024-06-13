package Service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

@Service
@Slf4j
public class ImdbService {
    private static final String url = "https://imdb8.p.rapidapi.com/auto-complete?q=game%20of%20thr";
    private static final String url2 = "https://covid-193.p.rapidapi.com/countries";
    private static final String url3 = "https://open-weather-map27.p.rapidapi.com/weather";

    private static final String xRapidapiKey = "a86832c5c2msh471a4eaad8903d5p167130jsnedbd9697736f";
    private static final String xRapidapiKey2 = "41f11fe2acmsh5c2091a8ce94422p12f8ecjsn7286f4926ffe";
    private static final String xRapidapiKey3 = "41f11fe2acmsh5c2091a8ce94422p12f8ecjsn7286f4926ffe";

    private static final String getxRapidApiHost = "imdb8.p.rapidapi.com";
    private static final String getxRapidApiHost2 = "covid-193.p.rapidapi.com";
    private static final String getxRapidApiHost3 = "open-weather-map27.p.rapidapi.com";

    @Autowired
    private RestTemplate restTemplate;

    public Object getAllImdbFilm(){
        try{
            HttpHeaders headers = new HttpHeaders();
            headers.set("x-rapidapi-key", xRapidapiKey);
            headers.set("x-rapidapi-host", getxRapidApiHost);

            ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET,new HttpEntity<>(headers),String.class);
            log.info("Output API: {} ", response.getBody());

            return response.getBody();
        }catch (Exception e){
            log.error("Terjadi kesalahan dengan RapidAPI ", e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR,
                    "Exeception ketika memanggil API",
                    e
            );
        }
    }
    public Object getAllDataCovid(){
        try{
            HttpHeaders headers = new HttpHeaders();
            headers.set("x-rapidapi-key", xRapidapiKey2);
            headers.set("x-rapidapi-host", getxRapidApiHost2);

            ResponseEntity<String> response = restTemplate.exchange(url2, HttpMethod.GET,new HttpEntity<>(headers),String.class);
            log.info("Output API: {} ", response.getBody());

            return response.getBody();
        }catch (Exception e){
            log.error("Terjadi kesalahan dengan RapidAPI ", e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR,
                    "Exeception ketika memanggil API",
                    e
            );
        }
    }
    public Object getAllDataWeather(){
        try{
            HttpHeaders headers = new HttpHeaders();
            headers.set("x-rapidapi-key", xRapidapiKey3);
            headers.set("x-rapidapi-host", getxRapidApiHost3);

            ResponseEntity<String> response = restTemplate.exchange(url3, HttpMethod.GET,new HttpEntity<>(headers),String.class);
            log.info("Output API: {} ", response.getBody());

            return response.getBody();
        }catch (Exception e){
            log.error("Terjadi kesalahan dengan RapidAPI ", e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR,
                    "Exeception ketika memanggil API",
                    e
            );
        }
    }
}
