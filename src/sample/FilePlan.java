package sample;

import java.io.IOException;
import java.util.StringTokenizer;

public class FilePlan extends FilePersistence{

    /***
     * Metodo get contenido del archivo
     * @return el contenedor del archivo (vector)
     * @throws IOException excepcion por carga de panel
     */
    public String [] getContentFile() throws IOException {
        String content = readFile();
        StringTokenizer Lines = new StringTokenizer(content, "\n");
        String [] outPut = new String[Lines.countTokens()];
        int cont =0;
        while (Lines.hasMoreTokens()){
            outPut[cont ++] = Lines.nextToken();
        }
        return outPut;
    }

    /***
     * Contenido del archivo
     * @param content el contendio del archivo
     * @throws IOException excepcion por carga de archivo
     */
    public void setContentFile(String...content) throws IOException {
        StringBuilder dump = new StringBuilder();
        for(String line: content) {
            dump.append(line + "\n");
        }
        writeFile(dump.toString());
    }
}
