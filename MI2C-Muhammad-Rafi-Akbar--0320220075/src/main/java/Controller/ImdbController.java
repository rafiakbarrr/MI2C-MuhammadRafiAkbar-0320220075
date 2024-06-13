package Controller;

import Service.ImdbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/imdb")
public class ImdbController {
    @Autowired
    private final ImdbService imbdService;

    public ImdbController(ImdbService imbdService){
        this.imbdService = imbdService;
    }
    @GetMapping("/getAll-film")
    public ResponseEntity<?> callImdbFilm(){
        return ResponseEntity.ok(imbdService.getAllImdbFilm());
    }
    @GetMapping("/getAll-covid")
    public ResponseEntity<?> callCovid(){
        return ResponseEntity.ok(imbdService.getAllDataCovid());
    }
    @GetMapping("/getAll-weather")
    public ResponseEntity<?> callWeather(){
        return ResponseEntity.ok(imbdService.getAllDataWeather());
    }
}
