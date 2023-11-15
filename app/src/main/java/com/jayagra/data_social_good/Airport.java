package com.jayagra.data_social_good;

import java.util.Arrays;
import java.util.List;

// airport class to represent a line from text file
public class Airport {
  // all public because too much crap to write getters for
  public String airportCode;
  public String airportName;
  public String timeLabel;
  public int timeMonth;
  public String timeMonthName;
  public String timeYear;
  public int carrierDelays;
  public int aircraftDelays;
  public int nasDelays;
  public int securityDelays;
  public int weatherDelays;
  public String carriers;
  public int carrierCount;
  public int cancelledFlights;
  public int delayedFlights;
  public int divertedFlights;
  public int ontimeFlights;
  public int totalFlights;
  public int minutesDelayedCarrier;
  public int minutesDelayedAircraft;
  public int minutesDelayedNas;
  public int minutesDelayedSecurity;
  public int minutesDelayedTotal;
  public int minutesDelayedWeather;

  public Airport(final String row) {
    // just throw the data in
    List<String> items = Arrays.asList(row.split("\",\""));
    this.airportCode = items.get(0).substring(1);
    this.airportName = items.get(1);
    this.timeLabel = items.get(2);
    this.timeMonth = Integer.parseInt(items.get(3));
    this.timeMonthName = items.get(4);
    this.timeYear = items.get(5);
    this.carrierDelays = Integer.parseInt(items.get(6));
    this.aircraftDelays = Integer.parseInt(items.get(7));
    this.nasDelays = Integer.parseInt(items.get(8));
    this.securityDelays = Integer.parseInt(items.get(9));
    this.weatherDelays = Integer.parseInt(items.get(10));
    this.carriers = items.get(11);
    this.carrierCount = Integer.parseInt(items.get(12));
    this.cancelledFlights = Integer.parseInt(items.get(13));
    this.delayedFlights = Integer.parseInt(items.get(14));
    this.divertedFlights = Integer.parseInt(items.get(15));
    this.ontimeFlights = Integer.parseInt(items.get(16));
    this.totalFlights = Integer.parseInt(items.get(17));
    this.minutesDelayedCarrier = Integer.parseInt(items.get(18));
    this.minutesDelayedAircraft = Integer.parseInt(items.get(19));
    this.minutesDelayedNas = Integer.parseInt(items.get(20));
    this.minutesDelayedSecurity = Integer.parseInt(items.get(21));
    this.minutesDelayedTotal = Integer.parseInt(items.get(22));
    this.minutesDelayedWeather = Integer.parseInt(items.get(23).substring(0, items.get(23).length() - 1));
  }

  public Airport() {
    // do jackshit
  }

  public String toString() {
    // something said i needed this but i never call it so idk
    return this.airportCode + "_" + this.airportName + "_" + this.timeLabel;
  }
}