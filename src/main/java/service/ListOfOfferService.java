package service;


import model.WeddingOffer;
import model.WeddingOfferTime;
import repository.ListOfOfferRepo;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

public class ListOfOfferService {

    public ListOfOfferService() {
    }


    public boolean addOfferToList(WeddingOffer offer) {

        if (offer == null) throw new IllegalArgumentException("Object is null");

        ListOfOfferRepo.getInstance().collectionAccess().add(offer);
        return true;
    }

    public WeddingOffer getOfferById(long id) {

        if (ListOfOfferRepo.getInstance().isPressentInRepoById(id)) {

            Optional<WeddingOffer> optionalWeddingOffer = ListOfOfferRepo.getInstance().getObjectById(id);
            if (optionalWeddingOffer.isPresent()) {
                WeddingOffer weddingOffer = optionalWeddingOffer.get();
                if (weddingOffer.isSaveTimes()){
                    weddingOffer.setLastReadTime(LocalDateTime.now());
                }
                return weddingOffer;
            }
        }

        throw new NoSuchElementException("Element with pointed id doesnt exist");
    }

    public boolean deleteOfferById(long id) {

        if (ListOfOfferRepo.getInstance().isPressentInRepoById(id)) {
            ListOfOfferRepo.getInstance().collectionAccess().remove(getOfferById(id));
            return true;
        }
        return false;
    }

    public List<WeddingOffer> getAllWeddingOffers() { return new ArrayList<>(ListOfOfferRepo.getInstance().collectionAccess()); }

    public WeddingOffer updateWeddingOffer(long id, WeddingOffer offer){

        if (ListOfOfferRepo.getInstance().isPressentInRepoById(id)) {
            WeddingOffer offerToUpdate = getOfferById(id);

            offerToUpdate.setOfferName(offer.getOfferName());

            offerToUpdate.setPrepared(offer.isPrepared());

            offerToUpdate.setOfferPrice(offer.getOfferPrice());

            offerToUpdate.setYoungCouple(offer.getYoungCouple());

            offerToUpdate.setSaveTimes(offer.isSaveTimes());

            if (offer.isSaveTimes()) {
                offerToUpdate.setUpdatedTime(LocalDateTime.now());
                offerToUpdate.setLastReadTime(offer.getLastReadTime());
            }

            ListOfOfferRepo.getInstance().collectionAccess().remove(getOfferById(id));
            ListOfOfferRepo.getInstance().collectionAccess().add(offerToUpdate);


            return offerToUpdate;
        }

        throw new NoSuchElementException("Element with pointed id doesnt exist");
    }
    public WeddingOfferTime getTimesById(long id) {
        return new WeddingOfferTime().create(getOfferById(id));
    }

    public List<WeddingOffer> getOffersByRegex(String regex) {
        if(regex == null){
            throw new IllegalArgumentException("regex can not by null");
        }

        return ListOfOfferRepo.getInstance().collectionAccess().stream()
                .filter(u -> u.getOfferName().contains(regex))
                .collect(Collectors.toList());
    }

    public boolean deleteOffersByRegex(String regex) {
        if(regex == null){
            throw new IllegalArgumentException("regex can not by null");
        }

        List<WeddingOffer> offersToRemove = getOffersByRegex(regex);
        if(offersToRemove.size() == 0) {
            return false;
        }

        offersToRemove.forEach(u -> deleteOfferById(u.getId()));
        return true;
    }

}
