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

public class CycleEntry {
     private String name;
  private Calendar dateAndTime;
  private float distance;
  private String surface;
  private String speed;
  
  public CycleEntry (String n, int d, int m, int y, int h, int min, int s, float dist, String sf, String sp) {
    name = n;
    Calendar inst = Calendar.getInstance();
    inst.set(y,m-1,d,h,min,s);
    dateAndTime = inst;
    distance = dist;
    surface = sf;
    speed = sp;
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

  public float getCycleDistance () {
    return distance;
  } //getYear
  public String getSurface() {
      return surface;
  }
  public String getSpeed() {
      return speed;
  }

  public String getCycleEntry () {
   String result = getName()+" cycled " + getCycleDistance() + " km in "
             +getHour()+":"+getMin()+":"+ getSec() + " on "
             +getDay()+ "/" +getMonth() + "/" +getYear() 
             +" on surface: " + getSurface() 
             +" at " + getSpeed() + " kmph. \n";
   return result;
  } //getEntry
}
