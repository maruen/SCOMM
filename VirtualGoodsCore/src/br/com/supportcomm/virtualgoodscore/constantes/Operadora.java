package br.com.supportcomm.virtualgoodscore.constantes;


public enum Operadora {

	CLARO	(5,  "Claro"),
	CTBC	(7,  "CTBC"),
	NEXTEL	(3,  "Nextel"),
	OI		(4,  "OI"),
	TIM		(9,  "Tim"),
	VIVO	(10, "Vivo");
	
	
	private  String 	descricao;
	private  int 		carrier;
	private boolean 	selected = false;
	
	private Operadora(final int carrier, final String descricao) {
		this.descricao = descricao;
		this.carrier = carrier;
	}

	public String getDescricao() {
		return descricao;
	}
	
	public static String getDescriptionByCode(String code) {
		
		try {
			Integer codeAsInt = Integer.parseInt(code);
			for ( Operadora oper : Operadora.values() ) {
				if (oper.getCarrier() == codeAsInt ) {
					return oper.descricao;
				}
			}
		} catch (NumberFormatException exp) {}
		
		return "";

	} 
	
	public int getCarrier() {
		return carrier;
	}

	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}	
}
