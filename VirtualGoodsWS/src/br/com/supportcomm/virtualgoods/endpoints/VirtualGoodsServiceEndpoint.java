package br.com.supportcomm.virtualgoods.endpoints;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.xml.soap.SOAPException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import br.com.supportcomm.virtualgoods.services.VoucherService;
import br.com.supportcomm.virtualgoods.types.VoucherDataInput;
import br.com.supportcomm.virtualgoods.types.VoucherDataOutput;
import br.com.supportcomm.virtualgoods.types.WSAuthenticateInput;

@Service("VirtualGoodsServiceEndpoint")
@WebService(serviceName="VoucherService")
public class VirtualGoodsServiceEndpoint extends SpringBeanAutowiringSupport {

	@Autowired
	private VoucherService voucherService;
	
	@WebMethod
	public VoucherDataOutput getVoucherStatus(	@WebParam(name="wsAuthenticateInput", header=true) 		WSAuthenticateInput wsAuthenticateInput,
							   			  		@WebParam(name="voucherDataInput" )						VoucherDataInput 	voucherDataInput)
							   			  	
							   			  					throws  SOAPException {
		
		return voucherService.getVoucherStatus(wsAuthenticateInput, voucherDataInput);
	}
	
	@WebMethod
	public VoucherDataOutput setVoucherToConsumed(	@WebParam(name="wsAuthenticateInput", header=true) 		WSAuthenticateInput wsAuthenticateInput,
		  											@WebParam(name="voucherDataInput" )						VoucherDataInput 	voucherDataInput)
		  										  
		  													throws  SOAPException {
		
		return voucherService.setVoucherToConsumed(wsAuthenticateInput, voucherDataInput);
	}

}
