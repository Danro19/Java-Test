/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.clienteMVC.ClienteDaos;

/**
 *
 * @author camper
 */
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


/**
 *
 * @author warle
 */
import com.clienteMVC.ClienteModel.ClienteModel;
import com.util.ConexionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClienteDao {
    private static ClienteDao instance;

    private ClienteDao() {
      
    }

    public static ClienteDao getInstance() {
        if (instance == null) {
            instance = new ClienteDao();
        }
        return instance;
    }

    public void add(ClienteModel client) throws SQLException {
        String query = "INSERT INTO Cliente (nombre, representante, correo, telefono, direccion, sector) VALUES (?, ?, ?, ?, ?, ?)";
        Connection conn = ConexionDB.getConnection();
        try (PreparedStatement stmt = conn.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, client.getNombre());
            stmt.setString(2, client.getRepresentante());
            stmt.setString(3, client.getCorreo());
            stmt.setString(4, client.getTelefono());
            stmt.setString(5, client.getDireccion());
            stmt.setString(6, client.getSector());
            stmt.executeUpdate();

            // Obtener el ID generado
            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    client.setId(generatedKeys.getInt(1));
                }
            }
        }
    }

    public ClienteModel getByNombre(String Nombre) throws SQLException {
        String query = "SELECT * FROM clients WHERE Nombre = ?";
        Connection conn = ConexionDB.getConnection();
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, Nombre);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new ClienteModel(
                        rs.getString("nombre"),
                        rs.getString("representante"),
                        rs.getString("correo"),
                        rs.getString("telefono"),
                        rs.getString("direccion"),
                        rs.getString("sector")
                    );
                }
            }
        }
        return null;
    }

    public List<ClienteModel> getAll() throws SQLException {
        List<ClienteModel> clientes = new ArrayList<>();
        String query = "SELECT * FROM clients";
        Connection conn = ConexionDB.getConnection();
        try (PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                ClienteModel client = new ClienteModel(
                    rs.getString("nombre"),
                    rs.getString("representante"),
                    rs.getString("correo"),
                    rs.getString("telefono"),
                    rs.getString("direccion"),
                    rs.getString("sector")
                );
                clientes.add(client);
            }
        }
        return clientes;
    }

    public void update(ClienteModel cliente) throws SQLException {
        String query = "UPDATE Cliente SET nombre = ?, representante = ?, correo= ?, telefono = ?, direccion = ?, sector = ? WHERE nombre = ?";
        Connection conn = ConexionDB.getConnection();
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, cliente.getNombre());
            stmt.setString(2, cliente.getRepresentante());
            stmt.setString(3, cliente.getCorreo());
            stmt.setString(4, cliente.getTelefono());
            stmt.setString(5, cliente.getDireccion());
            stmt.setString(6, cliente.getSector());
            stmt.setString(8, cliente.getNombre());
            stmt.executeUpdate();
        }
    }


     
}
