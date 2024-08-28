package com.example.ej3;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class PruebaMatematicas extends AppCompatActivity {

    private TextView textViewPregunta;
    private RadioGroup radioGroupOpciones;
    private Button buttonSiguiente;

    private String[] preguntas = {
            "1.Una persona que vive en Colombia tiene inversiones en dólares en Estados Unidos, y sabe que\n" +
                    "la tasa de cambio del dólar respecto al peso colombiano se mantendrá constante este mes, siendo 1 dólar equivalente a 2.000 pesos colombianos y que su inversión, en dólares, le dará ganancias del 3 % en el mismo periodo. Un amigo le asegura que en pesos sus ganancias también serán del 3 %.\n" +
                    "La afirmación de su amigo es",
            "2.Una escuela de natación cuenta con un total de 16 estudiantes. Para las clases se usan 2 piscinas con distinta profundidad. Por seguridad, las personas con una estatura inferior a 1,80 m se envían a la piscina menos profunda, y las demás, a la más profunda.Un día, el director de la escuela escucha que el promedio de estatura de las 16 personas es 1,70 m\n" +
                    "e insiste en aumentar la cantidad de alumnos para que el promedio sea 1,80 m, afirmando que\n" +
                    "de esta manera se logrará igualar la cantidad de personas en las dos piscinas. Esta afirmación es\n" +
                    "errónea, porque\n",
            "3.A partir de un conjunto de números S, cuyo promedio es 9 y desviación estándar 3, se construye\n" +
                    "un nuevo conjunto de números T, tomando cada elemento de S y sumándole 4 unidades. Si, por\n" +
                    "ejemplo, 8 es un elemento de S, entonces el número 8 + 4 = 12 es un elemento de T. Es correcto afirmar, entonces, que para los elementos del conjunto T su promedio y su desviación estándar son, respectivamente,\n",
            "4.El sistema de comunicaciones de un hotel utiliza los dígitos 2, 3, 4 y 5 para asignar un número de\n" +
                    "extensión telefónica de 4 dígitos diferentes a cada habitación. ¿Cuántas habitaciones del hotel\n" +
                    "pueden tener extensión telefónica?\n",
            "5.Una prueba atlética tiene un récord mundial de 10,49 segundos y un récord olímpico de 10,50\n" +
                    "segundos. ¿Es posible que un atleta registre un tiempo, en el mismo tipo de prueba, que rompa\n" +
                    "el récord olímpico pero no el mundial?",
            "6.Un trapecio isósceles es un cuadrilátero que tiene un solo par de lados paralelos y los otros dos,\n" +
                    "de igual medida.\n" +
                    "En un plano cartesiano se dibuja un trapecio isósceles de modo que el eje Y divide al trapecio en\n" +
                    "dos figuras iguales.\n" +
                    "Si las coordenadas de dos de los vértices del trapecio son (-4, 2) y (-2, 8), ¿Cuáles son las coordenadas de los otros dos vértices?",
            "7.Sobre una circunferencia de centro O se localizan dos puntos P y P’ diferentes.\n" +
                    "De las siguientes, ¿cuál figura NO puede resultar al unir entre sí los tres puntos P, P’ y O?",
            "8.Un colegio necesita enviar 5 estudiantes como representantes a un foro sobre la contaminación\n" +
                    "del medio ambiente. Se decidió que 2 estudiantes sean de grado décimo y 3 de grado undécimo.\n" +
                    "En décimo hay 5 estudiantes preparados para el foro y en undécimo hay 4. ¿Cuántos grupos\n" +
                    "diferentes pueden formarse para enviar al foro?\n"
    };

    private String[][] opciones = {
            {"A. correcta, pues, sin importar las variaciones en la tasa de cambio, la proporción en que aumenta la inversión en dólares es la misma que en pesos.\n", "B. incorrecta, pues debería conocerse el valor exacto de la inversión para poder calcular la cantidad de dinero que ganará.", "C. correcta, pues el 3 % representa una proporción fija en cualquiera de las dos monedas,\n" +
                    "puesto que la tasa de cambio permanecerá constante.", "D. incorrecta, pues el 3 % representa un incremento, que será mayor en pesos colombianos,\n" +
                    "pues en esta moneda cada dólar representa un valor 2.000 veces mayor."},
            {"A. las 16 personas se encuentran actualmente en la piscina menos profunda. El director de la escuela debe aceptar otros 16 alumnos con una estatura superior a 1,80 m.", "B. con el promedio es imposible determinar la cantidad de personas en las piscinas. Es necesario utilizar otras medidas, como la estatura máxima o mínima de las personas, en lugar\n" +
                    "de esta.\n", "C. incrementar el promedio a 1,80 m es insuficiente. El director de la escuela debe aceptar\n" +
                    "más estudiantes con una altura de 1,80 m hasta que la cantidad de alumnos sea igual en\n" +
                    "ambas piscinas.", "D. aunque el promedio de estatura de las 16 personas sea inferior a 1,80 m, no significa que la cantidad de personas en las piscinas sea diferente."},
            {"A. 9 y 3.", "B. 9 y 7.", "C. 13 y 3.", "D. 13 y 7."},
            {"A. 24", "B. 56", "C. 120", "D. 256"},
            {"A. Sí, porque puede registrar, por ejemplo, un tiempo de 10,497 segundos, que está entre los dos tiempos récord.", "B. Sí, porque puede registrar un tiempo menor que 10,4 y marcaría un nuevo récord.", "C. No, porque no existe un registro posible entre los dos tiempos récord.", "D. No, porque cualquier registro menor que el récord olímpico va a ser menor que el récord mundial."},
            {"A. (8, 2) y (2, 4).", "B. (2, 8) y (4, 2).", "C. (-2, -4) y (-8, -2).", "D. (-4, -2) y (-2, -8)."},
            {"A. Un triángulo isósceles.", "B. Un radio de la circunferencia.", "C. Un triángulo equilátero.", "D. Un diámetro de la circunferencia."},
            {"A. 9", "B. 14", "C. 20", "D. 40"}
    };

    private char[] respuestasCorrectas = {'C', 'D', 'C', 'A', 'A', 'B', 'B', 'D'};
    private int indicePregunta = 0;
    private int respuestasCorrectasContador = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prueba_matematicas);

        textViewPregunta = findViewById(R.id.textViewPregunta);
        radioGroupOpciones = findViewById(R.id.radioGroupOpciones);
        buttonSiguiente = findViewById(R.id.buttonSiguiente);

        mostrarPregunta();

        buttonSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int idSeleccionado = radioGroupOpciones.getCheckedRadioButtonId();
                if (idSeleccionado != -1) {
                    RadioButton radioButtonSeleccionado = findViewById(idSeleccionado);
                    String respuestaSeleccionada = radioButtonSeleccionado.getText().toString().substring(0, 1);

                    if (respuestaSeleccionada.charAt(0) == respuestasCorrectas[indicePregunta]) {
                        respuestasCorrectasContador++;
                    }

                    indicePregunta++;
                    if (indicePregunta < preguntas.length) {
                        mostrarPregunta();
                    } else {
                        mostrarResultado();
                    }
                } else {
                    Toast.makeText(PruebaMatematicas.this, "Selecciona una respuesta", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void mostrarPregunta() {
        textViewPregunta.setText(preguntas[indicePregunta]);
        radioGroupOpciones.clearCheck();
        ((RadioButton) radioGroupOpciones.getChildAt(0)).setText(opciones[indicePregunta][0]);
        ((RadioButton) radioGroupOpciones.getChildAt(1)).setText(opciones[indicePregunta][1]);
        ((RadioButton) radioGroupOpciones.getChildAt(2)).setText(opciones[indicePregunta][2]);
        ((RadioButton) radioGroupOpciones.getChildAt(3)).setText(opciones[indicePregunta][3]);
    }

    private void mostrarResultado() {
        int totalPreguntas = preguntas.length;
        int porcentajeCorrectas = (respuestasCorrectasContador * 100) / totalPreguntas;
        String mensajeResultado = "Respuestas correctas: " + respuestasCorrectasContador + "/" + totalPreguntas +
                "\nPorcentaje: " + porcentajeCorrectas + "%\n";

        if (porcentajeCorrectas >= 50) {
            mensajeResultado += "¡Buen trabajo!";
        } else {
            mensajeResultado += "Puedes mejorar.";
        }

        Toast.makeText(PruebaMatematicas.this, mensajeResultado, Toast.LENGTH_LONG).show();
        finish();
    }
}
