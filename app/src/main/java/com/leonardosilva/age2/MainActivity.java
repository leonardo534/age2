package com.leonardosilva.age2;

import androidx.appcompat.app.AppCompatActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.leonardosilva.age2.api.DataService;
import com.leonardosilva.age2.model.Civilization;

public class MainActivity extends AppCompatActivity {
    private static String TAG = "TAG";

    private Spinner spinnerCivi;
    private Retrofit retrofit;

    private TextView textName;
    private TextView textExpansion;
    private TextView textArmyType;
    private TextView textTeamBonus;
    private TextView textCivilizationBonus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        retrofit = new Retrofit.Builder()
                .baseUrl("https://age-of-empires-2-api.herokuapp.com/")
                .addConverterFactory(GsonConverterFactory.create()).build();

        spinnerCivi = findViewById(R.id.spinnerCivi);

        textName = findViewById(R.id.textName);
        textExpansion = findViewById(R.id.textExpansion);
        textArmyType = findViewById(R.id.textArmyType);
        textTeamBonus = findViewById(R.id.textTeamBonus);
        textCivilizationBonus = findViewById(R.id.textCivilizationBonus);


        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.civilization,
                android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerCivi.setAdapter(adapter);

        spinnerCivi.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                recuperar();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    private void recuperar(){
        String a = spinnerCivi.getSelectedItem().toString();
        DataService dataService = retrofit.create(DataService.class);
        Call<Civilization> call = dataService.getCivilization(spinnerCivi.getSelectedItem().toString());

        call.enqueue(new Callback<Civilization>() {
            @Override
            public void onResponse(Call<Civilization> call, Response<Civilization> response) {
                if (response.isSuccessful()) {
                    Civilization civilization = response.body();
                    textName.setText(civilization.getName());
                    textExpansion.setText(civilization.getExpansion());
                    textArmyType.setText(civilization.getArmy_type());
                    textTeamBonus.setText(civilization.getTeam_bonus());
                    textCivilizationBonus.setText(civilization.getCivilization_bonus().toString());

                }else{
                    Log.d(TAG, "onResponse: "+response.message());
                }
            }

            @Override
            public void onFailure(Call<Civilization> call, Throwable t) {
                Log.d(TAG, "onFailure: "+t.getMessage());
            }
        });
    }

}
