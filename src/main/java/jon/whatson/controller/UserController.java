package jon.whatson.controller;

import jon.whatson.model.User;
import jon.whatson.model.Venue;
import jon.whatson.service.IUserService;
import jon.whatson.service.IVenueService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    private IUserService userService;

    private IVenueService venueService;

    public UserController(IUserService userService) {
        this.userService = userService;
    }

    @PostMapping("/createLike")
    public ResponseEntity<String> createLike(@RequestParam Long userID,
                                             @RequestParam Long venueID) {
        Optional<User> user_ = userService.findById(userID);
        Optional<Venue> venue_ = venueService.findById(venueID);
        if (user_.isPresent() && venue_.isPresent()) {
            user_.get().getVenuesLiked().add(venue_.get());
            userService.save(user_.get());
            return new ResponseEntity<>("Ok at gamme user: " + userID + " med like venue " + venueID, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("fejl i oprettelse af like", HttpStatus.OK);
        }
    }

    @PostMapping("/createUser")
    public ResponseEntity<String> createUser(@RequestBody User user){
        String msg="";
        if(userService.save(user)!=null) {
            msg="Oprettet bruger: "+user.getName();
        } else {
            msg="fejl i oprettelse af " + user.getName();
        }
        return new ResponseEntity<>(msg, HttpStatus.OK);
    }

    @GetMapping("/getUserByName")
    public ResponseEntity<List<User>> findUserByName(String name) {
        return new ResponseEntity<>(userService.findByName(name), HttpStatus.OK);
    }
}
