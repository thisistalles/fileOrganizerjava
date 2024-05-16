import java.io.IOException;
import java.nio.file.*;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {

        Path arquivo = Paths.get("C://Users//Talles//Downloads//teste//teste.txt");

        List<String> linhas = Files.readAllLines(arquivo);

        for (String linha : linhas) {
            System.out.println(linha);
        }

        // Caminho do arquivo original
        Path origem = Paths.get("C:/Users/Talles/Downloads/teste/teste.txt");

        // Caminho da pasta de destino
        Path destino = Paths.get("D://teste.txt");

        try {
            // Move o arquivo
            Files.move(destino, origem);
            System.out.println("Arquivo movido com sucesso!");
        } catch (IOException e) {
            System.err.println("Ocorreu um erro ao mover o arquivo: " + e.getMessage());
        }


    }
}
//import java.io.IOException;
//import java.nio.file.*;
//
//public class Main {
//    public static void main(String[] args) {
//        // Caminho da pasta de origem
//        Path pastaOrigem = Paths.get("C:/Users/Talles/Downloads/");
//
//        // Caminho da pasta de destino
//        Path pastaDestino = Paths.get("C:/Users/Talles/Downloads/teste/");
//
//        // Intervalo de verificação em milissegundos (por exemplo, 1 minuto)
//        long intervaloVerificacao = 60 * 1000; // 1 minuto
//
//        // Loop infinito para verificar regularmente
//        while (true) {
//            try (DirectoryStream<Path> stream = Files.newDirectoryStream(pastaOrigem)) {
//                // Itera sobre os arquivos na pasta de origem
//                for (Path arquivo : stream) {
//                    // Verifica se é um arquivo regular
//                    if (Files.isRegularFile(arquivo)) {
//                        // Move o arquivo para a pasta de destino
//                        Files.move(arquivo, pastaDestino.resolve(arquivo.getFileName()), StandardCopyOption.REPLACE_EXISTING);
//                        System.out.println("Arquivo movido: " + arquivo.getFileName());
//                    }
//                }
//            } catch (IOException e) {
//                System.err.println("Erro ao verificar e mover arquivos: " + e.getMessage());
//            }
//
//            // Aguarda o próximo intervalo de verificação
//            try {
//                Thread.sleep(intervaloVerificacao);
//            } catch (InterruptedException e) {
//                System.err.println("Erro ao aguardar o próximo intervalo: " + e.getMessage());
//            }
//        }
//    }
//}

