/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Package1;

/**
 *
 * @author Ibrahim
 */
public class Flight 
{
    protected String origin;
    protected String destination;
    protected String date;
    protected String flightNumber;
    protected String boardingGate;
     static int count=0;
    
    public Flight(String org,String des,String date)
    {
        origin=org;
        destination=des;
        this.date=date;
        int r1=(int)(Math.random()*800+100+count);
        int r2=(int)(Math.random()*5+1);
        flightNumber="FL-"+r1;      
        boardingGate="G"+r2;
        count++;
    }
    
    public Flight(String org,String des,String date,String flNum,String bGate)
    {
        origin=org;
        destination=des;
        this.date=date;
        flightNumber=flNum;      
        boardingGate=bGate;
    }
        
    
}
