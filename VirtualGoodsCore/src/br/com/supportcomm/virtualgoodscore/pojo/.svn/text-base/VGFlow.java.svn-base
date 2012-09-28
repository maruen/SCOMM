package br.com.supportcomm.virtualgoodscore.pojo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table (name = "vg_flow")
public class VGFlow  implements Serializable{
	
	private static final long serialVersionUID = -6635140672257953179L;
	
	@Id
	@GeneratedValue    (generator = "vgflow", strategy 		= GenerationType.AUTO)
	@SequenceGenerator (name 	  = "vgflow", sequenceName  = "vg_flow_seq")
	
	@Column(name = "flow_id", nullable=false)			private Integer flowId;
	@Column(name = "flow_type", nullable=false)			private Integer flowType;
	@Column(name = "flow_name", nullable=false)			private String  flowName;
	@Column(name = "flow_description", nullable=false)	private String  flowDescription;
	
	public Integer getFlowId() {
		return flowId;
	}
	public void setFlowId(Integer flowId) {
		this.flowId = flowId;
	} 
	public String getFlowName() {
		return flowName;
	}
	public void setFlowName(String flowName) {
		this.flowName = flowName;
	}
	public String getFlowDescription() {
		return flowDescription;
	}
	public void setFlowDescription(String flowDescription) {
		this.flowDescription = flowDescription;
	}
	public Integer getFlowType() {
		return flowType;
	}
	public void setFlowType(Integer flowType) {
		this.flowType = flowType;
	}

}
