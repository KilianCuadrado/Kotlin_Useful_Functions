import itb.crearNumeroRandom
import itb.demanarNumeroControlat
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import kotlin.test.assertIs

class SimpleFunctionsKtTest {
    @Test
    fun checkSiRetornaInt(){
        assertIs<Int>(crearNumeroRandom())
    }
    @Test
    fun checkSiRetornaDoble(){
        assertIs<Double>(crearNumeroRandom("Double"))
    }
    @Test
    fun checkSiRetornaFloat(){
        assertIs<Float>(crearNumeroRandom("Float"))
    }
}
