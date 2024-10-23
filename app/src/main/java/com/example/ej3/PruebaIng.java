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

public class PruebaIng extends AppCompatActivity {

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
        setContentView(R.layout.activity_prueba_ing);

        textoLectura = findViewById(R.id.texto_lecturas);
        questionText = findViewById(R.id.question_text);
        answerGroup = findViewById(R.id.answer_group);
        nextButton = findViewById(R.id.next_button);
        imagenLectura = findViewById(R.id.imagen_lecturas);

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
                    Toast.makeText(PruebaIng.this, "Please select an answer.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void inicializarTextosConPreguntas() {
        textosConPreguntas = new ArrayList<>();


        List<Pregunta> preguntasPresenteSimple = new ArrayList<>();
        preguntasPresenteSimple.add(new Pregunta("What does he eat for breakfast?", new String[]{"He eats eggs", "He ate eggs", "He is eating eggs", "He will eat eggs"}, 0, 1));
        preguntasPresenteSimple.add(new Pregunta("Where does she work?", new String[]{"She is working at a school", "She worked at a school", "She works at a school", "She will work at a school"}, 2, 1));
        preguntasPresenteSimple.add(new Pregunta("Do they play football every weekend?", new String[]{"Yes, they do", "Yes, they are", "Yes, they will", "Yes, they did"}, 0, 1));
        preguntasPresenteSimple.add(new Pregunta("Does he visit his parents often?", new String[]{"Yes, he does", "Yes, he is", "Yes, he did", "Yes, he was"}, 0, 1));
        preguntasPresenteSimple.add(new Pregunta("How often do you go to the gym?", new String[]{"I go every day", "I am going every day", "I went every day", "I will go every day"}, 0, 1));

        textosConPreguntas.add(new TextoConPreguntas("Present Simple: Routine actions.", preguntasPresenteSimple, R.drawable.img_51));

        List<Pregunta> preguntasPasadoSimple = new ArrayList<>();
        preguntasPasadoSimple.add(new Pregunta("What did you do yesterday?", new String[]{"I do my homework", "I did my homework", "I am doing my homework", "I was doing my homework"}, 1, 1));
        preguntasPasadoSimple.add(new Pregunta("Did they travel last summer?", new String[]{"Yes, they do", "Yes, they did", "Yes, they are", "Yes, they were"}, 1, 1));
        preguntasPasadoSimple.add(new Pregunta("Where did you go last weekend?", new String[]{"I go to the beach", "I went to the beach", "I am going to the beach", "I was going to the beach"}, 1, 1));
        preguntasPasadoSimple.add(new Pregunta("When did the train leave?", new String[]{"It left an hour ago", "It leaves an hour ago", "It is leaving an hour ago", "It was leaving an hour ago"}, 0, 1));
        preguntasPasadoSimple.add(new Pregunta("Did she enjoy the movie?", new String[]{"Yes, she enjoys it", "Yes, she enjoyed it", "Yes, she is enjoying it", "Yes, she was enjoying it"}, 1, 1));

        textosConPreguntas.add(new TextoConPreguntas("Past Simple: Actions completed in the past.", preguntasPasadoSimple, R.drawable.img_51));


        List<Pregunta> preguntasPresenteSimple2 = new ArrayList<>();
        preguntasPresenteSimple2.add(new Pregunta("Do you speak English?", new String[]{"Yes, I speak", "Yes, I spoke", "Yes, I am speaking", "Yes, I will speak"}, 0, 1));
        preguntasPresenteSimple2.add(new Pregunta("Where does she live?", new String[]{"She lives in London", "She is living in London", "She lived in London", "She will live in London"}, 0, 1));
        preguntasPresenteSimple2.add(new Pregunta("How does he go to work?", new String[]{"He goes by bus", "He is going by bus", "He went by bus", "He will go by bus"}, 0, 1));
        preguntasPresenteSimple2.add(new Pregunta("Do they study together?", new String[]{"Yes, they do", "Yes, they are", "Yes, they did", "Yes, they were"}, 0, 1));
        preguntasPresenteSimple2.add(new Pregunta("Does she like coffee?", new String[]{"Yes, she does", "Yes, she is", "Yes, she did", "Yes, she was"}, 0, 1));

        textosConPreguntas.add(new TextoConPreguntas("Present Simple: Facts and habits.", preguntasPresenteSimple2, R.drawable.img_51));


        List<Pregunta> preguntasPasadoSimple2 = new ArrayList<>();
        preguntasPasadoSimple2.add(new Pregunta("Did you finish your project?", new String[]{"Yes, I finish it", "Yes, I finished it", "Yes, I am finishing it", "Yes, I was finishing it"}, 1, 1));
        preguntasPasadoSimple2.add(new Pregunta("Where did they go for vacation?", new String[]{"They go to Italy", "They went to Italy", "They are going to Italy", "They were going to Italy"}, 1, 1));
        preguntasPasadoSimple2.add(new Pregunta("What did he say?", new String[]{"He say nothing", "He said nothing", "He is saying nothing", "He was saying nothing"}, 1, 1));
        preguntasPasadoSimple2.add(new Pregunta("Did she cook dinner?", new String[]{"Yes, she cooks dinner", "Yes, she cooked dinner", "Yes, she is cooking dinner", "Yes, she was cooking dinner"}, 1, 1));
        preguntasPasadoSimple2.add(new Pregunta("When did the meeting start?", new String[]{"It starts at 9 AM", "It started at 9 AM", "It is starting at 9 AM", "It was starting at 9 AM"}, 1, 1));

        textosConPreguntas.add(new TextoConPreguntas("Past Simple: Completed actions.", preguntasPasadoSimple2, R.drawable.img_51));

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
        int porcentaje = (aciertos * 100) / totalPreguntas;
        Toast.makeText(this, "Correct answers: " + aciertos + "/" + totalPreguntas + "\nPercentage: " + porcentaje + "%", Toast.LENGTH_LONG).show();
    }
}
