import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import javafx.beans.binding.When;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.io.*;
import java.util.Scanner;

import static java.lang.System.in;
import static java.lang.System.out;
import static java.lang.System.setOut;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

/**
 * Created by Marcin on 11.03.2018.
 */

public class FileReaderHelperTest {

        @Test
        public void shouldReadContentFromFileOnClasspath() throws FileNotFoundException {
            String result = new FileReaderHelper().readFileContentFromClasspath("pdokument.txt");

            assertEquals("sdsojojsod sod osd sd s     dfkdmk  oskdokosk    oksok\r\n" +
                    "sdkoskd  sdasd sd adfd d d d  ddgdf jsk sk    sojdo\r\n" +
                    "              oskd so            sokd osk d\r\n" +
                    "              sod\r\n" +
                    "     sdsd s sd aifmklmz qsdnakmq qw d k smiej qowlamspd ", result);
        }

        @Test(expected = FileNotFoundException.class)
        public void shouldThrowAFileNotFoundExceptionWhenNoFileFound() throws FileNotFoundException {
            new FileReaderHelper().readFileContentFromClasspath("not existing file");
        }

        @Test
        public void readFileContentFromClasspathTest() throws FileNotFoundException {

            //given
            FileReaderHelper similar = new FileReaderHelper();
            //when
            String result = similar.readFileContentFromClasspath("pdokument.txt");
            //then
            Assert.assertEquals("sdsojojsod sod osd sd s     dfkdmk  oskdokosk    oksok\r\n" +
                    "sdkoskd  sdasd sd adfd d d d  ddgdf jsk sk    sojdo\r\n" +
                    "              oskd so            sokd osk d\r\n" +
                    "              sod\r\n" +
                    "     sdsd s sd aifmklmz qsdnakmq qw d k smiej qowlamspd ", result);

        }

        @Test
        public void deleteFileWhiteSpacesTest() {

            // given
            FileReaderHelper fileReaderHelper = new FileReaderHelper();
            // when
            String result = fileReaderHelper.deleteFileWhiteSpaces("sdsojojsod sod osd sd s     dfkdmk  oskdokosk    oksok\r\n" +
                    "sdkoskd  sdasd sd adfd d d d  ddgdf jsk sk    sojdo\r\n" +
                    "              oskd so            sokd osk d\r\n" +
                    "              sod\r\n" +
                    "     sdsd s sd aifmklmz qsdnakmq qw d k smiej qowlamspd ");
            // then
            Assert.assertEquals("sdsojojsodsodosdsdsdfkdmkoskdokoskoksok"+"sdkoskdsdasdsdadfddddddgdfjsksksojdo"+"oskdsosokdoskd"+"sod"+"sdsdssdaifmklmzqsdnakmqqwdksmiejqowlamspd", result);

        }
        @Test
        public void run() throws IOException{
            PrintWriter printWriter = mock(PrintWriter.class);
            String in = "pdokument.txt";
            InputStream isIn = new ByteArrayInputStream(in.getBytes());
            BufferedReader br = new BufferedReader(new InputStreamReader(isIn));
            new Appbud().run(br, printWriter);

            verify(printWriter).println("Hej zaczynamy. Podaj plik do zczytania. ");
            verify(printWriter).println("sdsojojsod sod osd sd s     dfkdmk  oskdokosk    oksok\r\n" +
                    "sdkoskd  sdasd sd adfd d d d  ddgdf jsk sk    sojdo\r\n" +
                    "              oskd so            sokd osk d\r\n" +
                    "              sod\r\n" +
                    "     sdsd s sd aifmklmz qsdnakmq qw d k smiej qowlamspd ");
            verify(printWriter).println("sdsojojsodsodosdsdsdfkdmkoskdokoskoksoksdkoskdsdasdsdadfddddddgdfjsksksojdooskdsosokdoskdsodsdsdssdaifmklmzqsdnakmqqwdksmiejqowlamspd");

        }

        @Test
        public void runEmptyFile() throws IOException{
            PrintWriter printWriter = mock(PrintWriter.class);
            String in = "dok.txt";
            InputStream isIn = new ByteArrayInputStream(in.getBytes());
            BufferedReader br = new BufferedReader(new InputStreamReader(isIn));
            new Appbud().run(br, printWriter);

            verify(printWriter).println("Hej zaczynamy. Podaj plik do zczytania. ");
            verify(printWriter).println("");
            verify(printWriter).println("");
        }

        @Test
        public void runFileWithoutSpaces() throws IOException{
            PrintWriter printWriter = mock(PrintWriter.class);
            String in = "dokumentNoSpace.txt";
            InputStream isIn = new ByteArrayInputStream(in.getBytes());
            BufferedReader br = new BufferedReader(new InputStreamReader(isIn));
            new Appbud().run(br, printWriter);

            verify(printWriter).println("Hej zaczynamy. Podaj plik do zczytania. ");
            verify(printWriter).println("loremipsumcostam");
            verify(printWriter).println("loremipsumcostam");
        }

        @Test
        public void add() {
            PrintWriter printWriter = mock(PrintWriter.class);
            new Appbud().sum(4,4, printWriter);
            verify(printWriter).println(8);

        }


//    @Test
//    public void run() throws IOException{
//        //given
//        BufferedReader bufferedReader = mock(BufferedReader.class);
//        when(bufferedReader.readLine()).thenReturn("pdokument.txt");
//
//        //when
//        String test = bufferedReader.readLine();
//        //then
//        assertEquals("pdokument.txt", test);// zamian test może być bufferedReader.readLine();
//    }
//    @Test
//    public void run() throws IOException{
//        //given
//        PrintWriter printWriter = mock(PrintWriter.class);
//        when(printWriter.toString()).thenReturn("pdokument.txt");
//        assertEquals("pdokument.txt",printWriter.toString());
//    }

        @Test
        public void whenReadUsingScanner_thenCorrectTest() throws IOException {
            String input = "pdokument.txt";
            InputStream zmienna = System.in;

            System.setIn(new ByteArrayInputStream(input.getBytes()));
            Scanner scanner = new Scanner(System.in);
            String results = scanner.nextLine();
            System.setIn(zmienna);
            Assert.assertEquals(input, results);
            scanner.close();
            out.println(input+""+results);
        }

}


