/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.contratoMVC.ContratoDaos;

/**
 *
 * @author camper
 */


import com.contratoMVC.ContratoModel.ContratoModel;
import com.util.ConexionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ContratoDAO {
    private static ContratoDAO instance;
    public ContratoDAO() {
    }
    
     public static ContratoDAO getInstance() {
        if (instance == null) {
            instance = new ContratoDAO();
        }
        return instance;
    }
     
     public void add (ContratoModel contrato) throws SQLException {
          String query = "INSERT INTO Cliente (fechaInicio, fechaFin, costoTotal, Estado) VALUES (?, ?, ?, ?)";
          Connection conn = ConexionDB.getConnection();
          try (PreparedStatement stmt = conn.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS)) {
            stmt.setObject(1, contrato.getFechaInicio());
            stmt.setObject(2, contrato.getFechaFin());
            stmt.setInt(3, contrato.getCostoTotal());
            stmt.setString(4, contrato.getEstado());
            stmt.executeUpdate();

            // Obtener el ID generado
            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    contrato.setId(generatedKeys.getInt(1));
                }
            }
        }
     } 
     
     public List<ContratoModel> getAllActivo() throws SQLException {
        List<ContratoModel> contrato = new ArrayList<>();
        String query = "SELECT * FROM Contrato where estado ='Activo' ";
        Connection conn = ConexionDB.getConnection();
        try (PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                ContratoModel contratos = new ContratoModel(
                    rs.getInt("id"),
                    rs.getObject("fechaInicio", LocalDate.class),
                    rs.getObject("fechaFin", LocalDate.class),
                    rs.getInt("costoTotal"),
                    rs.getString("Estado")
                );
                contrato.add(contratos);
            }
        }
        return contrato;
    }
     public void update(ContratoModel contrato) throws SQLException {
        String query = "UPDATE Contrato set estado = ? WHERE id = ?";
        Connection conn = ConexionDB.getConnection();
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, contrato.getEstado());
            
            stmt.executeUpdate();
        }
    }
     
}
