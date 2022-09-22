package jon.whatson.controller;

import jon.whatson.model.Band;
import jon.whatson.model.Event;
import jon.whatson.model.Review;
import jon.whatson.model.User;
import jon.whatson.service.IBandService;
import jon.whatson.service.IEventService;
// import jon.whatson.service.IReviewService;
import jon.whatson.service.IUserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class ReviewController {
    /*
    private IReviewService reviewService;

    private IEventService eventService;

    private IUserService userService;

    public ReviewController(IReviewService reviewService, IEventService eventService, IUserService userService) {
        this.reviewService = reviewService;
        this.eventService = eventService;
        this.userService = userService;
    }

    @PostMapping("/createReview")
    public ResponseEntity<String> createReview(@RequestBody Review review,
                                              @RequestParam Long eventID, @RequestParam Long userID){
        System.out.println("den går ind i mapping");
        // 1. hent event
        Optional<Event> event_ = eventService.findById(eventID);
        Optional<User> user_ = userService.findById(userID);
        if (event_.isPresent()) {
            review.setEvent(event_.get());
            reviewService.save(review); // Måske ikke nødvendigt at save to gange.
            System.out.println("Event bliver checket for");
            // 2. hent user
            if (user_.isPresent()) {
                review.setUser(user_.get());
                reviewService.save(review);
                System.out.println("User bliver checked for");
                return new ResponseEntity<>("ok at oprette review", HttpStatus.OK);
            } else {
                return new ResponseEntity<>("user ikke fundet", HttpStatus.OK);
            }
        } else {
            return new ResponseEntity<>("event ikke fundet", HttpStatus.OK);
        }
    }
*/
}
