import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;


public class Country {


    private int id = 1000;
    private String name;
    private String capital;
    private int population;
    private int area;
    private String continent;
    private List<String> neighbours;

    private final List<Country> countryList = new ArrayList<>();

    public Country() throws FileNotFoundException {
        addCountriesFromFile();
    }

    private Country(int id, String name, String capital, int population,
                    int area, String continent, List<String> neighbours) {
        this.id = id;
        this.name = name;
        this.capital = capital;
        this.population = population;
        this.area = area;
        this.continent = continent;
        this.neighbours = neighbours;
    }

    public void addCountriesFromFile() throws FileNotFoundException {

        int idAdder = 1;


        Scanner scanner = new Scanner(new File(".idea/countries.txt"));


        while (scanner.hasNext()) {

            String line = scanner.nextLine();
            String[] tokens = line.split(Pattern.quote("|"));
            String[] neighbours;
            if (tokens.length > 5) {
                neighbours = tokens[5].split(Pattern.quote("~"));
            } else {
                neighbours = null;
            }


            countryList.add(new Country(
                    id + (idAdder++),
                    tokens[0],
                    tokens[1],
                    Integer.parseInt(tokens[2]),
                    Integer.parseInt(tokens[3]),
                    tokens[4],
                    tokens.length > 5 ? List.of(neighbours) : null
//
            ));
        }

    }


    public List<Country> getCountryList() {
        return countryList;
    }

    @Override
    public String toString() {
        return id + " "
                + name + " "
                + capital + " "
                + population + " "
                + area + " "
                + continent + " "
                + " --- List of neighbours "
                + neighbours
                + "\n";
    }

    public String getName() {
        return name;
    }

    public String getCapital() {
        return capital;
    }

    public int getPopulation() {
        return population;
    }

    public String getContinent() {
        return continent;
    }

    public List<String> getNeighbours() {
        return neighbours;
    }
}
