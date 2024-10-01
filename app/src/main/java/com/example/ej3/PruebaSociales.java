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

public class PruebaSociales extends AppCompatActivity {

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

                    Toast.makeText(PruebaSociales.this, "Por favor, selecciona una respuesta.", Toast.LENGTH_SHORT).show();
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
        preguntas.add(new Pregunta("1.Como argumento a favor del vegetarianismo, una persona afirma que consumir carne es nocivo\n" +
                "para los humanos porque el animal, del cual se obtiene esta, sufre en el proceso, y esto produce\n" +
                "energías negativas que se transmiten al consumidor y perjudican su salud. Otra persona, igualmente a favor del vegetarianismo, sostiene que el consumo de productos de origen animal es un\n" +
                "acto amoral, en la medida en que resulta del abuso e insensibilidad del ser humano ante los demás\n" +
                "seres vivos.\n" +
                "¿Cuál de las siguientes afirmaciones sobre la relación entre las opiniones presentadas NO es\n" +
                "correcta?",
                new String[]{"A.Son similares, porque ambas van en contra del consumo de carne.", "B.Son complementarias, porque ambas promueven el vegetarianismo cuando argumentan\n" +
                        "la obligación de proteger a los animales.", "C.Son diferentes, porque la primera aboga por la salud del ser humano y la segunda, por el bienestar\n" +
                        "de los animales.", "D.Son disímiles, porque la primera se centra en cómo el animal afecta al ser humano y la segunda,\n" +
                        "en cómo el ser humano afecta al animal."}, 1, R.drawable.img_20));
        preguntas.add(new Pregunta("2.Los habitantes de un barrio de clase media se oponen a que se construyan, en este, viviendas\n" +
                "de interés social. Afirman que las personas de escasos recursos económicos que se beneficiarían\n" +
                "con estas viviendas representarían un peligro para la seguridad de los habitantes actuales del\n" +
                "barrio.\n" +
                "Señalan que las zonas más pobres de la ciudad son también las más inseguras, y argumentan\n" +
                "que esto prueba que una persona de escasos recursos tiene una probabilidad más alta de\n" +
                "ser un delincuente que una persona acomodada.\n" +
                "De los siguientes enunciados, ¿cuál contiene un argumento válido en contra de las afirmaciones\n" +
                "de los habitantes del barrio de clase media?",
                new String[]{"A.Quienes ejercen la delincuencia en una zona pobre de la ciudad pueden no ser habitantes\n" +
                        "de esa zona", "B.. Entre los delincuentes nunca hay personas de escasos recursos, pues todos son adinerados\n" +
                        "precisamente gracias a sus actividades delictivas.", "C.Los delincuentes que habitan en las zonas más pobres de la ciudad dejarían de violar la ley,\n" +
                        "si contaran con mejores condiciones de vida.", "D.Hay casos en que la pobreza y la falta de oportunidades llevan a una persona, en un\n" +
                        "momento de desesperación, a cometer un delito."}, 0, R.drawable.img_21));
        preguntas.add(new Pregunta("3.Un padre de familia no está de acuerdo con la participación de profesores homosexuales en la\n" +
                "educación de sus hijos. Al respecto, el rector del colegio argumenta: “Las personas con inclinaciones homosexuales, como todas las personas, merecen ser amadas. Además, en muchos países\n" +
                "gran parte de la población masculina y femenina es homosexual, y las preferencias sexuales son\n" +
                "el resultado de una compleja interacción de la biología con el medio ambiente. Yo creo que los\n" +
                "homosexuales pueden enseñar, siempre y cuando controlen su comportamiento en clase y no\n" +
                "afecten la orientación sexual de los estudiantes”.\n" +
                "¿Cuál de los siguientes enunciados del rector contiene un prejuicio cuestionable?",
                new String[]{"A.En muchos países, gran parte de la población masculina y femenina es homosexual.", "B.Las personas con inclinaciones homosexuales, como todas las personas, merecen ser\n" +
                        "amadas", "C.Las preferencias sexuales son el resultado de una compleja interacción de la biología con\n" +
                        "el medio ambiente.", "D.Los homosexuales pueden enseñar, siempre y cuando controlen su comportamiento en\n" +
                        "clase y no afecte la orientación sexual de los estudiantes."}, 3, R.drawable.img_22));
        preguntas.add(new Pregunta("4.Los siguientes magnicidios tuvieron incidencia en la historia política de Colombia durante el\n" +
                "siglo XX.\n" +
                "El orden cronológico de ocurrencia de estos hechos es",
                new String[]{"A.2, 3, 1 y 4", "B.3, 2, 1 y 4.", "C.3, 1, 2 y 4.", "D.4, 3, 2 y 1."}, 1, R.drawable.img_23));
        preguntas.add(new Pregunta("5.En Colombia se debate sobre la posibilidad de legalizar el tráfico y consumo de drogas, para contrarrestar los efectos económicos y sociales del narcotráfico. Algunos sectores sociales plantean\n" +
                "que esta alternativa es indeseable y proponen, en cambio, fortalecer los procesos de sensibilización\n" +
                "entre los consumidores sobre los riesgos de salud asociados al consumo de drogas. En contraste,\n" +
                "otros sectores sociales proponen endurecer las penas para los productores y expendedores de drogas, así como para aquellos consumidores que porten más de la dosis legalmente permitida.\n" +
                "Las dos posiciones frente a la legalización de las drogas descritas en el texto son",
                new String[]{"A.diferentes, porque una está a favor de la legalización y la otra a favor del endurecimiento\n" +
                        "de las sanciones legales.", "B.similares, porque ambas consideran que la regulación legal del consumo tiene un efecto\n" +
                        "directo sobre el narcotráfico", "C.diferentes, porque una plantea que la lucha contra el narcotráfico debe ser por la vía de la\n" +
                        "represión y la otra por la vía de la prevención del consumo.", "D.similares, porque ambas están en contra de la legalización y se enfocan en la protección\n" +
                        "de los consumidores de drogas."}, 2, R.drawable.img_24));
        preguntas.add(new Pregunta("6.Un ciudadano se encontraba inconforme con el actual sistema de salud en Colombia y quería promover una reforma a la Ley 100 de 1993 (Ley de Seguridad Social) para introducir mejoras en esta\n" +
                "materia. Para ello, presentó una propuesta ante el Congreso de la República a través de una “iniciativa popular”, a fin de modificar varios artículos de la mencionada ley.\n" +
                "El procedimiento realizado por el ciudadano es",
                new String[]{"A. inviable, porque la Constitución política de Colombia establece que un ciudadano no tiene\n" +
                        "la facultad por sí solo para introducir propuestas de reforma a las leyes colombianas.", "B. viable, porque la Constitución política de Colombia establece que se requiere un ciudadano\n" +
                        "para proponer una iniciativa popular que reforme una ley. ", "C.inviable, porque la Constitución política de Colombia establece que se requiere el 5 % del censo\n" +
                        "electoral para presentar una iniciativa popular que reforme una ley.", "D.viable, porque la Constitución política de Colombia establece que se requiere el 5 % del apoyo\n" +
                        "de los congresistas para que la iniciativa popular se apruebe."}, 2, R.drawable.img_25));
        preguntas.add(new Pregunta("7.Un presidente de Colombia está finalizando su periodo presidencial, y debido a la alta popularidad\n" +
                "de la que goza decide proponer la inclusión de la reelección presidencial indefinida dentro de la\n" +
                "Constitución. Para tal fin, quiere convocar un referendo.\n" +
                "¿El presidente puede hacer esto?",
                new String[]{"A.Sí, porque los referendos permiten reformar la Constitución.", "B.No, porque la Constitución no puede reformarla el Ejecutivo; solo a través de una\n" +
                        "Asamblea Constituyente.", "C.Sí, porque el presidente puede modificar la Constitución por su cuenta, sin acudir al poder\n" +
                        "legislativo.", "D.No, porque los referendos no permiten reformar la Constitución. "}, 0, R.drawable.img_26));
        preguntas.add(new Pregunta("8.En la parte de arriba se presentan dos caricaturas publicadas en la prensa colombiana.\n" +
                "¿Qué periodo de la historia política colombiana se representa en estas caricaturas?",
                new String[]{"A.La Violencia política", "B.El Frente Nacional.", "C.La Patria Boba.", "D. El gobierno de Rojas Pinilla"}, 0, R.drawable.img_27));
        preguntas.add(new Pregunta("9.Las revoluciones sociales son transformaciones rápidas y fundamentales de la situación de una\n" +
                "sociedad y de sus estructuras de clase; se acompañan de las revueltas y se basan en dos coincidencias: cambio estructural por levantamiento de clases y posibilidad de transformación política\n" +
                "y social. Entre las revoluciones más sobresalientes están: la Revolución mexicana, la Revolución\n" +
                "cubana, la Revolución nicaragüense (sandinista) y la Revolución rusa.\n" +
                "El orden cronológico (más antiguo al más reciente) de las revoluciones enunciadas es",
                new String[]{"A.Revolución nicaragüense, Revolución rusa, Revolución mexicana, Revolución cubana", "B.Revolución mexicana, Revolución rusa, Revolución cubana, Revolución nicaragüense", "C.Revolución rusa, Revolución cubana, Revolución mexicana, Revolución nicaragüense.", "D.Revolución cubana, Revolución rusa, Revolución mexicana, Revolución nicaragüense."}, 1, R.drawable.img_28));
        preguntas.add(new Pregunta("10.En las principales ciudades del mundo moderno está produciéndose un paulatino abandono de\n" +
                "las zonas residenciales del centro urbano, al tiempo que las zonas periféricas tienden a un mayor\n" +
                "poblamiento. Estas migraciones las realizan personas o familias que tienen ingresos medios y altos.\n" +
                "La principal causa de este fenómeno se atribuye",
                new String[]{"A.al creciente desarrollo de la industria en el centro de las ciudades.", "B.a la búsqueda de mejor calidad de vida en barrios tranquilos.", "C.a la escasa oferta de servicios en los barrios del centro de la ciudad.", "D.a la creciente oferta de vivienda barata en las afueras de la ciudad."}, 1, R.drawable.img_29));
        preguntas.add(new Pregunta("11.En Colombia, la discriminación de personas con orientación sexual diferente a la heterosexual, es\n" +
                "decir, lesbianas, homosexuales, bisexuales y transgéneristas, ha llevado a procesos de movilización\n" +
                "y acciones afirmativas de estas comunidades por la defensa de sus derechos. Estas movilizaciones\n" +
                "y acciones que visibilizan a personas con orientación sexual diferente a la general, son fundamentales en el desarrollo de la igualdad y del respeto por la diferencia, porque",
                new String[]{"A.exigen al gobierno proyectos pedagógicos para la salud sexual.", "B.denuncian la explotación laboral y las condiciones de marginación espacial de estas\n" +
                        "personas.", "C.promulgan y reivindican los derechos y se denuncia la exclusión.", "D.sensibilizan a la gente sobre la importancia de reconocer la diversidad de creencias\n" +
                        "religiosas."}, 2, R.drawable.img_30));
        preguntas.add(new Pregunta("12.Se dice que una Constitución es la ley de leyes, la fuente de toda la jurisprudencia en un Estado\n" +
                "de derecho. Por esta razón, cada una de las normas que se expidan debe ajustarse a los principios y mandatos constitucionales. En consonancia con lo anterior, una Constitución sirve\n" +
                "principalmente para",
                new String[]{"A.impartir justicia y orientar las acciones del Poder Ejecutivo en un Estado social de derecho\n" +
                        "como el colombiano.", "B.facilitar la labor de los jueces, al asumir la tarea de impartir justicia, de manera imparcial\n" +
                        "y oportuna.", "C.garantizar la paz y la prosperidad de las naciones, al expresar los acuerdos y los compromisos de cada ciudadano con la sociedad.", "D.establecer un orden jurídico y un marco normativo que delimita el poder del Estado y\n" +
                        "establece qué es legal."}, 3, R.drawable.img_31));
        preguntas.add(new Pregunta("13.Algunas tendencias del liberalismo promueven cobrar más impuestos a la parte de la población que posee más recursos, y menos impuestos a aquellas personas que posean menos.\n" +
                "¿Cuál de las siguientes situaciones está de acuerdo con lo anterior?",
                new String[]{"A.En el país A, la tasa promedio de impuestos es el 33% del salario de los habitantes.", "B.En el país B, el Gobierno autoriza aumentar el impuesto del IVA.", "C.En el país C, el Gobierno quita los subsidios para los servicios públicos.", "D.En el país D, el Gobierno aumenta los impuestos de patrimonio y renta."}, 3, R.drawable.img_32));
        preguntas.add(new Pregunta("14.El socialismo busca la igualdad social, política y económica. Para alcanzar este propósito el\n" +
                "socialismo propone",
                new String[]{"A.privatizar los medios de producción y lograr desmontar los sindicatos de las empresas\n" +
                        "transnacionales y multinacionales.", "B.impulsar el consumo y la capacidad de endeudamiento de los trabajadores como factores\n" +
                        "fundamentales para dinamizar la economía.", "C.ofrecer bienes y servicios según el esquema de los tratados de libre comercio y la apertura\n" +
                        "económica de las fronteras nacionales.", "D.lograr la tenencia colectiva de los medios de producción y la consolidación del poder político\n" +
                        "en las clases trabajadoras"}, 3, R.drawable.img_33));
        preguntas.add(new Pregunta("15.Un profesor universitario sostiene que cuando sus estudiantes mujeres responden a una pregunta,\n" +
                "se extienden demasiado en la respuesta. Por esa razón, cuando les pregunta a los estudiantes y\n" +
                "algunos levantan la mano para responder, hombres y mujeres por igual, el profesor solo les da\n" +
                "la palabra a los hombres.\n" +
                "De acuerdo con la Constitución, el profesor",
                new String[]{"A.puede hacer esto porque tiene más experiencia que sus estudiantes", "B.está actuando de forma incorrecta pues viola el principio de igualdad.", "C.adopta una actitud que puede ser chocante para algunos pero que no es discriminatoria.", "D.puede justificar lo que hace siempre y cuando pueda probar que las mujeres de hecho sí\n" +
                        "hablan demasiado."}, 1, R.drawable.img_34));
        preguntas.add(new Pregunta("16.Una compañía petrolera identificó un yacimiento de petróleo en una zona en la que vive una\n" +
                "comunidad indígena para la cual extraer el petróleo significa “robarle la sangre a la madre tierra”,\n" +
                "y por ello se opone a la explotación del yacimiento. La compañía invirtió muchos recursos en un\n" +
                "proceso de diálogo con los representantes de la comunidad, pero fue imposible llegar a un acuerdo.\n" +
                "Ante esto, y después de un análisis detenido de las posiciones, el Estado le negó a la empresa el\n" +
                "permiso de explotación.\n" +
                "La razón que mejor sustenta esta decisión es que, de acuerdo con la Constitución, el Estado debe",
                new String[]{"A.garantizar el derecho a la igualdad.", "B.garantizar el derecho a la libre asociación.", "C.proteger la diversidad étnica y cultural.", "D.proteger el medio ambiente."},2 , R.drawable.img_35));
        preguntas.add(new Pregunta("17.La violencia sexual contra las mujeres es un problema mundial. Hace poco tiempo, el jefe de\n" +
                "policía de una ciudad muy importante, en un país desarrollado, declaró al respecto: “Para evitar\n" +
                "estas situaciones, lo mejor sería que las mujeres dejaran de salir con minifaldas o escotes provocadores a la calle. Así evitarían ser víctimas de acoso o violencia sexual”. ¿Qué intereses está\n" +
                "favoreciendo esta declaración?",
                new String[]{"A.Los de las mujeres, porque está aconsejándoles cómo vestir para no ser víctimas", "B.Los de los policías, porque su función no es la de manejar casos de acoso.", "C. Los de los agresores, porque está dándoles una justificación a lo que hacen.", "D.Los de la ciudad, porque el acoso sexual afecta la percepción de seguridad."}, 2, R.drawable.img_36));
        preguntas.add(new Pregunta("18.La Corte Constitucional falló a favor de un soldado que había interpuesto una tutela al considerar\n" +
                "que la institución militar no le respetaba el derecho a la objeción de conciencia, porque su religión le prohíbe el uso de armas y las prácticas militares. El fundamento del fallo es la defensa de\n" +
                "la libertad de conciencia del soldado.\n" +
                "¿Cuál de las siguientes acciones es coherente con este fallo?",
                new String[]{"A.Ordenarle al Ejército la entrega de la libreta militar al soldado y su inmediata desvinculación de la institución.", "B.Ordenarle al soldado cumplir su servicio militar obligatorio con todas las responsabilidades\n" +
                        "asignadas.", "C. Ordenarle al Ejército que el soldado participe de los entrenamientos y haga solo tareas de\n" +
                        "oficina.", "D.Ordenarle al soldado participar únicamente en paradas militares, portando con orgullo la\n" +
                        "dotación militar."}, 0, R.drawable.img_37));
        preguntas.add(new Pregunta("19.Durante las épocas de lluvias, en muchas zonas rurales de Colombia se inundan escuelas y se interrumpen los caminos para llegar a estas.\n" +
                "¿Cuál de las siguientes opciones vulnera más claramente el derecho a la educación?",
                new String[]{"A.Organizar esquemas de transporte para que los estudiantes vayan a clases en escuelas no\n" +
                        "afectadas por las inundaciones.", "B.Ajustar el calendario escolar para que no haya clases en las épocas de inundación.", "C.Dar una parte de las clases a través de la emisora de radio local, para reducir los días en\n" +
                        "los que tienen que asistir al colegio.", "D.Trasladar a los niños a escuelas no inundadas dos veces por semana y reducir el número\n" +
                        "de horas de clases."}, 3, R.drawable.img_38));
        preguntas.add(new Pregunta("20.Un estudiante se intoxicó con comida que compró a un vendedor ambulante a la salida del\n" +
                "colegio. Por esto, el Consejo Directivo del colegio, con la ayuda de la Policía, logró la expulsión\n" +
                "de los vendedores ambulantes del sector. De los siguientes, ¿cuál sería un efecto de la expulsión de los vendedores?",
                new String[]{"A.El aumento de la inseguridad en las inmediaciones del colegio.", "B.El aumento de las intoxicaciones alimentarias de los estudiantes en el colegio.", "C.La disminución del apoyo de la comunidad al Consejo Directivo y a la Policía.", "D.La disminución de los ingresos de las familias que dependían de esas ventas."}, 3, R.drawable.img_39));



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