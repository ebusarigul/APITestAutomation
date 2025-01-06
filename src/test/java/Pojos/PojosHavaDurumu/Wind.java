package Pojos.PojosHavaDurumu;

public class Wind {

    private Float speed;
    private Integer deg;

    /**
     * No args constructor for use in serialization
     *
     */
    public Wind() {
    }

    /**
     *
     * @param deg
     * @param speed

     */
    public Wind(Float speed, Integer deg) {
        super();
        this.speed = speed;
        this.deg = deg;

    }

    public Float getSpeed() {
        return speed;
    }

    public void setSpeed(Float speed) {
        this.speed = speed;
    }

    public Integer getDeg() {
        return deg;
    }

    public void setDeg(Integer deg) {
        this.deg = deg;
    }

}


