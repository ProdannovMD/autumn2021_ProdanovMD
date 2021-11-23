package november22.classwork;

import november8.classwork.task.Verb;
import november8.classwork.task.VerbService;

import java.sql.*;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        try {
            Class.forName("org.h2.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        VerbService verbService = VerbService.getInstance();
        List<Verb> verbs = verbService.getVerbs();


        try (Connection connection = DriverManager.getConnection("jdbc:h2:mem:testa")) {
            connection.setAutoCommit(false);

            PreparedStatement create = connection.prepareStatement(CREATE_TABLE_SQL);
            create.execute();

            for (Verb verb : verbs) {
                PreparedStatement insert = connection.prepareStatement(INSERT_ROW_SQL, Statement.RETURN_GENERATED_KEYS);
                insert.setString(1, verb.getInfinitive());
                insert.setString(2, verb.getPastSimple());
                insert.setString(3, verb.getPastParticiple());
                insert.setString(4, verb.getRusName());
                insert.execute();
            }


//            PreparedStatement select = connection.prepareStatement("select * from VERBS");
//
//            ResultSet resultSet = select.executeQuery();
//            while (resultSet.next()) {
//                int id = resultSet.getInt(1);
//                String infinitive = resultSet.getString(2);
//                String pastSimple = resultSet.getString(3);
//                String pastParticiple = resultSet.getString(4);
//                String rusName = resultSet.getString(5);
//                Verb verb = new Verb(infinitive, pastSimple, pastParticiple, rusName, id);
//                System.out.println(verb);
//            }

            PreparedStatement select = connection.prepareStatement(SELECT_ROW_BY_RUS_NAME_SQL);
            select.setString(1, "с%");
            System.out.println("Глаголы, начинающиеся с С:");
            ResultSet resultSet = select.executeQuery();
            while (resultSet.next()) {
                String rusName = resultSet.getString(5);
                System.out.println(rusName);
            }

            PreparedStatement selectMaxLength = connection.prepareStatement(SELECT_MAX_LENGTH_VERB_SQL);
            ResultSet resultSet1 = selectMaxLength.executeQuery();
            System.out.println("Глаголы максимальной длины:");
            while (resultSet1.next()) {
                String word = resultSet1.getString(1);
                System.out.println(word);
            }


            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    private static final String CREATE_TABLE_SQL = "CREATE TABLE \"VERBS\"(\n" +
            "id int IDENTITY(1,1),\n" +
            "INFINITIVE varchar (250) NOT NULL,\n" +
            "PAST_SIMPLE varchar(250),\n" +
            "PAST_PARTICIPLE varchar(250),\n" +
            "RUS_NAME varchar(250),\n" +
            "PRIMARY KEY (id),\n" +
            "unique (INFINITIVE)\n" +
            ")";


    private static final String INSERT_ROW_SQL = "INSERT INTO VERBS " +
            "(\"INFINITIVE\", \"PAST_SIMPLE\", \"PAST_PARTICIPLE\", \"RUS_NAME\") VALUES (?, ?, ?, ?)";

    private static final String SELECT_ROW_BY_ID_SQL = "SELECT * FROM VERBS WHERE id = ?";

    private static final String SELECT_ROW_BY_RUS_NAME_SQL = "SELECT * FROM VERBS WHERE RUS_NAME LIKE ?";


    private static final String SELECT_MAX_LENGTH_VERB_SQL = "WITH subq (word) AS (\n" +
            "\tSELECT INFINITIVE AS word\n" +
            "\tFROM VERBS\n" +
            "\tWHERE LENGTH(INFINITIVE) = (SELECT MAX(LENGTH(INFINITIVE)) FROM VERBS)\n" +
            "\tUNION\n" +
            "\tSELECT PAST_SIMPLE AS word\n" +
            "\tFROM VERBS\n" +
            "\tWHERE LENGTH(PAST_SIMPLE) = (SELECT MAX(LENGTH(PAST_SIMPLE)) FROM VERBS)\n" +
            "\tUNION\n" +
            "\tSELECT PAST_PARTICIPLE AS word\n" +
            "\tFROM VERBS\n" +
            "\tWHERE LENGTH(PAST_PARTICIPLE) = (SELECT MAX(LENGTH(PAST_PARTICIPLE)) FROM VERBS)\n" +
            "\tUNION\n" +
            "\tSELECT RUS_NAME AS word\n" +
            "\tFROM VERBS\n" +
            "\tWHERE LENGTH(RUS_NAME) = (SELECT MAX(LENGTH(RUS_NAME)) FROM VERBS)\n" +
            ")\n" +
            "SELECT s.word\n" +
            "FROM subq s\n" +
            "WHERE LENGTH(s.word) = (SELECT MAX(LENGTH(inner_s.word)) FROM subq inner_s)";

}
