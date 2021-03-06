package org.course.part04.lesson39.code;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.course.part04.lesson39.constant.Directory.RESOURCE_DIR;

public class StaticServlet extends HttpServlet {

    private final String midPath;

    public StaticServlet(String midPath) {
        this.midPath = midPath;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)  {
        try (OutputStream os = resp.getOutputStream()) {
            Path path = Paths.get(RESOURCE_DIR.getPath(), midPath, req.getPathInfo());
            Files.copy(path, os);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
