/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stir.cscu9t4practical1;

/**
 *
 * @author edunn
 */
import java.util.Calendar;

public class RunEntry {
  private String name;
  private Calendar dateAndTime;
  private float distance;
  private int repetitions;
  private int recovery;
  
  public RunEntry (String n, int d, int m, int y, int h, int min, int s, float dist, int rep, int rec) {
    name = n;
    Calendar inst = Calendar.getInstance();
    inst.set(y,m-1,d,h,min,s);
    dateAndTime = inst;
    distance = dist;
    repetitions = rep;
    recovery = rec;
  } //constructor
  
  public String getName () {
    return name;
  } //getName
  
  public int getDay () {
    return dateAndTime.get(Calendar.DATE);
  } //getDay
  
  public int getMonth () {
    int month =  dateAndTime.get(Calendar.MONTH) + 1;
    return month;
  } //getMonth
  
  public int getYear () {
    return dateAndTime.get(Calendar.YEAR);
  } //getYear

  public int getHour () {
    return dateAndTime.get(Calendar.HOUR);
  } //getHour

  public int getMin () {
    return dateAndTime.get(Calendar.MINUTE);
  } //getMin

  public int getSec () {
    return dateAndTime.get(Calendar.SECOND);
  } //getSec

  public float getRunDistance () {
    return distance;
  } //getYear
  
  public int getRepetitions() {
      return repetitions;
  }
  public int getRecovery() {
      return recovery;
  }

  public String getRunEntry () {
   String result = getName()+" ran " + getRunDistance() + " km in "
             +getHour()+":"+getMin()+":"+ getSec() + " on "
             +getDay()+"/"+getMonth()+"/"+getYear()
             + " Repetitions: " + getRepetitions() 
             + " Recovery Time: "+ getRecovery() + " minutes. \n";
   return result;
  } //getEntry
}
