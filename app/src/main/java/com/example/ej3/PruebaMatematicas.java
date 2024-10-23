package com.example.ej3;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class PruebaMatematicas extends AppCompatActivity {

    private TextView preguntaTextView;
    private RadioButton opcionA, opcionB, opcionC, opcionD;
    private Button siguienteButton;
    private int preguntaActual = 0;
    private int respuestasCorrectas = 0;

    private String[] preguntas = {
            "1. ¿Cuál es el valor de x en la ecuación 2x + 5 = 15?",
            "2. Si el perímetro de un cuadrado es 40 cm, ¿cuál es la longitud de uno de sus lados?",
            "3. ¿Cuál es la pendiente de la recta que pasa por los puntos (1,2) y (3,6)?",
            "4. ¿Cuál es la solución de la ecuación cuadrática x^2 - 4x + 3 = 0?",
            "5. Si un tren recorre 60 km en 40 minutos, ¿cuál es su velocidad en km/h?",
            "6. ¿Qué ángulo forma una recta paralela al eje X?",
            "7. ¿Cuál es el área de un círculo con radio 7 cm?",
            "8. En una clase de 30 estudiantes, el 40% son mujeres. ¿Cuántas mujeres hay en la clase?",
            "9. Si el área de un triángulo es 24 cm² y su base es 6 cm, ¿cuál es la altura?",
            "10. Un número es múltiplo de 5 y está entre 50 y 60. ¿Cuál es ese número?",
            "11. ¿Cuál es la raíz cuadrada de 225?",
            "12. ¿Cuál es el máximo común divisor de 24 y 36?",
            "13. Si un auto consume 8 litros de gasolina para recorrer 100 km, ¿cuántos litros necesitará para recorrer 250 km?",
            "14. ¿Cuánto es 3^3?",
            "15. Si una piscina se llena en 5 horas con un caudal constante, ¿cuánto se llenará en 2 horas?",
            "16. ¿Qué número debe sumarse a 15 para obtener el doble de 20?",
            "17. Si el precio de un producto con el 20% de descuento es 80.000 pesos, ¿cuál era el precio original?",
            "18. ¿Cuál es el volumen de un cubo de 4 cm de lado?",
            "19. Si un examen tiene 10 preguntas y cada una vale 2 puntos, ¿cuál es la calificación máxima posible?",
            "20. ¿Qué fracción representa a 0,75?"
    };

    private String[][] opciones = {
            {"A. 5", "B. 4", "C. 3", "D. 2"},
            {"A. 5 cm", "B. 10 cm", "C. 15 cm", "D. 20 cm"},
            {"A. 2", "B. 3", "C. 4", "D. 5"},
            {"A. 1 y 3", "B. 2 y -1", "C. 1 y -3", "D. -1 y -3"},
            {"A. 90 km/h", "B. 80 km/h", "C. 70 km/h", "D. 60 km/h"},
            {"A. 30 grados", "B. 60 grados", "C. 90 grados", "D. 0 grados"},
            {"A. 144 cm²", "B. 154 cm²", "C. 168 cm²", "D. 98 cm²"},
            {"A. 10", "B. 12", "C. 15", "D. 18"},
            {"A. 6 cm", "B. 8 cm", "C. 9 cm", "D. 10 cm"},
            {"A. 52", "B. 55", "C. 58", "D. 60"},
            {"A. 13", "B. 14", "C. 15", "D. 16"},
            {"A. 6", "B. 8", "C. 12", "D. 18"},
            {"A. 16 litros", "B. 18 litros", "C. 20 litros", "D. 22 litros"},
            {"A. 9", "B. 21", "C. 27", "D. 33"},
            {"A. 2/5", "B. 3/5", "C. 4/5", "D. 5/5"},
            {"A. 20", "B. 25", "C. 30", "D. 35"},
            {"A. 100.000", "B. 120.000", "C. 150.000", "D. 160.000"},
            {"A. 64 cm³", "B. 32 cm³", "C. 128 cm³", "D. 16 cm³"},
            {"A. 15", "B. 20", "C. 25", "D. 30"},
            {"A. 3/4", "B. 1/4", "C. 1/2", "D. 2/3"}
    };

    private char[] respuestas = {'A', 'B', 'B', 'A', 'A', 'D', 'B', 'B', 'B', 'B', 'C', 'C', 'C', 'C', 'D', 'C', 'B', 'A', 'B', 'A'};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prueba_matematicas);

        preguntaTextView = findViewById(R.id.preguntaTextView);
        opcionA = findViewById(R.id.opcionA);
        opcionB = findViewById(R.id.opcionB);
        opcionC = findViewById(R.id.opcionC);
        opcionD = findViewById(R.id.opcionD);
        siguienteButton = findViewById(R.id.siguienteButton);

        mostrarPregunta();

        siguienteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                verificarRespuesta();
                preguntaActual++;
                if (preguntaActual < preguntas.length) {
                    mostrarPregunta();
                } else {
                    mostrarResultados();
                }
            }
        });
    }

    private void mostrarPregunta() {
        preguntaTextView.setText(preguntas[preguntaActual]);
        opcionA.setText(opciones[preguntaActual][0]);
        opcionB.setText(opciones[preguntaActual][1]);
        opcionC.setText(opciones[preguntaActual][2]);
        opcionD.setText(opciones[preguntaActual][3]);


        opcionA.setChecked(false);
        opcionB.setChecked(false);
        opcionC.setChecked(false);
        opcionD.setChecked(false);
    }

    private void verificarRespuesta() {
        char respuestaSeleccionada = ' ';
        if (opcionA.isChecked()) {
            respuestaSeleccionada = 'A';
        } else if (opcionB.isChecked()) {
            respuestaSeleccionada = 'B';
        } else if (opcionC.isChecked()) {
            respuestaSeleccionada = 'C';
        } else if (opcionD.isChecked()) {
            respuestaSeleccionada = 'D';
        }

        if (respuestaSeleccionada == respuestas[preguntaActual]) {
            respuestasCorrectas++;
        }
    }

    private void mostrarResultados() {
        double porcentaje = (double) respuestasCorrectas / preguntas.length * 100;
        String mensaje = "Has obtenido " + respuestasCorrectas + " respuestas correctas de " + preguntas.length + ".\n" +
                "Tu porcentaje de aciertos es: " + porcentaje + "%";
        Toast.makeText(this, mensaje, Toast.LENGTH_LONG).show();
        finish();
    }
}
