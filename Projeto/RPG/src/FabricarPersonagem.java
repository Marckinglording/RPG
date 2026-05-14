import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class FabricarPersonagem {

    public static Personagem criarPersonagem(String tipo_personagem) {
        
        try {
            
            Connection conexao = Conexao.conectar();

            String sql = "SELECT * FROM tipos_personagem WHERE tipo = ?";

            PreparedStatement statement = conexao.prepareStatement(sql);

            statement.setString(1, tipo_personagem);

            ResultSet rs = statement.executeQuery();

            if(rs.next()) {

                String tipo = rs.getString("tipo");

                double vida =
                    rs.getDouble("vida");

                double ataque =
                    rs.getDouble("ataque");

                double defesa =
                    rs.getDouble("defesa");

                double velocidadeMovimento =
                    rs.getDouble("velocidade_movimento");

                double velocidadeAtaque =
                    rs.getDouble("velocidade_ataque");

                double mana =
                    rs.getDouble("mana");

                switch(tipo) {

                    case "Guerreiro":

                        return new Guerreiro(
                            tipo,
                            vida,
                            ataque,
                            defesa,
                            velocidadeMovimento,
                            velocidadeAtaque,
                            mana,
                            1
                        );

                    case "Arqueiro":

                        return new Arqueiro(
                            tipo,
                            vida,
                            ataque,
                            defesa,
                            velocidadeMovimento,
                            velocidadeAtaque,
                            mana,
                            1
                        );

                    case "Mago":

                        return new Mago(
                            tipo,
                            vida,
                            ataque,
                            defesa,
                            velocidadeMovimento,
                            velocidadeAtaque,
                            mana,
                            1
                        );

                    case "Assassino":

                        return new Assassino(
                            tipo,
                            vida,
                            ataque,
                            defesa,
                            velocidadeMovimento,
                            velocidadeAtaque,
                            mana,
                            1
                        );

                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;

    }
    
}
