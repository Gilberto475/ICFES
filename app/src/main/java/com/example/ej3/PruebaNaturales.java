package com.example.ej3;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class PruebaNaturales extends AppCompatActivity {

    private ImageView questionImage;
    private TextView questionText;
    private RadioGroup answerGroup;
    private Button nextButton;
    private List<Pregunta> preguntas;
    private int preguntaActual = 0;
    private int aciertos = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prueba_naturales);

        questionImage = findViewById(R.id.question_image);
        questionText = findViewById(R.id.question_text);
        answerGroup = findViewById(R.id.answer_group);
        nextButton = findViewById(R.id.next_button);

        inicializarPreguntas();


        mostrarPregunta();


        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int selectedId = answerGroup.getCheckedRadioButtonId();
                if (selectedId == -1) {

                    Toast.makeText(PruebaNaturales.this, "Por favor, selecciona una respuesta.", Toast.LENGTH_SHORT).show();
                    return;
                }


                if (respuestaCorrecta()) {
                    aciertos++;
                }

                preguntaActual++;
                if (preguntaActual < preguntas.size()) {
                    mostrarPregunta();
                } else {
                    mostrarResultados();
                }
            }
        });
    }

    private void inicializarPreguntas() {
        preguntas = new ArrayList<>();
        preguntas.add(new Pregunta("1.¿Un estudiante analiza cómo cambia la solubilidad de una mezcla de sólido M; para esto,\n" +
                "disuelve distintas cantidades del sólido M en 20 gramos de agua destilada y registra la temperatura exacta a la cual se logra disolver completamente el sólido.\n" +
                "Los resultados se muestran en la parte de arriba.\n" +
                "Teniendo en cuenta lo observado con 20 gramos de agua destilada, el estudiante cree que si a\n" +
                "83 °C se agregan 50 gramos de sólido M en 40 gramos de agua destilada no se solubilizará\n" +
                "completamente esta cantidad de sólido M. ¿La suposición del estudiante es correcta?",
                new String[]{"Sí, porque para disolver esta cantidad de sólido M en 40 gramos de agua también se\n" +
                        "necesitaría el doble de temperatura, es decir, 166 °C.", "No, porque al tener el doble de agua, es más probable que el sólido M solo necesite la\n" +
                        "mitad de la temperatura para disolverse, es decir, 42 °C.", "No, porque a partir de 65 °C se pueden disolver completamente 50 g de sólido M en 40\n" +
                        "gramos de agua, por lo que a 83 °C el sólido estará completamente disuelto.", "Sí, porque con masas mayores a 35 gramos de sólido M, se necesitarían temperaturas\n" +
                        "mayores que 83 °C para disolverlo en esa cantidad de agua."}, 2, R.drawable.img));
        preguntas.add(new Pregunta("2.La siguiente ecuación representa la reacción química de la formación de agua (H2O).",
                new String[]{"A.H4 y O2.", "B.H4 y O4.", "C.H2 y O2.", "D. H2 y O4."}, 2, R.drawable.img_1));
        preguntas.add(new Pregunta("3.En el modelo se presenta el proceso de síntesis de proteínas en una célula.",
                new String[]{"A.Se produciría una cadena de ARNm doble como la molécula de ADN", "B.El ribosoma no podría entrar al núcleo a leer la información del ADN. ", "C.Los aminoácidos no podrían unirse al ARNt en el citoplasma.", "D. Se unirían aminoácidos que no corresponden con la secuencia de ADN."}, 3, R.drawable.img_2));

        preguntas.add(new Pregunta("4.Una estudiante quiere clasificar dos sustancias de acuerdo al tipo de mezclas que son. Al buscar, encuentra que las mezclas homogéneas son uniformes en todas sus partes, pero las mezclas heterogéneas no lo\n" +
                "son. La estudiante realiza los procedimientos que se muestran en la tabla con las sustancias 1 y 2.",
                new String[]{"A. La sustancia 1 es una mezcla homogénea y la sustancia 2 es una mezcla heterogénea.", "B. La sustancia 1 es una mezcla heterogénea y la sustancia 2 es una mezcla homogénea.", "C.Ambas sustancias son mezclas homogéneas.", "D.Ambas sustancias son mezclas heterogéneas"}, 0, R.drawable.img_3));

        preguntas.add(new Pregunta("5.Un estudiante camina por el frente de dos parlantes\n" +
                "ubicados afuera de la emisora del colegio. Dentro\n" +
                "de la emisora, la profesora de física toca la nota\n" +
                "do, en un clarinete para ayudar al profesor de\n" +
                "música a afinar algunos instrumentos musicales.\n" +
                "El estudiante percibe que hay lugares en donde el\n" +
                "sonido del clarinete se escucha más fuerte, mientras que en otros no, y los marca como se muestra\n" +
                "en la siguiente figura.\n"+"Si el estudiante le pregunta a la profesora la razón por la cual en los puntos blancos el sonido se\n" +
                "escucha más fuerte que en los negros, ¿cuál de los siguientes argumentos debe darle la profesora\n" +
                "al estudiante?",
                new String[]{"A.Porque las ondas de sonido interfieren constructivamente en los puntos negros, y en los\n" +
                        "puntos blancos se reflejan.", "B.Porque las ondas de sonido interfieren constructivamente y destructivamente en todos los\n" +
                        "puntos, pero en los blancos las ondas se refractan..", "C. Porque las ondas de sonido interfieren constructivamente en los puntos blancos, y\n" +
                        "destructivamente en los puntos negros. ", "D.Porque las ondas de sonido interfieren destructivamente en los puntos blancos y negros,\n" +
                        "pero en los negros se reflejan y se refractan."}, 2, R.drawable.img_4));


        preguntas.add(new Pregunta("6.Una estudiante observa la construcción de un edificio nuevo para el colegio y mira a un obrero\n" +
                "que lanza, cada vez, un ladrillo desde el primer piso, mientras que otro lo recibe justo a 3,0 m de\n" +
                "altura, como se muestra en la figura de arriba.\n" +
                "Si la estudiante sabe que la energía potencial depende de la altura y de la masa del objeto y de\n" +
                "repente observa que mientras el obrero se mantiene sosteniendo el ladrillo II a una altura de 1,0 m\n" +
                "respecto al piso, el otro obrero deja caer el ladrillo I, ¿qué altura tiene que descender el ladrillo I\n" +
                "para que ambos ladrillos tengan la misma energía potencial?",
                new String[]{"A.2,0 m. ", "B.1,5 m", "C.1,0 m", "D.3,0 m"}, 0, R.drawable.img_5));

        preguntas.add(new Pregunta("7.Se mide el tiempo de vaciado del agua de un tanque a través de una llave conectada al fondo del\n" +
                "mismo. La siguiente tabla muestra los resultados de este experimento, tomados para tres llaves\n" +
                "de diferentes diámetros y para el tanque llenado hasta determinada altura.\n" +
                "Con base en los datos registrados en la tabla sobre la dependencia del tiempo de vaciado y\n" +
                "tomando en cuenta el diámetro de la llave y la altura del agua, se puede afirmar que",
                new String[]{"A.disminuye más cuando el diámetro de la llave aumenta 1 cm que cuando se reduce la altura del nivel de agua 10 cm.", "B.disminuye más cuando el diámetro de la llave se reduce 1 cm que cuando se reduce la altura del nivel de agua 10 cm.\n", "C.aumenta más cuando el diámetro de la llave aumenta 1 cm que cuando se reduce la altura del nivel de agua en 10 cm", "D.aumenta más cuando el diámetro de la llave aumenta 1 cm que cuando se aumenta la altura del nivel de agua en 10 cm.\n"}, 0, R.drawable.img_6));

        preguntas.add(new Pregunta("8.El salto bungee se practica generalmente en puentes (ver figura). En uno de estos saltos, se utiliza una banda elástica que tiene una longitud sin estirar de 30 metros y que puede estirar 30 metros más. \n"+"En un salto, un deportista se lanzará desde un puente de 65 metros de altura. Cuando ha descendido apenas 20 metros de altura (ver figura), la transformación de energía que se habrá dado\n" +
                "hasta ese momento será de",
                new String[]{"A.energía cinética a potencial elástica.", "B.energía cinética a potencial gravitacional.", "C. energía potencial gravitacional a potencial elástica", "D.energía potencial gravitacional a cinética."}, 3, R.drawable.img_7));
        preguntas.add(new Pregunta("9.En tres instantes diferentes, un estudiante dibuja el diagrama de cuerpo libre para una piedra que\n" +
                "cae en un estanque de agua, como se muestra en la figura de arriba.\n" +
                "Si el estudiante mide la aceleración de la piedra después del tercer instante, se espera que su magnitud,\n" +
                "respecto a los otros instantes, sea",
                new String[]{"A.mayor que la del primer instante, porque el peso hace que la piedra se acelere hacia abajo", "B.mayor que el primer instante, porque el peso de la piedra disminuye cuando la fuerza de\n" +
                        "resistencia comienza a aumentar. ", "C.constante, porque la aceleración de la piedra siempre es igual que la aceleración de la\n" +
                        "gravedad.", "D.nula, porque después del tercer instante, el peso de la piedra y la fuerza de resistencia se\n" +
                        "cancelan."}, 3, R.drawable.img_8));
        preguntas.add(new Pregunta("10.El modelo representa la relación entre, la altura y la cantidad de partículas de aire.\n" +
                "Una olla con agua hierve a una temperatura de 100 °C, cuando la altura es 0 km. Teniendo en\n" +
                "cuenta que el punto de ebullición corresponde a la temperatura a la cual la presión de vapor del\n" +
                "gas iguala la presión atmosférica, si se pone a calentar la misma cantidad de agua a una altura\n" +
                "de 25 km, puede afirmarse que el agua",
                new String[]{"A.hierve a una temperatura menor que 100 °C, porque la presión es menor en esta altura.", "B.hierve a una temperatura mayor que 100 °C, porque la presión es menor en esta altura. ", "C.nunca hierve, porque en esta altura hay muy poca cantidad de aire", "D.se congela, porque al no haber aire el agua pasará a estado sólido."}, 0, R.drawable.img_9));
        preguntas.add(new Pregunta("11.Considere la reacción de la imagen y las masas molares de reactivos y productos.\n" +
                "De acuerdo con la información anterior, si reaccionan 124 g de P4 con 210 g de Cl2, ¿cuál es el\n" +
                "reactivo límite?",
                new String[]{"A.El Cl2, porque reaccionan en su totalidad 210 gramos de Cl2 y queda la mitad de P4 sin\n" +
                        "reaccionar.", "B.El P4, porque hay menor masa en gramos que de Cl2. ", "C.El Cl2, porque según la relación estequiométrica siempre se necesitan 6 moles de Cl2, sin\n" +
                        "importar la cantidad de P4.", "D.El P4, porque su masa molar es casi el doble que la del Cl2 ."},0 , R.drawable.img_10));
        preguntas.add(new Pregunta("12.La siguiente gráfica muestra la relación entre la resistencia eléctrica y la temperatura para cuatro\n" +
                "resistencias eléctricas (R1, R2, R3 y R4).\n" +
                "Un estudiante realiza actividades experimentales y encuentra que la corriente eléctrica en un circuito es inversamente proporcional a la resistencia eléctrica. Se le solicita al estudiante construir\n" +
                "un circuito usando una de estas resistencias, de forma que pase la menor cantidad de corriente\n" +
                "eléctrica a 90 °C. Si las tendencias de resistencia como función de la temperatura se mantienen,\n" +
                "la resistencia que debe utilizar el estudiante es",
                new String[]{"A.R1, porque tiene la mayor resistencia eléctrica desde los 40 °C hasta los 80 °C. ", "B.R2, porque su resistencia eléctrica será la mayor a 90 °C.", "C.R3, porque tiene la menor resistencia desde los 40 °C hasta los 80 °C.", "D.R4, porque su resistencia eléctrica no depende de la temperatura."},1 , R.drawable.img_11));
        preguntas.add(new Pregunta("13.Una estudiante desea conocer las proteínas presentes en la sangre. Para ello, emplea una técnica\n" +
                "que las separa de acuerdo con su peso molecular y produce una respuesta en diferentes instantes\n" +
                "de tiempo cada vez que una proteína es detectada.\n" +
                "Ella obtiene los resultados mostrados en la siguiente gráfica, en donde cada pico representa una\n" +
                "proteína diferente.Una proteína con peso molecular de 120 kDa podrá separarse en un tiempo",
                new String[]{"A.entre 25 y 35 minutos.", "B.entre 5 y 25 minutos.  ", "C.entre 35 y 45 minutos.", "D.después de 45 minutos."}, 0, R.drawable.img_12));
        preguntas.add(new Pregunta("14.La conductividad de una disolución es la capacidad que tiene esta para conducir la corriente eléctrica. Un estudiante realiza una serie de experimentos para estudiar la conductividad de un tipo\n" +
                "de sal (MgSO4) disuelta en agua, y obtiene los resultados (img de arriba).\n" +
                " Con base en la anterior información, en este experimento el estudiante buscaba estudiar",
                new String[]{"A.la influencia de la temperatura sobre la conductividad.", "B.el efecto de la conductividad de la disolución sobre la concentración de la sal ", "C.la influencia de la carga de los iones sobre la conductividad.", "D.el efecto de la concentración de la sal sobre la conductividad de la disolución."}, 3, R.drawable.img_13));
        preguntas.add(new Pregunta("15.Al agitar una cuerda extendida horizontalmente, cada sección de la cuerda se mueve de arriba\n" +
                "abajo en dirección perpendicular a la dirección de propagación de la onda generada; este es un\n" +
                "ejemplo de una onda transversal. En contraste, en una onda longitudinal, las partículas del medio\n" +
                "vibran en la misma dirección de propagación de la onda.\n" +
                "Un grupo de personas quiere representar una onda longitudinal; para esto, se ubican como muestra la figura. La fila representa el medio de propagación y las personas representan las partículas\n" +
                "del medio.\n" +
                "Para lograr la representación, el movimiento que debe hacer la primera persona y que los demás\n" +
                "deben repetir sucesivamente es",
                new String[]{"A.alzar y bajar lateralmente los brazos.", "B.sentarse y ponerse de pie ", "C.balancearse de izquierda a derecha.", "D.moverse hacia adelante y atrás."}, 3, R.drawable.img_14));
        preguntas.add(new Pregunta("16.Un estudiante sopla una pelota por un tubo vertical como muestra la figura.\n" +
                "La pelota sube aceleradamente por el tubo. Esto ocurre porque",
                new String[]{"A.el peso de la pelota cambia cuando el estudiante sopla aire por el tubo.", "B.la fuerza que ejerce el aire que sopla el estudiante es igual que el peso de la pelota. ", "C.el peso de la pelota es mayor que la fuerza del aire que sopla el estudiante.", "D.la fuerza que ejerce el aire que sopla el estudiante es mayor que el peso de la pelota."}, 3, R.drawable.img_15));
        preguntas.add(new Pregunta("17.Un carro de masa M, se mueve sobre una superficie horizontal con velocidad V1 en la dirección\n" +
                "que ilustra la figura (1). En cierto instante un objeto de masa m que se mueve perpendicular a la\n" +
                "superficie, cae en el interior del carro y continúan moviéndose los dos como se muestra en la\n" +
                "figura (2). Desprecie el rozamiento entre la superficie de la carretera y el carro.\n" +
                "La rapidez del carro después de que el objeto cae dentro de el",
                new String[]{"A.disminuye porque la cantidad de masa que se desplaza horizontalmente aumenta.", "B.aumenta porque durante el choque el carro adquiere la velocidad del objeto que cae. ", "C.aumenta porque al caer el objeto le da un impulso adicional al carro.", "D.no cambia porque el momentum del objeto es perpendicular al del carro"}, 0, R.drawable.img_16));
        preguntas.add(new Pregunta("18.Los rayos de luz emitidos por objetos luminosos viajan en línea recta dentro de un mismo medio\n" +
                "(ver figura 1). Si un rayo de luz pasa de aire a agua cambia su dirección como se muestra en la\n" +
                "figura 2.\n" +
                "Cuando una piscina está vacía, un nadador observa el farol que está en el borde (ver figura 1);\n" +
                "luego, cuando se llena la piscina (ver figura 2) el nadador verá el farol",
                new String[]{"A.más bajo", "B.de la misma altura. ", "C.más alto.", "D.invertido."}, 2, R.drawable.img_17));
        preguntas.add(new Pregunta("19.El objetivo de una práctica es la detección de almidón en la papa, utilizando el lugol como colorante. Se realizan cuatro experimentos con las condiciones que se muestran en la tabla.\n" +
                "En esta práctica, el experimento 4 es importante porque",
                new String[]{"A.permite que el almidón se encuentre soluble", "B.contiene el colorante con el cual se logra la detección de almidón. ", "C.contiene más almidón que el que contiene la papa.", "D.permite establecer el color esperado para la detección de almidón."}, 3, R.drawable.img_18));
        preguntas.add(new Pregunta("20.El anabolismo es una forma de metabolismo que requiere energía y da como resultado la elaboración de moléculas complejas a partir de moléculas simples. Por el contrario, el catabolismo\n" +
                "transforma moléculas complejas en moléculas simples y produce energía. El esquema \n" +
                "muestra los procesos de fotosíntesis y respiración en plantas.\n" +
                "Con base en la información anterior, se puede afirmar que",
                new String[]{"A.la fotosíntesis es un proceso anabólico porque produce glucosa como molécula compleja.", "B.la fotosíntesis es un proceso catabólico porque requiere energía en forma de luz solar ", "C.la respiración es un proceso anabólico porque produce energía en forma de ATP.", "D.la respiración es un proceso catabólico porque produce moléculas complejas como CO2\n" +
                        "y agua."}, 0, R.drawable.img_19));


    }

    private void mostrarPregunta() {
        Pregunta pregunta = preguntas.get(preguntaActual);

        questionText.setText(pregunta.getTextoPregunta());
        questionImage.setImageResource(pregunta.getImagenId());


        answerGroup.clearCheck();
        for (int i = 0; i < answerGroup.getChildCount(); i++) {
            ((RadioButton) answerGroup.getChildAt(i)).setText(pregunta.getOpciones()[i]);
        }
    }

    private boolean respuestaCorrecta() {
        int selectedId = answerGroup.getCheckedRadioButtonId();
        if (selectedId == -1) {
            return false;
        }
        int indexSeleccionado = answerGroup.indexOfChild(findViewById(selectedId));
        return indexSeleccionado == preguntas.get(preguntaActual).getRespuestaCorrecta();
    }

    private void mostrarResultados() {
        String mensaje = "Has acertado " + aciertos + " de " + preguntas.size();
        Toast.makeText(this, mensaje, Toast.LENGTH_LONG).show();


        new android.os.Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                reiniciarPrueba();
            }
        }, 2000);
    }

    private void reiniciarPrueba() {
        preguntaActual = 0;
        aciertos = 0;
        answerGroup.clearCheck();
        mostrarPregunta();
    }

}