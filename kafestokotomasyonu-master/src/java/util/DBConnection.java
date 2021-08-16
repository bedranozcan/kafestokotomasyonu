/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Asus
 */
public abstract class  DBConnection {

    
    private Connection connection;
    public Connection connect() {

        try {
             Class.forName("org.mariadb.jdbc.Driver");//driver yolunu gösteriyoruz.
            this.connection = DriverManager.getConnection("jdbc:postgresql://localhost:5433/kafastok", "postgres", "6612");
             System.out.println("Baglantı başarili");  

        } catch (Exception e) {

            System.out.println(e.getMessage());//ulaşma problemi varda yada kontrol dışında olduğunda orada olup olmadığınu kontol etmek için
        }

        return this.connection;

    }

}
