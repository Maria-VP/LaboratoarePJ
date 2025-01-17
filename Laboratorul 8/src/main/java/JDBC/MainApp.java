package JDBC;

import java.sql.*;
import java.util.Scanner;

public class MainApp {

    public static void AdaugarePersoana( Connection connection, int id, String nume, int varsta) throws SQLException{
        String sql = "insert into persoane values (?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, id);
        preparedStatement.setString(2, nume);
        preparedStatement.setInt(3, varsta);

        int randuri = preparedStatement.executeUpdate();
    }

    public static void AdaugareExcursie(Connection connection,int id_p, int id_e, String destinatie, int anul) throws SQLException{
        String sql = "insert into excursii values (?,?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, id_p);
        preparedStatement.setInt(2, id_e);
        preparedStatement.setString(3, destinatie);
        preparedStatement.setInt(4, anul);

        int randuri = preparedStatement.executeUpdate();
    }

    public static void CitirePersoana(Connection c) throws SQLException{
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nume: ");
        String nume = scanner.next();
        System.out.print("Varsta: ");
        int varsta = scanner.nextInt();

        AdaugarePersoana(c, 6, nume, varsta);
    }

    public static void CitireExcursie(Connection connection, Statement st) throws SQLException{
        Scanner scanner = new Scanner(System.in);
        ResultSet rs = st.executeQuery("select id from persoane");

        System.out.println("ID-ul persoanei: ");
        int id = scanner.nextInt();
        boolean idExista = true;

        while (idExista) {
            idExista = false;
            rs.beforeFirst();
            while (rs.next())
                if (rs.getInt("id") != id) {
                    System.out.println("ID-ul este deja folosit!");
                    id = scanner.nextInt();
                    idExista = true;
                }
        }

        System.out.println("ID-ul excursiei: ");
        int id_e = scanner.nextInt();

        System.out.println("Destinatia: ");
        String destinatia = scanner.next();

        System.out.println("Anul: ");
        int an = scanner.nextInt();

        AdaugareExcursie(connection, id, id_e, destinatia, an);
    }

    public static void AfisareTabelaPersoane(Statement statement) throws SQLException{
        ResultSet rs = statement.executeQuery("select * from persoane");
        rs.beforeFirst();
        while (rs.next()){
            System.out.println(rs.getInt(1) + " " + rs.getString(2) + rs.getString(3));
        }
    }

    public static void AfisareTabelaExcursii(Statement statement) throws SQLException{
        ResultSet rs = statement.executeQuery("select * from excursii");
        rs.beforeFirst();
        while (rs.next()){
            System.out.println(rs.getInt(1) + " " +rs.getInt(2) + " " + rs.getString(3) + " " + rs.getInt(4));
        }
    }

    public static void AfisarePersoaneSiExcursiile(Statement statement, Connection c) throws SQLException {
        ResultSet resultSet = statement.executeQuery("select * from persoane");

        while (resultSet.next()) {
            int persoanaId = resultSet.getInt("id");
            String numePersoana = resultSet.getString("nume");

            System.out.println(numePersoana + ":");

            String sql = "select id_excursie, destinatia, anul from excursii where id_persoana = ?";
            PreparedStatement preparedStatement = c.prepareStatement(sql);
            preparedStatement.setInt(1, persoanaId);
            ResultSet rs = preparedStatement.executeQuery();

            boolean excursii = false;
            while (rs.next()) {
                excursii = true;
                System.out.println("     " + rs.getInt("id_excursie") + " " + rs.getString("destinatia") + " " + rs.getInt("anul"));
            }

            if (!excursii) {
                System.out.println("     Nu a mers in nicio excursie!");
            }

            rs.close();
        }

        resultSet.close();
    }

    public static void AfisareExcursieInCareAFostOPersoana(Statement statement, Connection c) throws SQLException {
        ResultSet resultSet = statement.executeQuery("select * from persoane");
        Scanner scanner = new Scanner(System.in);

        System.out.println("Numele persoanei cautate: ");
        String numePersoana = scanner.next();

        while (resultSet.next()) {
            if(resultSet.getString(2).equalsIgnoreCase(numePersoana)){
                System.out.println(numePersoana + ":");

                int persoanaId = resultSet.getInt("id");

                String sql = "select id_excursie, destinatia, anul from excursii where id_persoana = ?";
                PreparedStatement preparedStatement = c.prepareStatement(sql);
                preparedStatement.setInt(1, persoanaId);
                ResultSet rs = preparedStatement.executeQuery();

                boolean excursii = false;
                while (rs.next()) {
                    excursii = true;
                    System.out.println("     " + rs.getInt("id_excursie") + " " + rs.getString("destinatia") + " " + rs.getInt("anul"));
                }

                if (!excursii) {
                    System.out.println("     Nu a mers in nicio excursie!");
                }
                rs.close();
            }
        }

        resultSet.close();
    }

    public static void AfisarePersoaneCareAuFostLaDest(Statement statement, Connection c) throws SQLException {
        ResultSet resultSet = statement.executeQuery("select * from persoane");
        Scanner scanner = new Scanner(System.in);

        System.out.println("Numele persoanei cautate: ");
        String numePersoana = scanner.next();

        while (resultSet.next()) {
            if(resultSet.getString(2).equalsIgnoreCase(numePersoana)){
                System.out.println(numePersoana + ":");

                int persoanaId = resultSet.getInt("id");

                String sql = "select id_excursie, destinatia, anul from excursii where id_persoana = ?";
                PreparedStatement preparedStatement = c.prepareStatement(sql);
                preparedStatement.setInt(1, persoanaId);
                ResultSet rs = preparedStatement.executeQuery();

                boolean excursii = false;
                while (rs.next()) {
                    excursii = true;
                    System.out.println("     " + rs.getInt("id_excursie") + " " + rs.getString("destinatia") + " " + rs.getInt("anul"));
                }

                if (!excursii) {
                    System.out.println("     Nu a mers in nicio excursie!");
                }
                rs.close();
            }
        }

        resultSet.close();
    }

    public static void AfisarePersoaneCareAuFacutExcursiiInAn(Statement statement, Connection c) throws SQLException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Introduceți anul dorit: ");
        int anCautat = scanner.nextInt();

        ResultSet resultSet = statement.executeQuery("select * from persoane");

        boolean gasit = false;

        while (resultSet.next()) {
            int persoanaId = resultSet.getInt("id");
            String numePersoana = resultSet.getString("nume");

            String sql = "select id_excursie, destinatia from excursii where id_persoana = ? and anul = ?";
            PreparedStatement preparedStatement = c.prepareStatement(sql);
            preparedStatement.setInt(1, persoanaId);
            preparedStatement.setInt(2, anCautat);
            ResultSet rs = preparedStatement.executeQuery();

            boolean hasExcursii = false;

            while (rs.next()) {
                if (!hasExcursii) {
                    System.out.println(numePersoana + ":");
                    hasExcursii = true;
                    gasit = true;
                }
                System.out.println("     " + rs.getInt("id_excursie") + " " + rs.getString("destinatia"));
            }

            if (!hasExcursii) {
                System.out.println(numePersoana + " nu a mers în nicio excursie în anul " + anCautat + ".");
            }

            rs.close();
        }

        if (!gasit) {
            System.out.println("Nu există persoane care să fi făcut excursii în anul " + anCautat + ".");
        }

        resultSet.close();
    }

    public static void StergereaExcursiei(Connection connection) throws SQLException{
        Scanner scanner = new Scanner(System.in);

        System.out.println("ID-ul excursiei pe care doriti sa o stergeti: ");
        int id = scanner.nextInt();

        String sql="delete from excursii where id_excursie = ?";
        PreparedStatement ps=connection.prepareStatement(sql);
        ps.setInt(1, id);

        int nr_randuri = ps.executeUpdate();
    }

    public static void StergerePersoanaSiExcursiaInCareAFost(Connection c) throws SQLException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Introduceți numele persoanei pe care doriți să o ștergeți: ");
        String numePersoana = scanner.next();

        String sql = "select id from persoane where nume = ?";
        PreparedStatement preparedStatementFindPerson = c.prepareStatement(sql);
        preparedStatementFindPerson.setString(1, numePersoana);
        ResultSet resultSet = preparedStatementFindPerson.executeQuery();

        if (!resultSet.next()) {
            System.out.println("Persoana cu numele " + numePersoana + " nu a fost găsită.");
            return;
        }

        int persoanaId = resultSet.getInt("id");

        String sqlDeleteTrips = "delete from excursii where id_persoana = ?";
        PreparedStatement preparedStatementDeleteTrips = c.prepareStatement(sqlDeleteTrips);
        preparedStatementDeleteTrips.setInt(1, persoanaId);
        int excursiiSterse = preparedStatementDeleteTrips.executeUpdate();

        String sqlDeletePerson = "delete from persoane where id = ?";
        PreparedStatement preparedStatementDeletePerson = c.prepareStatement(sqlDeletePerson);
        preparedStatementDeletePerson.setInt(1, persoanaId);
        int persoanaStearsa = preparedStatementDeletePerson.executeUpdate();
    }


    public static void main(String[] args) throws SQLException {
        String url = "jdbc:mysql://localhost:3306/sys";
        Connection connection = DriverManager.getConnection (url, "root", "Nuimimaiuitparola1@");

        Scanner scanner = new Scanner(System.in);

        Statement statement;
        statement = connection.createStatement();

        Meniu meniu = new Meniu();
        meniu.AfisareMeniu();
        int opt = scanner.nextInt();

        while (opt > 0){
            switch (opt){
                case 1:
                    System.out.println("---------------------Tabelul persoane-----------------------");
                    AfisareTabelaPersoane(statement);
                    CitirePersoana(connection);
                    break;
                case 2:
                    System.out.println("---------------------Tabelul excursii-----------------------");
                    AfisareTabelaExcursii(statement);
                    CitireExcursie(connection, statement);
                    break;
                case 3:
                    AfisarePersoaneSiExcursiile(statement, connection);
                    break;
                case 4:
                    AfisareExcursieInCareAFostOPersoana(statement, connection);
                    break;
                case 5:
                    AfisarePersoaneCareAuFostLaDest(statement, connection);
                    break;
                case 6:
                    AfisarePersoaneCareAuFacutExcursiiInAn(statement, connection);
                    break;
                case 7:
                    StergereaExcursiei(connection);
                    break;
                case 8:
                    StergerePersoanaSiExcursiaInCareAFost(connection);
                    break;
                default:
                    System.out.println("Optiune necunoscuta!");
                    break;
            }
            meniu.AfisareMeniu();
            opt = scanner.nextInt();
        }

        connection.close();
        statement.close();

    }
}
