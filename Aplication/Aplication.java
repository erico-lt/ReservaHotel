import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Aplication {
    public static void main(String[] args) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Scanner sc = new Scanner(System.in);
        try{
            System.out.print("Room Number: ");
            int roomNumber = sc.nextInt();

            System.out.print("Check-in date (dd/MM/yyyy): ");
            Date chekin = sdf.parse(sc.next());

            System.out.print("Check-Out date (dd/MM/yyyy): ");
            Date chekout = sdf.parse(sc.next());

            Reservation reservation = new Reservation(roomNumber, chekin, chekout);
            System.out.println(reservation);
            System.out.println();

            System.out.println("Enter date dor update");
            System.out.print("Check-in date (dd/MM/yyyy): ");
            chekin = sdf.parse(sc.next());

            System.out.print("Check-Out date (dd/MM/yyyy): ");
            chekout = sdf.parse(sc.next());

            reservation.updateDates(chekin, chekout);            
        }
        catch(ParseException e) {
            System.out.println("[Erro] Invalida date format");
        }
        catch(DomainException e) {
            System.out.println("[Erro]" + e.getMessage());
        }
        catch(RuntimeException e){
            System.out.println("Unexpected erro");
        }          

        sc.close();
    }
}
