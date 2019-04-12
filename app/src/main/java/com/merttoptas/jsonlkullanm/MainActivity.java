  package com.merttoptas.jsonlkullanm;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.google.gson.Gson;
import com.merttoptas.jsonlkullanm.Model.CityList;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

  public class MainActivity extends AppCompatActivity {

      Spinner spinner, spinner1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        spinner = findViewById(R.id.spinner);

        spinner1 = findViewById(R.id.spinner1);


        CityList cityList = new CityList();
        try {
            //Load File
            BufferedReader jsonReader = new BufferedReader(new InputStreamReader(this.getResources().openRawResource(R.raw.citys)));
            StringBuilder jsonBuilder = new StringBuilder();
            for (String line = null; (line = jsonReader.readLine()) != null; ) {
                jsonBuilder.append(line).append("\n");
            }

            Gson gson = new Gson();
            cityList = gson.fromJson(jsonBuilder.toString(),CityList.class);

            Log.d("Deneme",cityList.getCityDetail().get(0).getName());


        } catch (FileNotFoundException e) {
            Log.e("jsonFile", "file not found");
        } catch (IOException e) {
            Log.e("jsonFile", "ioerror");
        }

        List<String> spinnerData = new ArrayList<>();

        for(int i=0;i<cityList.getCityDetail().size();i++){
            spinnerData.add(cityList.getCityDetail().get(i).getName());
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, spinnerData);


        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(adapter);



        //Distcirt json raw file

        DistrictList districtDetail = new DistrictList();
        try {
            //load File
            BufferedReader jsonReader = new BufferedReader(new InputStreamReader(this.getResources().openRawResource(R.raw.district)));
            StringBuilder jsonBuilder = new StringBuilder();
            for (String line = null; (line = jsonReader.readLine()) != null; ) {
                jsonBuilder.append(line).append("\n");
            }

            Gson gson = new Gson();
            districtDetail = gson.fromJson(jsonBuilder.toString(), DistrictList.class);

            Log.d("Deneme", districtDetail.getDistrictDetail().get(0).getIlceTitle());

        }catch (FileNotFoundException e){
            Log.e("jsonFİle", "file not found");
        }catch (IOException e){
            Log.e("jsonFile","ioerror");
        }
        List<String>  districtData = new ArrayList<>();

        for(int i=0; i<districtDetail.getDistrictDetail().size(); i++){
            districtData.add(districtDetail.getDistrictDetail().get(i).getIlceTitle());
        }

        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, districtData);


        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner1.setAdapter(adapter1);


    }
}
