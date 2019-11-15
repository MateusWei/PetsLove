package PetsLove.sistema.negocios;

import java.util.ArrayList;
import PetsLove.sistema.FachadaPL;
import PetsLove.sistema.exceptions.UsuarioJaExisteException;
import PetsLove.sistema.negocios.beans.Animal;
import PetsLove.sistema.negocios.beans.Cachorro;
import PetsLove.sistema.negocios.beans.EnumPelagem;
import PetsLove.sistema.negocios.beans.EnumRaca;
import PetsLove.sistema.negocios.beans.EnumSexo;
import PetsLove.sistema.negocios.beans.EnumTamanho;
import PetsLove.sistema.negocios.beans.Gato;
import PetsLove.sistema.negocios.beans.Solicitacao;
import PetsLove.sistema.negocios.beans.Usuario;

public class Teste {
	
	public static void main(String[] args) throws UsuarioJaExisteException {
		
		FachadaPL fachada = FachadaPL.getInstance();
		
		Usuario u1 = new Usuario(123, "Ben10", "99954-4213", "rogerinho..@hotmail.com", "321anhes");
		Usuario u2 = new Usuario(133, "Barbie", "99857-1682", "Barbiegirl@hotmail.com", "ken123");
		fachada.cadastrarUsuario(u1);
		fachada.cadastrarUsuario(u2);
		
		Cachorro c1 = new Cachorro(321, 4, EnumSexo.MACHO, "Bob", u1, EnumRaca.PITBULL, EnumTamanho.ALTO);
		Cachorro c2 = new Cachorro(331, 3, EnumSexo.FEMEA, "Mary", u2, EnumRaca.PITBULL, EnumTamanho.ALTO);
		Gato g1 = new Gato(213, 2, EnumSexo.FEMEA, "Meow", u1, EnumPelagem.FELPUDO);
		fachada.cadastrarAnimal(c1);
		fachada.cadastrarAnimal(c2);
		fachada.cadastrarAnimal(g1);
		
		
		
		FachadaPL.login("rogerinho..@hotmail.com", "321anhes");
		System.out.println(FachadaPL.getUsuarioLogado().getNome());
		
		FachadaPL.logout();
		
		FachadaPL.login("Barbiegirl@hotmail.com", "ken123");
		System.out.println(FachadaPL.getUsuarioLogado().getNome());
		
		FachadaPL.login("rogerinho..@hotmail.com", "321anhes");
		System.out.println(FachadaPL.getUsuarioLogado().getNome());
		
		
		
		ArrayList<Animal> animais = fachada.listarAnimais();
		for(Animal animal : animais) {
			System.out.println(animal.getNome());
		}
		
		Solicitacao s1 = new Solicitacao(c1, c2);
		System.out.println(s1);
		
	}
	
}