package sample;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class FilePersistence {

    /***
     * Atributos
     */
    private Path path;
    private File file;
    private String nameFile;
    private String pathFile;

    /***
     * Metodo get path
     * @return path
     */
    public Path getPath() {
        return path;
    }

    /***
     * Metodo get file
     * @return file
     */
    public File getFile() {
        return file;
    }

    /***
     * metodo set file
     * @param file file
     */
    public void setFile(File file) {
        this.file = file;
    }

    /***
     * metodo get name file
     * @return name file
     */
    public String getNameFile() {
        return nameFile;
    }

    /***
     * metodo set name file
     * @param nameFile name file
     */
    public void setNameFile(String nameFile) {
        this.nameFile = nameFile;
    }

    /***
     * Metodo get path file
     * @return path file
     */
    public String getPathFile() {
        return pathFile;
    }

    /***
     * metodo set path file
     * @param pathFile path file
     */
    public void setPathFile(String pathFile) {
        this.pathFile = pathFile;
    }

    /***
     * metodo para poder abriri el archivo
     */
    public void openFile(){
        path = Paths.get(pathFile+nameFile);
    }

    /***
     * Metodo para poder leer el archivo
     * @return salida del archivo
     * @throws IOException excepcion por lectira de archivo
     */
    public String readFile() throws IOException {
        BufferedReader input = Files.newBufferedReader(path, Charset.defaultCharset());
        StringBuilder output = new StringBuilder();
        String line = null;
        while((line = input.readLine())!=null) {
            output.append(line +"\n");
        }
        input.close();
        return output.toString();
    }

    /***
     * Metod para escribi el rachivo
     * @param content el contenido del archivo
     * @throws IOException excepcion por lectura de archivo
     */
    public void writeFile (String content) throws IOException {
        BufferedWriter output = Files.newBufferedWriter(path, Charset.defaultCharset(),
                StandardOpenOption.WRITE, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
        output.write(content);
        output.close();
    }

}
