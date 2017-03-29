/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelreservation.session;

import hotelreservation.entity.Customers;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author mazhar
 */
@Remote
public interface CustomerSessionBeanRemote {

    

    Boolean registerCustomer(Customers customer, ArrayList addresses);
    
}
