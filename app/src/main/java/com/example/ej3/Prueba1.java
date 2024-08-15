package com.example.ej3;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class Prueba1 extends AppCompatActivity {

    private RadioGroup answersGroup;
    private Button checkButton;
    private Button nextButton;
    private TextView resultText;
    private TextView questionText;
    private TextView scoreText;

    // Aqui estan Preguntas, opciones y respuestas
    private String[] questions = {
            "¿Cuál es la capital de Francia?",
            "¿Cuál es la capital de España?",
            "¿Cuál es la capital de Alemania?",
            "¿Cuál es la capital de Italia?",
            "¿Cuál es la capital de Portugal?",
            "¿Cuál es la capital de Reino Unido?",
            "¿Cuál es la capital de Canadá?",
            "¿Cuál es la capital de Australia?"
    };

    private String[][] options = {
            {"a) Berlín", "b) Madrid", "c) París", "d) Lisboa"},
            {"a) Berlín", "b) Madrid", "c) París", "d) Lisboa"},
            {"a) Berlín", "b) Madrid", "c) París", "d) Lisboa"},
            {"a) Roma", "b) Madrid", "c) París", "d) Lisboa"},
            {"a) Roma", "b) Madrid", "c) Lisboa", "d) París"},
            {"a) Londres", "b) Edimburgo", "c) Dublín", "d) Cardiff"},
            {"a) Toronto", "b) Vancouver", "c) Ottawa", "d) Montreal"},
            {"a) Melbourne", "b) Sídney", "c) Brisbane", "d) Canberra"}
    };

    private String[] correctAnswers = {
            "c) París",
            "b) Madrid",
            "a) Berlín",
            "a) Roma",
            "c) Lisboa",
            "a) Londres",
            "c) Ottawa",
            "d) Canberra"
    };

    private int currentQuestionIndex = 0;
    private int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prueba1);

        // Recupera las vistas
        answersGroup = findViewById(R.id.answersGroup);
        checkButton = findViewById(R.id.checkButton);
        nextButton = findViewById(R.id.nextButton);
        resultText = findViewById(R.id.resultText);
        questionText = findViewById(R.id.questionText);
        scoreText = findViewById(R.id.scoreText);

        // Esta es la configuracion del boton para verificar la respuesta
        checkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer();
            }
        });

        // Aqui configuro el botón para la siguiente pregunta
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nextQuestion();
            }
        });

        // Inicio la primera pregunta
        loadQuestion();
    }

    private void loadQuestion() {
        // Aqui cargo la pregunta y las respuestas para la pregunta actual
        questionText.setText(questions[currentQuestionIndex]);
        RadioButton answer1 = findViewById(R.id.answer1);
        RadioButton answer2 = findViewById(R.id.answer2);
        RadioButton answer3 = findViewById(R.id.answer3);
        RadioButton answer4 = findViewById(R.id.answer4);

        answer1.setText(options[currentQuestionIndex][0]);
        answer2.setText(options[currentQuestionIndex][1]);
        answer3.setText(options[currentQuestionIndex][2]);
        answer4.setText(options[currentQuestionIndex][3]);
    }

    private void checkAnswer() {
        // Obténgo el id del RadioButton seleccionado
        int selectedId = answersGroup.getCheckedRadioButtonId();
        RadioButton selectedRadioButton = findViewById(selectedId);

        // Verifico si la respuesta es correcta
        if (selectedRadioButton != null && selectedRadioButton.getText().toString().equals(correctAnswers[currentQuestionIndex])) {
            resultText.setText("¡Correcto!");
            score++;
        } else {
            resultText.setText("Incorrecto. La respuesta correcta es " + correctAnswers[currentQuestionIndex] + ".");
        }

        // Aqui desabilito el botón de verificación después de responder
        checkButton.setVisibility(View.GONE);
    }

    private void nextQuestion() {
        // Incrementa el puntaje de la pregunta actual
        currentQuestionIndex++;

        if (currentQuestionIndex < questions.length) {
            // Carga la siguiente pregunta
            loadQuestion();
            // Borra el resultado anterior y la selección del RadioButton
            resultText.setText("");
            answersGroup.clearCheck();
            // Habilita el botón de verificación para la siguiente pregunta
            checkButton.setVisibility(View.VISIBLE);
        } else {
            // Muestra la puntuación final
            scoreText.setText("Tu puntuación es: " + score);
            // Oculta los botones de verificación y siguiente pregunta
            checkButton.setVisibility(View.GONE);
            nextButton.setVisibility(View.GONE);
        }
    }
}
