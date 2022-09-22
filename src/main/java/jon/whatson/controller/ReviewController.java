package jon.whatson.controller;

import jon.whatson.model.Band;
import jon.whatson.model.Event;
import jon.whatson.model.Review;
import jon.whatson.model.User;
import jon.whatson.service.IBandService;
import jon.whatson.service.IEventService;
import jon.whatson.service.IReviewService;
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

    private IReviewService reviewService;

    private IEventService eventService;

    private IUserService userService;

    public ReviewController(IReviewService reviewService, IEventService eventService, IUserService userService) {
        this.reviewService = reviewService;
        this.eventService = eventService;
        this.userService = userService;
    }

    @PostMapping("/createReview")
    public ResponseEntity<String> createReview(Review review,
                                              @RequestParam Long eventID, @RequestParam Long userID){
        System.out.println("den går ind i mapping");
        // Hent event og user
        Optional<Event> event_ = eventService.findById(eventID);
        Optional<User> user_ = userService.findById(userID);
        if (event_.isPresent() && user_.isPresent()) {
            review.setEvent(event_.get());
            review.setUser(user_.get());
            reviewService.save(review);
            System.out.println("Event bliver checket for");
                return new ResponseEntity<>("ok at oprette review", HttpStatus.OK);
            } else {
            return new ResponseEntity<>("Ikke fundet", HttpStatus.OK);
        }
    }
}
