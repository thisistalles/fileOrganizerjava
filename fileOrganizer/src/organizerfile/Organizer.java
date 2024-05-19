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
        while (true) {

            try (DirectoryStream<Path> stream = Files.newDirectoryStream(origem)) {
                for (Path arquivo : stream) {
                    if (Files.isRegularFile(arquivo)) {
                        Path nome = arquivo.getFileName();
                        String name = nome.toString().toLowerCase();
                        setArquivo(arquivo); // Corrigindo aqui
                        setExtensao(FilenameUtils.getExtension(name));

                        switch (getExtensao()) {
                            case "pdf":
                                setDestino(Paths.get("D:/Gtalles/Downloads/Organizacao/PDF"));
                                moveFile();
                                break;

                            case "png":
                                setDestino(Paths.get("D:/Gtalles/Downloads/Organizacao/IMAGENS/PNG"));
                                moveFile();
                                break;

                            case "jpeg":
                                setDestino(Paths.get("D:/Gtalles/Downloads/Organizacao/IMAGENS/JPEG"));
                                moveFile();
                                break;

                            case "mov":
                                setDestino(Paths.get("D:/Gtalles/Downloads/Organizacao/VIDEOS/MOV"));
                                moveFile();
                                break;

                            case "mp3":
                                setDestino(Paths.get("D:/Gtalles/Downloads/Organizacao/AUDIOS/MP3"));
                                moveFile();
                                break;

                            case "mp4":
                                setDestino(Paths.get("D:/Gtalles/Downloads/Organizacao/VIDEOS/MP4"));
                                moveFile();
                                break;

                            case "wav":
                                setDestino(Paths.get("D:/Gtalles/Downloads/Organizacao/AUDIOS/WAV"));
                                moveFile();
                                break;

                            case "docx":
                                setDestino(Paths.get("D:/Gtalles/Downloads/Organizacao/WORD"));
                                moveFile();
                                break;

                            case "jpg":
                                setDestino(Paths.get("D:/Gtalles/Downloads/Organizacao/IMAGENS/JPG"));
                                moveFile();
                                break;

                            case "txt":
                                setDestino(Paths.get("D:/Gtalles/Downloads/Organizacao/TEXTOS"));
                                moveFile();
                                break;

                            case "csv":
                                setDestino(Paths.get("D:/Gtalles/Downloads/Organizacao/DADOS"));
                                moveFile();
                                break;

                            case "xlsx":
                                setDestino(Paths.get("D:/Gtalles/Downloads/Organizacao/EXCEL"));
                                moveFile();
                                break;

                            case "pptx":
                                setDestino(Paths.get("D:/Gtalles/Downloads/Organizacao/POWERPOINT"));
                                moveFile();
                                break;

                            case "zip":
                                setDestino(Paths.get("D:/Gtalles/Downloads/Organizacao/ARQUIVOS_COMPACTADOS/ZIP"));
                                moveFile();
                                break;

                            case "rar":
                                setDestino(Paths.get("D:/Gtalles/Downloads/Organizacao/ARQUIVOS_COMPACTADOS/RAR"));
                                moveFile();
                                break;

                            case "exe":
                                setDestino(Paths.get("D:/Gtalles/Downloads/Organizacao/APLICATIVOS"));
                                moveFile();
                                break;

                            default:
                                System.out.println("Extensão não reconhecida: " + getExtensao());
                                setDestino(Paths.get("D://Gtalles//Downloads//Organizacao//DESCONHECIDO"));
                                moveFile();
                                break;
                        }


                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                System.err.println("Erro ao aguardar o próximo intervalo: " + e.getMessage());
            }
        }
    }

    public void moveFile() {
        try {
            Path arquivo = getArquivo();
            if (arquivo != null) {
                if (arquivo.getFileName().toString().endsWith(".tmp") || arquivo.getFileName().toString().endsWith(".opdownload")) {
                    System.out.println("Arquivo ignorado: " + arquivo.getFileName() + " devido à sua extensão");
                    return; // Se a extensão for "tmp", retorna sem fazer nada
                }

                Path destino = getDestino().resolve(arquivo.getFileName());
                Files.move(arquivo, destino, StandardCopyOption.REPLACE_EXISTING);
                System.out.println("Arquivo movido: " + arquivo.getFileName() + " para pasta: " + destino);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}