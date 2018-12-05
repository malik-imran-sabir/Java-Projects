package org.api.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class SpringWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    public static final String CHARACTER_ENCODING = "UTF-8";


    /*@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
    	
		super.onStartup(servletContext);
	}
*/
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[] { SpringMVCConfiguration.class };
    }

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[] { AppConfiguration.class };
    }

    @Override
    protected String[] getServletMappings() {
        return new String[] { "/" };
    }
    
}
