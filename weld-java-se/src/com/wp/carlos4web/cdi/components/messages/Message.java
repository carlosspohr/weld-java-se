package com.wp.carlos4web.cdi.components.messages;

public class Message {
	private Long id;
	private String titulo;
	
	private String descricao;
	
	private int tipo;
	
	public static final int ERROR = 0;
	
	public static final int INFO = 0;
	
	public static final int SUCCESS = 0;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}
}
