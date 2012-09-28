package br.com.supportcomm.virtualgoodscore.constantes;

public enum TransactionStatus {

	WAITING_TO_PROCESS,								
	
	PROCESS_TRANSACTION,	
	
	SEND_OPTION_IN,
	WAIT_OPTION_IN_ANSWER,
	
	ASK_PARTNER_AUTHORIZATION,
	WAIT_PARTNER_AUTHORIZATION,	
	
	TRANSACTION_AUTHORIZED,
	
	PROCESS_BILLING,		
	
	CHECK_CREDIT_FAILED,		
	BILLING_FAILED,			
	BILLING_SUCCESS,
	VOUCHER_GENERATED,
	VOUCHER_NOT_GENERATED,
	
	PROCESS_TRANSACTION_RESPONSE,
	TRANSACTION_RESPONSE_NOT_SENT,
	PROCESS_SEND_VOUCHER,
	
	TRANSACTION_CANCELED,
	TRANSACTION_FINISHED,				

}
