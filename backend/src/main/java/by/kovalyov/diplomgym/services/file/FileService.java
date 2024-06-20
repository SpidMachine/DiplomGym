package by.kovalyov.diplomgym.services.file;

public interface FileService {
    String saveFile(String base64);
    String saveFile(byte[] file);
}
