package servlets;

import classes.Product;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Random;

public class FirstServlet extends HttpServlet {

    private static Logger logger = LoggerFactory.getLogger(FirstServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Random rn = new Random();
        logger.info("Log: GET");

        for(int i = 0;i<10;i++){
            resp.getWriter().println("<html><body><p>"+(new Product(i, String.valueOf(i), ((rn.nextInt(10)+1)*1000))).toString()+"</p></body></html>");
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

        logger.info("log: DESTROY");

    }

    @Override
    public void init() throws ServletException {

        logger.info("log: INIT");
    }
}
