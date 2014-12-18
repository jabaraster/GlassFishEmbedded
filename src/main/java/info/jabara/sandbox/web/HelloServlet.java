/**
 * 
 */
package info.jabara.sandbox.web;

import info.jabara.sandbox.service.HogeService;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author jabaraster
 */
@WebServlet(urlPatterns = { "/hello" })
public class HelloServlet extends HttpServlet {
    private static final long serialVersionUID = -5672921286427029830L;

    @Inject
    HogeService               hogeService;

    /**
     * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    @SuppressWarnings("nls")
    @Override
    protected void doGet(@SuppressWarnings("unused") final HttpServletRequest pReq, final HttpServletResponse pResp) throws IOException {
        this.hogeService.insert();
        pResp.setContentType("text/plain");
        pResp.getWriter().print("Hello, Embedded GlassFish!! --> " + this.hogeService.getNow());
    }
}
