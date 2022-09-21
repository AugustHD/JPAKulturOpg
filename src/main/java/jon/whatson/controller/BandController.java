package jon.whatson;

import jon.whatson.service.IBandService;
import jon.whatson.service.IUserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BandController {

    private IBandService bandService;

    public BandController(IBandService bandService) {
        this.bandService = bandService;
    }

    @PostMapping("/createBand")
    public ResponseEntity<String> createBand(@RequestBody Band band){
        String msg="";
        if(bandService.save(band)!=null) {
            msg="Oprettet band: "+band.getBandName();
        }else {
            msg="fejl i oprettelse af " + band.getBandName();
        }
        return new ResponseEntity<>(msg, HttpStatus.OK);
    }

}
