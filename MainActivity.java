package com.example.pedroluis.teste;

import android.app.Activity;
import android.os.Bundle;
import android.os.StrictMode;


import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends Activity {

    PokemonList pokemons = new PokemonList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pokemons.getPokemons();

        List<String> pokeNames = pokemons.returnAllPokemons();


        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, pokeNames);

        final Spinner spinnerPokemonName = (Spinner) findViewById(R.id.choosePokemonName);

        //final Spinner spinnerMusic = (Spinner) findViewById(R.id.chooseMusic);

        spinnerPokemonName.setAdapter(adapter);



        spinnerPokemonName.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {

                String selectedPokemonName = String.valueOf(spinnerPokemonName.getSelectedItem());

                List<String> tipos = pokemons.returnPokemonByName(selectedPokemonName);


                ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_dropdown_item, tipos);
                //Exibindo numero da pokedex do pokemon
                String numeroPokedex = pokemons.returnPokedex(selectedPokemonName);
                TextView resultArea1 = (TextView) findViewById(R.id.pokedex);
                resultArea1.setText(numeroPokedex);
                //Exibindo Tipo 1 do pokemon
                String tipoPokemon1 = pokemons.returnTipo1(selectedPokemonName);
                TextView resultArea2 = (TextView) findViewById(R.id.type1);
                resultArea2.setText(tipoPokemon1);
                //Exibindo Tipo 2 do pokemon
                String tipoPokemon2 = pokemons.returnTipo2(selectedPokemonName);
                TextView resultArea3 = (TextView) findViewById(R.id.type2);
                resultArea3.setText(tipoPokemon2);


                //spinnerMusic.setAdapter(adapter2);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // your code here
            }

        });

        /*spinnerMusic.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {

                String selectedBand = String.valueOf(spinnerBand.getSelectedItem());
                String selectedMusic = String.valueOf(spinnerMusic.getSelectedItem());
                String result = pokemons.returnChords(selectedBand, selectedMusic);
                TextView resultArea = (TextView) findViewById(R.id.result);

                resultArea.setText(result);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // your code here
            }

        });*/

    }

}
