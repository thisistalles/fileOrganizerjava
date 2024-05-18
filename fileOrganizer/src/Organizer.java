import org.apache.commons.io.FilenameUtils;

import java.io.IOException;
import java.nio.file.*;

public class Organizer {

    private String extensao;
    private Path origem = Paths.get("C:/Users/Talles/Downloads/");
    private Path destino;
    private Path arquivo;
    private String type;

    public String getExtensao() {
        return extensao;
    }

    public void setExtensao(String extensao) {
        this.extensao = extensao;
    }

    public Path getDestino() {
        return destino;
    }

    public void setDestino(Path destino) {
        this.destino = destino;
    }

    public Path getArquivo() {
        return arquivo;
    }

    public void setArquivo(Path arquivo) {
        this.arquivo = arquivo;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void fileCheck() {
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(origem)) {
            for (Path arquivo : stream) {
                if (Files.isRegularFile(arquivo)) {
                    Path nome = arquivo.getFileName();
                    String name = nome.toString();
                    setArquivo(arquivo); // Corrigindo aqui
                    setExtensao(FilenameUtils.getExtension(name));
                    moveFile(); // Chamando moveFile para cada arquivo verificado
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void moveFile() {
        try {
            if (getExtensao().equalsIgnoreCase(getType())) {
                if (getArquivo() != null) { // Verifica se arquivo não é nulo
                    Files.move(getArquivo(), getDestino().resolve(getArquivo().getFileName()), StandardCopyOption.REPLACE_EXISTING);
                    System.out.println("Arquivo movido: " + getArquivo().getFileName());
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}

