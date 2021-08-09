package servlets;

import classes.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Random;

public class FirstServlet extends HttpServlet {

    private static Logger logger = LoggerFactory.getLogger(FirstServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Random rn = new Random();
        logger.info("Log: GET");
        resp.setContentType("html/text");
        for(int i = 0;i<10;i++){
            resp.getWriter().println("<html><body><p>"+(new Product(i, String.valueOf(i), (rn.nextInt(10)*1000))).toString()+"</p></body></html>");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.info("log: POST");
        resp.getWriter().println();
        resp.setContentType("html/text");
    }

    @Override
    public void destroy() {
        super.destroy();
        logger.info("log: DESTROY");

    }

    @Override
    public void init() throws ServletException {
        super.init();
        logger.info("log: INIT");
    }
}
