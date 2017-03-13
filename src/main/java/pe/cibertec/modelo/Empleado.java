package pe.cibertec.modelo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;

@Entity
@Table(name = "TBL_EMPLEADOS")
public class Empleado implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "COD_EMPLEADO")
	private Long codigo;

	@Column(name = "APELLIDOS")
	private String apellidos;

	@Column(name = "NOMBRES")
	private String nombres;

	@Column(name = "FECHA_NACIMIENTO")
	private Date fechaNacimiento;

	@OneToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name = "ID_DIRECCION")
	private Direccion direccion;

	public Empleado() {

	}

	public Empleado(Long codigo, String apellidos, String nombres, Date fechaNacimiento) {
		this.codigo = codigo;
		this.apellidos = apellidos;
		this.nombres = nombres;
		this.fechaNacimiento = fechaNacimiento;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public Direccion getDireccion() {
		return direccion;
	}

	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}

	@Override
	public String toString() {
		return "Empleado [codigo=" + codigo + ", apellidos=" + apellidos + ", nombres=" + nombres + ", fechaNacimiento="
				+ fechaNacimiento + ", direccion=" + direccion + "]";
	}

}
