package br.com.fatecmogidascruzes.ecommerce.photo.useCases;

import br.com.fatecmogidascruzes.ecommerce.photo.entities.Photo;
import br.com.fatecmogidascruzes.ecommerce.photo.entities.builder.PhotoBuilder;
import br.com.fatecmogidascruzes.ecommerce.photo.repository.PhotoRepository;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.UUID;

public class Upload {

    private final PhotoRepository photoRepository;

    public Upload(PhotoRepository photoRepository) {
        this.photoRepository = photoRepository;
    }

    public Photo execute(MultipartFile photo) throws IOException {
        String fileName = "file_" + UUID.randomUUID().toString();

        InputStream in = photo.getInputStream();
        OutputStream out = new FileOutputStream(fileName);

        byte[] bytes =  new byte[4096];
        int read;
        while((read = in.read(bytes, 0, bytes.length)) != -1) {
            out.write(bytes, 0, read);
        }
        in.close();
        out.close();

        Photo photodb = PhotoBuilder.of()
                .withFileName(fileName)
                .withOriginalFileName(photo.getOriginalFilename())
                .withSize(photo.getSize())
                .withContentType(photo.getContentType())
                .build();
        return photoRepository.save(photodb);
    }
}
