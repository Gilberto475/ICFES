package com.example.ej3;

public class Pregunta {
    private String textoPregunta;
    private String[] opciones;
    private int respuestaCorrecta;
    private int imagenId;  // id de la imagen asociada

    public Pregunta(String textoPregunta, String[] opciones, int respuestaCorrecta, int imagenId) {
        this.textoPregunta = textoPregunta;
        this.opciones = opciones;
        this.respuestaCorrecta = respuestaCorrecta;
        this.imagenId = imagenId;
    }

    public String getTextoPregunta() {
        return textoPregunta;
    }

    public String[] getOpciones() {
        return opciones;
    }

    public int getRespuestaCorrecta() {
        return respuestaCorrecta;
    }

    public int getImagenId() {
        return imagenId;
    }
}
