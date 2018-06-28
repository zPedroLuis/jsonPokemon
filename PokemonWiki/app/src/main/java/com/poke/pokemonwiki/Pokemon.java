package com.poke.pokemonwiki;

public class Pokemon {

    private String pokedex;
    private String pokemonName;
    private String type1;
    private String type2;
    private String region;

    public Pokemon(String pokedex, String pokemonName, String type1, String type2, String region){
        this.pokedex = pokedex;
        this.pokemonName = pokemonName;
        this.type1 = type1;
        this.type2 = type2;
        this.region = region;
    }

    public String getPokedex(){
        return this.pokedex;
    }

    public String getPokemonName(){ return this.pokemonName; }

    public String getType1(){ return this.type1; }

    public String getType2(){ return this.type2; }

    public String getRegion(){ return this.region;}

}

