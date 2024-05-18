import org.apache.commons.io.FilenameUtils;

import java.io.IOException;
import java.nio.file.*;

public class Main {
    public static void main(String[] args) {

        Organizer orgPdf = new Organizer();
        Organizer orgJpg = new Organizer();
        Organizer orgPng = new Organizer();
        Organizer orgJpeg = new Organizer();
        Organizer orgMov = new Organizer();
        Organizer orgMp3 = new Organizer();
        Organizer orgMp4 = new Organizer();
        Organizer orgWav = new Organizer();


        orgPdf.setDestino(Paths.get("C:/Users/Talles/Downloads/Organização/PDF"));
        orgPdf.setType("PDF");
        orgPdf.fileCheck();

        orgJpg.setDestino(Paths.get("C:/Users/Talles/Downloads/Organização/IMAGENS/JPG"));
        orgJpg.setType("JPG");
        orgJpg.fileCheck();


        orgJpeg.setDestino(Paths.get("C:/Users/Talles/Downloads/Organização/IMAGENS/JPEG"));
        orgJpeg.setType("JPEG");
        orgJpeg.fileCheck();

        orgPng.setDestino(Paths.get("C:/Users/Talles/Downloads/Organização/IMAGENS/PNG"));
        orgPng.setType("PNG");
        orgPng.fileCheck();

        orgPng.setDestino(Paths.get("C:/Users/Talles/Downloads/Organização/WORD"));
        orgPng.setType("DOCX");
        orgPng.fileCheck();

        orgMov.setDestino(Paths.get("C:/Users/Talles/Downloads/Organização/VIDEOS/MOV"));
        orgMov.setType("MOV");
        orgMov.fileCheck();

        orgMp3.setDestino(Paths.get("C:/Users/Talles/Downloads/Organização/AUDIOS/MP3"));
        orgMp3.setType("MP3");
        orgMp3.fileCheck();

        orgMp4.setDestino(Paths.get("C:/Users/Talles/Downloads/Organização/VIDEOS/MP4"));
        orgMp4.setType("MP4");
        orgMp4.fileCheck();

        orgWav.setDestino(Paths.get("C:/Users/Talles/Downloads/Organização/AUDIOS/WAV"));
        orgWav.setType("WAV");
        orgWav.fileCheck();


    }
}


//chatgpt