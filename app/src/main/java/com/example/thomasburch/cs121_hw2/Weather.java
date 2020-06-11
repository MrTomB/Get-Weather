package com.example.thomasburch.cs121_hw2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.GsonConverterFactory;
import retrofit2.Retrofit;
import retrofit2.http.GET;
import retrofit2.Response;
import retrofit2.Callback;
import android.view.View.OnClickListener;

import com.example.thomasburch.cs121_hw2.WeatherResponse.*;

public class Weather extends AppCompatActivity {//implements OnClickListener{

    // Locations declarations
    String full;
    String elevation;
    String longitude;
    String latitude;
    String countryIso3166;

    //Conditions declarations
    String weather1;
    Double tempF;
    Double tempC;
    String relativeHumidity;
    Integer windGustMph;
    Double windMph;

    public static String LOG_TAG = "WeatherApplication";

    public interface WeatherService {
        @GET("default/get_weather/")
        Call<Example> getWeather();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);

        // declaring button
        Button bnew = (Button) findViewById(R.id.findweather);
        bnew.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

                //Location initialization to empty string
                TextView tx_full = (TextView) findViewById(R.id.full_id);
                tx_full.setText("");

                TextView tx_elevation = (TextView) findViewById(R.id.elevation_id);
                tx_elevation.setText("");

                TextView tx_longitude = (TextView) findViewById(R.id.longitude_id);
                tx_longitude.setText("");

                TextView tx_latitude = (TextView) findViewById(R.id.latitude_id);
                tx_latitude.setText("");

                TextView tx_countryIso3166 = (TextView) findViewById(R.id.countryIso_id);
                tx_countryIso3166.setText("");



                //Condition initialization to empty string
                TextView tx_weather = (TextView) findViewById(R.id.weather_id);
                tx_weather.setText("");

                TextView tx_tempF = (TextView) findViewById(R.id.tempF_id);
                tx_tempF.setText("");

                TextView tx_tempC = (TextView) findViewById(R.id.tempC_id);
                tx_tempC.setText("");

                TextView tx_relativeHumidity = (TextView) findViewById(R.id.relativeHumidity_id);
                tx_relativeHumidity.setText("");

                TextView tx_windGustMph = (TextView) findViewById(R.id.windGustMph_id);
                tx_windGustMph.setText("");

                TextView tx_windMph = (TextView) findViewById(R.id.windMph_id);
                tx_windMph.setText("");

                // HTTP Call with OkHttp Retrofit Lib
                HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
                // set your desired log level
                logging.setLevel(HttpLoggingInterceptor.Level.BODY);
                OkHttpClient httpClient = new OkHttpClient.Builder()
                        .addInterceptor(logging)
                        .build();

                //Retrofit Declaration
                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl("http://luca-teaching.appspot.com/weather/default/get_weather/")
                        .addConverterFactory(GsonConverterFactory.create())    //parse Gson string
                        .client(httpClient)    //add logging
                        .build();

                WeatherService service = retrofit.create(WeatherService.class);

                Call<Example> WeatherResponseCall = service.getWeather();

                //Call retrofit asynchronously
                WeatherResponseCall.enqueue(new Callback<Example>() {
                    @Override
                    public void onResponse(Response<Example> weather) {

                        //Server500 Error
                        if ((weather.body() == null)) {
                            TextView tx_error = (TextView) findViewById(R.id.full_id);
                            tx_error.setText("Server500 Error");
                        } else {

                            Log.i(LOG_TAG, "result is: " + weather.body().response.result);
                            if ((weather.body().response.result).equals("ok")) {

                                //Location
                                full = weather.body().response.conditions.observationLocation.full;
                                elevation = weather.body().response.conditions.observationLocation.elevation;
                                longitude = weather.body().response.conditions.observationLocation.longitude;
                                latitude = weather.body().response.conditions.observationLocation.latitude;
                                countryIso3166 = weather.body().response.conditions.observationLocation.countryIso3166;

                                //Condition
                                weather1 = weather.body().response.conditions.weather;
                                tempF = weather.body().response.conditions.tempF;
                                tempC = weather.body().response.conditions.tempC;
                                relativeHumidity = weather.body().response.conditions.relativeHumidity;
                                windGustMph = weather.body().response.conditions.windGustMph;
                                windMph = weather.body().response.conditions.windMph;

                                Log.i(LOG_TAG, "City is: " + full);
                                Log.i(LOG_TAG, "Elevation is: " + elevation);
                                Log.i(LOG_TAG, "tempF is: " + tempF);
                                Log.i(LOG_TAG, "relativeHumidity is: " + relativeHumidity);
                                Log.i(LOG_TAG, "windGustMph is: " + windGustMph);
                                Log.i(LOG_TAG, "windMph is: " + windMph);

                                //Location
                                TextView tx_full = (TextView) findViewById(R.id.full_id);
                                tx_full.setText(full);

                                TextView tx_countryIso3166 = (TextView) findViewById(R.id.countryIso_id);
                                tx_countryIso3166.setText("countryIso3166: " + countryIso3166);

                                TextView tx_elevation = (TextView) findViewById(R.id.elevation_id);
                                tx_elevation.setText("Elevation: " + elevation);

                                TextView tx_longitude = (TextView) findViewById(R.id.longitude_id);
                                tx_longitude.setText("Longitude: " + longitude);

                                TextView tx_latitude = (TextView) findViewById(R.id.latitude_id);
                                tx_latitude.setText("Longitude: " + latitude);

                                //Condition
                                TextView tx_weather = (TextView) findViewById(R.id.weather_id);
                                tx_weather.setText("Weather: " + weather1);

                                TextView tx_tempF = (TextView) findViewById(R.id.tempF_id);
                                String str_tempF = Double.toString(tempF);
                                tx_tempF.setText("Fahrenheit: " + str_tempF + "F");

                                TextView tx_tempC = (TextView) findViewById(R.id.tempC_id);
                                String str_tempC = Double.toString(tempC);
                                tx_tempC.setText("Celsius: " + str_tempC + "C");

                                TextView tx_relativeHumidity = (TextView) findViewById(R.id.relativeHumidity_id);
                                tx_relativeHumidity.setText("Relative Humidity: " + relativeHumidity);

                                TextView tx_windGustMph = (TextView) findViewById(R.id.windGustMph_id);
                                String str_windGustMph = Integer.toString(windGustMph);
                                tx_windGustMph.setText("Wind Gust: " + str_windGustMph + "Mph");

                                TextView tx_windMph = (TextView) findViewById(R.id.windMph_id);
                                String str_windMph = Double.toString(windMph);
                                tx_windMph.setText("Wind Speed: " + str_windMph + "Mph");
                            }

                            //Server200 Error
                            if ((weather.body().response.result).equals("error")) {
                                TextView tx_error = (TextView) findViewById(R.id.full_id);
                                tx_error.setText("Server200 Error");
                            }
                        }
                    }

                    @Override
                    public void onFailure(Throwable t) {
                        // Log error here since request failed
                        TextView tx_error = (TextView) findViewById(R.id.full_id);
                        tx_error.setText("onFailure Error");
                    }
                });
            }
        });

    }
}

