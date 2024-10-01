package com.example.ej3;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class PruebaLec extends AppCompatActivity {

    private List<TextoConPreguntas> textosConPreguntas;
    private int indiceTexto = 0;
    private int indicePregunta = 0;
    private int aciertos = 0;
    private int totalPreguntas = 0;

    private TextView textoLectura;
    private TextView questionText;
    private RadioGroup answerGroup;
    private Button nextButton;
    private ImageView imagenLectura;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prueba_lec);

        textoLectura = findViewById(R.id.texto_lectura);
        questionText = findViewById(R.id.question_text);
        answerGroup = findViewById(R.id.answer_group);
        nextButton = findViewById(R.id.next_button);
        imagenLectura = findViewById(R.id.imagen_lectura);

        inicializarTextosConPreguntas();
        cargarTextoYPregunta();

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (respuestaSeleccionada()) {
                    verificarRespuesta();
                    if (indicePregunta < textosConPreguntas.get(indiceTexto).getPreguntas().size() - 1) {
                        indicePregunta++;
                        mostrarPregunta(indicePregunta);
                    } else {

                        indiceTexto++;
                        if (indiceTexto < textosConPreguntas.size()) {
                            indicePregunta = 0;
                            cargarTextoYPregunta();
                        } else {
                            mostrarResultado();
                        }
                    }
                } else {
                    Toast.makeText(PruebaLec.this, "Por favor, selecciona una respuesta.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void inicializarTextosConPreguntas() {
        textosConPreguntas = new ArrayList<>();


        List<Pregunta> preguntasTexto1 = new ArrayList<>();
        preguntasTexto1.add(new Pregunta("1.A juzgar por su estilo, tema y estructura, ¿en cuál de los siguientes contextos estaría inscrito más apropiadamente el pasaje anterior?",
                new String[]{"A.En una revista académica, como parte de un artículo sobre los orígenes y la importancia de la filosofía cartesiana.", "B.En un discurso ofrecido a un grupo conformado por aficionados al estudio de asesinatos en la historia de la filosofía.", "C.En una crónica periodística, con motivo de un especial acerca de las muertes más curiosas de la historia", "D.En un seminario dirigido a historiadores especialistas en la vida de los personajes insignes del siglo XX."}
                , 0, 1));
        preguntasTexto1.add(new Pregunta("¿Qué conclusión se puede sacar?",
                new String[]{"Opción 1", "Opción 2", "Opción 3", "Opción 4"}, 1, 1));


        textosConPreguntas.add(new TextoConPreguntas("El primer gran filósofo del siglo diecisiete (si exceptuamos a Bacon y Galileo) fue Descartes, y si alguna vez se dijo de alguien que estuvo a punto de ser asesinado habrá que decirlo de él. La historia es la siguiente, según la cuenta Baillet en su Vie de M. Descartes, tomo I, páginas 102-103. En 1621, Descartes, que tenía unos veintiséis años, se hallaba como siempre viajando (pues era inquieto como una hiena) y, al llegar al Elba, tomó una embarcación para Friezland oriental. Nadie se ha enterado nunca de lo que podía buscar en Friezland oriental y tal vez él se hiciera la misma pregunta, ya que, al llegar a Embden, decidió dirigirse al instante a Friezland occidental, y siendo demasiado impaciente para tolerar cualquier demora, alquiló una barca y contrató a unos cuantos marineros. Tan pronto habían salido al mar cuando hizo un agradable descubrimiento, al saber que se había encerrado en una guarida de asesinos. Se dio cuenta, dice M. Baillet, de que su tripulación estaba formada por criminales, no aficionados, señores, como lo somos nosotros, sino profesionales cuya máxima ambición, por el momento, era degollarlo. La historia es demasiado amena para resumirla y a continuación la traduzco cuidadosamente del original francés de la biografía: “M. Descartes no tenía más compañía que su criado, con quien conversaba en francés. Los marineros, creyendo que se trataba de un comerciante y no de un caballero, pensaron que llevaría dinero consigo y pronto llegaron a una decisión que no era en modo alguno ventajosa para su bolsa. Entre los ladrones de mar y los ladrones de bosques, hay esta diferencia, que los últimos pueden perdonar la vida a sus víctimas sin peligro para ellos, en tanto que si los otros llevan a sus pasajeros a la costa, corren grave peligro de ir a parar a la cárcel. La tripulación de M. Descartes tomó sus precauciones para evitar todo riesgo de esta naturaleza. Lo suponían un extranjero venido de lejos, sin relaciones en el país, y se dijeron que nadie se daría el trabajo de averiguar su paradero cuando desapareciera”. Piensen, señores, en estos perros de Friezland que hablan de un filósofo como si fuese una barrica de ron consignada a un barco de carga. “Notaron que era de carácter manso y paciente y, juzgándolo por la gentileza de su comportamiento y la cortesía de su trato, se imaginaron que debía ser un joven inexperimentado, sin situación ni raíces en la vida, y concluyeron que les sería fácil quitarle la vida. No tuvieron empacho en discutir la cuestión en presencia suya pues no creían que entendiese otro idioma además del que empleaba para hablar con su criado; como resultado de sus deliberaciones decidieron asesinarlo, arrojar sus restos al mar y dividirse el botín”. Perdonen que me ría, caballeros, pero a decir verdad me río siempre que recuerdo esta historia, en la que hay dos cosas que me parecen muy cómicas. Una de ellas es el pánico de Descartes, a quien se le debieron poner los pelos de punta, ante el pequeño drama de su propia muerte, funeral, herencia y administración de bienes. Pero hay otro aspecto que me parece aún más gracioso, y es que si los mastines de Friezland hubieran estado “a la altura”, no tendríamos filosofía cartesiana",
                preguntasTexto1, R.drawable.img_21));


        List<Pregunta> preguntasTexto2 = new ArrayList<>();
        preguntasTexto2.add(new Pregunta("¿Qué se infiere del texto?",
                new String[]{"Opción 1", "Opción 2", "Opción 3", "Opción 4"}, 0, 1));


        textosConPreguntas.add(new TextoConPreguntas("Este es el texto de ejemplo 2...", preguntasTexto2, R.drawable.img));


        for (TextoConPreguntas texto : textosConPreguntas) {
            totalPreguntas += texto.getPreguntas().size();
        }
    }

    private void cargarTextoYPregunta() {
        if (indiceTexto < textosConPreguntas.size()) {
            TextoConPreguntas textoConPreguntas = textosConPreguntas.get(indiceTexto);

            imagenLectura.setImageResource(textoConPreguntas.getImagenResId());


            textoLectura.setText(textoConPreguntas.getTexto());
            mostrarPregunta(indicePregunta);
        }
    }

    private void mostrarPregunta(int indicePregunta) {
        Pregunta pregunta = textosConPreguntas.get(indiceTexto).getPreguntas().get(indicePregunta);
        questionText.setText(pregunta.getTextoPregunta());


        answerGroup.clearCheck();
        for (int i = 0; i < answerGroup.getChildCount(); i++) {
            RadioButton radioButton = (RadioButton) answerGroup.getChildAt(i);
            radioButton.setText(pregunta.getOpciones()[i]);
        }
    }

    private boolean respuestaSeleccionada() {
        return answerGroup.getCheckedRadioButtonId() != -1;
    }

    private void verificarRespuesta() {
        int selectedId = answerGroup.getCheckedRadioButtonId();
        RadioButton selectedRadioButton = findViewById(selectedId);
        int selectedIndex = answerGroup.indexOfChild(selectedRadioButton);

        Pregunta pregunta = textosConPreguntas.get(indiceTexto).getPreguntas().get(indicePregunta);
        if (selectedIndex == pregunta.getRespuestaCorrecta()) {
            aciertos++;
        }
    }

    private void mostrarResultado() {
        double porcentaje = (double) aciertos / totalPreguntas * 100;
        String mensaje = String.format("Tu porcentaje de aciertos es: %.2f%%", porcentaje);

        if (porcentaje < 50) {
            mensaje += "\nPuedes mejorar.";
        }

        Toast.makeText(this, mensaje, Toast.LENGTH_LONG).show();
        finish();
    }
}
