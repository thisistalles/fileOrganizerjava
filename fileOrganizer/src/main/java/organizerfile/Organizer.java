package organizerfile;

import org.apache.commons.io.FilenameUtils;

import java.io.IOException;
import java.nio.file.*;

public class Organizer {


    private String extensao;
    private Path origem;
    private Path destino;
    private Path arquivo;

    public Organizer(String origem) {
        this.origem = Paths.get(origem);
    }

    public void fileCheck() {
        while (true) {
            try (DirectoryStream<Path> stream = Files.newDirectoryStream(origem)) {
                for (Path arquivo : stream) {
                    if (Files.isRegularFile(arquivo)) {
                        Path nome = arquivo.getFileName();
                        String name = nome.toString().toLowerCase();
                        this.arquivo = arquivo;
                        this.extensao = FilenameUtils.getExtension(name);

                        switch (this.extensao) {
                            case "pdf":
                                this.destino = Paths.get("D:/Gtalles/Downloads/Organizacao/PDF");
                                moveFile();
                                break;

                            case "png":
                                this.destino = Paths.get("D:/Gtalles/Downloads/Organizacao/IMAGENS/PNG");
                                moveFile();
                                break;

                            case "jpeg":
                                this.destino = Paths.get("D:/Gtalles/Downloads/Organizacao/IMAGENS/JPEG");
                                moveFile();
                                break;

                            case "mov":
                                this.destino = Paths.get("D:/Gtalles/Downloads/Organizacao/VIDEOS/MOV");
                                moveFile();
                                break;

                            case "mp3":
                                this.destino = Paths.get("D:/Gtalles/Downloads/Organizacao/AUDIOS/MP3");
                                moveFile();
                                break;

                            case "mp4":
                                this.destino = Paths.get("D:/Gtalles/Downloads/Organizacao/VIDEOS/MP4");
                                moveFile();
                                break;

                            case "wav":
                                this.destino = Paths.get("D:/Gtalles/Downloads/Organizacao/AUDIOS/WAV");
                                moveFile();
                                break;

                            case "docx":
                                this.destino = Paths.get("D:/Gtalles/Downloads/Organizacao/WORD");
                                moveFile();
                                break;

                            case "jpg":
                                this.destino = Paths.get("D:/Gtalles/Downloads/Organizacao/IMAGENS/JPG");
                                moveFile();
                                break;

                            case "txt":
                                this.destino = Paths.get("D:/Gtalles/Downloads/Organizacao/TEXTOS");
                                moveFile();
                                break;

                            case "csv":
                                this.destino = Paths.get("D:/Gtalles/Downloads/Organizacao/DADOS");
                                moveFile();
                                break;

                            case "xlsx":
                                this.destino = Paths.get("D:/Gtalles/Downloads/Organizacao/EXCEL");
                                moveFile();
                                break;

                            case "pptx":
                                this.destino = Paths.get("D:/Gtalles/Downloads/Organizacao/POWERPOINT");
                                moveFile();
                                break;

                            case "zip":
                                this.destino = Paths.get("D:/Gtalles/Downloads/Organizacao/ARQUIVOS_COMPACTADOS/ZIP");
                                moveFile();
                                break;

                            case "rar":
                                this.destino = Paths.get("D:/Gtalles/Downloads/Organizacao/ARQUIVOS_COMPACTADOS/RAR");
                                moveFile();
                                break;

                            case "exe":
                                this.destino = Paths.get("D:/Gtalles/Downloads/Organizacao/APLICATIVOS");
                                moveFile();
                                break;

                            default:
                                System.out.println("Extensão não reconhecida: " + this.extensao);
                                this.destino = (Paths.get("D:/Gtalles/Downloads/Organizacao/DESCONHECIDO"));
                                moveFile();
                                break;
                        }


                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.err.println("Erro ao aguardar o próximo intervalo: " + e.getMessage());
            }
        }
    }

    public void moveFile() {
        try {
            Path arquivo = this.arquivo;
            if (arquivo != null) {
                if (arquivo.getFileName().toString().endsWith(".tmp") || arquivo.getFileName().toString().endsWith(".opdownload")) {
                    System.out.println("Arquivo ignorado: " + arquivo.getFileName() + " devido à sua extensão");
                    return;
                }

                Path destino = this.destino.resolve(arquivo.getFileName());
                Files.move(arquivo, destino, StandardCopyOption.REPLACE_EXISTING);
                System.out.println("Arquivo movido: " + arquivo.getFileName() + " para pasta: " + destino);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}