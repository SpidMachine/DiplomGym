package by.kovalyov.diplomgym.services.file;

import lombok.RequiredArgsConstructor;
import org.hibernate.id.uuid.UuidGenerator;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.Base64;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class FileServiceImpl implements FileService {
    @Value("${upload.path}")
    private String uploadPath;

    @Override
    public String saveFile(String base64) {
        return saveFile(Base64.getDecoder().decode(base64));
    }

    @Override
    public String saveFile(byte[] fileByte) {
        UUID uuid = UUID.randomUUID();
        String filepath = uploadPath + "/" + uuid;

        try {
            OutputStream out = new FileOutputStream(filepath);
            out.write(fileByte);
            out.close();
            return filepath;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
