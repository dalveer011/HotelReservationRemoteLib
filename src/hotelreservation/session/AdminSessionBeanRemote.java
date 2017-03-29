/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelreservation.session;

import hotelreservation.entity.Rooms;
import java.util.Date;
import javax.ejb.Remote;

/**
 *
 * @author DALVEERSINGH
 */
@Remote
public interface AdminSessionBeanRemote {

    Boolean updatePassword(String username,String password);

    void addRoom(Rooms room);

    void updateRoom(int roomNum,Rooms newDetailesOfRoom);

    void deleteRoom(int roomNum);

    void generateReportBasedOnDate(Date startDate, Date endDate);
    
}
