/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Package1;
import java.util.ArrayList;
import java.io.File;
import java.io.*;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Ibrahim
 */
abstract class Ticket implements Operations
{
    protected double baseFare=300.0;
    protected double fare;
    protected double markUp;
    protected String seatNumber;
    protected boolean isRoundTrip;
    protected Flight flight;
    protected Passenger passenger;
    protected int luggage;
    
    public Ticket(String org,String des,String date,String name,String pNum,boolean rTrip,int lug)
    {
        this.flight=new Flight(org,des,date);
        this.passenger=new Passenger(name,pNum);
        isRoundTrip=rTrip;
        luggage=lug;
    }
    
    public Ticket(String org,String des,String date,String name,String pNum,boolean rTrip,
            int lug,String flNum,String bGate)
    {
        this.flight=new Flight(org,des,date,flNum,bGate);
        this.passenger=new Passenger(name,pNum);
        isRoundTrip=rTrip;
        luggage=lug;
    }
     
    public void viewTicket(Form3 f)
    {
        
        String cls="";
        if (markUp==1) { cls="ECONOMY"; }
        else if (markUp==2) { cls="BUSINESS"; }
        else { cls="FIRST"; }
      
        f.getLabel5().setText(cls);
        f.getLabel6().setText(flight.flightNumber);
        f.getLabel13().setText(seatNumber);
        f.getLabel14().setText(flight.origin);
        f.getLabel15().setText(flight.destination);
        String lg=Integer.toString(luggage);
        f.getLabel16().setText(lg);
        f.getLabel17().setText(flight.boardingGate);
        f.getLabel18().setText(passenger.name);
        f.getLabel20().setText(flight.date);
        String chk="";
        if(isRoundTrip==true) { chk="ROUND"; }
        else { chk="ONE-WAY"; }
        f.getLabel22().setText(chk);
        
    }
    
    public void printTicket()
    {
        String fName=passenger.name+"_"+flight.flightNumber+"_Ticket.txt";
       try 
    {
      
      File myObj = new File(fName);
      if (myObj.createNewFile()) { } 
      else { }
    } 
        catch (IOException e) { }
       
      try 
    {
        FileWriter fw= new FileWriter(fName);        
        BufferedWriter myWriter = new BufferedWriter(fw);
        
      myWriter.newLine();myWriter.newLine();  
      myWriter.write("\t> Name: "+passenger.name);     
      myWriter.newLine();myWriter.newLine();
      myWriter.write("\t> Flight Number: "+flight.flightNumber);
      myWriter.newLine();myWriter.newLine();
      myWriter.write("\t> Seat Number: "+seatNumber);
      myWriter.newLine();myWriter.newLine();
      myWriter.write("\t> Origin City: "+flight.origin);
      myWriter.newLine();myWriter.newLine();
      myWriter.write("\t> Destination City: "+flight.destination);
      myWriter.newLine();myWriter.newLine();
      myWriter.write("\t> Boarding Gate: "+flight.boardingGate);
      myWriter.newLine();myWriter.newLine();
      myWriter.write("\t> Date: "+flight.date);
      myWriter.newLine();myWriter.newLine();
      
      String class1="", duration1="";
      if (markUp==1) { class1="ECONOMY"; }
      else if (markUp==2) { class1="BUSINESS"; }
      else if (markUp==4) { class1="FIRST"; }
      
      if (isRoundTrip==true) { duration1="ROUND"; }
      else { duration1="ONE-WAY"; }
      
      myWriter.write("\t> Class: "+class1);
      myWriter.newLine();myWriter.newLine();
      myWriter.write("\t> Duration: "+duration1);
      myWriter.newLine();myWriter.newLine();
      myWriter.write("\t> Luggage (kg): "+luggage);
      myWriter.close();
    } 
       catch (IOException e) { }
        
    }
    
    public void saveArraylistToFile(ArrayList<Ticket> arr)
    {
        try
            {
                FileWriter myWriter = new FileWriter("arrayList.txt");
                BufferedWriter b=new BufferedWriter(myWriter);
                String str="";
                
        for (int i=0; i<arr.size(); i++)
        {
            Ticket t=arr.get(i);
            String class2="";
            if (t.markUp==1) { class2="ECONOMY"; }
            else if (t.markUp==2) { class2="BUSINESS"; }
            else { class2="FIRST"; }
            
            str=class2+"*"+t.flight.origin+"/"+t.flight.destination+"."+
                    t.flight.date+","+t.passenger.name+";"+t.passenger.passportNum
                    +"?"+t.isRoundTrip+"!"+t.luggage+"&"+t.seatNumber+"$"
                    +t.flight.flightNumber+"#"+t.flight.boardingGate;
            b.write(str);
                b.newLine();
                b.flush();
        }
                                         
            }
            catch(IOException e) { }           
        
    }
    
   
        
    
}
