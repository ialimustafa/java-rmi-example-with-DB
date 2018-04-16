import java.rmi.*;
import java.util.*;

public class MyClient{
public static void main(String args[]){
try{
Scanner sc=new Scanner(System.in);
int expamount,income=0,inc=0,choice,exit=1;
int totalexp=0;
Adder stub=(Adder)Naming.lookup("AddService");
System.out.println("Enter the Initial Income : ");
income=sc.nextInt();
do{
System.out.println("Enter your Choice :\n ");
System.out.println("1.Add to the Income :");
System.out.println("2.View Total Available Income : ");
System.out.println("3.Add Expense");
System.out.println("4.View Total Expense");
System.out.println("5.Retrive User Details");
System.out.println("6.Savings");
System.out.println("7.Exit");
choice=sc.nextInt();
switch(choice)
{
    case 1:{
        System.out.println("Enter Income : ");
        inc=sc.nextInt();
        int total=income;
        income=stub.addinc(total,inc);
        System.out.println("Sucessfully Added: ");
        break;
    }
    case 2:{
        System.out.println("Available Income is" +income);
        break;
    }
    case 3:
    {
        System.out.println("Enter the Amount : ");
        expamount=sc.nextInt();
        totalexp=stub.delexp(totalexp,expamount);
        System.out.println("Sucessfully Added the Expense: ");
        break;
        
    }
    case 4:{
        System.out.println("Total Expense Amount : "+ totalexp);
        break;
    }
    case 5:{
        System.out.println("Retriving Data from DB ");
        //String[] ar=new String[10];
        String[] ar= stub.dbconn(1);
        System.out.println("ID: "+ar[0]);
        System.out.println("Name: "+ar[1]);
        System.out.println("Total Income "+ar[2]);
        System.out.println("Total Expense "+ar[3]);
        
        break;   
    }
    case 6:{
       System.out.println("Total Saving:"+(income-totalexp));
       
        break;
    }
    case 7:
    {
         exit=0;
        break;
    }
    default:{
        System.out.println("Wrong Choice");

    }
}

}while(exit==1);
}
catch(Exception e){}
}
}
