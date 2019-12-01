package pl.pjwstk.repository;

import pl.pjwstk.model.WeddingOffer;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ListOfOfferRepo {

    private static ListOfOfferRepo ourInstance = new ListOfOfferRepo();

    public static ListOfOfferRepo getInstance() {
        return ourInstance;
    }

    private ListOfOfferRepo() {
    }

    private List<WeddingOffer> listOfOffers = new ArrayList<>();


    public List<WeddingOffer> collectionAccess() {
        listOfOffers
                .stream()
                .filter(WeddingOffer::isSaveTimes)
                .forEach(u -> u.setLastReadTime(LocalDateTime.now()));
        return listOfOffers;
    }

    public void setListOfOffers(List<WeddingOffer> listOfOffers) {
        this.listOfOffers = listOfOffers;
    }



    public Optional<WeddingOffer> getObjectById(Long id) {

        return listOfOffers.stream()
                .filter(u -> u.getId().equals(id))
                .findFirst();
    }

    public boolean isPressentInRepoById(final Long id) {

        return listOfOffers.stream().anyMatch(u -> u.getId().equals(id));
    }
}
