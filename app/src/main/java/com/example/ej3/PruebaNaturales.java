package com.example.ej3;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class PruebaNaturales extends AppCompatActivity {

    private TextView textViewPregunta;
    private RadioGroup radioGroupOpciones;
    private RadioButton radioButtonA, radioButtonB, radioButtonC, radioButtonD;
    private Button buttonSiguiente;

    private int preguntaActual = 0;
    private int correctas = 0;


    private final String[] preguntas = {
            "Pregunta 1: ¿Qué es la fotosíntesis?",
            "Pregunta 2: ¿Qué gas respiramos?",
            "Pregunta 3: ¿Cuál es el planeta más grande del sistema solar?",
            "Pregunta 4: ¿Cuál es la función de los glóbulos rojos?",
            "Pregunta 5: ¿Qué órgano del cuerpo humano filtra la sangre?",
            "Pregunta 6: ¿Cuál es el metal más abundante en la corteza terrestre?",
            "Pregunta 7: ¿Qué parte de la célula contiene el material genético?",
            "Pregunta 8: ¿Cuál es el estado de la materia que no tiene forma ni volumen fijo?",
            "Pregunta 9: ¿Qué fenómeno natural es causado por el movimiento de las placas tectónicas?",
            "Pregunta 10: ¿Qué gas es esencial para la combustión?",
            "Pregunta 11: ¿Qué tipo de energía es la energía solar?",
            "Pregunta 12: ¿Qué animal es conocido como el rey de la selva?",
            "Pregunta 13: ¿Cuál es el hábitat de los pingüinos?",
            "Pregunta 14: ¿Qué planeta se conoce como el planeta rojo?",
            "Pregunta 15: ¿Qué fuerza mantiene a los planetas en órbita alrededor del Sol?"
    };

    private final String[][] opciones = {
            {"Transformación de luz en energía", "Un proceso de digestión", "El ciclo del agua", "Ninguna de las anteriores"},
            {"Oxígeno", "Dióxido de carbono", "Nitrógeno", "Helio"},
            {"Tierra", "Marte", "Júpiter", "Venus"},
            {"Transportar oxígeno", "Producir energía", "Digieren alimentos", "Controlan infecciones"},
            {"Hígado", "Riñón", "Corazón", "Pulmón"},
            {"Hierro", "Cobre", "Aluminio", "Oro"},
            {"Núcleo", "Citoplasma", "Membrana", "Pared celular"},
            {"Líquido", "Sólido", "Gas", "Plasma"},
            {"Tormenta", "Huracán", "Terremoto", "Tsunami"},
            {"Oxígeno", "Dióxido de carbono", "Hidrógeno", "Nitrógeno"},
            {"Energía cinética", "Energía potencial", "Energía renovable", "Energía solar"},
            {"Tigre", "Elefante", "León", "Oso"},
            {"Bosques", "Desiertos", "Polo norte y sur", "Selvas"},
            {"Mercurio", "Venus", "Tierra", "Marte"},
            {"Fuerza centrífuga", "Magnetismo", "Gravedad", "Energía oscura"}
    };

    // Índices de las respuestas correctas (corresponden a las posiciones en las opciones)
    private final int[] respuestasCorrectas = {0, 0, 2, 0, 1, 2, 0, 2, 2, 0, 3, 2, 2, 3, 2};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prueba_naturales);

        textViewPregunta = findViewById(R.id.textViewPregunta);
        radioGroupOpciones = findViewById(R.id.radioGroupOpciones);
        radioButtonA = findViewById(R.id.radioButtonA);
        radioButtonB = findViewById(R.id.radioButtonB);
        radioButtonC = findViewById(R.id.radioButtonC);
        radioButtonD = findViewById(R.id.radioButtonD);
        buttonSiguiente = findViewById(R.id.buttonSiguiente);

        cargarPregunta();

        buttonSiguiente.setOnClickListener(v -> {
            int idSeleccionado = radioGroupOpciones.getCheckedRadioButtonId();
            if (idSeleccionado == -1) {
                Toast.makeText(PruebaNaturales.this, "Por favor selecciona una opción", Toast.LENGTH_SHORT).show();
                return;
            }

            verificarRespuesta(idSeleccionado);
            preguntaActual++;

            if (preguntaActual < preguntas.length) {
                cargarPregunta();
            } else {
                mostrarResultado();
            }
        });
    }

    private void cargarPregunta() {
        textViewPregunta.setText(preguntas[preguntaActual]);
        radioButtonA.setText(opciones[preguntaActual][0]);
        radioButtonB.setText(opciones[preguntaActual][1]);
        radioButtonC.setText(opciones[preguntaActual][2]);
        radioButtonD.setText(opciones[preguntaActual][3]);
        radioGroupOpciones.clearCheck(); // Limpiar selección anterior
    }

    private void verificarRespuesta(int idSeleccionado) {
        int respuestaCorrecta = respuestasCorrectas[preguntaActual];
        RadioButton radioButtonSeleccionado = findViewById(idSeleccionado);
        int indiceSeleccionado = radioGroupOpciones.indexOfChild(radioButtonSeleccionado);

        if (indiceSeleccionado == respuestaCorrecta) {
            correctas++;
        }
    }

    private void mostrarResultado() {
        int porcentaje = (correctas * 100) / preguntas.length;

        String mensaje = "Tu puntaje es: " + porcentaje + "%\n";
        if (porcentaje > 50) {
            mensaje += "¡Felicitaciones! Aprobaste la prueba.";
        } else {
            mensaje += "Lo siento, no aprobaste la prueba.";
        }

        Toast.makeText(PruebaNaturales.this, mensaje, Toast.LENGTH_LONG).show();
    }
}
