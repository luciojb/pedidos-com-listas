package estabelecimento;

import java.util.Date;

public class Operacao {
	private Date dtInicio;
	private Date dtFim;
	
	public Date getDtFim() {
		return dtFim;
	}
	
	public void setDtFim(Date dtFim) {
		this.dtFim = dtFim;
	}
	
	public Date getDtInicio() {
		return dtInicio;
	}
	
	public void setDtInicio(Date dtInicio) {
		this.dtInicio = dtInicio;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Operacao [dtInicio=");
		builder.append(dtInicio);
		builder.append(", dtFim=");
		builder.append(dtFim);
		builder.append("]");
		return builder.toString();
	}
	
	
	
	
	
	
}
