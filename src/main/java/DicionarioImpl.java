
import java.io.BufferedReader;
import java.io.FileReader;
import java.rmi.RemoteException;
import java.io.IOException;

/**
 * Objeto com a implementação dos métodos remotos.
 *
 * @author osmar
 */
public class DicionarioImpl implements Dicionario {

    @Override
    public String traduzir(String palavraPtBR) throws RemoteException {
        //Inicialização da palavra a ser traduzida
        String traducao = "-1";
        try {
            //Abre o arquivo
            BufferedReader in = new BufferedReader(new FileReader("dicionario.txt"));
            //Leitura da primeira linha
            String linha = in.readLine();
            //Enquanto existir linha
            while (linha != null) {
                //Divide a linha pela vírgula
                String[] palavras = linha.split(",");
                //Verifica se a palavra em português é igual a palavra solicitada
                if (palavras[0].equalsIgnoreCase(palavraPtBR)) {
                    //Retorna a palavra traduzida em inglês
                    return palavras[1];
                }
                //Leitura da próxima linha
                linha = in.readLine();
            }
            //Fecha o arquivo
            in.close();
        } catch (IOException ioe) {
            System.out.println("Excecao: " + ioe.getMessage());
        }
        //Retorna -1 quando não foi encontrada a palavra no dicionário
        return traducao;
    }
}
