package br.com.fatecmogidascruzes.ecommerce.photo.useCases;

import br.com.fatecmogidascruzes.ecommerce.photo.entities.Photo;

import javax.servlet.http.HttpServletResponse;
import java.io.*;

public class Download {

    public void execute(Photo photo, HttpServletResponse response) throws IOException {
        response.setContentType(photo.getContentType());

        InputStream in = new FileInputStream(photo.getFileName());
        OutputStream out = response.getOutputStream();

        byte[] bytes =  new byte[4096];
        int read;
        while((read = in.read(bytes, 0, bytes.length)) != -1) {
            out.write(bytes, 0, read);
        }
        in.close();
        out.close();
    }
}
