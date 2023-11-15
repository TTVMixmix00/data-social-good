package com.jayagra.data_social_good;

import java.util.Scanner;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// your computer might hate this. it stores a 4k line text file by creating an arraylist of objects in memory.
public class DataRunner {
    public static void main(String[] args) {
        // initialize some variables that may be used later
        BufferedReader stream;
        ArrayList<Airport> airports = new ArrayList<Airport>();
        // try catch to prevent unhandled ioexceptions
        try {
            // create bufferedreader from filereader to read the airport text file
            stream = new BufferedReader(new InputStreamReader(new GetBufferedReader().a()));
            // current line
            String line = stream.readLine();
            // notify user that we're reading data now
            System.out.println("reading data...");
            // iterates over whole text file
            while (line != null) {
                // make sure we're not reading the first line
                if (!line.contains("airportCode")) {
                    // add a new airport object constructed by passing the current line
                    airports.add(new Airport(line));
                    // UNUSED CODE: System.out.println(airports.get(airports.size() - 1));
                    // progress indicator
                    System.out.print("█");
                }
                // advance to next line
                line = stream.readLine(); 
            }
            // make 2 empty lines
            System.out.println("\n");
            // prevent resource leaks, close bufferedreader
            stream.close();
            // data loaded
            // set up a scanner for user input on system.in
            Scanner inp = new Scanner(System.in);
            // UNUSED CODE: System.out.println("Get data on...\n\t0 - an airport\n\t1 - a year\n\t2 - a month (by name)\n");
            // user prompt
            System.out.println("enter an airport code to get data on:");
            String res = inp.next();
            // close scanner
            inp.close();

            /* stupid "search algo" */
            // results arraylist
            ArrayList<Airport> results = new ArrayList<Airport>();
            // iterate over all the airports and find matches
            for (Airport bad : airports) {
                if (bad.airportCode.equals(res)) {
                    results.add(bad);
                    // print full block for match
                    System.out.print("█");
                } else {
                    // and print an underscore for no match
                    System.out.print("▁");
                }
            }
            // 2 empty lines
            System.out.println("\n");
            // check to ensure there are results
            if (results.size() == 0) {
                // no results :(
                System.out.println("no results.");
            } else {
                // get average of results
                Airport avg = average(results);
                // why isnt this a tostring
                // i didnt want to move the code
                // print statement to user
                System.out.println("Airport " + res + " had an average of " + avg.delayedFlights + " delayed flights (" 
                                + avg.carrierDelays + " carrier delays, " + avg.aircraftDelays + " aircraft delays, "
                                + avg.nasDelays + "national aviation system delays, " + avg.securityDelays + " and weather delays)"
                                + ", " + avg.cancelledFlights + " cancelled flights, " + avg.divertedFlights + " diverted flights, and " + 
                                + avg.ontimeFlights + " on time flights, for a total of " + avg.totalFlights + " flights (per month). " 
                                + res + " also had an average delay of " + avg.minutesDelayedTotal + " minutes per month ("
                                + avg.minutesDelayedCarrier + " carrier, " + avg.minutesDelayedAircraft + " aircraft, " + avg.minutesDelayedNas
                                + " national aviation system, " + avg.minutesDelayedSecurity + " security, and " + avg.minutesDelayedWeather
                                + " due to weather.).");
            }
        } catch (IOException shit) {
            // io error 😭
            shit.printStackTrace();
        }
    }

    // ↓ im not documenting this garbage code ↓
    private static Airport average(ArrayList<Airport> airports) {
        // because of int/double, the avgs will be calculated to truncated integer precision. this is ok because it was a ui choice guys it wasne because i didnt want to write another type
        Airport avg = new Airport();
        for (Airport worse : airports) {
            avg.carrierDelays += worse.carrierDelays;
            avg.aircraftDelays += worse.aircraftDelays;
            avg.nasDelays += worse.nasDelays;
            avg.securityDelays += worse.securityDelays;
            avg.weatherDelays += worse.weatherDelays;
            avg.cancelledFlights += worse.cancelledFlights;
            avg.delayedFlights += worse.delayedFlights;
            avg.divertedFlights += worse.divertedFlights;
            avg.ontimeFlights += worse.ontimeFlights;
            avg.totalFlights += worse.totalFlights;
            avg.minutesDelayedCarrier += worse.minutesDelayedCarrier;
            avg.minutesDelayedAircraft += worse.minutesDelayedAircraft;
            avg.minutesDelayedNas += worse.minutesDelayedNas;
            avg.minutesDelayedSecurity += worse.minutesDelayedSecurity;
            avg.minutesDelayedTotal += worse.minutesDelayedTotal;
            avg.minutesDelayedWeather += worse.minutesDelayedWeather;
        }
        // too expensive to go total all of the crap every time
        int arraySize = airports.size();
        avg.carrierDelays /= arraySize;
        avg.aircraftDelays /= arraySize;
        avg.nasDelays /= arraySize;
        avg.securityDelays /= arraySize;
        avg.weatherDelays /= arraySize;
        avg.cancelledFlights /= arraySize;
        avg.delayedFlights /= arraySize;
        avg.divertedFlights /= arraySize;
        avg.ontimeFlights /= arraySize;
        avg.totalFlights /= arraySize;
        avg.minutesDelayedCarrier /= arraySize;
        avg.minutesDelayedAircraft /= arraySize;
        avg.minutesDelayedNas /= arraySize;
        avg.minutesDelayedSecurity /= arraySize;
        avg.minutesDelayedTotal /= arraySize;
        avg.minutesDelayedWeather /= arraySize;
        return avg;
    }
}