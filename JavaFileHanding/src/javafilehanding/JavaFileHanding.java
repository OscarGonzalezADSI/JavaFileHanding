/*
 * Copyright (C) 2020 oscarGonzalezADSI
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package javafilehanding;
import java.io.File;  // Import the File class
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;  // Import the IOException class to handle errors
import java.util.Scanner;
/**
 *
 * @author oscarGonzalezADSI
 */
public class JavaFileHanding {
    /**
     * @param args the command line arguments
     */
    
    private static String Constructor(String FileName, String Contenido) {
        String CreaArchivo = CreateFile(FileName);
        String Escritura = WriteToFile(FileName, Contenido);
        String Lectura = ReadFile(FileName);
        String Borrado = DeleteFile(FileName);
        String Salida = CreaArchivo +"\n\n"+
                           Escritura +"\n\n"+
                           Lectura +"\n\n"+
                           Borrado;
        return Salida;
    }
    
    public static void main(String[] args) {
        String FileName = "filename.csv";
        String Contenido = "contenido";
        String Salida = Constructor(FileName, Contenido);
        Imprimir(Salida);
    }
    
    private static void Imprimir(String Contenido) {
        System.out.println(Contenido);
    }
    
    private static String CreateFile(String FileName) {
        String Salida;
        try {
            File myObj = new File(FileName);
            if (myObj.createNewFile()) {
                Salida = "Archivo a crear: " + myObj.getName();
            } else {
                Salida = "El archivo ya existe." +"\n"+ myObj.getAbsolutePath();
            }
        } catch (IOException e) {
            Salida = "Ha ocurrido un error. main";
            e.printStackTrace();
        }
        return Salida;
    }
    
    private static String WriteToFile(String FileName, String contenido) {
        String Salida;
        try {  
            FileWriter myWriter = new FileWriter(FileName);
            myWriter.write(contenido);
            myWriter.close();
            Salida = "Successfully wrote to the file.";
        } catch (IOException e) {
            Salida = "Ha ocurrido un error. WriteToFile";
            e.printStackTrace();
        }
        return Salida;
    } 

    private static String ReadFile(String FileName) {
        String Salida= "";        
        try {
            File myObj2 = new File(FileName);
            Scanner myReader = new Scanner(myObj2);
            while (myReader.hasNextLine()) {
                Salida += myReader.nextLine();
            }
            myReader.close();
        }catch (FileNotFoundException e) {
            Salida = "Ha ocurrido un error. ReadFile";
            e.printStackTrace();
        }
        return Salida;        
    }

    private static String DeleteFile(String FileName) {
        String Salida;
        File myObj = new File(FileName);
        if (myObj.delete()) {
            Salida = "Archivo borrado: " + myObj.getName();
        } else {
            Salida = "Se ha fallado en el intento de borrar el archivo.";
        }
        return Salida;
    }
   
}
