package DAO;

import model.Mood;
import util.ConnectionUtil;

import java.sql.*;
import java.util.List;
import java.util.concurrent.locks.AbstractQueuedLongSynchronizer.ConditionObject;

import javax.naming.spi.DirStateFactory.Result;

import org.eclipse.jetty.jndi.local.localContextRoot;

import com.fasterxml.jackson.databind.introspect.ConcreteBeanPropertyBase;

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

    public List<Mood> getAllMood() {
        Connection connection = ConnectionUtil.getConnection();
        List<Mood> mood = new ArrayList<>();
        try {
            String sql = "SELECT * FROM Rainbow";

            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Mood mood = new Mood(
                    rs.getDouble("mood");
                    rs.getInt("timeSlept");
                    rs.getString("activities");
                    rs.getString("memo");
                );
                mood.add(mood);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return mood;
    }

    public Mood getMoodById (Mood mood, String mood_id) {
        Connection connection = ConnectionUtil.getConnection();
        try {
            String sql = "SELECT * FROM Rainbows WHERE mood_id = (?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, mood_id);

            ResultSet rs = preparedStatement.executeQuery();
                if (rs.next()) {
                    return new Mood(
                        rs.getDouble("mood");
                        rs.getInt("timeSlept");
                        rs.getString("activities");
                        rs.getString("memo");
                    );
                }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Mood updateMood (Mood mood, String mood_id) {
        Connection connection = ConnectionUtil.getConnection();
        Mood updatedMood = getMoodById(mood_id);
        if (updatedMood = null) {
            return null;
        }
        try {
            String sql = "UPDATE Rainbow SET mood = ? WHERE mood_id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setDouble(1, mood.getMood());
            preparedStatement.setString(2, mood.getMood_id());

            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                return getMoodById(mood_id);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
