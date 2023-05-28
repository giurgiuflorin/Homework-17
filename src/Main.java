import java.io.FileNotFoundException;
import java.util.List;


public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        Country country = new Country();
        List<Country> countryList = country.getCountryList();

        CountryService countryService = new CountryService(countryList);


        // - list all countries:  -> returns a list of country objects
        System.out.println(countryService.listAllCountries());

        //- list all country names :  -> returns a list of strings
        System.out.println(countryService.listAllCountryNames());

        //- get capital of a country :  -> returns a string
        System.out.println(countryService.getCapitalOfCountry("Andorra"));

        //- get population of a country : -> returns a long
        System.out.println(countryService.getPopulationOfCountry("Andorra"));

        //- get countries in continent : -> returns list of Country objects
        System.out.println(countryService.getCountriesFromContinent("Asia"));

        //- get country neighbours :  -> returns list of Strings
        System.out.println(countryService.getCountryNeighbours("Afghanistan"));

        //- get countries in <continent> with population larger than <population> : -> returns list of Country objects
        System.out.println(countryService.getCountriesWithPopLargerThanFromCont("Asia", 120935800));

        //- get countries that neighbor X but not neighbor Y :-> returns list of Country objects
        // ma folosesc de exemplul primei tari din countries.txt
        //Afghanistan|Kabul|27657145|652230|Asia|IRN~PAK~TKM~UZB~TJK~CHN

        System.out.println(countryService.getCountriesOnlyWithNeighbourX("IRN", "GRC"));
    }

}
