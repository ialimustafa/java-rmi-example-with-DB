import java.rmi.*;
import java.util.*;

public class MyClient{
public static void main(String args[]){
try{
Scanner sc=new Scanner(System.in);
int expamount,income=0,inc=0,choice,exit=1;
Adder stub=(Adder)Naming.lookup("AddService");
System.out.println("Enter the Initial Income : ");
income=sc.nextInt();
do{
System.out.println("Enter your Choice :\n ");
System.out.println("1.Add to the Income :");
System.out.println("2.View Total Available Income : ");
System.out.println("3.Add Expense");
System.out.println("4. Retrive User Details from DB");
System.out.println("5.Exit");
choice=sc.nextInt();
switch(choice)
{
    case 1:{
        System.out.println("Enter Income : ");
        inc=sc.nextInt();
        inc=stub.addinc(income,inc);
        System.out.println("Sucessfully Added: ");
        break;
    }
    case 2:{
        System.out.println("Available Income is" +inc);
        break;
    }
    case 3:{
        System.out.println("Enter the Amount : ");
        expamount=sc.nextInt();
        inc=stub.delexp(inc,expamount);
        System.out.println("Sucessfully Added: ");
        break;
    }
    case 4:{
        System.out.println("Retriving Data from DB ");
        


        
    }
    case 5:{
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
