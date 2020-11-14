package codes.enumTest;

/**
 * # @author  chilcyWind
 * # @Time   2020/11/13 21:07
 * # @version 1.0
 * # @File : Pizza.java
 * # @Software: IntelliJ IDEA
 */
public class Pizza {
    private PizzaStatus status;

     enum PizzaStatus {
        ORDERED,
        READY,
        DELIVERED;
    }



    public PizzaStatus getStatus() {
        return status;
    }

    public void setStatus(PizzaStatus status) {
        this.status = status;
    }



    public boolean isDeliverable() {
        return getStatus() == PizzaStatus.READY;
    }



}
