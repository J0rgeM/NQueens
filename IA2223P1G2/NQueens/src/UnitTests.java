import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import org.junit.Test;

public class UnitTests {
    @Test
    public void testConstructor() throws IOException {
        Path resultext = Path.of("C:/Users/rober/OneDrive/Ambiente de Trabalho/UAlg/5º Semestre/Inteligência Artificial/NQueens/src/result.txt");
        String text = "";
        LocalSearch a = new LocalSearch();
        int rounds = 1;
        float result = 0;
        int n = 100; // começa com 100 queens
        int avg = 10; // media
        int var = 100; // variacao 
        int limit = 2000; // limit test

        while (n <= limit) {
            text += n + " queens, resultados com base em media de " + avg + " em variações de " + var + "\n";
            text += "Resultados em separado:" + "\n";
            for (int i = 0; i < avg; i++) {
                long startTime = System.nanoTime();
                Ilayout solution = a.solve(new Board(n));
                long endTime = System.nanoTime();
                text += solution.isGoal() + " -> ";
                result += ((float) (endTime - startTime) / 1000000000);
                text += (float) (endTime - startTime) / 1000000000 + " Seconds" + "\n";
            }
            text += "Resultado da media:" + "\n";
            text += result / avg + " Segundos" + "\n" + "\n";
            if(rounds == 5){ // passado 5 rondas deminiu a avg pa 5 e a var para 250
                var = 250;
                avg = 5;
            }
            n = n + var;
            result = 0;
            rounds++;
        }

        Files.writeString(resultext, text);
    }
}
