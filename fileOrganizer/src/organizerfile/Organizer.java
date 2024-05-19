package organizerfile;

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

    public Path getOrigem() {
        return origem;
    }

    public void setOrigem(Path origem) {
        this.origem = origem;
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


    public void fileCheck() {
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(origem)) {
            for (Path arquivo : stream) {
                if (Files.isRegularFile(arquivo)) {
                    Path nome = arquivo.getFileName();
                    String name = nome.toString().toLowerCase();
                    setArquivo(arquivo); // Corrigindo aqui
                    setExtensao(FilenameUtils.getExtension(name));

                    switch (getExtensao()) {
                        case "pdf":
                            setDestino(Paths.get("D:/Gtalles/Downloads/Organização/PDF"));
                            moveFile();
                            break;

                        case "png":
                            setDestino(Paths.get("D:/Gtalles/Downloads/Organização/IMAGENS/PNG"));
                            moveFile();
                            break;

                        case "jpeg":
                            setDestino(Paths.get("D:/Gtalles/Downloads/Organização/IMAGENS/JPEG"));
                            moveFile();
                            break;

                        case "mov":
                            setDestino(Paths.get("D:/Gtalles/Downloads/Organização/VIDEOS/MOV"));
                            moveFile();
                            break;

                        case "mp3":
                            setDestino(Paths.get("D:/Gtalles/Downloads/Organização/AUDIOS/MP3"));
                            moveFile();
                            break;

                        case "mp4":
                            setDestino(Paths.get("D:/Gtalles/Downloads/Organização/VIDEOS/MP4"));
                            moveFile();
                            break;

                        case "wav":
                            setDestino(Paths.get("D:/Gtalles/Downloads/Organização/AUDIOS/WAV"));
                            moveFile();
                            break;

                        case "docx":
                            setDestino(Paths.get("D:/Gtalles/Downloads/Organização/WORD"));
                            moveFile();
                            break;

                        case "jpg":
                            setDestino(Paths.get("D:/Gtalles/Downloads/Organização/IMAGENS/JPG"));
                            moveFile();
                            break;

                        case "txt":
                            setDestino(Paths.get("D:/Gtalles/Downloads/Organização/TEXTOS"));
                            moveFile();
                            break;

                        case "csv":
                            setDestino(Paths.get("D:/Gtalles/Downloads/Organização/DADOS"));
                            moveFile();
                            break;

                        case "xlsx":
                            setDestino(Paths.get("D:/Gtalles/Downloads/Organização/EXCEL"));
                            moveFile();
                            break;

                        case "pptx":
                            setDestino(Paths.get("D:/Gtalles/Downloads/Organização/POWERPOINT"));
                            moveFile();
                            break;

                        case "zip":
                            setDestino(Paths.get("D:/Gtalles/Downloads/Organização/ARQUIVOS_COMPACTADOS/ZIP"));
                            moveFile();
                            break;

                        case "rar":
                            setDestino(Paths.get("D:/Gtalles/Downloads/Organização/ARQUIVOS_COMPACTADOS/RAR"));
                            moveFile();
                            break;

                        case "exe":
                            setDestino(Paths.get("D:/Gtalles/Downloads/Organização/APLICATIVOS"));
                            moveFile();
                            break;

                        default:
                            System.out.println("Extensão não suportada: " + getExtensao());
                            break;
                    }


                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void moveFile() {
        try {
            if (getArquivo() != null) { // Verifica se arquivo não é nulo
                Files.move(getArquivo(), getDestino().resolve(getArquivo().getFileName()), StandardCopyOption.REPLACE_EXISTING);
                System.out.println("Arquivo movido: " + getArquivo().getFileName());
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}