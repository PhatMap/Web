/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Context;

import javax.persistence.*;

public class Utils {
     static public EntityManager getEntityManager(){
             EntityManagerFactory  factory = Persistence.createEntityManagerFactory("AoOnly");
            return  factory.createEntityManager();
    }
}
