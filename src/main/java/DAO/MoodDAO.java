package DAO;

import model.Mood;
import util.ConnectionUtil;

import java.sql.*;
import java.util.List;

import org.eclipse.jetty.jndi.local.localContextRoot;

import java.util.ArrayList;

public class MoodDAO {
    
    public Mood createMoodUser (Mood mood) {
        Connection connection = ConnectionUtil.getConnection();
        try {
            String sql = "INSERT INTO Rainbows (mood, userID, timeSlept, activities, memo) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            preparedStatement.setDouble(1, mood.getMood);
            // FK??
            preparedStatement.setString(2, account.getUserID);
            preparedStatement.setInt(3, mood.getTimeSlept);
            preparedStatement.setString(4, mood.getActivities);
            preparedStatement.setString(5, mood.setMemo);

            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected == 1) {
                ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    int moodId = generatedKeys.getInt(1);
                    mood.setMoodId(moodId);
                    return mood;
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
            return null;
        }
    }

    public Mood createMood (Mood mood) {
        Connection connection = ConnectionUtil.getConnection();
        try {
            String sql = "INSERT INTO Rainbows (mood, timeSlept, activities, memo) VALUES (?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            preparedStatement.setDouble(1, mood.getMood);
            // FK??
            preparedStatement.setInt(3, mood.getTimeSlept);
            preparedStatement.setString(4, mood.getActivities);
            preparedStatement.setString(5, mood.setMemo);

            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected == 1) {
                ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    int moodId = generatedKeys.getInt(1);
                    mood.setMoodId(moodId);
                    return mood;
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
            return null;
        }
    }

    public getMoodById(int _id) {
        Connection connection = ConnectionUtil.getConnection();
        try {
            String sql = "SELECT * "
        }
    }
}
