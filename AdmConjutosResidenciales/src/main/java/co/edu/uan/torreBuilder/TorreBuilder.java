package co.edu.uan.torreBuilder;

import java.util.ArrayList;

public class TorreBuilder implements IBuilder<Torre>{
	
	private int numero;
	private Zona zona;
	private final ArrayList<Apartamento> apartamentos = new ArrayList<>();

	
	
	public TorreBuilder() {
	}

	public TorreBuilder setNumero(int numero) {
		this.numero=numero;
		return this;
	}
	public TorreBuilder setZona(String idzona, String nombre, float administracion, ArrayList<Integer> numeros, float costo) {
		this.zona = new Zona(idzona, nombre, administracion,new Parqueadero(numeros, costo));
		return this;
	}
	
	public TorreBuilder addApartamentos(int numero, String reside, String parqueadero) {
		apartamentos.add(new Apartamento(numero, reside, parqueadero));
		return this;
	}
	
	@Override
	public Torre build() {		
		return new Torre(numero, zona, apartamentos);
		
	}

}
