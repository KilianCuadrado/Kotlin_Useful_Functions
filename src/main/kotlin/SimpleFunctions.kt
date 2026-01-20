package itb
//Utilitats per la fincuio de mostrar la data
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
//Utilitat per la genaracio random de numero
import kotlin.random.Random

/**
 * Grabs local date from device and returns it in spanish format.
 * @autor: @KilianCuadrado
 * @see: 'https://es.stackoverflow.com/questions/470891/como-poner-la-fecha-y-hora-actual-en-espa%C3%B1ol-con-simpledateformat'
 * @since 20/01/2026
 */
fun mostrarDataActual(): String? {
    val fechaEspanol = SimpleDateFormat("dd/MM/yyyy", Locale.forLanguageTag("es_ES"))
    //Necesari par trucar a la fecha 'fechaEspanol.format(Date())'
    return fechaEspanol.format(Date())
}
/**
 * Grabs local hour from device and returns it in HH:mm:ss with the same metod as mostrarDataActual.
 * @autor: @KilianCuadrado
 * @see: 'https://es.stackoverflow.com/questions/470891/como-poner-la-fecha-y-hora-actual-en-espa%C3%B1ol-con-simpledateformat'
 * @see mostrarDataActual
 * @since 20/01/2026
 */
fun mostrarHoraActual(): String? {
    val horaEspanol = SimpleDateFormat("HH:mm:ss", Locale.forLanguageTag("es_ES"))
    //Necesari par trucar a la fecha 'fechaEspanol.format(Date())'
    return horaEspanol.format(Date())
}
/**
 * You can put strings and it will show a numbered list or not depending on your specification with it's title if again specified of those strings and if you specify with 'opcioSortidaMenu' it will display at the bottom with the number 0.
 * @author @KilianCuadrado
 * @param opcionsMenu All of the options you want to display.
 * @param opcioSortidaMenu Only option that will show with number 0 usually used for exiting a menu.
 * @param mostrarNumerat A boolean that asks if the coder wants to display the menu numered or not.
 * @param titolMenu Option to put a title to the menu to make it look more apealing to the user.
 * @since 20/01/2026
 */
fun mostrarMenu(vararg opcionsMenu: String, opcioSortidaMenu: String = "", mostrarNumerat: Boolean, titolMenu: String="") {
    val teTitul = titolMenu.isNotEmpty()
    //Comprovar si es vol afegir un titul al menu
    val teSortida = opcioSortidaMenu.isNotEmpty()
    // Una suma amb if per crear correctament l'array amb les opcions
    val totalOpcions = opcionsMenu.size + if (teSortida) 1 else 0
    //Definició de la mida del array
    val arrayOpcionsMenu = Array(totalOpcions) { Array(2) { "" } }

    // Opcions normals sense sortida
    for (i in opcionsMenu.indices) {
        arrayOpcionsMenu[i][0] = "${i + 1}. "
        arrayOpcionsMenu[i][1] = opcionsMenu[i]
    }
    // Si es posa una opcio de sortida
    if (teSortida) {
        arrayOpcionsMenu[opcionsMenu.size][0] = "0. "
        arrayOpcionsMenu[opcionsMenu.size][1] = opcioSortidaMenu
    }
    // Mostrar menú amb titul si s'espcifica
    if (teTitul){
        println("--- $titolMenu ---")
    }
    if (mostrarNumerat) {
        for (opcioNumerada in arrayOpcionsMenu) {
            println(opcioNumerada[0] + opcioNumerada[1])
        }
    }else{
        for (opcioNoNumerada in arrayOpcionsMenu) {
            println("- ${opcioNoNumerada[1]}")
        }
    }

}

/**
 * It will ask the user for a NUMBER and will make sure the user doesn't put a string or text. !IMPORTANT it will always return a float type number conver with .toX for better convinience.
 * @author @KilianCuadrado
 * @param missatge Text that will show for asking the input to the user.
 * @param missatgeError Text that will tell the user that the input is wrong.
 * @return Float that the user has put. REMEMBER THE RETURN NUMBER IS ALWAYS ON FLOAT.
 * @since 20/01/2026
 */
fun demanarNumeroControlat (missatge:String, missatgeError: String): Float{
    print(missatge)
    var numeroUsuari = readln().toFloatOrNull()
    while (numeroUsuari==null){
        println(missatgeError)
        print(missatge)
        numeroUsuari = readln().toFloatOrNull()
    }
    return numeroUsuari
}

/**
 * Generates a random number between two number if unspecified it will default to a range of 1 to 10 in Int
 * @author @KilianCuadrado
 * @param numeroMaxim Indicates the maximum of the range of the generation. Default is 10
 * @param numeroMinim Indicates the minimum of the range of the generation. Default is 1
 * @param tipusDeNumeroRetorn Indicates the type of random you want to generate default is Int also if type of number is not indicated correctly it will also default to Int
 * @return Number converted to the type specified before at tipusDeNumeroRetorn
 * @since 20/01/2026
 */
fun crearNumeroRandom(tipusDeNumeroRetorn: String="Int", numeroMinim: Number=1, numeroMaxim: Number=10): Number {
    val numeroATornar = when (tipusDeNumeroRetorn){
        "Int"->{
            Random.nextInt(numeroMinim.toInt(), numeroMaxim.toInt())
        }
        "Double"->{
            Random.nextDouble(numeroMinim.toDouble(), numeroMaxim.toDouble())
        }
        "Float"->{
            Random.nextFloat()
        }
        else -> {
            Random.nextInt(numeroMinim.toInt(), numeroMaxim.toInt())
        }
    }
    return numeroATornar
}