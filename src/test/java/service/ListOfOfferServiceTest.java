package service;

import model.WeddingOffer;
import model.YoungCouple;
import org.junit.*;
import repository.ListOfOfferRepo;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class ListOfOfferServiceTest {


    private ListOfOfferRepo repository = ListOfOfferRepo.getInstance();
    private ListOfOfferService listOfOfferService = new ListOfOfferService();

    @BeforeClass
    public static void setup() {
    }

    @Before
    public void initList() {
        repository.collectionAccess().add(new WeddingOffer(1, "tatar siekany", 500.0));
        repository.collectionAccess().add(new WeddingOffer(2, "tort weselny", 300.0));
        repository.collectionAccess().add(new WeddingOffer(3, "rosol", 300));
        repository.collectionAccess().add(new WeddingOffer(4, "fotograf", 3000));
    }


    @Test
    public void getOfferById_correct_case() {
        WeddingOffer offer = listOfOfferService.getOfferById(1);
        Assert.assertEquals(offer.getOfferName(), "tatar siekany");
    }

    @Test(expected = NoSuchElementException.class)
    public void getOfferById_NoSuchElementException_expected() {
        WeddingOffer offer = listOfOfferService.getOfferById(99);
    }

    @Test
    public void addOfferToList_correct_case() {
        int offerCountBeforeAdd = repository.collectionAccess().size();
        listOfOfferService.addOfferToList(new WeddingOffer(5, "bus dla gosci z kierowca", 5000));
        Assert.assertEquals(offerCountBeforeAdd + 1, repository.collectionAccess().size());
    }

    @Test
    public void deleteOfferById_correct_case() {
        int elementNumbersBeforeTest = repository.collectionAccess().size();
        Assert.assertTrue(listOfOfferService.deleteOfferById(1));
        Assert.assertEquals(elementNumbersBeforeTest, repository.collectionAccess().size() + 1);
    }

    @Test
    public void deleteOfferById_no_element_to_delete() {

        Assert.assertFalse(listOfOfferService.deleteOfferById(99));
    }

    @Test
    public void getAllWeddingOffers_correct_case() {
        List<WeddingOffer> offers = listOfOfferService.getAllWeddingOffers();
        Assert.assertEquals(offers.size(), 4);
    }

    @Test
    public void updateWeddingOffer_correct_case() {

        WeddingOffer offer = new WeddingOffer(99, "DJ", 6000.0);
        offer.setPrepared(true);
        WeddingOffer offerToUpdate = listOfOfferService.getOfferById(1);
        offer.setYoungCouple(new YoungCouple((long) 1,"Kamil","Nowak", "Mariola", "Kaminska",true));
        listOfOfferService.updateWeddingOffer(1, offer);

        Assert.assertEquals(offerToUpdate.getOfferName(), offer.getOfferName());
        Assert.assertEquals(offerToUpdate.isPrepared(), offer.isPrepared());
    }

    @Test(expected = NoSuchElementException.class)
    public void updateWeddingOffer_NoSuchElementException_expected() {

        WeddingOffer offer = new WeddingOffer(99, "DJ", 6000.0);
        offer.setPrepared(true);
        offer.setYoungCouple(new YoungCouple((long) 1,"Kamil","Nowak", "Mariola", "Kaminska",true));
        listOfOfferService.updateWeddingOffer(98, offer);

    }

    @After
    public void clear() {
        repository.setListOfOffers(new ArrayList<>());
    }
}
