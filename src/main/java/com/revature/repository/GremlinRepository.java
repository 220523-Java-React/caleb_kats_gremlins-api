package com.revature.repository;

import com.revature.model.Gremlin;
import com.revature.util.ConnectionUtility;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GremlinRepository implements DAO<Gremlin> {

    @Override
    public Gremlin create(Gremlin gremlin) {

        String sql = "insert into gremlins(name, age, color, is_evil) values(?,?,?,?)";

        try(Connection connection = ConnectionUtility.getInstance()) {
            PreparedStatement stmt = connection.prepareStatement(sql);

            stmt.setString(1, gremlin.getName());
            stmt.setInt(2, gremlin.getAge());
            stmt.setString(3, gremlin.getColor());
            stmt.setBoolean(4, gremlin.isEvil());

            if(stmt.executeUpdate() == 1) {
                return gremlin;
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Gremlin> getAll() {

        List<Gremlin> gremlins = new ArrayList<>();
        String sql = "select * from gremlins";

        try (Connection connection = ConnectionUtility.getInstance()){
            PreparedStatement stmt = connection.prepareStatement(sql);

            ResultSet rs = stmt.executeQuery();

            while(rs.next()) {
                Gremlin gremlin = new Gremlin();
                gremlin.setName(rs.getString("name"));
                gremlin.setAge(rs.getInt("age"));
                gremlin.setColor(rs.getString("color"));
                gremlin.setEvil(rs.getBoolean("is_evil"));

                gremlins.add(gremlin);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return gremlins;
    }
}
