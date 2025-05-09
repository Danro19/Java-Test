/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.util;

/**
 *
 * @author camper
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionDB {
    private static final String host = "jdbc:mysql://localhost:3306/SolucionesEficientes";
    private static final String user = "campus2023";
    private static final String password = "campus2023";

    private static Connection con;

    private ConexionDB() {
        this.con = null;
    }

    public static Connection getConnection() {
        if (con == null) {
            try {
                con = DriverManager.getConnection(host, user, password);
            } catch (SQLException e) {
                System.err.println("Error al conectar con la base de datos: " + e.getMessage());
            }
        }

        return con;
    }

    public static void closeConnection() {
        if (con != null) {
            try {
                con.close();;
                con = null;
            } catch (SQLException e) {
                System.err.println("Error al desconectar de la base de datos: " + e.getMessage());
            }
        }
    }
}