/**
 * Daniel Moudatsos Strassacapa Rodrigues R.A 81716932
 */

package br.usjt.ciclodevidagpsemapas;

import java.io.Serializable;

public class Localizacao implements Serializable {

    private Double latitude;
    private Double longitude;

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    @Override
    public String toString() {
        return "Lat: " + latitude + ", Long: " + longitude;
    }
}
