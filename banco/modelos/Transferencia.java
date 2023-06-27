package banco.modelos;

import java.util.Date;

public class Transferencia {

	private Integer id;
	private Integer idOrigen;
	private Integer idDestino;
	private Integer importe;
	private String concepto;
	private Date fecha;

	public Transferencia(Integer id, Integer idOrigen, Integer idDestino, Integer importe, String concepto, Date fecha) {
		this.id = id;
		this.idOrigen = idOrigen;
		this.idDestino = idDestino;
		this.importe = importe;
		this.concepto = concepto;
		this.fecha = new Date();
	}



	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public Integer getIdOrigen() {
		return idOrigen;
	}



	public void setIdOrigen(Integer idOrigen) {
		this.idOrigen = idOrigen;
	}



	public Integer getIdDestino() {
		return idDestino;
	}



	public void setIdDestino(Integer idDestino) {
		this.idDestino = idDestino;
	}



	public Integer getImporte() {
		return importe;
	}



	public void setImporte(Integer importe) {
		this.importe = importe;
	}



	public String getConcepto() {
		return concepto;
	}



	public void setConcepto(String concepto) {
		this.concepto = concepto;
	}



	public Date getFecha() {
		return fecha;
	}



	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

		

	public String toString() {
		return "Transferencia [id=" + id + ", idOrigen=" + idOrigen + ", idDestino=" + idDestino + ", importe="
				+ importe + ", concepto=" + concepto + ", fecha=" + fecha + "]";
	}



	public boolean equals(Object o) {
		Transferencia m = (Transferencia) o;
		boolean mismoId = this.id == m.id;
		return mismoId;
	}

}
