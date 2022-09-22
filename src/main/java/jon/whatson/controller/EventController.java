package jon.whatson.controller;

import jon.whatson.model.Band;
import jon.whatson.model.Event;
import jon.whatson.service.IBandService;
import jon.whatson.service.IEventService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
public class EventController {

    private IEventService eventService;

    private IBandService bandService;

    public EventController(IEventService eventService, IBandService bandService) {
        this.eventService = eventService;
        this.bandService = bandService;
    }

    @PostMapping("/createEvent")
    public ResponseEntity<String> createEvent(Event event,
                                              @RequestParam Long bandID){
        // 1. hent band
        Optional<Band> band_ = bandService.findById(bandID);
        if (band_.isPresent()) {
            event.setBand(band_.get());
            eventService.save(event);
            return new ResponseEntity<>("ok at oprette event", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("band ikke fundet", HttpStatus.OK);
        }
    }
    @GetMapping("/getEvents")
    public Set<Event> events() {
        System.out.println("Printed");
        return eventService.findAll();
    }
}