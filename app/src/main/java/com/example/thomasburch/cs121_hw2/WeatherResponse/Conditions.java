package com.example.thomasburch.cs121_hw2.WeatherResponse;

/**
 * Created by thomasburch on 2/1/16.
 */
//-----------------------------------com.example.Conditions.java-----------------------------------

        import com.google.gson.annotations.Expose;
        import com.google.gson.annotations.SerializedName;


public class Conditions {

    @SerializedName("wind_gust_mph")
    @Expose
    public Integer windGustMph;
    @SerializedName("temp_f")
    @Expose
    public Double tempF;
    @SerializedName("observation_location")
    @Expose
    public ObservationLocation observationLocation;
    @SerializedName("temp_c")
    @Expose
    public Double tempC;
    @SerializedName("relative_humidity")
    @Expose
    public String relativeHumidity;
    @SerializedName("weather")
    @Expose
    public String weather;
    @SerializedName("dewpoint_c")
    @Expose
    public Integer dewpointC;
    @SerializedName("windchill_c")
    @Expose
    public String windchillC;
    @SerializedName("pressure_mb")
    @Expose
    public String pressureMb;
    @SerializedName("windchill_f")
    @Expose
    public String windchillF;
    @SerializedName("dewpoint_f")
    @Expose
    public Integer dewpointF;
    @SerializedName("wind_mph")
    @Expose
    public Double windMph;

    /**
     *
     * @return
     * The windGustMph
     */
    public Integer getWindGustMph() {
        return windGustMph;
    }

    /**
     *
     * @param windGustMph
     * The wind_gust_mph
     */
    public void setWindGustMph(Integer windGustMph) {
        this.windGustMph = windGustMph;
    }

    /**
     *
     * @return
     * The tempF
     */
    public Double getTempF() {
        return tempF;
    }

    /**
     *
     * @param tempF
     * The temp_f
     */
    public void setTempF(Double tempF) {
        this.tempF = tempF;
    }

    /**
     *
     * @return
     * The observationLocation
     */
    public ObservationLocation getObservationLocation() {
        return observationLocation;
    }

    /**
     *
     * @param observationLocation
     * The observation_location
     */
    public void setObservationLocation(ObservationLocation observationLocation) {
        this.observationLocation = observationLocation;
    }

    /**
     *
     * @return
     * The tempC
     */
    public Double getTempC() {
        return tempC;
    }

    /**
     *
     * @param tempC
     * The temp_c
     */
    public void setTempC(Double tempC) {
        this.tempC = tempC;
    }

    /**
     *
     * @return
     * The relativeHumidity
     */
    public String getRelativeHumidity() {
        return relativeHumidity;
    }

    /**
     *
     * @param relativeHumidity
     * The relative_humidity
     */
    public void setRelativeHumidity(String relativeHumidity) {
        this.relativeHumidity = relativeHumidity;
    }

    /**
     *
     * @return
     * The weather
     */
    public String getWeather() {
        return weather;
    }

    /**
     *
     * @param weather
     * The weather
     */
    public void setWeather(String weather) {
        this.weather = weather;
    }

    /**
     *
     * @return
     * The dewpointC
     */
    public Integer getDewpointC() {
        return dewpointC;
    }

    /**
     *
     * @param dewpointC
     * The dewpoint_c
     */
    public void setDewpointC(Integer dewpointC) {
        this.dewpointC = dewpointC;
    }

    /**
     *
     * @return
     * The windchillC
     */
    public String getWindchillC() {
        return windchillC;
    }

    /**
     *
     * @param windchillC
     * The windchill_c
     */
    public void setWindchillC(String windchillC) {
        this.windchillC = windchillC;
    }

    /**
     *
     * @return
     * The pressureMb
     */
    public String getPressureMb() {
        return pressureMb;
    }

    /**
     *
     * @param pressureMb
     * The pressure_mb
     */
    public void setPressureMb(String pressureMb) {
        this.pressureMb = pressureMb;
    }

    /**
     *
     * @return
     * The windchillF
     */
    public String getWindchillF() {
        return windchillF;
    }

    /**
     *
     * @param windchillF
     * The windchill_f
     */
    public void setWindchillF(String windchillF) {
        this.windchillF = windchillF;
    }

    /**
     *
     * @return
     * The dewpointF
     */
    public Integer getDewpointF() {
        return dewpointF;
    }

    /**
     *
     * @param dewpointF
     * The dewpoint_f
     */
    public void setDewpointF(Integer dewpointF) {
        this.dewpointF = dewpointF;
    }

    /**
     *
     * @return
     * The windMph
     */
    public Double getWindMph() {
        return windMph;
    }

    /**
     *
     * @param windMph
     * The wind_mph
     */
    public void setWindMph(Double windMph) {
        this.windMph = windMph;
    }

}