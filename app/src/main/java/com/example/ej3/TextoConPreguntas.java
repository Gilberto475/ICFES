package com.example.ej3;

import java.util.List;

public class TextoConPreguntas {
    private String texto;
    private List<Pregunta> preguntas;
    private int imagenResId;

    public TextoConPreguntas(String texto, List<Pregunta> preguntas, int imagenResId) {
        this.texto = texto;
        this.preguntas = preguntas;
        this.imagenResId = imagenResId;
    }

    public String getTexto() {
        return texto;
    }

    public List<Pregunta> getPreguntas() {
        return preguntas;
    }

    public int getImagenResId() {
        return imagenResId;
    }
}
