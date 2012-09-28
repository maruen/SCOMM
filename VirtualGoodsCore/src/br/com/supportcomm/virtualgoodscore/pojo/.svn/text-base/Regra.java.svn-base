package br.com.supportcomm.virtualgoodscore.pojo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import br.com.supportcomm.virtualgoodscore.constantes.Operadora;

@Entity
public class Regra implements Serializable {
	
	private static final long serialVersionUID = 7122106407535703877L;
	
	public static final int ENABLED = 1;
	public static final int DISABLED = 0;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "regra")
	@SequenceGenerator(name = "regra", sequenceName = "regra_seq")
	@Column(name = "id_regra")
	private long id;

	@Column(name = "nm_regra", nullable = false, length = 50)
	private String nome;

	@ManyToOne
	@JoinColumn(name = "id_parceiro", nullable = false)
	private Parceiro parceiro;

	@ManyToOne
	@JoinColumn(name = "id_la", nullable = false)
	private LA la;

	@ManyToOne
	@JoinColumn(name = "id_keycode", nullable = false)
	private Keycode keycode;

	@ManyToOne
	@JoinColumn(name = "id_sharecode_vivo", nullable = true)
	private Sharecode sharecodeVivo;

	@ManyToOne
	@JoinColumn(name = "id_sharecode_claro", nullable = true)
	private Sharecode sharecodeClaro;

	@ManyToOne
	@JoinColumn(name = "id_sharecode_oi", nullable = true)
	private Sharecode sharecodeOi;

	@ManyToOne
	@JoinColumn(name = "id_sharecode_tim", nullable = true)
	private Sharecode sharecodeTim;

	@ManyToOne
	@JoinColumn(name = "id_sharecode_nextel", nullable = true)
	private Sharecode sharecodeNextel;

	@ManyToOne
	@JoinColumn(name = "id_sharecode_ctbc", nullable = true)
	private Sharecode sharecodeCtbc;

	@Column(name = "cd_ativo", nullable = false)
	private int ativo;
	
	@Column(name = "dt_criacao", nullable = false)
	private Date dtCriacao;

	@Column(name = "dt_alteracao", nullable = false)
	private Date dtAlteracao;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Parceiro getParceiro() {
		return parceiro;
	}

	public void setParceiro(Parceiro parceiro) {
		this.parceiro = parceiro;
	}

	public LA getLa() {
		return la;
	}

	public void setLa(LA la) {
		this.la = la;
	}

	public Keycode getKeycode() {
		return keycode;
	}

	public void setKeycode(Keycode keycode) {
		this.keycode = keycode;
	}

	public Sharecode getSharecodeVivo() {
		return sharecodeVivo;
	}

	public void setSharecodeVivo(Sharecode sharecodeVivo) {
		this.sharecodeVivo = sharecodeVivo;
	}

	public Sharecode getSharecodeClaro() {
		return sharecodeClaro;
	}

	public void setSharecodeClaro(Sharecode sharecodeClaro) {
		this.sharecodeClaro = sharecodeClaro;
	}

	public Sharecode getSharecodeOi() {
		return sharecodeOi;
	}

	public void setSharecodeOi(Sharecode sharecodeOi) {
		this.sharecodeOi = sharecodeOi;
	}

	public Sharecode getSharecodeTim() {
		return sharecodeTim;
	}

	public void setSharecodeTim(Sharecode sharecodeTim) {
		this.sharecodeTim = sharecodeTim;
	}

	public Sharecode getSharecodeNextel() {
		return sharecodeNextel;
	}

	public void setSharecodeNextel(Sharecode sharecodeNextel) {
		this.sharecodeNextel = sharecodeNextel;
	}

	public Sharecode getSharecodeCtbc() {
		return sharecodeCtbc;
	}

	public void setSharecodeCtbc(Sharecode sharecodeCtbc) {
		this.sharecodeCtbc = sharecodeCtbc;
	}

	public int getAtivo() {
		return ativo;
	}

	public void setAtivo(int ativo) {
		this.ativo = ativo;
	}
	

	public Date getDtCriacao() {
		return dtCriacao;
	}

	public void setDtCriacao(Date dtCriacao) {
		this.dtCriacao = dtCriacao;
	}

	public Date getDtAlteracao() {
		return dtAlteracao;
	}

	public void setDtAlteracao(Date dtAlteracao) {
		this.dtAlteracao = dtAlteracao;
	}
	
	public void setSharecode(Sharecode share) {
		if(share.getOperadora() == Operadora.CLARO.getCarrier())
			sharecodeClaro = share;
		if(share.getOperadora() == Operadora.VIVO.getCarrier())
			sharecodeVivo = share;
		if(share.getOperadora() == Operadora.CTBC.getCarrier())
			sharecodeCtbc = share;
		if(share.getOperadora() == Operadora.NEXTEL.getCarrier())
			sharecodeNextel = share;
		if(share.getOperadora() == Operadora.OI.getCarrier())
			sharecodeOi = share;
		if(share.getOperadora() == Operadora.TIM.getCarrier())
			sharecodeTim = share;		
	}

	public Sharecode getSharecode(int operadora) {
		if(operadora == Operadora.CLARO.getCarrier())
			return sharecodeClaro;
		if(operadora == Operadora.VIVO.getCarrier())
			return sharecodeVivo;
		if(operadora == Operadora.CTBC.getCarrier())
			return sharecodeCtbc;
		if(operadora == Operadora.NEXTEL.getCarrier())
			return sharecodeNextel;
		if(operadora == Operadora.OI.getCarrier())
			return sharecodeOi;
		if(operadora == Operadora.TIM.getCarrier())
			return sharecodeTim;
		return null;
	}
	
	public String getSharecodeFormat() {		
		String s = new String();
		if(sharecodeClaro != null)
			s += Operadora.CLARO.getDescricao() + " - " + sharecodeClaro.getNome() + " - " +sharecodeClaro.getTarifacao() + "<br />";
		if(sharecodeCtbc != null)
			s += Operadora.CTBC.getDescricao() + " - " + sharecodeCtbc.getNome() + " - " +sharecodeCtbc.getTarifacao() + "<br />" ;
		if(sharecodeNextel != null)
			s += Operadora.NEXTEL.getDescricao() + " - " + sharecodeNextel.getNome() + " - " +sharecodeNextel.getTarifacao() + "<br />" ;
		if(sharecodeOi != null)
			s += Operadora.OI.getDescricao() + " - " + sharecodeOi.getNome() + " - " +sharecodeOi.getTarifacao() + "<br />" ;
		if(sharecodeTim != null)
			s += Operadora.TIM.getDescricao() + " - " + sharecodeTim.getNome() + " - " +sharecodeTim.getTarifacao() + "<br />" ;
		if(sharecodeVivo != null)
			s += Operadora.VIVO.getDescricao() + " - " + sharecodeVivo.getNome() + " - " +sharecodeVivo.getTarifacao() + "<br />" ;
		return s;
	}
	
	public String getAtivoFormat() {
		if(this.ativo == ENABLED)
			return "SIM";
		if(this.ativo == DISABLED)
			return "NAO";
		return "";
	}
	
	public boolean isHabilitado() {
		return this.ativo == ENABLED;
	}


}
