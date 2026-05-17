import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {

    public static Connection conectar() {

        try {

            String url = "jdbc:mysql://localhost:3306/rpg";
            String usuario = "root";
            String senha = "";
            
            Connection conn = DriverManager.getConnection(url, usuario, senha);

            //System.out.println("Conectado ao banco de dados com sucesso!");

            return conn;

        } catch (Exception e) {
            
            System.out.println("Conexão com o banco de dados falhou!\n" + e.getMessage());

            return null;

        }

    }

}