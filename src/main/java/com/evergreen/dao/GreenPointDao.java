package com.evergreen.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.evergreen.bean.GreenPoint;
import com.evergreen.util.DbUtil;

public class GreenPointDao {
	private Connection connection;
	
    public GreenPointDao() {
        connection = DbUtil.getConnection();
    }
    public void addGreenPoint(GreenPoint greenPoint) {

        try {

            PreparedStatement preparedStatement = connection

                    .prepareStatement("insert into greenpoints(latitude,longitude,image_avant, image_apres,id_emetteur, id_nettoyeur, description) values (?, ?, ?, ?,?,?,? )");

            // Parameters start with 1

            preparedStatement.setFloat(1, greenPoint.getLatitude());

            preparedStatement.setFloat(2, greenPoint.getLongitude());
            
            preparedStatement.setString(3, greenPoint.getImage_avant());
            
            preparedStatement.setString(4, greenPoint.getImage_apres());

            preparedStatement.setInt(5, greenPoint.getId_nettoyeur());

            preparedStatement.setInt(6, greenPoint.getId_emetteur());

            preparedStatement.setString(7, greenPoint.getDescription());
            preparedStatement.executeUpdate();



        } catch (SQLException e) {

            e.printStackTrace();

        }

    }



    public void deleteGreenPoint(int greenPointId) {

        try {

            PreparedStatement preparedStatement = connection

                    .prepareStatement("delete from greenpoints where greenPointId=?");

            // Parameters start with 1

            preparedStatement.setInt(1, greenPointId);

            preparedStatement.executeUpdate();



        } catch (SQLException e) {

            e.printStackTrace();

        }

    }



    public void updateGreenPoint(GreenPoint greenPoint) {

        try {

            PreparedStatement preparedStatement = connection

                    .prepareStatement("update greenpoints set latitude=?,longitude=?,image_avant=?, image_apres=?,id_emetteur=?, id_nettoyeur=?, description=?" +

                            "where greenPointId=?");

            // Parameters start with 1
            preparedStatement.setFloat(1, greenPoint.getLatitude());
            preparedStatement.setFloat(2, greenPoint.getLongitude());
            preparedStatement.setString(3, greenPoint.getImage_avant());
            preparedStatement.setString(4, greenPoint.getImage_apres());
            preparedStatement.setInt(5, greenPoint.getId_nettoyeur());
            preparedStatement.setInt(6, greenPoint.getId_emetteur());
            preparedStatement.setInt(7, greenPoint.getGreenPointId());
            preparedStatement.setString(8, greenPoint.getDescription());
       
            preparedStatement.executeUpdate();



        } catch (SQLException e) {

            e.printStackTrace();

        }

    }





    public List<GreenPoint> getAllGreenPoints() {

        List<GreenPoint> greenPoints = new ArrayList<GreenPoint>();

        try {

            Statement statement = connection.createStatement();

            ResultSet rs = statement.executeQuery("select * from greenpoints");

            while (rs.next()) {

            	GreenPoint greenPoint = new GreenPoint();

            	greenPoint.setGreenPointId(rs.getInt("greenPointId"));
            	greenPoint.setId_emetteur(rs.getInt("id_emetteur"));
            	greenPoint.setId_nettoyeur(rs.getInt("id_nettoyeur"));
            	greenPoint.setImage_apres(rs.getString("image_apres"));
            	greenPoint.setImage_avant(rs.getString("image_avant"));
            	greenPoint.setLatitude(rs.getFloat("latitude"));
            	greenPoint.setLongitude(rs.getFloat("longitude"));
            	greenPoint.setDescription(rs.getString("description"));

            	greenPoints.add(greenPoint);

            }

        } catch (SQLException e) {

            e.printStackTrace();

        }



        return greenPoints;

    }



    public GreenPoint getGreenPointById(int greenPointId) {

    	GreenPoint greenPoint = new GreenPoint();

        try {

            PreparedStatement preparedStatement = connection.

                    prepareStatement("select * from greenpoints where greenPointId=?");

            preparedStatement.setInt(1, greenPointId);

            ResultSet rs = preparedStatement.executeQuery();



            if (rs.next()) {

            	greenPoint.setGreenPointId(rs.getInt("greenPointId"));
            	greenPoint.setId_emetteur(rs.getInt("id_emetteur"));
            	greenPoint.setId_nettoyeur(rs.getInt("id_nettoyeur"));
            	greenPoint.setImage_apres(rs.getString("image_apres"));
            	greenPoint.setImage_avant(rs.getString("image_avant"));
            	greenPoint.setLatitude(rs.getFloat("latitude"));
            	greenPoint.setLongitude(rs.getFloat("longitude"));
            	greenPoint.setDescription(rs.getString("description"));

            }

        } catch (SQLException e) {

            e.printStackTrace();

        }



        return greenPoint;

    }

}
