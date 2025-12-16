package itb
//Utilitats per la fincuio de mostrar la data
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

/**
 * Grabs local date from device and returns it in spanish format.
 * @autor: @KilianCuadrado
 * @see: 'https://es.stackoverflow.com/questions/470891/como-poner-la-fecha-y-hora-actual-en-espa%C3%B1ol-con-simpledateformat'
 */
fun mostrarDataActual(): String? {
    val fechaEspanol = SimpleDateFormat("dd/MM/yyyy", Locale.forLanguageTag("es_ES"))
    //Necesari par trucar a la fecha 'fechaEspanol.format(Date())'
    return fechaEspanol.format(Date())
}

/**
 * You can put strings and it will show a numbered list of those strings and if you especify with 'opcioSortidaMenu' it will display at the bottom with the number 0..
 * @author @KilianCuadrado
 * @param opcionsMenu All of the options you want to display,
 * @param opcioSortidaMenu Only option that will show with number 0 usually used for exiting a menu.
 */
fun mostrarMenu(vararg opcionsMenu: String, opcioSortidaMenu: String = "") {
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
    // Mostrar menú
    for (opcio in arrayOpcionsMenu) {
        println(opcio[0] + opcio[1])
    }
}

/**
 * It will ask the user for a NUMBER and will make sure the user doesn't put a string or text. !IMPORTANT it will always return a float type number conver with .toX for better convinience.
 * @author @KilianCuadrado
 * @param missatge Text that will show for asking the input to the user.
 * @param missatgeError Text that will tell the user that the input is wrong.
 * @return Number that the user has put. REMEMBER THE RETURN NUMBER IS ALWAYS ON FLOAT.
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