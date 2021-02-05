// An implementation of a Training Record as an ArrayList
package com.stir.cscu9t4practical1;

import java.util.*;

public class TrainingRecord {

    private List<RunEntry> runTR;
    private List<SwimmingEntry> swimTR;
    private List<CycleEntry> cycleTR;

    public TrainingRecord() {
        runTR = new ArrayList<RunEntry>();
        swimTR = new ArrayList<SwimmingEntry>();
        cycleTR = new ArrayList<CycleEntry>();

    } //constructor

    // add a record to the list
    public void addRunEntry(RunEntry run) {
        runTR.add(run);
    } // addClass

    public void addSwimEntry(SwimmingEntry swim) {
            swimTR.add(swim);
    } // addClass

    public void addCycleEntry(CycleEntry cycle) {
        cycleTR.add(cycle);
    } // addClass
    public void removeEntry(String n, int d, int m, int y)
    {
        ListIterator<RunEntry> runIter = runTR.listIterator();
        ListIterator<SwimmingEntry> swimIter = swimTR.listIterator();
        ListIterator<CycleEntry> cycleIter = cycleTR.listIterator();
        while (runIter.hasNext()) {
            RunEntry current = runIter.next();
            if (current.getName().equals(n) && current.getDay() == d && current.getMonth() == m && current.getYear() == y) {
                runIter.remove();
            }
        }
        while (swimIter.hasNext()) {
            SwimmingEntry current = swimIter.next();
            if (current.getName().equals(n) && current.getDay() == d && current.getMonth() == m && current.getYear() == y) {
                swimIter.remove();
            }
        }
        while (cycleIter.hasNext()) {
            CycleEntry current = cycleIter.next();
            if (current.getName().equals(n) && current.getDay() == d && current.getMonth() == m && current.getYear() == y) {
                cycleIter.remove();
            }
        }
    }

    // look up the entry of a given day and month
    public String lookupEntry(int d, int m, int y) { // to be fixed, add type select gui maybe
        ListIterator<RunEntry> runIter = runTR.listIterator();
        ListIterator<SwimmingEntry> swimIter = swimTR.listIterator();
        ListIterator<CycleEntry> cycleIter = cycleTR.listIterator();
        String result = "No entries found";
        while (runIter.hasNext()) {
            RunEntry current = runIter.next();
            if (current.getDay() == d && current.getMonth() == m && current.getYear() == y) {
                result = current.getRunEntry();
            }
        }
        while (swimIter.hasNext()) {
            SwimmingEntry current = swimIter.next();
            if (current.getDay() == d && current.getMonth() == m && current.getYear() == y) {
                result = current.getSwimEntry();
            }
        }
        while (cycleIter.hasNext()) {
            CycleEntry current = cycleIter.next();
            if (current.getDay() == d && current.getMonth() == m && current.getYear() == y) {
                result = current.getCycleEntry();
            }
        }
        return result;
    } // lookupEntry

    public String findAllEntry(int d, int m, int y) {
        ListIterator<RunEntry> runIter = runTR.listIterator();
        ListIterator<SwimmingEntry> swimIter = swimTR.listIterator();
        ListIterator<CycleEntry> cycleIter = cycleTR.listIterator();

        String result = "";
        String multiResult = "No entries found";

        boolean firstIter = true;
        while (runIter.hasNext()) {
            RunEntry current = runIter.next();
            if (current.getDay() == d && current.getMonth() == m && current.getYear() == y) {
                if (firstIter == true) {
                    multiResult = current.getRunEntry();
                    firstIter = false;
                } else {
                    multiResult = multiResult + current.getRunEntry();
                }
            }
        }
         while (swimIter.hasNext()) {
            SwimmingEntry current = swimIter.next();
            if (current.getDay() == d && current.getMonth() == m && current.getYear() == y) {
                if (firstIter == true) {
                    multiResult = current.getSwimEntry();
                    firstIter = false;
                } else {
                    multiResult = multiResult + current.getSwimEntry();
                }
            }
        }
          while (cycleIter.hasNext()) {
            CycleEntry current = cycleIter.next();
            if (current.getDay() == d && current.getMonth() == m && current.getYear() == y) {
                if (firstIter == true) {
                    multiResult = current.getCycleEntry();
                    firstIter = false;
                } else {
                    multiResult = multiResult + current.getCycleEntry();
                }
            }
        }
        result = multiResult;
        return result;
    } // findAllEntry
    

    // Count the number of entries
    public int getNumberOfEntries() {
        int numberOfEntries = runTR.size() + swimTR.size() + cycleTR.size();
        return numberOfEntries;
    }
    // Clear all entries
    public void clearAllEntries() {
        runTR.clear();
        swimTR.clear();
        cycleTR.clear();
    }

} // TrainingRecord
