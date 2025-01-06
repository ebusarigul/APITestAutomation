package Pojos.PojosHavaDurumu;

public class Rain {

    private Float _1h;

    /**
     * No args constructor for use in serialization
     *
     */
    public Rain() {
    }

    /**
     *
     * @param _1h
     */
    public Rain(Float _1h) {
        super();
        this._1h = _1h;
    }

    public Float get1h() {
        return _1h;
    }

    public void set1h(Float _1h) {
        this._1h = _1h;
    }

}