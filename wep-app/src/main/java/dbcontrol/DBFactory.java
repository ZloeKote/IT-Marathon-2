package dbcontrol;

import java.sql.SQLException;

public class DBFactory {
	private static IDBControl dao = null;
    public static IDBControl getDAOInstance (TypeDB type) {
        if (type == TypeDB.MySQL)
			try {
				dao = new MySqlControl();
			} catch (SQLException e) {
				e.printStackTrace();
			}
        return dao;
    }
}
