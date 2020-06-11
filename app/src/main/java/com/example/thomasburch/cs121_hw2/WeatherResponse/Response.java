package com.example.thomasburch.cs121_hw2.WeatherResponse;

/**
 * Created by thomasburch on 2/1/16.
 */
//-----------------------------------com.example.Response.java-----------------------------------

        import com.google.gson.annotations.Expose;
        import com.google.gson.annotations.SerializedName;

public class Response {

    @SerializedName("conditions")
    @Expose
    public Conditions conditions;
    @SerializedName("result")
    @Expose
    public String result;

    /**
     *
     * @return
     * The conditions
     */
    public Conditions getConditions() {
        return conditions;
    }

    /**
     *
     * @param conditions
     * The conditions
     */
    public void setConditions(Conditions conditions) {
        this.conditions = conditions;
    }

    /**
     *
     * @return
     * The result
     */
    public String getResult() {
        return result;
    }

    /**
     *
     * @param result
     * The result
     */
    public void setResult(String result) {
        this.result = result;
    }

}