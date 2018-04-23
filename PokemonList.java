package com.example.pedroluis.teste;

import java.util.LinkedList;
import java.util.List;

public class PokemonList {

    List<Pokemon> pokemons = new LinkedList<Pokemon>();
    Connection connection = new Connection();

    public void getPokemons(){
        try {
            pokemons = connection.sendGet();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<String> returnAllPokemons(){
        List<String> pokeNames = new LinkedList<String>();
        for(Pokemon pokemon: pokemons){
            pokeNames.add(pokemon.getPokemonName());
        }
        return pokeNames;
    }

    public List<String> returnPokemonByName(String pokemonName){
        List<String> found = new LinkedList<String>();
        for(Pokemon pokemon: pokemons){
            if(pokemon.getPokemonName().equals(pokemonName)) found.add(pokemon.getType1());
        }
        return found;
    }

    /*public String returnChords(String band, String musicName){
        for(Music music: pokemons){
            if(music.getBand().equals(band) && music.getMusicName().equals(musicName)) return music.getChords();
        }
        return "Sorry...";
    }*/
    //Retorna apenas o pokemon selecionado sem depender de outra variável, consequentemente de outro Spinner
    public String returnPokedex(String pokemonName){
        for(Pokemon pokemon: pokemons){
            if(pokemon.getPokemonName().equals(pokemonName))return pokemon.getPokedex();
        }
        return "Sorry...";
    }
    public String returnTipo1(String type1){
        for (Pokemon pokemon: pokemons){
            if(pokemon.getPokemonName().equals(type1)) return pokemon.getType1();
        }
        return "Sorry...";
    }

    public String returnTipo2(String type2){
        for(Pokemon pokemon: pokemons){
            if(pokemon.getPokemonName().equals(type2))return pokemon.getType2();
        }
        return "Sorry...";
    }



}
