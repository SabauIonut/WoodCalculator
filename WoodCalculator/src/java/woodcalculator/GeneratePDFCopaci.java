
package woodcalculator;

import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import java.io.File;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.RoundingMode;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Sabau Ionut
 */
public class GeneratePDFCopaci {
    
    public void generate(File path, String fileName, String user, String data) throws FileNotFoundException, DocumentException, BadElementException, IOException{
     
       try{
            String file_name = path.toString();

            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream(file_name));

            document.open();
            //add the "WoodCalculator" logo
            Font fontLogo = new Font(Font.FontFamily.TIMES_ROMAN, 30, Font.BOLD, new BaseColor(0, 0, 0));
            Paragraph logo = new Paragraph("WoodCalculator",fontLogo);
            logo.add("\n\n");
            logo.setAlignment(Element.ALIGN_CENTER);
            document.add(logo);
            
            //add header
            Font fontHeader = new Font(Font.FontFamily.TIMES_ROMAN, 15, Font.BOLD, new BaseColor(0, 0, 0));
            Paragraph header = new Paragraph();
            
                //add filename
                header.add("\n"+"Nume fisier: ");  
                header.add(new Chunk(fileName, fontHeader));
                //add username
                header.add("\nUtilizator: ");  
                header.add(new Chunk(user, fontHeader));
                 //date of file
                header.add("\nData: "); 
                header.add(new Chunk(data, fontHeader));
                header.add("\n\n"); 
            
            document.add(header);

            //add image
            Paragraph image = new Paragraph();
            String url = "C:/Users/Sabau Ionut/OneDrive/Desktop/Proiect/WoodCalculator/WoodCalculatorLogin/imagini/copac115.png";
            Image img = Image.getInstance(url);
            img.setAlignment(Element.ALIGN_CENTER);
            image.add(img);
            document.add(image);
            
            //add data as a table
            PdfPTable table = new PdfPTable(6);
            
            PdfPCell c1 = new PdfPCell(new Phrase("Nr.crt."));
            table.addCell(c1);
            
            c1 = new PdfPCell(new Phrase("Nr. buc."));
            table.addCell(c1);
            
            c1 = new PdfPCell(new Phrase("Specie"));
            table.addCell(c1);
            
            c1 = new PdfPCell(new Phrase("Inaltime"));
            table.addCell(c1);
            
            c1 = new PdfPCell(new Phrase("Diametru piept"));
            table.addCell(c1);
            
            c1 = new PdfPCell(new Phrase("Volum"));
            table.addCell(c1);
            
            table.setHeaderRows(1);
            
            PreparedStatement st;
            ResultSet rs;
            String query = "SELECT * FROM `copaci` WHERE `username` = ? AND `fname`= ?";
            
            try{
                st = My_CNX.getConnection().prepareStatement(query);
        
                st.setString(1, user);
                st.setString(2, fileName);
                rs = st.executeQuery();
                
                Double VolumTotal = 0.0;
                Integer nrCrt =1;
                while(rs.next()){
                
                    String nrBuc = (String)rs.getString("cantitate");
                    String specie = (String)rs.getString("specie");
                    String inaltime = (String)rs.getString("inaltime");
                    String diametrupiept = (String)rs.getString("diametrupiept");
                    String volum = (String)rs.getString("volum");
                    
                    VolumTotal += Double.parseDouble(volum);
                    
                    table.addCell(nrCrt.toString());
                    table.addCell(nrBuc);
                    table.addCell(specie);
                    table.addCell(inaltime);
                    table.addCell(diametrupiept);
                    table.addCell(volum);
                    
                    nrCrt++;
                    
                }
                
                document.add(table);
                
                Font fontVolumTotal = new Font(Font.FontFamily.TIMES_ROMAN, 20, Font.BOLD, new BaseColor(0, 0, 0));
                Paragraph volumTotal = new Paragraph();
                volumTotal.setAlignment(Element.ALIGN_CENTER);
                
                DecimalFormatSymbols dfs = new DecimalFormatSymbols(Locale.getDefault());
                dfs.setDecimalSeparator('.');
                DecimalFormat df = new DecimalFormat("0.00", dfs);
                df.setRoundingMode(RoundingMode.HALF_DOWN);
                String x = df.format(VolumTotal);
                
                volumTotal.add(new Chunk("\n\nVolum total: "+ x +" mc", fontVolumTotal));
                document.add(volumTotal);

            }
            catch(SQLException ex){
                Logger.getLogger(LoginForm.class.getName()).log(Level.SEVERE,null,ex);
            }
          
            document.close();
       }catch(DocumentException | FileNotFoundException e){
           System.err.println(e);
       }
       
    }
    
}
