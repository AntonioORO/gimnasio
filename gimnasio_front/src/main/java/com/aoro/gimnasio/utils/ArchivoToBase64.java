package com.aoro.gimnasio.utils;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;

public class ArchivoToBase64 {
	public static String getTipoArchivo(String rutaArchivo) {
        try {
            return Files.probeContentType(Paths.get(rutaArchivo));
        } catch (IOException e) {
            return "application/octet-stream";
        }
    }

    public static String archivoToBase64(String rutaArchivo) {
        try (FileInputStream fileInputStream = new FileInputStream(new File(rutaArchivo))) {
            byte[] bytes = fileInputStream.readAllBytes();
            return Base64.getEncoder().encodeToString(bytes);
        } catch (IOException e) {
            return "";
        }
    }
}
