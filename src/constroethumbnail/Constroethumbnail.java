/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package constroethumbnail;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Positions;
import net.coobird.thumbnailator.name.Rename;

/**
 *
 * @author rodrigo
 */
public class Constroethumbnail {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String pathCsv = "/home/rodrigo/Documentos/Rodrigo/uploads.csv";
        String pathImagens = "/opt/Terras/uploads/imovel/1920-migrcao/";
        
        BufferedReader buffRead = null;
        try {
            buffRead = new BufferedReader(new FileReader(pathCsv));
            String linha = "";
            while (true) {
                if (linha != null) {
                    System.out.println(linha.replaceAll("\"", ""));
                    Constroethumbnail.criarMiniatura(pathImagens + linha.replaceAll("\"", ""));
                    
                } else {
                    break;
                }
                linha = buffRead.readLine();
            }
            buffRead.close();
        } catch (Exception ex) {
            Logger.getLogger(Constroethumbnail.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    public static void criarMiniatura(String caminhoImagem) {
        try {
            Thumbnails.of(new File(caminhoImagem)).crop(Positions.CENTER).size(60, 60).toFiles(Rename.PREFIX_DOT_THUMBNAIL);
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }

}
