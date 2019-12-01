package pl.pjwstk.controller;

import pl.pjwstk.model.WeddingOffer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.pjwstk.service.ListOfOfferService;

@RestController
@RequestMapping("/api")
public class OfferController {

    private ListOfOfferService listOfOfferService;

    @Autowired
    public OfferController(ListOfOfferService listOfOfferService) {
        this.listOfOfferService = listOfOfferService;
    }

    @PostMapping("/add")
    public ResponseEntity<Boolean> addTask(@RequestBody WeddingOffer weddingOffer) {
        return ResponseEntity.ok(listOfOfferService.addOfferToList(weddingOffer));
    }

    @GetMapping("/{id}")
    public ResponseEntity<WeddingOffer> getTaskById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(listOfOfferService.getOfferById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(listOfOfferService.deleteOfferById(id));
    }

    @PutMapping
    public ResponseEntity<WeddingOffer> updateTaskById(@PathVariable("id") Long id, @RequestBody WeddingOffer weddingOffer) {
        return ResponseEntity.ok(listOfOfferService.updateWeddingOffer(id, weddingOffer));
    }

}
