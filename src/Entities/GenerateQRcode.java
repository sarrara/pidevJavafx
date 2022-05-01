/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Sarra
 */
public class GenerateQRcode {

private static final String OutputQr="C:\\sarra.png" ;
private static void qr (Object x, int width, int height, String filePath) throws WriterException, IOException{
QRCodeWriter qe = new QRCodeWriter ();
BitMatrix bm = qe.encode ((String) x, BarcodeFormat.QR_CODE, width, height) ;
Path pobj = FileSystems.getDefault().getPath(filePath) ;

MatrixToImageWriter.writeToPath(bm, "PNG", pobj);
}

/*public statie void main(String [] args) {
generategRcode ("My Name is Andres P. t);

}*/
}