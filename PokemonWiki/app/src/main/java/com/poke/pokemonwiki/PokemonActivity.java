package com.poke.pokemonwiki;

import android.os.Bundle;
import android.os.StrictMode;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.List;

public class PokemonActivity extends android.support.v4.app.Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //myView = inflater.inflate(R.layout.activity_maps, container, false);
        //return super.onCreateView(inflater, container, savedInstanceState);
        return inflater.inflate(R.layout.tela_pokemon, container, false);
    }

    PokemonList pokemons = new PokemonList();

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        pokemons.getPokemons();

        List<String> pokeNames = pokemons.returnAllPokemons();


        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_dropdown_item, pokeNames);

        final Spinner spinnerPokemonName = (Spinner) getView().findViewById(R.id.choosePokemonName);

        //final Spinner spinnerMusic = (Spinner) findViewById(R.id.chooseMusic);

        spinnerPokemonName.setAdapter(adapter);



        spinnerPokemonName.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {

                String selectedPokemonName = String.valueOf(spinnerPokemonName.getSelectedItem());

                List<String> tipos = pokemons.returnPokemonByName(selectedPokemonName);


                ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(getActivity().getApplicationContext(), android.R.layout.simple_spinner_dropdown_item, tipos);
                //Exibindo numero da pokedex do pokemon
                String numeroPokedex = pokemons.returnPokedex(selectedPokemonName);
                TextView resultArea1 = (TextView) getView().findViewById(R.id.pokedex);
                resultArea1.setText(numeroPokedex);
                //Exibindo Tipo 1 do pokemon
                String tipoPokemon1 = pokemons.returnTipo1(selectedPokemonName);
                TextView resultArea2 = (TextView) getView().findViewById(R.id.type1);
                resultArea2.setText(tipoPokemon1);
                //Exibindo Tipo 2 do pokemon
                String tipoPokemon2 = pokemons.returnTipo2(selectedPokemonName);
                TextView resultArea3 = (TextView) getView().findViewById(R.id.type2);
                resultArea3.setText(tipoPokemon2);
                String regiaoPokemon = pokemons.returnRegion(selectedPokemonName);
                TextView resultArea4 = (TextView) getView().findViewById(R.id.region);
                resultArea4.setText(regiaoPokemon);


                //spinnerMusic.setAdapter(adapter2);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // your code here
            }

        });
    }
}