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

    // Aquí están las nuevas preguntas, opciones y respuestas
    private String[] questions = {
            "¿Cuál es la función principal del poder legislativo en una democracia?",
            "Explica la diferencia entre economía de mercado y economía planificada.",
            "¿Qué fue la Revolución Francesa y cuáles fueron sus principales causas y consecuencias?",
            "Describe el impacto de la globalización en las economías de los países en desarrollo.",
            "¿Qué es el imperialismo y cómo afectó a las colonias en África y Asia durante el siglo XIX?",
            "¿Cuáles son los principios fundamentales de la Declaración Universal de los Derechos Humanos?",
            "Menciona y describe tres grandes civilizaciones antiguas y sus aportes a la humanidad.",
            "¿Qué es el conflicto israelo-palestino y cuáles son las principales disputas entre las partes involucradas?",
            "¿Cómo influye el cambio climático en la geografía y las economías globales?",
            "¿Qué papel desempeñó la Organización de las Naciones Unidas (ONU) en la resolución de conflictos internacionales durante el siglo XX?"
    };

    private String[][] options = {
            {"a) Ejecutar leyes y políticas gubernamentales", "b) Interpretar las leyes y resolver disputas legales", "c) Crear, modificar y aprobar leyes", "d) Administrar el presupuesto nacional"},
            {"a) En la economía de mercado, el gobierno controla la producción; en la economía planificada, los consumidores deciden.", "b) En la economía de mercado, los precios son determinados por la oferta y la demanda; en la economía planificada, los precios son establecidos por el gobierno.", "c) En la economía de mercado, el gobierno establece los salarios; en la economía planificada, los salarios son negociados entre empleados y empleadores.", "d) En la economía de mercado, los recursos son distribuidos equitativamente; en la economía planificada, la distribución es desigual."},
            {"a) Un conflicto militar que estableció la monarquía absolutista en Francia.", "b) Un levantamiento popular que llevó a la creación del sistema feudal.", "c) Un cambio social y político que llevó al derrocamiento de la monarquía y al establecimiento de la República.", "d) Un proceso de industrialización que transformó la economía francesa."},
            {"a) Reducción de la desigualdad y mejora en la calidad de vida.", "b) Aumento de la independencia económica y disminución de la influencia externa.", "c) Aumento de la inversión extranjera y acceso a nuevos mercados, pero también riesgo de explotación y dependencia económica.", "d) Estancamiento económico y retroceso en la industrialización."},
            {"a) Una política de expansión territorial que benefició a las colonias con infraestructura y desarrollo.", "b) Un movimiento cultural que promovió la autonomía y la independencia de las colonias.", "c) Una política de dominación y explotación que resultó en la extracción de recursos y la opresión de los pueblos colonizados.", "d) Un acuerdo diplomático para el intercambio equitativo de recursos entre naciones."},
            {"a) Igualdad ante la ley, derecho a la propiedad privada, y libertad de expresión.", "b) Derecho al trabajo, educación gratuita y libertad de religión.", "c) Derechos a la vida, libertad y seguridad; igualdad y no discriminación.", "d) Derecho a la participación política, acceso a la justicia y protección social."},
            {"a) Egipcios (escritura jeroglífica, pirámides), Romanos (arquitectura, leyes), Chinos (pólvora, imprenta).", "b) Aztecas (calendario, arquitectura), Incas (puentes, agricultura), Mayas (matemáticas, astronomía).", "c) Griegos (democracia, filosofía), Romanos (derecho, ingeniería), Mesopotámicos (escritura, leyes).", "d) Vikingos (navegación, comercio), Celtas (arte, metalurgia), Egipcios (jeroglíficos, navegación)."},
            {"a) Un conflicto religioso en la región de Medio Oriente por el control de recursos.", "b) Una disputa territorial entre dos estados árabes por el acceso a rutas comerciales.", "c) Un conflicto prolongado entre israelíes y palestinos sobre el control territorial y el establecimiento de un estado palestino.", "d) Una serie de guerras civiles en la región de Medio Oriente por la influencia política."},
            {"a) Aumento de desastres naturales y pérdida de biodiversidad.", "b) Mejora en la calidad del aire y aumento de la vegetación.", "c) Disminución de las temperaturas globales y estabilidad climática.", "d) Menor impacto en las economías y sociedades globales."},
            {"a) Fomentó el desarme nuclear y la cooperación económica internacional.", "b) Se centró en la resolución de conflictos regionales y el fortalecimiento de alianzas militares.", "c) Desarrolló iniciativas para el desarrollo sostenible y la justicia social.", "d) Actuó como mediador en conflictos internacionales y promovió la cooperación entre naciones."}
    };

    private String[] correctAnswers = {
            "c) Crear, modificar y aprobar leyes",
            "b) En la economía de mercado, los precios son determinados por la oferta y la demanda; en la economía planificada, los precios son establecidos por el gobierno.",
            "c) Un cambio social y político que llevó al derrocamiento de la monarquía y al establecimiento de la República.",
            "c) Aumento de la inversión extranjera y acceso a nuevos mercados, pero también riesgo de explotación y dependencia económica.",
            "c) Una política de dominación y explotación que resultó en la extracción de recursos y la opresión de los pueblos colonizados.",
            "c) Derechos a la vida, libertad y seguridad; igualdad y no discriminación.",
            "c) Griegos (democracia, filosofía), Romanos (derecho, ingeniería), Mesopotámicos (escritura, leyes).",
            "c) Un conflicto prolongado entre israelíes y palestinos sobre el control territorial y el establecimiento de un estado palestino.",
            "a) Aumento de desastres naturales y pérdida de biodiversidad.",
            "d) Actuó como mediador en conflictos internacionales y promovió la cooperación entre naciones."
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

        // Esta es la configuración del botón para verificar la respuesta
        checkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer();
            }
        });

        // Aquí configuro el botón para la siguiente pregunta
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
        // Aquí cargo la pregunta y las respuestas para la pregunta actual
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
        // Obteniendo el id del RadioButton seleccionado
        int selectedId = answersGroup.getCheckedRadioButtonId();
        RadioButton selectedRadioButton = findViewById(selectedId);

        // Verifico si la respuesta es correcta
        if (selectedRadioButton != null && selectedRadioButton.getText().toString().equals(correctAnswers[currentQuestionIndex])) {
            resultText.setText("¡Correcto!");
            score++;
        } else {
            resultText.setText("Incorrecto. La respuesta correcta es " + correctAnswers[currentQuestionIndex] + ".");
        }

        // Deshabilito el botón de verificación después de responder
        checkButton.setVisibility(View.GONE);
    }

    private void nextQuestion() {
        // Incrementa el índice de la pregunta actual
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
