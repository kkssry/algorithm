package baekjoon.q8979;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int countryCount = sc.nextInt();
        int findCountry = sc.nextInt();
        Country[] countries = new Country[countryCount];
        initCountrys(countries, sc);
        Arrays.sort(countries);
        initRank(countries);
        int findIndex = findIndex(countries, findCountry);
        findCountryRank(countries, findIndex);
    }

    private static int findIndex(Country[] countries, int findCountry) {
        int findIndex = 0;
        for (int i = 0; i < countries.length; i++) {
            if (countries[i].value == findCountry) {
                findIndex = i;
                break;
            }
        }
        return findIndex;
    }

    private static void findCountryRank(Country[] countrys, int findIndex) {
        int count = 1;
        for (Country country : countrys) {
            if (countrys[findIndex].rank <= country.rank) {
                break;
            }
            count++;
        }
        System.out.println(count);
    }

    private static void initRank(Country[] countries) {
        countries[0].rank = 1;
        for (int i = 1; i < countries.length; i++) {
            if (!countries[i].equals(countries[i - 1])) {
                countries[i].rank = countries[i - 1].rank + 1;
            }
                countries[i].rank = countries[i - 1].rank;

        }
    }

    private static void initCountrys(Country[] countrys, Scanner sc) {
        for (int i = 0; i < countrys.length; i++) {
            int value = sc.nextInt();
            int goldCount = sc.nextInt();
            int silverCount = sc.nextInt();
            int bronzeCount = sc.nextInt();
            countrys[i] = new Country(value, goldCount, silverCount, bronzeCount);
        }
    }

    static class Country implements Comparable<Country> {
        int rank;
        int value;
        int goldCount;
        int silverCount;
        int bronzeCount;

        Country(int value, int goldCount, int silverCount, int bronzeCount) {
            this.value = value;
            this.goldCount = goldCount;
            this.silverCount = silverCount;
            this.bronzeCount = bronzeCount;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Country)) return false;
            Country country = (Country) o;
            return goldCount == country.goldCount &&
                    silverCount == country.silverCount &&
                    bronzeCount == country.bronzeCount;
        }

        @Override
        public int hashCode() {
            return Objects.hash(goldCount, silverCount, bronzeCount);
        }

        @Override
        public String toString() {
            return "Country{" +
                    "rank=" + rank +
                    ", value=" + value +
                    ", goldCount=" + goldCount +
                    ", silverCount=" + silverCount +
                    ", bronzeCount=" + bronzeCount +
                    '}';
        }

        @Override
        public int compareTo(Country o) {
            if (goldCount == o.goldCount) {
                if (silverCount == o.silverCount) {
                    return Integer.compare(o.bronzeCount, bronzeCount);
                }
                return Integer.compare(o.silverCount, silverCount);
            }
            return Integer.compare(o.goldCount, goldCount);

        }
    }
}

