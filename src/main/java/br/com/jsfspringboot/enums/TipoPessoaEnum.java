package br.com.jsfspringboot.enums;

import br.com.jsfspringboot.enums.interfaces.IEnumModel;

//FIXME (FASE FUTURA): Pessoa JURIDICA comentada porque o sistema só trabalha atualmente com pessoa FISICA.
public enum TipoPessoaEnum implements IEnumModel<String> {
	FISICA("F", "Física"),
	JURIDICA("J", "Jurídica");

	private String valor;

	private String descricao;

	private TipoPessoaEnum(String valor, String descricao) {
		this.valor = valor;
		this.descricao = descricao;
	}

	@Override
	public String getDescricao() {
		return this.descricao;
	}

	@Override
	public String getValor() {
		return this.valor;
	}

}
