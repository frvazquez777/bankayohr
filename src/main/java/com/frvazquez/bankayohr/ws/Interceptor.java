package com.frvazquez.bankayohr.ws;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.ws.context.MessageContext;
import org.springframework.ws.server.EndpointInterceptor;

import com.frvazquez.bankayohr.domain.Request;
import com.frvazquez.bankayohr.service.PokemonService;

@Component
public class Interceptor implements EndpointInterceptor {

	protected static Logger LOG = LoggerFactory.getLogger(Interceptor.class);

	private final HttpServletRequest httpServletRequest;
	private PokemonService service;

    public Interceptor(HttpServletRequest httpServletRequest, PokemonService service) {
        this.httpServletRequest = httpServletRequest;
        this.service = service;
    }

    private String getIpOrigen() {
        String remoteAddr = "";
        if (httpServletRequest != null) {
            remoteAddr = httpServletRequest.getHeader("X-FORWARDED-FOR");
            if (remoteAddr == null || "".equals(remoteAddr)) {
                remoteAddr = httpServletRequest.getRemoteAddr();
            }
        }

        return remoteAddr;
    }

    @Override
    public boolean handleRequest(MessageContext messageContext, Object o) throws Exception {
		LOG.info("----------------------------------------------------------------------------");

        LOG.info("capturamos datos...");
		Request req = new Request();
		req.setMetodo(messageContext.getRequest().toString().split("}")[1]);
		req.setIpOrigen(getIpOrigen());
		try {
			Request request = service.save(req);
			LOG.info("----------------------------------------------------------------------------");
			LOG.info("Request Guardado");
			LOG.info(request.toString());
			LOG.info("----------------------------------------------------------------------------");

	        return true;

		} catch (Exception e) {
			LOG.error("Fallo al captura los datos de la petición...");
			LOG.error(e.getMessage());
	        return false;
		}
		
    }
  


	@Override
	public boolean handleResponse(MessageContext messageContext, Object endpoint) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean handleFault(MessageContext messageContext, Object endpoint) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void afterCompletion(MessageContext messageContext, Object endpoint, Exception ex) throws Exception {
		// TODO Auto-generated method stub
		
	}
}
