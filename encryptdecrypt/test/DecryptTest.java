package encryptdecrypt.test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import encryptdecrypt.Decrypt;
import encryptdecrypt.Parameter;
import org.junit.jupiter.api.Test;

class DecryptTest {
    @Test
    public void decryptTextWithDataAlgDefault() {
        Parameter parameter = new Parameter("dec", 5, "maciej", "", "","");

        Decrypt decrypt = new Decrypt(parameter);
        assertEquals("hvxdze", decrypt.cipherText("maciej"));
        assertEquals("Rdove Hvxdze   !@#..uuu", decrypt.cipherText("Witaj Maciej   !@#..zzz"));
    }

}