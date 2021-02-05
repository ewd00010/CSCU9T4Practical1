// GUI and main program for the Training Record
package com.stir.cscu9t4practical1;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import java.lang.Number;

public class TrainingRecordGUI extends JFrame implements ActionListener {

    private JTextField name = new JTextField(30);
    private JTextField day = new JTextField(2);
    private JTextField month = new JTextField(2);
    private JTextField year = new JTextField(4);
    private JTextField hours = new JTextField(2);
    private JTextField mins = new JTextField(2);
    private JTextField secs = new JTextField(2);
    private JTextField dist = new JTextField(4);
    private JTextField surface = new JTextField(20);
    private JTextField speed = new JTextField(4);
    private JTextField repetitions = new JTextField(4);
    private JTextField recovery = new JTextField(3);
    private JTextField where = new JTextField(30);
    private JLabel labn = new JLabel(" Name:");
    private JLabel labd = new JLabel(" Day:");
    private JLabel labm = new JLabel(" Month:");
    private JLabel laby = new JLabel(" Year:");
    private JLabel labh = new JLabel(" Hours:");
    private JLabel labmm = new JLabel(" Mins:");
    private JLabel labs = new JLabel(" Secs:");
    private JLabel labdist = new JLabel(" Distance (km):");
    private JLabel labsf = new JLabel (" on Surface:");
    private JLabel labsp = new JLabel (" at speed (kmph):");
    private JLabel labrep = new JLabel(" repetitions:");
    private JLabel labrec = new JLabel("recovery (mins):");
    private JLabel labwhe = new JLabel("location:");
    private JButton addRunInput = new JButton("Create Run Record");
    private JButton addSwimInput = new JButton("Create Swimming Record");
    private JButton addCycleInput = new JButton("Create Cycle Record");
    private JButton addRemoveInput = new JButton("Remove A Record");
    private JButton addLookUpByDateInput = new JButton("Look Up Record By Date");
    private JButton addFindAllByDateInput = new JButton("Find All Records By Date");
    private JButton addRun = new JButton("Add Run");
    private JButton addSwim = new JButton("Add Swim");
    private JButton addCycle = new JButton("Add Cycle");
    private JButton removeEntry = new JButton("remove entry");
    private JButton lookUpByDate = new JButton("Look Up By Date");
    private JButton findAllByDate = new JButton("Find All By Date");
    

    private TrainingRecord myAthletes = new TrainingRecord();

    private JTextArea outputArea = new JTextArea(14, 50);
    
    private boolean onlyOneEntry = true;

    public static void main(String[] args) {
        TrainingRecordGUI applic = new TrainingRecordGUI();
    } // main

    // set up the GUI 
    public TrainingRecordGUI() {
        super("Training Record");
        setLayout(new FlowLayout());
        add(labn);
        add(name);
        name.setEditable(true);
        add(labd);
        add(day);
        day.setEditable(true);
        add(labm);
        add(month);
        month.setEditable(true);
        add(laby);
        add(year);
        year.setEditable(true);
        add(labh);
        add(hours);
        hours.setEditable(true);
        add(labmm);
        add(mins);
        mins.setEditable(true);
        add(labs);
        add(secs);
        secs.setEditable(true);
        add(labdist);
        add(dist);
        dist.setEditable(true);
        add(labsf);
        add(surface);
        surface.setEditable(true);
        add(labsp);
        add(speed);
        speed.setEditable(true);
        add(labrep);
        add(repetitions);
        repetitions.setEditable(true);
        add(labrec);
        add(recovery);
        recovery.setEditable(true);
        add(addRunInput);
        addRunInput.addActionListener(this);
        add(addSwimInput);
        addSwimInput.addActionListener(this);
        add(addCycleInput);
        addCycleInput.addActionListener(this);
        add(addRun);
        addRun.addActionListener(this);
        add(addSwim);
        addSwim.addActionListener(this);
        add(addCycle);
        addCycle.addActionListener(this);
        add(removeEntry);
        removeEntry.addActionListener(this);
        add(lookUpByDate);
        lookUpByDate.addActionListener(this);
        add(findAllByDate);
        findAllByDate.addActionListener(this);
        add(addRemoveInput);
        addRemoveInput.addActionListener(this);
        add(addLookUpByDateInput);
        addLookUpByDateInput.addActionListener(this);
        add(addFindAllByDateInput);
        addFindAllByDateInput.addActionListener(this);
        add(outputArea);
        outputArea.setEditable(false);
        setSize(720, 400);
        setVisible(true);
        blankDisplay();
        
        /*
        sorry for how expansive the follow blocks of code are, at a later point i'll probably change these
        blocks to work with an iterator to remove around 300 lines of code into a nice at most 60 lines worth of iterators
        but i'm running short on time and getting an iterator to work would probably take a good couple hours
        */
        //setting textbox inputs to not show
        findAllByDate.setVisible(false);
        lookUpByDate.setVisible(false);
        removeEntry.setVisible(false);
        addRun.setVisible(false);
        addSwim.setVisible(false);
        addCycle.setVisible(false);
        name.setVisible(false);
        day.setVisible(false); 
        month.setVisible(false);
        year.setVisible(false);
        hours.setVisible(false); 
        mins.setVisible(false); 
        secs.setVisible(false); 
        dist.setVisible(false); 
        surface.setVisible(false);
        speed.setVisible(false);
        recovery.setVisible(false);
        repetitions.setVisible(false);
        where.setVisible(false);
        //setting text input descriptors to not show
        labn.setVisible(false); 
        labd.setVisible(false); 
        labm.setVisible(false); 
        laby.setVisible(false); 
        labh.setVisible(false); 
        labmm.setVisible(false); 
        labs.setVisible(false); 
        labdist.setVisible(false);
        labsf.setVisible(false); 
        labsp.setVisible(false); 
        labrep.setVisible(false);
        labrec.setVisible(false);
        labwhe.setVisible(false);
        
        // To save typing in new entries while testing, uncomment
        // the following lines (or add your own test cases)
        
    } // constructor

    // listen for and respond to GUI events 
    public void actionPerformed(ActionEvent event) {
        String message = "";
        
        if (event.getSource() == addRunInput)
        {
            addRun.setVisible(true);
            repetitions.setVisible(true);
            recovery.setVisible(true);
            name.setVisible(true);
            day.setVisible(true); 
            month.setVisible(true);
            year.setVisible(true);
            hours.setVisible(true); 
            mins.setVisible(true); 
            secs.setVisible(true); 
            dist.setVisible(true);
            labrep.setVisible(true);
            labrec.setVisible(true);
            labn.setVisible(true); 
            labd.setVisible(true); 
            labm.setVisible(true); 
            laby.setVisible(true); 
            labh.setVisible(true); 
            labmm.setVisible(true); 
            labs.setVisible(true); 
            labdist.setVisible(true);
            addRunInput.setVisible(false);
            addSwimInput.setVisible(false);
            addCycleInput.setVisible(false);
            addRemoveInput.setVisible(false);
            addLookUpByDateInput.setVisible(false);
            addFindAllByDateInput.setVisible(false);
        }
        if (event.getSource() == addSwimInput)
        {
            addSwim.setVisible(true);
            where.setVisible(true);
            name.setVisible(true);
            day.setVisible(true); 
            month.setVisible(true);
            year.setVisible(true);
            hours.setVisible(true); 
            mins.setVisible(true); 
            secs.setVisible(true); 
            dist.setVisible(true);
            labwhe.setVisible(true);
            labn.setVisible(true); 
            labd.setVisible(true); 
            labm.setVisible(true); 
            laby.setVisible(true); 
            labh.setVisible(true); 
            labmm.setVisible(true); 
            labs.setVisible(true); 
            labdist.setVisible(true);
            addRunInput.setVisible(false);
            addSwimInput.setVisible(false);
            addCycleInput.setVisible(false);
            addRemoveInput.setVisible(false);
            addLookUpByDateInput.setVisible(false);
            addFindAllByDateInput.setVisible(false);
        }
        if (event.getSource() == addCycleInput)
        {
            labdist.setVisible(true);
            addCycle.setVisible(true);
            surface.setVisible(true);
            speed.setVisible(true);
            name.setVisible(true);
            day.setVisible(true); 
            month.setVisible(true);
            year.setVisible(true);
            hours.setVisible(true); 
            mins.setVisible(true); 
            secs.setVisible(true); 
            dist.setVisible(true);
            labsf.setVisible(true); 
            labsp.setVisible(true); 
            labn.setVisible(true); 
            labd.setVisible(true); 
            labm.setVisible(true); 
            laby.setVisible(true); 
            labh.setVisible(true); 
            labmm.setVisible(true); 
            labs.setVisible(true); 
            addRunInput.setVisible(false);
            addSwimInput.setVisible(false);
            addCycleInput.setVisible(false);
            addRemoveInput.setVisible(false);
            addLookUpByDateInput.setVisible(false);
            addFindAllByDateInput.setVisible(false); 
        }
        if (event.getSource() == addRun) {
            message = addRunEntry("generic");
            addRun.setVisible(false);
            repetitions.setVisible(false);
            recovery.setVisible(false);
            name.setVisible(false);
            day.setVisible(false); 
            month.setVisible(false);
            year.setVisible(false);
            hours.setVisible(false); 
            mins.setVisible(false); 
            secs.setVisible(false); 
            dist.setVisible(false); 
            labrep.setVisible(false);
            labrec.setVisible(false);
            labn.setVisible(false); 
            labd.setVisible(false); 
            labm.setVisible(false); 
            laby.setVisible(false); 
            labh.setVisible(false); 
            labmm.setVisible(false); 
            labs.setVisible(false); 
            labdist.setVisible(false);
            addRunInput.setVisible(true);
            addSwimInput.setVisible(true);
            addCycleInput.setVisible(true);
            addRemoveInput.setVisible(true);
            addLookUpByDateInput.setVisible(true);
            addFindAllByDateInput.setVisible(true);
        }
        if (event.getSource() == addSwim) {
            message = addSwimEntry("generic");
            addSwim.setVisible(false);
            where.setVisible(false);
            name.setVisible(false);
            day.setVisible(false); 
            month.setVisible(false);
            year.setVisible(false);
            hours.setVisible(false); 
            mins.setVisible(false); 
            secs.setVisible(false); 
            dist.setVisible(false);
            labwhe.setVisible(false);
            labn.setVisible(false); 
            labd.setVisible(false); 
            labm.setVisible(false); 
            laby.setVisible(false); 
            labh.setVisible(false); 
            labmm.setVisible(false); 
            labs.setVisible(false); 
            labdist.setVisible(false);
            addRunInput.setVisible(true);
            addSwimInput.setVisible(true);
            addCycleInput.setVisible(true);
            addRemoveInput.setVisible(true);
            addLookUpByDateInput.setVisible(true);
            addFindAllByDateInput.setVisible(true);
        }
        if (event.getSource() == addCycle) {
            message = addCycleEntry("generic");
            addCycle.setVisible(false);
            surface.setVisible(false);
            speed.setVisible(false);
            name.setVisible(false);
            day.setVisible(false); 
            month.setVisible(false);
            year.setVisible(false);
            hours.setVisible(false); 
            mins.setVisible(false); 
            secs.setVisible(false); 
            dist.setVisible(false);
            labsf.setVisible(false); 
            labsp.setVisible(false); 
            labn.setVisible(false); 
            labd.setVisible(false); 
            labm.setVisible(false); 
            laby.setVisible(false); 
            labh.setVisible(false); 
            labmm.setVisible(false); 
            labs.setVisible(false); 
            labdist.setVisible(false);
            addRunInput.setVisible(true);
            addSwimInput.setVisible(true);
            addCycleInput.setVisible(true);
            addRemoveInput.setVisible(true);
            addLookUpByDateInput.setVisible(true);
            addFindAllByDateInput.setVisible(true);
        }
        if (event.getSource() == addRemoveInput)
        {
            removeEntry.setVisible(true);
            name.setVisible(true);
            day.setVisible(true); 
            month.setVisible(true);
            year.setVisible(true);
            labn.setVisible(true); 
            labd.setVisible(true); 
            labm.setVisible(true); 
            laby.setVisible(true); 
            addRunInput.setVisible(false);
            addSwimInput.setVisible(false);
            addCycleInput.setVisible(false);
            addRemoveInput.setVisible(false);
            addLookUpByDateInput.setVisible(false);
            addFindAllByDateInput.setVisible(false); 
        }
        if (event.getSource() == removeEntry) {
            message = removeEntry("generic");
            removeEntry.setVisible(false);
            name.setVisible(false);
            day.setVisible(false); 
            month.setVisible(false);
            year.setVisible(false);
            labn.setVisible(false); 
            labd.setVisible(false); 
            labm.setVisible(false); 
            laby.setVisible(false); 
            addRunInput.setVisible(true);
            addSwimInput.setVisible(true);
            addCycleInput.setVisible(true);
            addRemoveInput.setVisible(true);
            addLookUpByDateInput.setVisible(true);
            addFindAllByDateInput.setVisible(true);
        }
        if (event.getSource() == addLookUpByDateInput)
        {
            lookUpByDate.setVisible(true);
            day.setVisible(true); 
            month.setVisible(true);
            year.setVisible(true);
            labd.setVisible(true); 
            labm.setVisible(true); 
            laby.setVisible(true); 
            addRunInput.setVisible(false);
            addSwimInput.setVisible(false);
            addCycleInput.setVisible(false);
            addRemoveInput.setVisible(false);
            addLookUpByDateInput.setVisible(false);
            addFindAllByDateInput.setVisible(false); 
        }
        if (event.getSource() == lookUpByDate) {
            message = lookupEntry();
            lookUpByDate.setVisible(false);
            day.setVisible(false); 
            month.setVisible(false);
            year.setVisible(false);
            labd.setVisible(false); 
            labm.setVisible(false); 
            laby.setVisible(false); 
            addRunInput.setVisible(true);
            addSwimInput.setVisible(true);
            addCycleInput.setVisible(true);
            addRemoveInput.setVisible(true);
            addLookUpByDateInput.setVisible(true);
            addFindAllByDateInput.setVisible(true);
        }
        if (event.getSource() == addFindAllByDateInput)
        {
            findAllByDate.setVisible(true);
            name.setVisible(true);
            day.setVisible(true); 
            month.setVisible(true);
            labd.setVisible(true); 
            labm.setVisible(true); 
            laby.setVisible(true); 
            addRunInput.setVisible(false);
            addSwimInput.setVisible(false);
            addCycleInput.setVisible(false);
            addRemoveInput.setVisible(false);
            addLookUpByDateInput.setVisible(false);
            addFindAllByDateInput.setVisible(false); 
        }        
        if (event.getSource() == findAllByDate) {
            message = findAllEntry();
            findAllByDate.setVisible(false);
            day.setVisible(false); 
            month.setVisible(false);
            year.setVisible(false);
            labd.setVisible(false); 
            labm.setVisible(false); 
            laby.setVisible(false); 
            addRunInput.setVisible(true);
            addSwimInput.setVisible(true);
            addCycleInput.setVisible(true);
            addRemoveInput.setVisible(true);
            addLookUpByDateInput.setVisible(true);
            addFindAllByDateInput.setVisible(true);
        }
        outputArea.setText(message);
        blankDisplay();
    } // actionPerformed

    public String addRunEntry(String what) {
        String message = "Record already added\n";
        System.out.println("Adding "+what+" entry to the records");
        String n = name.getText();
        int m = Integer.parseInt(month.getText());
        int d = Integer.parseInt(day.getText());
        int y = Integer.parseInt(year.getText());
        float km = java.lang.Float.parseFloat(dist.getText());
        int h = Integer.parseInt(hours.getText());
        int mm = Integer.parseInt(mins.getText());
        int s = Integer.parseInt(secs.getText());
        int rep = Integer.parseInt(repetitions.getText());
        int rec = Integer.parseInt(recovery.getText());
        RunEntry run = new RunEntry(n, d, m, y, h, mm, s, km, rep, rec);
        TrainingRecord RecordCheck = new TrainingRecord();
        RecordCheck.addRunEntry(run);
        if(RecordCheck.equals(myAthletes) || onlyOneEntry == true) // this format doesn't work now different variables added for different Entry Collections
        {
            myAthletes.addRunEntry(run);
            message = " Record added\n";
            onlyOneEntry = false;
        }
        return message;
    }
    public String addSwimEntry(String what) {
        String message = "Record already added\n";
        System.out.println("Adding "+what+" entry to the records");
        String n = name.getText();
        int m = Integer.parseInt(month.getText());
        int d = Integer.parseInt(day.getText());
        int y = Integer.parseInt(year.getText());
        float km = java.lang.Float.parseFloat(dist.getText());
        int h = Integer.parseInt(hours.getText());
        int mm = Integer.parseInt(mins.getText());
        int s = Integer.parseInt(secs.getText());
        String whe = where.getText();
        SwimmingEntry swim = new SwimmingEntry(n, d, m, y, h, mm, s, km, whe);
        TrainingRecord RecordCheck = new TrainingRecord();
        RecordCheck.addSwimEntry(swim);
        if(RecordCheck.equals(myAthletes) || onlyOneEntry == true)
        {
            myAthletes.addSwimEntry(swim);
            message = " Record added\n";
            onlyOneEntry = false;
        }
        return message;
    }
    public String addCycleEntry(String what) {
        String message = "Record already added\n";
        System.out.println("Adding "+what+" entry to the records");
        String n = name.getText();
        int m = Integer.parseInt(month.getText());
        int d = Integer.parseInt(day.getText());
        int y = Integer.parseInt(year.getText());
        float km = java.lang.Float.parseFloat(dist.getText());
        int h = Integer.parseInt(hours.getText());
        int mm = Integer.parseInt(mins.getText());
        int s = Integer.parseInt(secs.getText());
        String sf = surface.getText();
        String sp = speed.getText();
        CycleEntry cycle = new CycleEntry(n, d, m, y, h, mm, s, km, sf, sp);
        TrainingRecord RecordCheck = new TrainingRecord();
        RecordCheck.addCycleEntry(cycle);
        if(RecordCheck.equals(myAthletes) || onlyOneEntry == true)
        {
            myAthletes.addCycleEntry(cycle);
            message = " Record added\n";
            onlyOneEntry = false;
        }
        return message;
    }
    public String removeEntry(String what) {
        String message = "Record removed\n";
        System.out.println("removing "+what+" entry from the records");
        String n = name.getText();
        int m = Integer.parseInt(month.getText());
        int d = Integer.parseInt(day.getText());
        int y = Integer.parseInt(year.getText());
        TrainingRecord RecordCheck = new TrainingRecord();
        RecordCheck.removeEntry(n, d, m, y); 
        if(RecordCheck.equals(myAthletes) == false)
        {
            myAthletes.removeEntry(n, d, m, y);
        }
        return message;
    }
    
    public String lookupEntry() {
        int m = Integer.parseInt(month.getText());
        int d = Integer.parseInt(day.getText());
        int y = Integer.parseInt(year.getText());
        outputArea.setText("looking up record ...");
        String message = myAthletes.lookupEntry(d, m, y);
        return message;
    }
    
        public String findAllEntry() {
        int m = Integer.parseInt(month.getText());
        int d = Integer.parseInt(day.getText());
        int y = Integer.parseInt(year.getText());
        outputArea.setText("looking up record ...");
        String message = myAthletes.findAllEntry(d, m, y);
        return message;
    }

    public void blankDisplay() {
        recovery.setText("");
        repetitions.setText("");
        speed.setText("");
        surface.setText("");
        where.setText("");
        name.setText("");
        day.setText("");
        month.setText("");
        year.setText("");
        hours.setText("");
        mins.setText("");
        secs.setText("");
        dist.setText("");

    }// blankDisplay
    // Fills the input fields on the display for testing purposes only
    public void fillRunDisplay(RunEntry ent) {
        name.setText(ent.getName());
        day.setText(String.valueOf(ent.getDay()));
        month.setText(String.valueOf(ent.getMonth()));
        year.setText(String.valueOf(ent.getYear()));
        hours.setText(String.valueOf(ent.getHour()));
        mins.setText(String.valueOf(ent.getMin()));
        secs.setText(String.valueOf(ent.getSec()));
        dist.setText(String.valueOf(ent.getRunDistance()));
        repetitions.setText(String.valueOf(ent.getRepetitions()));
        recovery.setText(String.valueOf(ent.getRecovery()));    
    }
    public void fillSwimDisplay(SwimmingEntry ent) {
        name.setText(ent.getName());
        day.setText(String.valueOf(ent.getDay()));
        month.setText(String.valueOf(ent.getMonth()));
        year.setText(String.valueOf(ent.getYear()));
        hours.setText(String.valueOf(ent.getHour()));
        mins.setText(String.valueOf(ent.getMin()));
        secs.setText(String.valueOf(ent.getSec()));
        dist.setText(String.valueOf(ent.getSwimDistance()));
        where.setText(ent.getWhere()); 
    }
    public void fillCycleDisplay(CycleEntry ent) {
        name.setText(ent.getName());
        day.setText(String.valueOf(ent.getDay()));
        month.setText(String.valueOf(ent.getMonth()));
        year.setText(String.valueOf(ent.getYear()));
        hours.setText(String.valueOf(ent.getHour()));
        mins.setText(String.valueOf(ent.getMin()));
        secs.setText(String.valueOf(ent.getSec()));
        dist.setText(String.valueOf(ent.getCycleDistance()));
        surface.setText(ent.getSurface());
        speed.setText(ent.getSpeed());    
    }
} // TrainingRecordGUI

