package iftm;

public class Dados {

	String nome;
	int slot;

	public Dados(int slot, String nome) {
		this.nome = nome;
		this.slot = slot;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getSlot() {
		return slot;
	}

	public void setSlot(int slot) {
		this.slot = slot;
	}
	
	
}
