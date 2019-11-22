package PetsLove.sistema.exceptions;

import PetsLove.sistema.negocios.beans.EnumRacaCachorro;

public class RacaNaoExisteException extends Exception{
	
	private String raca;
	
	public RacaNaoExisteException(EnumRacaCachorro raca) {
		super("A ra�a "+raca+" n�o foi encontrada");
		this.raca = raca.toString();
	}
	
	public String getRaca() {
		return raca;
	}
	
}
