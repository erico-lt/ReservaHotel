import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {
    private Integer roomNumber;
    private Date checkin;
    private Date checkOut;
    Date now = new Date();

    public static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public Reservation(){        
    }

    public Reservation(Integer roomNumber, Date checkin, Date checkOut) throws DomainException{  
        if (!checkOut.after(checkin)) {

            throw new DomainException("[Erro] Check-Out date must be after check-in date");        
        } else if (checkin.before(now) || checkOut.before(now)) {
        
            throw new DomainException("[Erro] Reservation dates for update must be future dates");        
        }      
        this.setRoomNumber(roomNumber);
        this.setCheckin(checkin);
        this.setCheckOut(checkOut);
    }

    public long duration(){
        long millesegonds = this.getCheckin().getTime() - this.getCheckOut().getTime();
        return TimeUnit.DAYS.convert(millesegonds, TimeUnit.MILLISECONDS);
    }
    
    public void updateDates(Date checkin, Date checkOut) throws DomainException {       
        if (!checkOut.after(checkin)) {

            throw new DomainException("Check-Out date must be after check-in date");        
        } else if (checkin.before(now) || checkOut.before(now)) {
        
            throw new DomainException("Reservation dates for update must be future dates");        
        }
        this.setCheckin(checkin);
        this.setCheckOut(checkOut);
    }

    public Integer getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }

    public Date getCheckin() {
        return checkin;
    }

    private void setCheckin(Date checkin) {
        this.checkin = checkin;
    }

    public Date getCheckOut() {
        return checkOut;
    }

    private void setCheckOut(Date chekOut) {
        this.checkOut = chekOut;
    }

    @Override
    public String toString(){
        return "Reservation: Room " + this.getRoomNumber() +
        ", Chek-in: " + sdf.format(this.getCheckin()) + 
        ", Chek-Out: " + sdf.format(this.getCheckOut()) 
        + ", " + this.duration() + " nighhts";
    }

}
