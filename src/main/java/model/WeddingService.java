package model;

public class WeddingService {
    private Long id;
    private String serviceName;
    private boolean isPrepared;
    private YoungCouple youngCouple;

    public WeddingService() {
    }

    public WeddingService(long id, String serviceName) {
        this.id = id;
        this.serviceName = serviceName;
        this.isPrepared = false;
        this.youngCouple = new YoungCouple();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public boolean isPrepared() {
        return isPrepared;
    }

    public void setPrepared(boolean prepared) {
        isPrepared = prepared;
    }

    public YoungCouple getYoungCouple() {
        return youngCouple;
    }

    public void setYoungCouple(YoungCouple youngCouple) {
        this.youngCouple = youngCouple;
    }
}
