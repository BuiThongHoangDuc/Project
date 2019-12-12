/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hoangduc.filter;

import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author ADMIN
 */
public class RoleFilter implements Filter {

    private static final String INDEX = "/ShowProductController";
    private static final String LOGIN = "/login.jsp";
    private static final String SIGNUP = "/signup.jsp";
    private static final String CART = "/cart.jsp";
    private static final String ADMIN = "/admin/admin.jsp";
    private static final boolean debug = true;

    // The filter configuration object we are associated with.  If
    // this value is null, this filter instance is not currently
    // configured. 
    private FilterConfig filterConfig = null;

    public RoleFilter() {
    }

    private void doBeforeProcessing(ServletRequest request, ServletResponse response)
            throws IOException, ServletException {
        if (debug) {
            log("RoleFilter:DoBeforeProcessing");
        }

        // Write code here to process the request and/or response before
        // the rest of the filter chain is invoked.
        // For example, a logging filter might log items on the request object,
        // such as the parameters.
        /*
	for (Enumeration en = request.getParameterNames(); en.hasMoreElements(); ) {
	    String name = (String)en.nextElement();
	    String values[] = request.getParameterValues(name);
	    int n = values.length;
	    StringBuffer buf = new StringBuffer();
	    buf.append(name);
	    buf.append("=");
	    for(int i=0; i < n; i++) {
	        buf.append(values[i]);
	        if (i < n-1)
	            buf.append(",");
	    }
	    log(buf.toString());
	}
         */
    }

    private void doAfterProcessing(ServletRequest request, ServletResponse response)
            throws IOException, ServletException {
        if (debug) {
            log("RoleFilter:DoAfterProcessing");
        }

        // Write code here to process the request and/or response after
        // the rest of the filter chain is invoked.
        // For example, a logging filter might log the attributes on the
        // request object after the request has been processed. 
        /*
	for (Enumeration en = request.getAttributeNames(); en.hasMoreElements(); ) {
	    String name = (String)en.nextElement();
	    Object value = request.getAttribute(name);
	    log("attribute: " + name + "=" + value.toString());

	}
         */
        // For example, a filter might append something to the response.
        /*
	PrintWriter respOut = new PrintWriter(response.getWriter());
	respOut.println("<P><B>This has been appended by an intrusive filter.</B>");
         */
    }

    /**
     *
     * @param request The servlet request we are processing
     * @param response The servlet response we are creating
     * @param chain The filter chain we are processing
     *
     * @exception IOException if an input/output error occurs
     * @exception ServletException if a servlet error occurs
     */
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException {
        String url = INDEX;
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        HttpSession session = req.getSession();
        String role = (String) session.getAttribute("ROLE");
        String uri = req.getRequestURI();
        System.out.println("URI: " + uri);
        int lastIndex = uri.lastIndexOf("/");
        String resource = uri.substring(lastIndex + 1);

        System.out.println("Resource: " + resource);
        if (uri.contains("/assets/") || uri.contains("/css/") || uri.contains("/fonts/") || uri.contains("/images/") || uri.contains("/js/") || uri.contains("/vendor/") || uri.contains("/vendors/")) {
            chain.doFilter(request, response);
            return;
        } else {

            if (resource.length() > 0) {
                if (uri.contains("Controller")) {
                    url = "//" + resource;
                    System.out.println("URL: " + url);
                }

                if (url.equals("//MainController") || url.equals("//LoginController")) {
                    request.getRequestDispatcher(url).forward(request, response);
                    return;
                }
            }

            if (role != null) {

                if (uri.contains("/admin/") || url.equals("//EditProductController") || url.equals("//SearchBillController") || url.equals("//SearchController") || url.equals("//SearchProductController") || url.equals("//ServiceEditController") || url.equals("//ServiceSearchController") || url.equals("//ViewBillController")) {
                    if (!role.equals("1")) {
                        url = INDEX;
                    } else {
                        int lastindex1 = uri.lastIndexOf("/", 8);
                        String resource1 = uri.substring(lastindex1);
                        url = resource1;
                    }
                } else if (uri.contains("/user/") || url.equals("//ShowProductController") || url.equals("//ShowCatProductController") || url.equals("//ShowDogProductController") || url.equals("//CheckOutController") || url.equals("//EditPetController") || url.equals("//PersonSearchPetController") || url.equals("//SearchPetController") || url.equals("//UserViewBillController") || url.equals("//ViewBillController") || url.equals("//UserListBillController") || url.equals("//ShowServiceController")) {
                    if (!role.equals("2")) {
                        url = ADMIN;
                    } else {
                        int lastindex1 = uri.lastIndexOf("/", 8);
                        String resource1 = uri.substring(lastindex1);
                        System.out.println(resource1);
                        url = resource1;
                    }
                } else if (resource.equals("login.jsp")) {
                    if (role.equals("1")) {
                        url = ADMIN;
                    }
                } else if (resource.equals("signup.jsp")) {
                    if (role.equals("1")) {
                        url = ADMIN;
                    }
                } else if (resource.equals("index.jsp")) {
                    if (role.equals("1")) {
                        url = ADMIN;
                    }
                } else if (resource.equals("cart.jsp")) {
                    if (role.equals("2")) {
                        url = CART;
                    } else {
                        url = ADMIN;
                    }
                }
            } else {
                if (uri.contains("/admin/") || uri.contains("/user/") || url.equals("//SearchBillController") || url.equals("//SearchController") || url.equals("//SearchPetController") || url.equals("//SearchProductController") || url.equals("//PersonSearchPetController") || url.equals("//EditProductController") || url.equals("//EditPetController") || url.equals("//EditController") || url.equals("//ServiceEditController") || url.equals("//ServiceSearchController") || url.equals("//UserListBillController") || url.equals("//UserViewBillController") || url.equals("//ViewBillController")) {

                    url = INDEX;

                } else if (resource.equals("login.jsp")) {
                    url = LOGIN;
                } else if (resource.equals("signup.jsp")) {
                    url = SIGNUP;
                } else if (resource.equals("cart.jsp")) {
                    url = CART;
                }

            }

            if (url != null) {
                req.getRequestDispatcher(url).forward(request, response);
            } else {
                chain.doFilter(request, response);
            }
        }
    }

    /**
     * Return the filter configuration object for this filter.
     */
    public FilterConfig getFilterConfig() {
        return (this.filterConfig);
    }

    /**
     * Set the filter configuration object for this filter.
     *
     * @param filterConfig The filter configuration object
     */
    public void setFilterConfig(FilterConfig filterConfig) {
        this.filterConfig = filterConfig;
    }

    /**
     * Destroy method for this filter
     */
    public void destroy() {
    }

    /**
     * Init method for this filter
     */
    public void init(FilterConfig filterConfig) {
        this.filterConfig = filterConfig;
        if (filterConfig != null) {
            if (debug) {
                log("RoleFilter:Initializing filter");
            }
        }
    }

    /**
     * Return a String representation of this object.
     */
    @Override
    public String toString() {
        if (filterConfig == null) {
            return ("RoleFilter()");
        }
        StringBuffer sb = new StringBuffer("RoleFilter(");
        sb.append(filterConfig);
        sb.append(")");
        return (sb.toString());
    }

    private void sendProcessingError(Throwable t, ServletResponse response) {
        String stackTrace = getStackTrace(t);

        if (stackTrace != null && !stackTrace.equals("")) {
            try {
                response.setContentType("text/html");
                PrintStream ps = new PrintStream(response.getOutputStream());
                PrintWriter pw = new PrintWriter(ps);
                pw.print("<html>\n<head>\n<title>Error</title>\n</head>\n<body>\n"); //NOI18N

                // PENDING! Localize this for next official release
                pw.print("<h1>The resource did not process correctly</h1>\n<pre>\n");
                pw.print(stackTrace);
                pw.print("</pre></body>\n</html>"); //NOI18N
                pw.close();
                ps.close();
                response.getOutputStream().close();
            } catch (Exception ex) {
            }
        } else {
            try {
                PrintStream ps = new PrintStream(response.getOutputStream());
                t.printStackTrace(ps);
                ps.close();
                response.getOutputStream().close();
            } catch (Exception ex) {
            }
        }
    }

    public static String getStackTrace(Throwable t) {
        String stackTrace = null;
        try {
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            t.printStackTrace(pw);
            pw.close();
            sw.close();
            stackTrace = sw.getBuffer().toString();
        } catch (Exception ex) {
        }
        return stackTrace;
    }

    public void log(String msg) {
        filterConfig.getServletContext().log(msg);
    }

}
