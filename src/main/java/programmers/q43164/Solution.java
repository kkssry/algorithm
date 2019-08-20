package programmers.q43164;

import java.util.*;

public class Solution {
    List<City> list = new ArrayList<>();

    public String[] solution(String[][] tickets) {
        String[] answer = new String[tickets.length + 1];
        City[] cities = new City[tickets.length];
        initCities(cities, tickets);
        PriorityQueue<City> priorityQueue = new PriorityQueue<>();
        initPriorityQueue(priorityQueue, cities);
        Arrays.sort(cities);
        saveResult(priorityQueue, cities);
        initAnswer(list,answer);
//        System.out.println(Arrays.toString(answer));
        return answer;
    }

    private void initAnswer(List<City> list, String[] answer) {
        for (int i = 0; i < answer.length; i++) {
            if (i == 0) {
                answer[i] = list.get(0).departurePlace;
            }
            if (i == 1) {
                answer[i] = list.get(0).arrivalPlace;
            }
            if (i > 1) {
                answer[i] = list.get(i - 1).arrivalPlace;
            }
        }
    }

    private void initCities(City[] cities, String[][] tickets) {
        for (int i = 0; i < cities.length; i++) {
            cities[i] = new City(i, tickets[i][0], tickets[i][1]);
        }
    }

    private void saveResult(PriorityQueue<City> priorityQueue, City[] cities) {
        while (!priorityQueue.isEmpty()) {
            list.clear();
            initIsCheckedAndCount(cities);
            City startCity = priorityQueue.poll();
            checkCount(cities, startCity);
            list.add(startCity);
            startDFS(cities, startCity);
            if (list.size() == cities.length) {
                return;
            }
        }
    }

    private void checkCount(City[] cities, City startCity) {
        for (City city : cities) {
            if (city.equals(startCity)) {
                city.isChecked = true;
                return;
            }
        }
    }

    private void startDFS(City[] cities, City previousCity) {
        if (list.size() == cities.length) {
            return;
        }

        for (City nextCity : cities) {
            if (previousCity.arrivalPlace.equals(nextCity.departurePlace) && !nextCity.isChecked) {
                    nextCity.isChecked = true;
                    list.add(nextCity);
                    startDFS(cities, nextCity);
                    if (list.size() == cities.length) {
                        return;
                    }
                    list.remove(nextCity);
                    nextCity.isChecked = false;
            }
        }
    }

    private void initIsCheckedAndCount(City[] cities) {
        for (City city : cities) {
            city.isChecked = false;
        }
    }

    private void initPriorityQueue(PriorityQueue<City> priorityQueue, City[] cities) {
        for (City city : cities) {
            if (city.departurePlace.equals("ICN")) {
                priorityQueue.add(city);
            }
        }
    }

    static class City implements Comparable<City> {
        int id;
        String departurePlace;
        String arrivalPlace;
        boolean isChecked;

        City(int id, String departurePlace, String arrivalPlace) {
            this.id = id;
            this.departurePlace = departurePlace;
            this.arrivalPlace = arrivalPlace;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof City)) return false;
            City city = (City) o;
            return id == city.id;
        }

        @Override
        public int hashCode() {
            return Objects.hash(id);
        }

        @Override
        public int compareTo(City o) {
            if (departurePlace.compareTo(o.departurePlace) == 0) {
                return arrivalPlace.compareTo(o.arrivalPlace);
            }
            return departurePlace.compareTo(o.departurePlace);
        }

        @Override
        public String toString() {
            return id + " " + departurePlace + " " + arrivalPlace;

        }
    }
}

