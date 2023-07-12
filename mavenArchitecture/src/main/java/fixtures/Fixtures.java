package fixtures;

import java.sql.SQLException;

public class Fixtures {
    private Users userFxt;

    public Fixtures(Users userFxt){
        this.userFxt = userFxt;
    }

    public void doFixtures() throws SQLException {
        this.userFxt.createUserFixtures();
    }


}
