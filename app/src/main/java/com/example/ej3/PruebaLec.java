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
                , 1, 1));
        textosConPreguntas.add(new TextoConPreguntas("El primer gran filósofo del siglo diecisiete (si exceptuamos a Bacon y Galileo) fue Descartes, y si alguna vez se dijo de alguien que estuvo a punto de ser asesinado habrá que decirlo de él. La historia es la siguiente, según la cuenta Baillet en su Vie de M. Descartes, tomo I, páginas 102-103. En 1621, Descartes, que tenía unos veintiséis años, se hallaba como siempre viajando (pues era inquieto como una hiena) y, al llegar al Elba, tomó una embarcación para Friezland oriental. Nadie se ha enterado nunca de lo que podía buscar en Friezland oriental y tal vez él se hiciera la misma pregunta, ya que, al llegar a Embden, decidió dirigirse al instante a Friezland occidental, y siendo demasiado impaciente para tolerar cualquier demora, alquiló una barca y contrató a unos cuantos marineros. Tan pronto habían salido al mar cuando hizo un agradable descubrimiento, al saber que se había encerrado en una guarida de asesinos. Se dio cuenta, dice M. Baillet, de que su tripulación estaba formada por criminales, no aficionados, señores, como lo somos nosotros, sino profesionales cuya máxima ambición, por el momento, era degollarlo. La historia es demasiado amena para resumirla y a continuación la traduzco cuidadosamente del original francés de la biografía: “M. Descartes no tenía más compañía que su criado, con quien conversaba en francés. Los marineros, creyendo que se trataba de un comerciante y no de un caballero, pensaron que llevaría dinero consigo y pronto llegaron a una decisión que no era en modo alguno ventajosa para su bolsa. Entre los ladrones de mar y los ladrones de bosques, hay esta diferencia, que los últimos pueden perdonar la vida a sus víctimas sin peligro para ellos, en tanto que si los otros llevan a sus pasajeros a la costa, corren grave peligro de ir a parar a la cárcel. La tripulación de M. Descartes tomó sus precauciones para evitar todo riesgo de esta naturaleza. Lo suponían un extranjero venido de lejos, sin relaciones en el país, y se dijeron que nadie se daría el trabajo de averiguar su paradero cuando desapareciera”. Piensen, señores, en estos perros de Friezland que hablan de un filósofo como si fuese una barrica de ron consignada a un barco de carga. “Notaron que era de carácter manso y paciente y, juzgándolo por la gentileza de su comportamiento y la cortesía de su trato, se imaginaron que debía ser un joven inexperimentado, sin situación ni raíces en la vida, y concluyeron que les sería fácil quitarle la vida. No tuvieron empacho en discutir la cuestión en presencia suya pues no creían que entendiese otro idioma además del que empleaba para hablar con su criado; como resultado de sus deliberaciones decidieron asesinarlo, arrojar sus restos al mar y dividirse el botín”. Perdonen que me ría, caballeros, pero a decir verdad me río siempre que recuerdo esta historia, en la que hay dos cosas que me parecen muy cómicas. Una de ellas es el pánico de Descartes, a quien se le debieron poner los pelos de punta, ante el pequeño drama de su propia muerte, funeral, herencia y administración de bienes. Pero hay otro aspecto que me parece aún más gracioso, y es que si los mastines de Friezland hubieran estado “a la altura”, no tendríamos filosofía cartesiana",
                preguntasTexto1, R.drawable.img_42));


        List<Pregunta> preguntasTexto2 = new ArrayList<>();
        preguntasTexto2.add(new Pregunta("2.En la frase “Las fotografías son la prueba irrecusable de que se hizo la excursión, se cumplió el programa, se gozó del viaje”, ¿cuál de las siguientes palabras es un sinónimo de la palabra ‘irrecusable’??",
                new String[]{"A.Inminente.", "B.Concluyente.", "C.Irremplazable.", "D.Cuestionable."},
                1, 1));

        preguntasTexto2.add(new Pregunta("3.Considere el siguiente resumen del texto anterior: \n" +
                "“La autora analiza la relación entre el turismo y la fotografía, teniendo en cuenta que los cos- mopolitas ven en sus viajes al acto de fotografiar como una necesidad. Según ella, ese acto acaba por convertirse en una práctica trivial con la que solo se busca mitigar la desorienta- ción general que causan los viajes. Así, la fotografía se convierte para los cosmopolitas japo- neses, estadounidenses y alemanes en una especie de reemplazo del trabajo al que están acostumbrados”. \n" +
                "El anterior resumen se puede describir como inadecuado porque\n",
                new String[]{"A.se centra en un tipo particular de turistas y no en los turistas en general.", "B.expone ideas contrarias a las afirmaciones principales del texto.", "C.omite el tono irónico y burlón con que la autora se refiere al arte de la fotografía.", "D.se detiene en presentar información en extremo detallada y secundaria del texto."},
                0, 1));

        textosConPreguntas.add(new TextoConPreguntas("RESPONDA LAS PREGUNTAS 2 Y 3 DE ACUERDO CON LA SIGUIENTE INFORMACIÓN\n" +"\n"+
                "Si las fotografías permiten la posesión imaginaria de un pasado irreal, también ayudan a tomar posesión de un espacio donde la gente está insegura. Así, la fotografía se desarrolla en conjunción con una de las actividades modernas más características: el turismo. Por primera vez en la historia, grupos numerosos de gente abandonan sus entornos habituales por breves periodos. Parece decididamente anormal viajar por placer sin llevar una cámara. Las fotografías son la prueba irrecusable de que se hizo la excursión, se cumplió el programa, se gozó del viaje. Las fotografías documentan secuencias de consumo realizadas en ausencia de la familia, los amigos, los vecinos. Pero la dependencia de la cámara, en cuanto aparato que da realidad a las experiencias, no disminuye cuando la gente viaja más. El acto de fotografiar satisface las mismas necesidades para los cosmopolitas que acumulan trofeos fotográficos de su excursión en barco por el Nilo o sus catorce días en China, que para los turistas de clase media que hacen instantáneas de la Torre Eiffel o las cataratas del Niágara. El acto fotográfico, un modo de certificar la experiencia, es también un modo de rechazarla: cuando se confina a la búsqueda de lo fotogénico, cuando se convierte la experiencia en una imagen, un recuerdo. El viaje se transforma en una estrategia para acumular fotos. La propia actividad fotográfica es tranquilizadora, y mitiga esa desorientación general que se suele agudizar con los viajes. La mayoría de los turistas se sienten obligados a poner la cámara entre ellos y toda cosa destacable que les sale al paso. Al no saber cómo reaccionar, hacen una foto. Así, la experiencia cobra forma: alto, una fotografía, adelante. El método seduce sobre todo a gente subyugada a una ética de trabajo implacable: alemanes, japoneses y estadounidenses. El empleo de una cámara atenúa su ansiedad provocada por la inactividad laboral cuando están en vacaciones y presuntamente divirtiéndose. Cuentan con una tarea que parece una simpática imitación del trabajo: pueden hacer fotos.\n", preguntasTexto2, R.drawable.img_41));

        List<Pregunta> preguntasTexto3 = new ArrayList<>();
        preguntasTexto3.add(new Pregunta("4.¿Cuál de los siguientes es un ejemplo que menciona el autor para apoyar su posición frente a los Gobiernos??",
                new String[]{"A.La guerra con México.", "B.Los abusos del ejército", "C.La tiranía de las mayorías.", "D.La debilidad de las minorías."},
                0, 1));


        textosConPreguntas.add(new TextoConPreguntas("RESPONDA LA PREGUNTA 4 DE ACUERDO CON LA SIGUIENTE INFORMACIÓN DEL DEBER DE LA DESOBEDIENCIA CIVIL (1849)\n" +
                "Creo de todo corazón en el lema “El mejor gobierno es el que tiene que gobernar menos”, y me gustaría verlo hacerse efectivo más rápida y sistemáticamente. Bien llevado, finalmente resulta en algo en lo que también creo: “El mejor gobierno es el que no tiene que gobernar en absoluto”. Y cuando los pueblos estén preparados para ello, ése será el tipo de gobierno que tengan. En el me - jor de los casos, el gobierno no es más que una conveniencia, pero en su mayoría los gobiernos son inconvenientes y todos han resultado serlo en algún momento. Las objeciones que se han hecho a la existencia de un ejército permanente, que son varias y de peso, y que merecen mantenerse, pue - den también por fin esgrimirse en contra del gobierno. El ejército permanente es sólo el brazo del gobierno establecido. El gobierno en sí, que es únicamente el modo escogido por el pueblo para ejecutar su voluntad, está igualmente sujeto al abuso y la corrupción antes de que el pueblo pueda actuar a través suyo. Somos testigos de la actual guerra con México, obra de unos pocos individuos comparativamente, que utilizan como herramienta al gobierno actual; en principio, el pueblo no habría aprobado esta medida. Pero, para hablar en forma práctica y como ciudadano, a diferencia de aquellos que se llaman “anti - gobiernistas”, yo pido, no como “antigobiernista” sino como ciudadano, y de inmediato, un mejor go - bierno. Permítasele a cada individuo dar a conocer el tipo de gobierno que lo impulsaría a respetarlo y eso ya sería un paso ganado para obtener ese respeto. Después de todo, la razón práctica por la cual, una vez que el poder está en manos del pueblo, se le permite a una mayoría, y por un período largo de tiempo, regir, no es porque esa mayoría esté tal vez en lo correcto, ni porque le parezca justo a la minoría, sino porque físicamente son los más fuertes. Pero un gobierno en el que la mayoría rige en todos los casos no se puede basar en la justicia. No es deseable cultivar respeto por la ley más de por lo que es correcto. La única obligación a la que debo someterme es a la de hacer siempre lo que creo correcto. La ley nunca hizo al hombre un ápice más justo, y a causa del respeto por ella, aún el hombre bien dispuesto se convierte a diario en un agente de la injusticia.\n", preguntasTexto3, R.drawable.img_43));

        List<Pregunta> preguntasTexto4 = new ArrayList<>();
        preguntasTexto4.add(new Pregunta("5.En el texto, el autor hace referencia a Rubens para mostrar que",
                new String[]{"A.a todos nos atrae lo bello y por fortuna el arte lo recoge en la pintura", "B.el público siempre exige que el artista refleje la realidad en los cuadros.", "C.algunos artistas plasman en sus obras lo que nos gusta ver en la realidad.", "D.La inclinación en el arte por los temas bonitos y atractivos es bastante nociva."},
                2, 1));
        preguntasTexto4.add(new Pregunta("6.¿Cuál de los siguientes enunciados expresa un juicio de valor presente en el texto?",
                new String[]{"A.Mientras Rubens dibujó la juventud, Durero dibujó la vejez.", "B.Los golfillos del pintor español Murillo tienen gran encanto.", "C.Rubens estaba orgulloso de su hijo y deseaba que lo admiráramos.", "D. Para el público, la hermosura de un cuadro reside en la belleza de su tema."},
                1, 1));
        preguntasTexto4.add(new Pregunta("7.¿Cuál de los siguientes títulos podría ser el más adecuado para el texto anterior?",
                new String[]{"A.En defensa del mal gusto en el arte", "B.El arte como modelo de la realidad.", "C.La representación de la belleza en el arte.", "D.Rubens, Durero y Murillo: el arte de la pintura."},
                2, 1));


        textosConPreguntas.add(new TextoConPreguntas("RESPONDA LAS PREGUNTAS 5 A 7 DE ACUERDO CON LA SIGUIENTE INFORMACIÓN\n" +
                "\n" +
                "A mucha gente le gusta ver en los cuadros lo que también le gustaría ver en la realidad. Se trata de una preferencia perfectamente comprensible. A todos nos atrae lo bello en la naturaleza y agradecemos a los artistas que lo recojan en sus obras. Esos mismos artistas no nos censurarían por nuestros gustos. Cuando el gran artista flamenco Rubens dibujó a su hijo, estaba orgulloso de sus agradables acciones y deseaba que también nosotros admiráramos al pequeño. Pero esta inclinación a los temas bonitos y atractivos puede convertirse en nociva si nos conduce a rechazar obras que representan asuntos menos agradables. El gran pintor alemán Alberto Durero seguramente dibujó a su madre con tanta devoción y cariño como Rubens a su hijo. Su verista estudio de la vejez y la decrepitud puede producirnos tan viva impresión que nos haga apartar los ojos de él y, sin embargo, si reaccionamos contra esta primera aversión, quedaremos recompensados con creces, pues el dibujo de Durero, en su tremenda sinceridad, es una gran obra. En efecto, de pronto descubrimos que la hermosura de un cuadro no reside realmente en la belleza de su tema. No sé si los golfillos que el pintor español Murillo se complacía en pintar eran estrictamente bellos o no, pero tal como fueron pintados por él, poseen desde luego gran encanto.\n", preguntasTexto4, R.drawable.img_44));


        List<Pregunta> preguntasTexto5 = new ArrayList<>();
        preguntasTexto5.add(new Pregunta("8.¿Cuál de las siguientes afirmaciones contradice las ideas que presenta el autor?",
                new String[]{"A. Algunas personas actúan justamente a pesar de poder actuar de manera injusta.", "B.La injusticia, contrariamente a la justicia, es natural en el ser humano.", "C.Actuar con justicia brinda menos ventajas que hacerlo con injusticia.", "D. La injusticia, contrariamente a la justicia, se comete voluntariamente."},
                0, 1));
        preguntasTexto5.add(new Pregunta("9.De los siguientes enunciados, ¿cuál presenta un supuesto subyacente a la afirmación “Todo hombre piensa que la injusticia le brinda más ventajas individuales que la justicia, y está en lo cierto, si habla de acuerdo con esta teoría”?",
                new String[]{"A.La injusticia brinda las mismas ventajas individuales que la justicia.", "B.La justicia, al igual que la injusticia, brinda ventajas individuales.", "C.La injusticia, a diferencia de la justicia, brinda pocas ventajas individuales.", "D.La justicia no brinda ninguna de las ventajas individuales que la injusticia brinda"},
                1, 1));
        preguntasTexto5.add(new Pregunta("10.¿Cuál de las siguientes afirmaciones constituye una razón a favor de la tesis principal del texto anterior, a saber, que cuando alguien actúa justamente lo hace por obligación y no voluntariamente?",
                new String[]{"A.La gente se ve obligada a actuar justamente.", "B.Solo la igualdad garantiza el respeto por la ley.", "C.La injusticia brinda las mismas ventajas individuales que la justicia.", "D.Siempre que una persona cuente con la libertad para cometer injusticias lo hará."},
                3, 1));
        preguntasTexto5.add(new Pregunta("11.¿Cuál de las siguientes afirmaciones sintetiza adecuadamente las ideas contenidas en el primer párrafo?",
                new String[]{"A.El que alguien sea justo es un deber que se deriva de la conciencia moral que tienen todos los hombres.", "B.El que alguien sea justo resulta de una imposición, pues toda persona sin las restricciones y exigencias de la ley buscará satisfacer sus deseos", "C.La justicia es una ilusión, ya que lo natural es que una persona busque cumplir sus deseos y alcanzar sus intereses, sin reparar en la igualdad que exige la ley.", "D.La justicia es un ideal inalcanzable, ya que toda persona, por más justa que aparente ser, tiene intereses propios que pueden llevarla a cometer injusticias."},
                1, 1));
        preguntasTexto5.add(new Pregunta("12.Dada la estructura del texto anterior, ¿qué propósito general tiene el autor al introducir el relato sobre el anillo de Giges, y cómo lo alcanza?",
                new String[]{"A.Promover en la audiencia la idea de que es más ventajoso seguir el camino de la injusticia. El caso de Giges muestra cómo obtuvo beneficios gracias al comportamiento injusto que le posibilitó el anillo.", "B.Convencer a la audiencia de que todo hombre cometerá injusticias cuando tenga la oportunidad. Así lo hizo Giges una vez descubrió el poder que le otorgaba el anillo.", "C.Reforzar en la audiencia la idea de que todos cometemos injusticias. El caso de Giges ilustra cómo las personas aparentemente justas en realidad cometen grandes injusticias.", "D.Persuadir a la audiencia de que actuar justamente requiere mucha fuerza de voluntad. En el caso de Giges, la tentación derivada del poder del anillo doblegó su voluntad."},
                1, 1));
        textosConPreguntas.add(new TextoConPreguntas("RESPONDA LAS PREGUNTAS 8 A 12 DE ACUERDO CON LA SIGUIENTE INFORMACIÓN\n" +
                " \n" +
                "Nadie es justo por voluntad sino porque no tiene el poder de cometer injusticias. Esto lo percibiremos mejor si nos imaginamos las cosas del siguiente modo: demos tanto al justo como al injusto el poder de hacer lo que cada uno de ellos quiere, y a continuación sigámoslos para observar hasta dónde lo lleva a cada uno el deseo. Entonces sorprenderemos al justo tomando el mismo camino que el injusto, siguiendo sus propios intereses, lo que toda criatura persigue por naturaleza como un bien, pero que la fuerza de la ley obliga a seguir el camino del respeto por la igualdad. El poder del que hablo sería efectivo al máximo si aquellos hombres adquirieran una fuerza tal como la que se dice que cierta vez tuvo Giges, el antepasado del lidio. Giges era un pastor que servía al entonces rey de Lidia. Un día sobrevino una gran tormenta y un terremoto que rasgó la tierra y produjo un abismo en el lugar en que Giges llevaba el ganado a pastorear. Asombrado al ver esto, descendió al abismo y halló, entre otras maravillas que narran los mitos, un caballo de bronce, hueco y con ventanillas, a través de las cuales divisó adentro un cadáver de tamaño más grande que el de un hombre, según parecía, y que no tenía nada excepto un anillo de oro en la mano. Giges le quitó el anillo y salió del abismo. Ahora bien, los pastores hacían su reunión habitual para dar al rey el informe mensual concerniente a la hacienda, cuando llegó Giges llevando el anillo. Tras sentarse entre los demás, casualmente volvió el engaste del anillo hacia el interior de su mano. Al suceder esto se tornó invisible para los que estaban sentados allí, quienes se pusieron a hablar de él como si se hubiera ido. Giges se asombró, y luego, examinando el anillo, dio vuelta al engaste hacia afuera y tornó a hacerse visible. Al advertirlo, experimentó con el anillo para ver si tenía tal propiedad, y comprobó que así era: cuando giraba el engaste hacia adentro, su dueño se hacía invisible, y cuando lo giraba hacia afuera, se hacía visible. En cuanto se hubo cerciorado de ello, maquinó el modo de formar parte de los que fueron a la residencia del rey como informantes y, una vez allí, sedujo a la reina y con ayuda de ella mató al rey y se apoderó del reino. Por consiguiente, si hubiese dos anillos como el de Giges y se diera uno a un hombre justo y otro a uno injusto, ninguno perseveraría en la justicia ni soportaría abstenerse de bienes ajenos, cuando podría tanto apoderarse impunemente de lo que quisiera del mercado, como, al entrar en las casas, acostarse con la mujer que prefiriera, y tanto matar a unos como librar de las cadenas a otros, según su voluntad, y hacer todo como si fuera igual a un dios entre los hombres. En esto, el hombre justo no haría nada diferente del injusto, sino que ambos marcharían por el mismo camino. E incluso se diría que esto es una importante prueba de que nadie es justo si no es forzado a serlo, por no considerarse a la justicia como un bien individual, ya que allí donde cada uno se cree capaz de cometer injusticias, las comete. En efecto, todo hombre piensa que la injusticia le brinda más ventajas individuales que la justicia, y está en lo cierto, si habla de acuerdo con esta teoría.\n", preguntasTexto5, R.drawable.img_45));

        List<Pregunta> preguntasTexto6 = new ArrayList<>();
        preguntasTexto6.add(new Pregunta("13.Para el autor, el amor o el enamoramiento son",
                new String[]{"A.las bases fundamentales del matrimonio y de la familia.", "B.amenazas al respeto y la solidaridad debida a la familia.", "C.ideas solo recientemente vinculadas al matrimonio y a la familia.", "D.sentimientos irracionales que contradicen el deber ser del matrimonio"},
                2, 1));
        preguntasTexto6.add(new Pregunta("14.La función del conector “sin embargo” del penúltimo párrafo es",
                new String[]{"A.introducir un nuevo tema de reflexión", "B.negar información suministrada previamente.", "C.agregar nuevos detalles acerca de lo dicho anteriormente.", "D.contrastar la información anterior sin llegar a invalidarla."},
                3, 1));
        preguntasTexto6.add(new Pregunta("15.La palabra “dote” del segundo párrafo puede remplazarse, sin que la frase pierda su significado, por",
                new String[]{"A.ahorros de la futura esposa", "B.dinero de los familiares", "C.aporte patrimonial", "D.ceremonia matrimonial"},
                2, 1));
        preguntasTexto6.add(new Pregunta("16.El tercer párrafo del texto",
                new String[]{"A.presenta un paralelo entre las concepciones del amor y el matrimonio en la China tradicional y en Occidente", "B.demuestra que en China el enamoramiento entre esposos era una amenaza al respeto y la solidaridad de la familia.", "C.sintetiza las razones por las cuales en algunas culturas el enamoramiento y el matrimonio se consideran incompatibles", "D.provee un ejemplo de que la asociación entre el amor y el matrimonio no es algo propio de todos los tiempos y culturas."},
                3, 1));
        preguntasTexto6.add(new Pregunta("17.¿Cuál de los siguientes enunciados apoya la idea de que el amor maduro y sincero no siempre ha sido considerado como la base de la familia?",
                new String[]{"A.En los años 50 se produjo una marcada distinción entre los roles masculino y femenino en la familia.", "B.La idea del amor como la razón que ha de llevar al matrimonio surgió con el movimiento romántico en el siglo XVIII.", "C.Ambos miembros de la pareja deben poner mucho empeño para que el matrimonio se sostenga.", "D.El matrimonio se consolidó en el siglo XIX como la principal forma de institucionalización del amor conyugal."},
                1, 1));
        preguntasTexto6.add(new Pregunta("18.¿Cuál de los siguientes ejemplos ilustra la idea de la familia como una institución política y económica?",
                new String[]{"A.En la Edad Media la mujer aportaba una dote en el momento de casarse.", "B.Entre los fulbes africanos es común que las mujeres nieguen amar a sus maridos.", "C.En los siglos XVIII y XIX cambió la idea sobre cuál es la base que sostiene la familia.", "D.En la sociedad china solo hasta la década de 1920 se acuñó un término para designar el cariño entre esposos."},
                0, 1));
        preguntasTexto6.add(new Pregunta("19.¿Qué implicación sobre el matrimonio entre los fulbes africanos puede derivarse a partir de lo dicho por el autor?",
                new String[]{"A.Que en esa comunidad no sucede que haya amor entre esposos.", "B.Que en esa comunidad el amor no es una condición necesaria para el matrimonio.", "C.Que las mujeres de esa comunidad sienten temor a enamorarse de sus esposos.", "D.Que las mujeres de esa comunidad no ven su amor correspondido por sus esposos."},
                1, 1));
        preguntasTexto6.add(new Pregunta("20.De acuerdo con el texto, ¿qué se puede concluir acerca del matrimonio?",
                new String[]{"A.Que es una institución que tiene únicamente propósitos económicos y políticos.", "B.Que es la base de la familia en culturas tan diversas y complejas como las nuestras.", "C.Que es una institución que varía dependiendo del contexto histórico y social.", "D.Que es un pacto entre dos individuos que debe basarse en el amor y la confianza."},
                2, 1));

        textosConPreguntas.add(new TextoConPreguntas("RESPONDA LAS PREGUNTAS 13 A 20 DE ACUERDO CON LA SIGUIENTE INFORMACIÓN\n" +
                "\n" +
                "En nuestra sociedad, se tiende a pensar que el matrimonio, la base de la familia, se sostiene si hay confianza mutua y buena comunicación, así como si ambos miembros de la pareja trabajan unidos para resolver los conflictos y pasan tiempo juntos. En resumen, su piedra angular es un amor maduro y sincero. No obstante, la idea de que este deba ser la razón última del enlace es bastante reciente: aparece en el siglo XVIII y se afianza en el XIX, con el movimiento romántico. Hasta entonces, el matrimonio era ante todo una institución económica y política demasiado trascendente como para dejarla en manos de los dos individuos implicados. En general, resultaba inconcebible que semejante acuerdo se basara en algo tan irracional como el enamoramiento. De hecho, no se inventó ni para que los hombres protegieran a las mujeres ni para que las explotaran. Se trataba de una alianza entre grupos que iba más allá de los familiares más cercanos o incluso los pequeños grupos. Para las élites, era una manera excelente de consolidar la riqueza, fusionar recursos y forjar uniones políticas. Desde la Edad Media, la dote de boda de la mujer constituía el mayor ingreso de dinero, bienes o tierras que un hombre iba a recibir en toda su vida. Para los más pobres, también suponía una transacción económica que debía ser beneficiosa para la familia. Así, se solía casar al hijo con la hija de quien tenía un campo colindante. El matrimonio se convirtió en la estructura que garantizaba la supervivencia de la familia extendida, que incluye abuelos, hermanos, sobrinos… Al contrario de lo que solemos creer, la imagen del marido trabajando fuera de la casa y la mujer haciéndose cargo de la misma es un producto reciente, de los años 50. Hasta entonces, la familia no se sostenía con un único proveedor, sino que todos sus integrantes contribuían al único negocio de la que esta dependía. Que el matrimonio no se basara en el amor no quiere decir que las personas no se enamoraran. Sin embargo, en algunas culturas se trata de algo incompatible con el matrimonio. En la China tradicional, por ejemplo, una atracción excesiva entre los esposos era tenida como una amenaza al respeto y solidaridad debida a la familia. Es más, en tal ambiente, la palabra amor solo se aplicaba para describir las relaciones ilícitas. Fue en la década de 1920 cuando se inventó un término para designar el cariño entre cónyuges. Una idea tan radicalmente nueva exigía un vocabulario especial. Aún hoy, muchas sociedades desaprueban la idea de que el amor sea el centro del matrimonio. Es el caso de los fulbes africanos, del norte de Camerún. “Muchas de sus mujeres niegan vehementemente cualquier apego hacia el marido”, asegura Helen A. Regis, del Departamento de Geografía y Antropología de la Universidad Estatal de Luisiana. Otras, en cambio, aprueban el amor entre esposos, pero nunca antes de que el matrimonio haya cumplido su objetivo primordial.\n", preguntasTexto6, R.drawable.img_46));

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
