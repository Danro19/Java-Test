/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.servicioMVC.ServicioDaos;

import com.servicioMVC.ServicioModel.ServicioModel;
import com.util.ConexionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author camper
 */
public class ServicioDao {

    private static ServicioDao instance;

    public ServicioDao() {
    }

    public static ServicioDao getInstance() {
        if (instance == null) {
            instance = new ServicioDao();
        }
        return instance;
    }

    public void add(ServicioModel servicio) throws SQLException {
        String query = "INSERT INTO Cliente (nombre, descripcion, precioPorHora, categoria) VALUES (?, ?, ?, ?)";
        Connection conn = ConexionDB.getConnection();
        try (PreparedStatement stmt = conn.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, servicio.getNombre());
            stmt.setString(2, servicio.getDescripcion());
            stmt.setInt(3, servicio.getPrecioPorHora());
            stmt.setString(4, servicio.getCategoria());
            stmt.executeUpdate();

            // Obtener el ID generado
            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    servicio.setId(generatedKeys.getInt(1));
                }
            }
        }
    }

   
    
    public List<ServicioModel> consultarPorCategoria(String categoria) throws SQLException {
        List<ServicioModel> servicio = new ArrayList<>();
        String query = "SELECT * FROM Contrato where categoria =? ";
        Connection conn = ConexionDB.getConnection();
        try (PreparedStatement stmt = conn.prepareStatement(query)){
       stmt.setString(1, Categoria);
       try (ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                ServicioModel  servicios = new ServicioModel(
                rs.getInt("id"),
                            rs.getString("nombre"),
                            rs.getString("descripcion"),
                            rs.getInt("precioPorHora"),
                            rs.getString("categoria")
                );
                servicio.add(servicios);
            }
        }
        }
        return servicio;
    }

}
