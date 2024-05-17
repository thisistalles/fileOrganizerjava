import org.apache.commons.io.FilenameUtils;

import java.io.IOException;
import java.nio.file.*;

public class Main {
    public static void main(String[] args) throws IOException {

        String extensao = "";

        // Caminho da pasta de origem
        Path pastaOrigem = Paths.get("C:/Users/Talles/Downloads/");

        // Caminho da pasta de destino
        Path pastaDestino = Paths.get("C:/Users/Talles/Downloads/Organização/IMAGENS/");


        try (DirectoryStream<Path> stream = Files.newDirectoryStream(pastaOrigem)) {

            for (Path arquivo : stream) {
                // Verifica se é um arquivo regular
                if (Files.isRegularFile(arquivo)) {

                    Path nome = arquivo.getFileName();
                    String name = nome.toString();
                    extensao = FilenameUtils.getExtension(name);

                    if (extensao.equalsIgnoreCase("jpg")) {
                        Files.move(arquivo, pastaDestino.resolve(arquivo.getFileName()), StandardCopyOption.REPLACE_EXISTING);
                        System.out.println("Arquivo movido: " + arquivo.getFileName());
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


//chatgpt