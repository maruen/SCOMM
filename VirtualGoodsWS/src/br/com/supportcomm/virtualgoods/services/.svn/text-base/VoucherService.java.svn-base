package br.com.supportcomm.virtualgoods.services;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Properties;

import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPFactory;
import javax.xml.soap.SOAPFault;
import javax.xml.ws.soap.SOAPFaultException;

import org.springframework.stereotype.Service;

import br.com.supportcomm.virtualgoods.enums.VoucherStatus;
import br.com.supportcomm.virtualgoods.types.VoucherDataInput;
import br.com.supportcomm.virtualgoods.types.VoucherDataOutput;
import br.com.supportcomm.virtualgoods.types.WSAuthenticateInput;

@Service("VoucherService")
public class VoucherService {

	private static Connection 		conn;
	private PreparedStatement 		pstmt;
	private ResultSet 				rs;
	private static Properties 		properties;
	
	private static final Integer IS_CONSUMED 					= 1;
	
	private static final String CONFIG_FILENAME		 		= "config.properties";
	
	private static final String DATABASE_URL_PROPERTY			= "database_url";
	private static final String DRIVER_CLASSNAME_PROPERTY 	= "driver_classname";
	private static final String USERNAME_PROPERTY		 		= "username";
	private static final String PASSWORD_PROPERTY		 		= "password";
	
	private static final String IS_CONSUMED_FIELD			 	= "is_consumed";
	private static final String CONSUMPTION_DATE_FIELD		= "consumption_date";
	private static final String PURCHASE_DATE_FIELD			= "purchase_date";
	private static final String PARTNER_ID_FIELD				= "id_parceiro";
	
	
	static {

		properties = new Properties();
		InputStream in = VoucherService.class.getResourceAsStream(CONFIG_FILENAME);
		try {
			properties.load(in);
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		String DB_CONN_STRING 		= properties.getProperty(DATABASE_URL_PROPERTY);
		String DRIVER_CLASS_NAME 	= properties.getProperty(DRIVER_CLASSNAME_PROPERTY);
		String USER_NAME 			= properties.getProperty(USERNAME_PROPERTY);
		String PASSWORD 			= properties.getProperty(PASSWORD_PROPERTY);

		conn = null;

		try {
			Class.forName(DRIVER_CLASS_NAME).newInstance();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		try {
			conn = DriverManager.getConnection(DB_CONN_STRING, USER_NAME,PASSWORD);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	public VoucherDataOutput getVoucherStatus(WSAuthenticateInput wsAuthenticateInput, VoucherDataInput voucherDataInput) throws  SOAPException {
		
		Long partner = wsAuthenticate(wsAuthenticateInput); 
		
		StringBuffer sbf = new StringBuffer();
		
		sbf.append("SELECT is_consumed, consumption_date,purchase_date FROM voucher,campanha,regra ");
		sbf.append("WHERE voucher_code = ? AND msisdn = ? ");
		sbf.append("AND voucher.id_campanha = campanha.id_campanha AND campanha.id_regra = regra.id_regra AND regra.id_parceiro = ?");
		
		VoucherDataOutput voucherStatusResponse = new VoucherDataOutput();
		try {
			pstmt = conn.prepareStatement(sbf.toString());
			pstmt.setString	(1, voucherDataInput.getVoucherCode());
			pstmt.setString	(2, voucherDataInput.getMsisdn());
			pstmt.setLong	(3, partner);
			rs = pstmt.executeQuery();
			
			if ( rs.next() ) {
				
				Integer intValue 		= rs.getInt(IS_CONSUMED_FIELD);
				Date consumptionDate 	= rs.getTimestamp(CONSUMPTION_DATE_FIELD);
				Date purchaseDate		= rs.getTimestamp(PURCHASE_DATE_FIELD);
				
				voucherStatusResponse.setConsumptionDate(consumptionDate);
				voucherStatusResponse.setPurchaseDate(purchaseDate);
				
				if (intValue == 1) {
					voucherStatusResponse.setVoucherStatus(VoucherStatus.VOUCHER_ALREADY_CONSUMED);
					
				} else {
					voucherStatusResponse.setVoucherStatus(VoucherStatus.VOUCHER_NOT_CONSUMED);
				}
				
			} else {
				voucherStatusResponse.setVoucherStatus(VoucherStatus.VOUCHER_NOT_FOUND);
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
			voucherStatusResponse.setVoucherStatus(VoucherStatus.ERROR_WHILE_GETTING_VOUCHER_STATUS);
		}
		
		return voucherStatusResponse;

	}
	
	public VoucherDataOutput setVoucherToConsumed(WSAuthenticateInput wsAuthenticateInput, VoucherDataInput voucherDataInput) throws  SOAPException {
		
		VoucherDataOutput output = (VoucherDataOutput) getVoucherStatus(wsAuthenticateInput, voucherDataInput);
		
		if (output.getVoucherStatus() == VoucherStatus.VOUCHER_NOT_CONSUMED) {
		
			StringBuffer sbf = new StringBuffer();
			sbf.append("UPDATE voucher SET is_consumed = ?, consumption_date = ? WHERE voucher_code = ? AND msisdn = ? AND consumption_date IS NULL");
			
			Timestamp timestamp = new Timestamp(System.currentTimeMillis());
			
			try {
				pstmt = conn.prepareStatement(sbf.toString());
				pstmt.setInt		(1, IS_CONSUMED);
				pstmt.setTimestamp	(2, timestamp);
				pstmt.setString		(3, voucherDataInput.getVoucherCode());
				pstmt.setString		(4, voucherDataInput.getMsisdn());
				
				if (pstmt.executeUpdate() > 0) {
					VoucherDataOutput updateResult = new VoucherDataOutput();
					updateResult.setConsumptionDate(timestamp);
					updateResult.setPurchaseDate(output.getPurchaseDate());
					updateResult.setVoucherStatus(VoucherStatus.VOUCHER_SET_TO_CONSUMED_SUCESSFULLY);
					return updateResult;
				}
				
			
			} catch (SQLException e) {
				e.printStackTrace();
				VoucherDataOutput response = new VoucherDataOutput();
				response.setVoucherStatus(VoucherStatus.ERROR_WHILE_UPDATING_VOUCHER_STATUS);
				return response;
			}
		
		}
		
		
		return output;

	}

	
	private Long wsAuthenticate(WSAuthenticateInput wsAuthenticateInput) throws SOAPException    {
		
		
		StringBuffer sbf = new StringBuffer();
		sbf.append("SELECT id_parceiro, voucher_ws_login, voucher_ws_passwd FROM parceiro WHERE voucher_ws_login = ? AND voucher_ws_passwd = ? ");
		
		try {
			pstmt = conn.prepareStatement(sbf.toString());
			pstmt.setString	(1, wsAuthenticateInput.getVoucherWSLogin());
			pstmt.setString	(2, wsAuthenticateInput.getVoucherWSPasswd());
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				return rs.getLong(PARTNER_ID_FIELD);
			} else {
				 SOAPFault fault = SOAPFactory.newInstance().createFault();
				 fault.setFaultString("Usuário ou senha inválidos");
				 fault.setFaultCode("USER_OR_PASSWORD_INVALID");
				 throw new SOAPFaultException(fault);
			}
		
		} catch (SQLException e) {
			 SOAPFault fault = SOAPFactory.newInstance().createFault();
			 fault.setFaultString("Erro ao fazer autenticação");
			 fault.setFaultCode("ERROR");
			 throw new SOAPFaultException(fault);
		}
	
	}
	
	@Override
	protected void finalize() throws Throwable {
		super.finalize();

		try {

			if (rs != null) {
				rs.close();
			}

			if (pstmt != null) {
				pstmt.close();
			}

			if (conn != null) {
				conn.close();
			}

		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
		}
	}

}
