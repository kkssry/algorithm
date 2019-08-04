package baekjoon.q9203;

import java.io.*;
import java.time.*;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCount = Integer.parseInt(br.readLine());
        int[] results = new int[testCount];
        executeTest(testCount, results,br);
        IntStream.of(results).forEach(System.out::println);
    }

    private static void executeTest(int testCount, int[] results, BufferedReader br) throws IOException {
        for (int i = 0; i < testCount; i++) {
            int[] reservNCleanInfo = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            Reservation[] reservations = new Reservation[reservNCleanInfo[0]];

            initReservations(reservNCleanInfo, reservations, br);
            Arrays.sort(reservations);
            saveEfficientRoomCount(reservations);
            results[i] = reservationRoomCount(reservations);
        }
    }

    private static int reservationRoomCount(Reservation[] reservations) {
        Set<String> identities = new HashSet<>();
        for (Reservation reservation : reservations) {
            identities.add(reservation.identity);
        }
        return identities.size();
    }

    private static void saveEfficientRoomCount(Reservation[] reservations) {
        String identifier1 = "i";
        int identifier2 = 0;

        reservations[0].identity = identifier1 + identifier2;
        for (int i = 1; i < reservations.length; i++) {
            Reservation currentReservation = reservations[i];
            for (int j = 0; j < i; j++) {
                Reservation pastReservation = reservations[j];
                if (pastReservation.isOpen) {
                    if (currentReservation.startDateTime.compareTo(pastReservation.endDateTime) < 0) {
                        identifier2++;
                        currentReservation.identity = identifier1 + identifier2;
                    } else {
                        pastReservation.isOpen = false;
                        currentReservation.identity = pastReservation.identity;
                    }
                }
            }
        }

    }

    private static void initReservations(int[] reservNCleanInfo, Reservation[] reservations, BufferedReader br) throws IOException {
        int cleaningTime = reservNCleanInfo[1];

        for (int j = 0; j < reservNCleanInfo[0]; j++) {
            String[] reservationDateTime = br.readLine().split(" ");
            LocalDate startDate = LocalDate.parse(reservationDateTime[1]);
            LocalTime startTime = LocalTime.parse(reservationDateTime[2]);
            LocalDateTime startDateTime = LocalDateTime.of(startDate,startTime);

            LocalDate endDate = LocalDate.parse(reservationDateTime[3]);
            LocalTime endTime = LocalTime.parse(reservationDateTime[4]);
            LocalDateTime endDateTime = LocalDateTime.of(endDate, endTime);
            endDateTime = endDateTime.plus(cleaningTime, ChronoUnit.MINUTES);

            reservations[j] = new Reservation(startDateTime, endDateTime);
        }
    }

    static class Reservation implements Comparable<Reservation> {
        LocalDateTime startDateTime;
        LocalDateTime endDateTime;
        boolean isOpen = true;
        String identity;

        Reservation(LocalDateTime startDateTime, LocalDateTime endDateTime) {
            this.startDateTime = startDateTime;
            this.endDateTime = endDateTime;
        }

        @Override
        public int compareTo(Reservation o) {
            return this.startDateTime.compareTo(o.startDateTime);
        }

        @Override
        public String toString() {
            return "Reservation{" +
                    "startDateTime=" + startDateTime +
                    ", endDateTime=" + endDateTime +
                    '}';
        }
    }
}
