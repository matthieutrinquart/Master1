package server;

public class Espece {


    private String speciesName;
    private String race;
    private int speciesAverageLife;

    protected Espece(String _speciesName , String _race , int _speciesAverageLife){

        this.speciesName = _speciesName;
        this.race = _race;
        this.speciesAverageLife = _speciesAverageLife;
    }

    public String getSpeciesName() {
        return speciesName;
    }

    public String getRace() {
        return race;
    }

    public int getSpeciesAverageLife() {
        return speciesAverageLife;
    }


}
