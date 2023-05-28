import java.io.FileNotFoundException;
import java.util.List;


public class CountryService extends Country {

    private List<Country> countryList;

    public CountryService(List<Country> countryList) throws FileNotFoundException {
        super();
        this.countryList = countryList;
    }


    public List<Country> listAllCountries() {

        return countryList;

    }

    public List<String> listAllCountryNames() {

        List<String> countryNames = countryList.stream().
                map(Country::getName).
                toList();

        return countryNames;
    }

    public String getCapitalOfCountry(String nameOfCountry) {

        List<String> list = countryList.stream().
                filter(country -> country.getName().equalsIgnoreCase(nameOfCountry)).
                map(Country::getCapital).
                toList();

        if (list.size() == 0) {
            return "Country not in the list or name spelled wrong";
        }

        return list.get(0);
    }

    public long getPopulationOfCountry(String nameOfCountry) {

        List<Integer> list = countryList.stream().
                filter(country -> country.getName().equalsIgnoreCase(nameOfCountry)).
                map(Country::getPopulation).
                toList();

        if (list.size() == 0) {
            System.out.println("Country not in the list or name spelled wrong");
            return -1;
        }

        return list.get(0);
    }

    //- get countries in continent : -> returns list of Country objects
    public List<Country> getCountriesFromContinent(String continent) {

        List<Country> list = countryList.stream().
                filter(country -> country.getContinent().equalsIgnoreCase(continent)).
                toList();

        if (list.size() == 0) {
            System.out.println("Country not in the list or name spelled wrong");
            return null;
        }
        return list;
    }

    public List<String> getCountryNeighbours(String countryName) {

        List<String> list = countryList.stream().
                filter(country -> country.getName().equalsIgnoreCase(countryName)).
                map(country -> country.getNeighbours().toString()).toList();

        if (list.size() == 0) {
            System.out.println("Country doesn't have neighbours");
            return null;
        }

        return list;
    }

    public List<Country> getCountriesWithPopLargerThanFromCont(String countryName, int population) {

        List<Country> list = countryList.stream().
                filter(country -> country.getContinent().equalsIgnoreCase(countryName)).
                filter(country -> country.getPopulation() > population).
                toList();

        if (list.size() == 0) {
            System.out.println("No match found");
        }
        return list;

    }

    public List<Country> getCountriesOnlyWithNeighbourX(String neighbourName, String excludedNeighbour) {

        List<Country> list = countryList.stream().
                filter(country -> country.getNeighbours() != null).
                filter(country -> country.getNeighbours().contains(neighbourName)
                        && !country.getNeighbours().contains(excludedNeighbour)).
                toList();

        return list;
    }
}

