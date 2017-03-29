/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelreservation.session;

import hotelreservation.entity.Rooms;
import java.util.Date;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author mazhar
 */
@Remote
public interface StaffSessionBeanRemote {
    
        List<Rooms> findAvailableRooms(Date startDate, Date endDate);

    Boolean bookRoom(Rooms room);

}
