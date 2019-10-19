package model;

import java.util.List;

public class ListOfService {
    private Long id;
    private List<WeddingService> weddingServices;

    public ListOfService() {
    }

    public ListOfService(Long id, List<WeddingService> weddingServices) {
        this.id = id;
        this.weddingServices = weddingServices;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<WeddingService> getWeddingServices() {
        return weddingServices;
    }

    public void setToWeddingServices(List<WeddingService> weddingServices) {
        this.weddingServices = weddingServices;
    }
}
