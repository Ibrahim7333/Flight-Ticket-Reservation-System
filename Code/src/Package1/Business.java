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
public class Business extends Ticket
{
    static int count=1;
    
    public Business(String org,String des,String date,String name,String pNum,boolean rTrip,int lug)
    {
        super(org,des,date,name,pNum,rTrip,lug);
        markUp=2;
        if (isRoundTrip==true) { fare=markUp*baseFare*1.5; }
        else { fare=markUp*baseFare*1; }
        seatNumber="B-"+count;      
        count++;
    }
    
    public Business(String org,String des,String date,String name,String pNum,boolean rTrip,int lug,
           String flNum,String seatNum, String bGate)
    {
        super(org,des,date,name,pNum,rTrip,lug,flNum,bGate);
        markUp=2;
        if (isRoundTrip==true) { fare=markUp*baseFare*1.5; }
        else { fare=markUp*baseFare*1; }
        seatNumber=seatNum;
    }
}
