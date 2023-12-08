package Dental_clinic;
import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javax.imageio.ImageIO;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;

/**
 *
 * @author_ZRD
 */
public class Dental_Clinic extends Application {
    Scene Lock_Screen, Homepage,INFO , FORM, Search,REVIEW, search_Job,Search_EDIT_CUSTOMER,Review_EDIT_CUSTOMER,TREATMENT;
    Alert Message = new Alert();

           public static ObservableList<name_Person> getPhone(String Phone) throws FileNotFoundException{
        ObservableList<name_Person> data_Phone = FXCollections.observableArrayList(); 
        try {
               FileInputStream fis = new FileInputStream(new File("F://Present/new.xlsx"));
        Workbook wb = WorkbookFactory.create(fis);
        Sheet sh = wb.getSheetAt(0);
        int i=0;
        while(true){
if(String.valueOf(sh.getRow(i).getCell(2)).contains(Phone)){
          data_Phone.add(new name_Person(String.valueOf(i+1),String.valueOf(sh.getRow(i).getCell(0)),String.valueOf(sh.getRow(i).getCell(2)),String.valueOf(sh.getRow(i).getCell(5)), String.valueOf(sh.getRow(i).getCell(4)),String.valueOf(sh.getRow(i).getCell(3))));                  
        }             
    if(i>sh.getLastRowNum()-1){
                break;

    }else{
         i++;

    }
        }
        } catch (IOException | InvalidFormatException ex) {
            Logger.getLogger(person.class.getName()).log(Level.SEVERE, null, ex);
        }
        return data_Phone;
    }
             public static ObservableList<name_Person> getName(String Name) throws FileNotFoundException {
        ObservableList<name_Person> data_Name = FXCollections.observableArrayList();
 
        try {
               FileInputStream fis = new FileInputStream(new File("F://Present/new.xlsx"));
        Workbook wb = WorkbookFactory.create(fis);
        Sheet sh = wb.getSheetAt(0);
        int i=0;
        while(true){
if(String.valueOf(sh.getRow(i).getCell(0)).contains(Name)){
          data_Name.add(new name_Person(String.valueOf(i+1),String.valueOf(sh.getRow(i).getCell(0)),String.valueOf(sh.getRow(i).getCell(2)),String.valueOf(sh.getRow(i).getCell(5)), String.valueOf(sh.getRow(i).getCell(4)),String.valueOf(sh.getRow(i).getCell(3))));                  
        }             
    if(i>sh.getLastRowNum()-1){
                break;

    }else{
         i++;

    }
        }
     
    

        } catch (IOException | InvalidFormatException ex) {
            Logger.getLogger(person.class.getName()).log(Level.SEVERE, null, ex);
        }
        return data_Name;
    }
  public static ObservableList<person> getProducts(String JOB) throws FileNotFoundException{
        ObservableList<person> data = FXCollections.observableArrayList(); 
        try {
               FileInputStream fis = new FileInputStream(new File("F://Present//new.xlsx"));
        Workbook wb = WorkbookFactory.create(fis);
        Sheet sh = wb.getSheetAt(0);
        int i=0;
        while(true){
if(String.valueOf(sh.getRow(i).getCell(4)).contains(JOB)){
          data.add(new person(String.valueOf(i+1),String.valueOf(sh.getRow(i).getCell(0)),String.valueOf(sh.getRow(i).getCell(2)),String.valueOf(sh.getRow(i).getCell(5)), String.valueOf(sh.getRow(i).getCell(4)),String.valueOf(sh.getRow(i).getCell(3))));                  
        }             
    if(i>sh.getLastRowNum()-1){
                break;
    }else{
         i++;

    }
        }
        } catch (IOException | InvalidFormatException ex) {
            //Logger.getLogger(person.class.getName()).log(Level.SEVERE, null, ex);
        }
        return data;
    }
    @Override
    public void start(Stage Window) {
//        create_folder("mohamed","01098220511");
        Window.getIcons().add(new Image("file:../icon.jpg"));
        Window.setTitle("Log in");
        Window.setScene(Lock_screen(Window));
        Window.show();
    }
    public void create_folder(String Folder_number) {
          File DIR = new File("F://Present//client_folder//"+Folder_number);//‪F:\Present\client_folder  
        if (!DIR.exists()) {
            if (DIR.mkdir()) {
              Alert.display("successful", "the FOLDER has been created");

            } else {
                Alert.display("Warning!!", "the FOLDER has been FAIL to created");

            }
        }else{
            
                     Alert.display("folder fail", "folder is already here");

        }
    }
     public String [] read_and_Search_on_EX_EQUAL(String Name, String phone) throws Exception {
        String[] array=new String[6];
         array[0]="false";
        array[1]="false";
        boolean check=false;
        FileInputStream fis = new FileInputStream(new File("F://Present//new.xlsx"));
        Workbook wb = WorkbookFactory.create(fis);
        Sheet sh = wb.getSheetAt(0);
        int i=0;
        while(true){
            String Ph=(String.valueOf(sh.getRow(i).getCell(2)));
            if(Ph.length()>2){
//                System.out.println("ohh"+sh.getRow(i).getCell(2));
             Ph=(String.valueOf(sh.getRow(i).getCell(2))).replace(".","");
            }
//            System.out.println("ph: "+Ph);
//            System.out.println("Name: "+String.valueOf(sh.getRow(i).getCell(0)));

if(String.valueOf(sh.getRow(i).getCell(0)).equalsIgnoreCase(Name)&&Ph.contains(phone)){
              check=true;              
                array[1]=String.valueOf(sh.getRow(i).getCell(0));
                if(Ph.length()>2){
                array[2]=(String.valueOf(sh.getRow(i).getCell(2))).replace(".","");
            }else{
                    array[2]=(String.valueOf(sh.getRow(i).getCell(2))).replace(".","");
                }
                    array[0]=String.valueOf(i);                
                    array[3]=String.valueOf(sh.getRow(i).getCell(3));
                    array[4]=String.valueOf(sh.getRow(i).getCell(4));
                    array[5]=String.valueOf(sh.getRow(i).getCell(5));
        
        }
        if(check){
        break;        
    }          
    if(i>sh.getLastRowNum()-1){
                break;

    }else{
         i++;

    }
        }
      
    return array;
    }
    public String [] read_and_Search_on_EX(String Name, String phone) throws Exception {
        String[] array=new String[6];
         array[0]="false";
        array[1]="false";
        boolean check=false;
        FileInputStream fis = new FileInputStream(new File("F://Present//new.xlsx"));
        Workbook wb = WorkbookFactory.create(fis);
        Sheet sh = wb.getSheetAt(0);
        int i=0;
        while(true){
            String Ph=(String.valueOf(sh.getRow(i).getCell(2)));
            if(Ph.length()>2){
//                System.out.println("ohh"+sh.getRow(i).getCell(2));
             Ph=(String.valueOf(sh.getRow(i).getCell(2))).replace(".","");
            }
//            System.out.println("ph: "+Ph);
//            System.out.println("Name: "+String.valueOf(sh.getRow(i).getCell(0)));

if(String.valueOf(sh.getRow(i).getCell(0)).contains(Name)&&Ph.contains(phone)){
              check=true;              
                array[1]=String.valueOf(sh.getRow(i).getCell(0));
                if(Ph.length()>2){
                array[2]=(String.valueOf(sh.getRow(i).getCell(2))).replace(".","");
            }else{
                    array[2]=(String.valueOf(sh.getRow(i).getCell(2))).replace(".","");
                }
                    array[0]=String.valueOf(i);                
                    array[3]=String.valueOf(sh.getRow(i).getCell(3));
                    array[4]=String.valueOf(sh.getRow(i).getCell(4));
                    array[5]=String.valueOf(sh.getRow(i).getCell(5));
        
        }
        if(check){
        break;        
    }          
    if(i>sh.getLastRowNum()-1){
                break;

    }else{
         i++;

    }
        }
      
    return array;
    }
   public String [] special_read(String NUM) throws Exception{
               String[] array=new String[6];
        FileInputStream fis = new FileInputStream(new File("F://Present//new.xlsx"));
                Workbook wb = WorkbookFactory.create(fis);
        Sheet sh = wb.getSheetAt(0);
        
               if((Integer.valueOf(NUM)-1)<sh.getLastRowNum()+1){
array[1]=String.valueOf(sh.getRow(Integer.valueOf(NUM)-1).getCell(0));
                    array[2]=(String.valueOf(sh.getRow(Integer.valueOf(NUM)-1).getCell(2)));

 array[0]=String.valueOf(Integer.valueOf(NUM)-1);                
                    array[3]=String.valueOf(sh.getRow(Integer.valueOf(NUM)-1).getCell(3));
                    array[4]=String.valueOf(sh.getRow(Integer.valueOf(NUM)-1).getCell(4));
                    array[5]=String.valueOf(sh.getRow(Integer.valueOf(NUM)-1).getCell(5));}else{
                                       Alert.display("Warning!!", "this num doesn't exists");                                        

                   
               }
                    return array;
   }
     public String [] read_and_Search_on_EX_By_Phone(String phone) throws Exception {       
        String[] array=new String[6];
         array[0]="false";
        array[1]="false";
        boolean check=false;
        FileInputStream fis = new FileInputStream(new File("F://Present//new.xlsx"));
        Workbook wb = WorkbookFactory.create(fis);
        Sheet sh = wb.getSheetAt(0);
        int i=0;
        while(true){
            String Ph=(String.valueOf(sh.getRow(i).getCell(2)));
            if(Ph.length()>2){
             Ph=(String.valueOf(sh.getRow(i).getCell(2))).replace(".","");
            }
if(Ph.contains(phone)){
              check=true;              
                array[1]=String.valueOf(sh.getRow(i).getCell(0));
                if(Ph.length()>2){
                array[2]=(String.valueOf(sh.getRow(i).getCell(2))).replace(".","");
            }else{
                    array[2]=(String.valueOf(sh.getRow(i).getCell(2))).replace(".","");
                }
                    array[0]=String.valueOf(i);                
                    array[3]=String.valueOf(sh.getRow(i).getCell(3));
                    array[4]=String.valueOf(sh.getRow(i).getCell(4));
                    array[5]=String.valueOf(sh.getRow(i).getCell(5));
        }
        if(check){
        break;        
    }          
    if(i>sh.getLastRowNum()-1){
                break;

    }else{
         i++;

    }
        }
      
    return array;
    }
     public Scene Search_EDIT_CUSTOMER(Stage Window){
          TextField NAME = new TextField();
        NAME.setMaxWidth(200);        
        TextField Phone = new TextField();
        Phone.setMaxWidth(200);
Label NAME_TXT=new Label("");
NAME_TXT.setText("NAME:");
        Label PHONE_TXT = new Label();
        PHONE_TXT.setText("PHONE +20:");
           Button search = new Button();
        search.setText("Search");
        Button Back = new Button();
        Back.setText("Back");
        HBox Name=new HBox(80);   
        HBox PHONE=new HBox(40);   
        VBox BUTTON=new VBox(60);   
                Name.getChildren().addAll(NAME_TXT,NAME);
                PHONE.getChildren().addAll(PHONE_TXT,Phone);
                BUTTON.getChildren().addAll(search,Back);
        VBox DATA = new VBox(25);     
        DATA.getChildren().addAll(Name, PHONE);
        Back.setOnAction((ActionEvent event) -> {
            try {
                Window.setScene(Homepage(Window));
                Window.setTitle("HOME");
                
            } catch (Exception ex) {
                Logger.getLogger(Dental_Clinic.class.getName()).log(Level.SEVERE, null, ex);
            }
          });
        search.setOnAction((ActionEvent event) -> {
            try {
                String array[] = null;
                if(!NAME.getText().isEmpty()&&!Phone.getText().isEmpty()){
                                      array=read_and_Search_on_EX_EQUAL(NAME.getText(),Phone.getText());
                     if(array[0].equalsIgnoreCase("false")){                    
                    array=read_and_Search_on_EX(NAME.getText(),Phone.getText());}
                }else if(NAME.getText().isEmpty()&&!Phone.getText().isEmpty()){
                    array=read_and_Search_on_EX_By_Phone(Phone.getText());                    
                }else if(!NAME.getText().isEmpty()&&Phone.getText().isEmpty()){
                    Alert.display("Warning!!", "you didn't put phone Number");                                        
                }else{
                    Alert.display("Warning!!", "you didn't put Name or phone ");
                    
                }
                if(Arrays.deepToString(array).equalsIgnoreCase("null")){
                    
                }else{
                    if(array[0].equals("false")){
                        
                        Alert.display("(404 NOT FOUND)", "We couldn't find the name on CSV");
                        
                    }else{
                        Window.setScene(Review_EDIT_CUSTOMER(Window, array,Search_EDIT_CUSTOMER(Window)));
                        Window.setTitle("");
                    }

                }
            } catch (Exception ex) {
                Logger.getLogger(Dental_Clinic.class.getName()).log(Level.SEVERE, null, ex);
            }
          });
        BorderPane root = new BorderPane();
        DATA.setPadding(new Insets(90, 0, 0, 100));
        BUTTON.setPadding(new Insets(80, 350, 0, 0));
        root.setCenter(DATA);
        root.setRight(BUTTON);
        this.Search_EDIT_CUSTOMER = new Scene(root, 1300, 1300);
        String css_Search_EDIT_CUSTOMER = Dental_Clinic.class.getResource("Search_EDIT_CUSTOMER.css").toExternalForm();
        this.Search_EDIT_CUSTOMER.getStylesheets().add(css_Search_EDIT_CUSTOMER);
        return this.Search_EDIT_CUSTOMER;         
     }
               int counter = 0; 
public int count()
{
    counter++;
    return counter;
}
public int count_(int counter)
{
    this.counter=counter;
    return counter;
}
public int count_0()
{
    counter=0;
    return counter;
}
public boolean check_tabel(String Word,ObservableList<Treatment> Data){
    boolean check=true;
    Treatment T=new Treatment();
    if(Data.size()>=12){
    check=false;
    
    }else{
    for (int i = 0; i < Data.size(); i++) {
        T=Data.get(i);
        if(T.getName_Treatment().equalsIgnoreCase(Word)){
            check=false;
            
        }
    }       } 
    return check;
    
}
     public Scene ADD_TREATMENT(Stage Window,String array[],Scene back){
         TableView<Treatment>table3;

          TableColumn<Treatment,String> Number = new TableColumn<>("Number");
        Number.setMinWidth(100);
 Number.setCellValueFactory(
                new PropertyValueFactory<>("Number"));
 Number.getStyleClass().add("TableColumn");
  TableColumn<Treatment,String> Name_Treatment = new TableColumn<>("Name_Treatment");
        Name_Treatment.setMinWidth(200);
 Name_Treatment.setCellValueFactory(
                new PropertyValueFactory<>("Name_Treatment"));
 Name_Treatment.getStyleClass().add("TableColumn");
  TableColumn<Treatment,String> Time = new TableColumn<>("Times");
        Time.setMinWidth(200);
 Time.setCellValueFactory(
                new PropertyValueFactory<>("Time"));
 Time.getStyleClass().add("TableColumn");
         table3 = new TableView<>(); 
         table3.setEditable(true);
          Time.setCellFactory(TextFieldTableCell.forTableColumn());
          Time.setOnEditCommit(new EventHandler<CellEditEvent<Treatment, String>>(){
             @Override
             public void handle(CellEditEvent<Treatment, String> event) {
                 Treatment T;
                 T=event.getRowValue();
                 T.setTime(event.getNewValue());
             }
              
          });
table3.getColumns().addAll(Number, Name_Treatment, Time);
table3.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
 Label name=new Label("NAME: "+array[1]);
 Label Phone=new Label("PHONE: +20"+array[2]);
 Label AGE=new Label("AGE: "+array[3]);
 Label Address=new Label("ADD: "+array[5]);
 Label JOB=new Label("JOB: "+array[4]);
 Button BACK=new Button("BACK");
 BACK.setOnAction((ActionEvent event) -> {
     Window.setScene(back);
     count_0();
         });
 VBox data_client=new VBox(20);
 data_client.getChildren().addAll(name,Phone,AGE,Address,JOB,BACK);
 ////////////////////////////////////////////////////////////////////
 Button Amrizol_Surp=new Button("Amrizol Surp");
 Amrizol_Surp.setOnAction((ActionEvent event) -> {
     String Data[]=new String[3];
     Data[1]="Amrizol Surp";
     Data[2]="معلقة كل (12) ساعة";
     
             try {
                if (check_tabel(Data[1],table3.getItems())){
                         Data[0]=String.valueOf(count());

                 table3.getItems().add(new Treatment(Data[0],Data[1],Data[2]));}else{
                    if(table3.getItems().size()>=12){
                   Alert.display("Warning!!", "max 12 Treatment!!");

                        
                    }else{
                    Alert.display("Warning!!", "you already add it");    
                    }
                }
             } catch (Exception ex) {
                 Logger.getLogger(Dental_Clinic.class.getName()).log(Level.SEVERE, null, ex);
             }
         });
 Button Amrizole_500mg=new Button("Amrizol 500mg");
  Amrizole_500mg.setOnAction((ActionEvent event) -> {
     String Data[]=new String[3];
     Data[1]="Amrizol 500mg";
     Data[2]="قرص كل  (12) ساعة";
     
             try {
                  if (check_tabel(Data[1],table3.getItems())){
                           Data[0]=String.valueOf(count());
                 table3.getItems().add(new Treatment(Data[0],Data[1],Data[2]));}else{
                                     if(table3.getItems().size()>=12){
                   Alert.display("Warning!!", "max 12 Treatment!!");

                        
                    }else{
                    Alert.display("Warning!!", "you already add it");    
                    }
                    
                }
             } catch (Exception ex) {
                 Logger.getLogger(Dental_Clinic.class.getName()).log(Level.SEVERE, null, ex);
             }
         });
  Button Alphenterin=new Button("Alphenterin");
   Alphenterin.setOnAction((ActionEvent event) -> {
     String Data[]=new String[3];
     Data[1]="Alphenterin";
     Data[2]="(2) قرص كل (8) ساعات";
     
             try {
     if (check_tabel(Data[1],table3.getItems())){
     Data[0]=String.valueOf(count());

                 table3.getItems().add(new Treatment(Data[0],Data[1],Data[2]));}else{
          if(table3.getItems().size()>=12){
                   Alert.display("Warning!!", "max 12 Treatment!!");

                        
                    }else{
                    Alert.display("Warning!!", "you already add it");    
                    }
                    
                }
             } catch (Exception ex) {
                 Logger.getLogger(Dental_Clinic.class.getName()).log(Level.SEVERE, null, ex);
             }
         });
 Button Betadine_mouth_wash=new Button("Betadine Mouth wash");
   Betadine_mouth_wash.setOnAction((ActionEvent event) -> {
     String Data[]=new String[3];
     Data[1]="Betadine Mouth wash";
     Data[2]="مضمضة (3) مرات يوميا";
     
             try {
                 if (check_tabel(Data[1],table3.getItems())){
                          Data[0]=String.valueOf(count());
                 table3.getItems().add(new Treatment(Data[0],Data[1],Data[2]));}else{
                      if(table3.getItems().size()>=12){
                   Alert.display("Warning!!", "max 12 Treatment!!");

                        
                    }else{
                    Alert.display("Warning!!", "you already add it");    
                    }
                    
                }
             } catch (Exception ex) {
                 Logger.getLogger(Dental_Clinic.class.getName()).log(Level.SEVERE, null, ex);
             }
         });
 Button Bibrufenicl_tab=new Button("Bibrufenid tab");
    Bibrufenicl_tab.setOnAction((ActionEvent event) -> {
     String Data[]=new String[3];
     Data[1]="Bibrufenid tab";
     Data[2]="قرص كل (8) ساعات او عند اللزوم";
     
             try {
           if (check_tabel(Data[1],table3.getItems())){
     Data[0]=String.valueOf(count());

                 table3.getItems().add(new Treatment(Data[0],Data[1],Data[2]));}else{
                if(table3.getItems().size()>=12){
                   Alert.display("Warning!!", "max 12 Treatment!!");

                        
                    }else{
                    Alert.display("Warning!!", "you already add it");    
                    }
                    
                }
             } catch (Exception ex) {
                 Logger.getLogger(Dental_Clinic.class.getName()).log(Level.SEVERE, null, ex);
             }
         });
 Button Brufen_400mg=new Button("Brufen 400mg");
     Brufen_400mg.setOnAction((ActionEvent event) -> {
     String Data[]=new String[3];
     Data[1]="Brufen 400mg";
     Data[2]="قرص كل (8) ساعات او عند اللزوم";
     
             try {
                       if (check_tabel(Data[1],table3.getItems())){
                                Data[0]=String.valueOf(count());
                 table3.getItems().add(new Treatment(Data[0],Data[1],Data[2]));}else{
                            if(table3.getItems().size()>=12){
                   Alert.display("Warning!!", "max 12 Treatment!!");

                        
                    }else{
                    Alert.display("Warning!!", "you already add it");    
                    }
                    
                }
             } catch (Exception ex) {
                 Logger.getLogger(Dental_Clinic.class.getName()).log(Level.SEVERE, null, ex);
             }
         });
 Button Catadly_surp=new Button("Catafly Surp");
      Catadly_surp.setOnAction((ActionEvent event) -> {
     String Data[]=new String[3];
     Data[1]="Catafly Surp";
     Data[2]="معلقة عند اللزوم";
     
             try {
                  if (check_tabel(Data[1],table3.getItems())){
     Data[0]=String.valueOf(count());

                 table3.getItems().add(new Treatment(Data[0],Data[1],Data[2]));}else{
                       if(table3.getItems().size()>=12){
                   Alert.display("Warning!!", "max 12 Treatment!!");

                        
                    }else{
                    Alert.display("Warning!!", "you already add it");    
                    }
                    
                }
             } catch (Exception ex) {
                 Logger.getLogger(Dental_Clinic.class.getName()).log(Level.SEVERE, null, ex);
             }
         });
 Button Cataflam_50mg=new Button("Cataflam 50mg");
       Cataflam_50mg.setOnAction((ActionEvent event) -> {
     String Data[]=new String[3];
     Data[1]="Cataflam 50mg";
     Data[2]="قرص كل (8) ساعات او عند اللزوم";
     
             try {
                          if (check_tabel(Data[1],table3.getItems())){
                                   Data[0]=String.valueOf(count());
                 table3.getItems().add(new Treatment(Data[0],Data[1],Data[2]));}else{
                               if(table3.getItems().size()>=12){
                   Alert.display("Warning!!", "max 12 Treatment!!");

                        
                    }else{
                    Alert.display("Warning!!", "you already add it");    
                    }
                    
                }
             } catch (Exception ex) {
                 Logger.getLogger(Dental_Clinic.class.getName()).log(Level.SEVERE, null, ex);
             }
         });
       Button Cephatraxion_sandos=new Button("Cephatraxion(sandos)1gm Amp");
        Cephatraxion_sandos.setOnAction((ActionEvent event) -> {
     String Data[]=new String[3];
     Data[1]="Cephatraxion (sandos) 1gm Amp";
     Data[2]="حقنة واحدة في اليوم بعد اختبار الحساسية لمدة (3) ايام";
     
             try {
                           if (check_tabel(Data[1],table3.getItems())){
                                    Data[0]=String.valueOf(count());

                 table3.getItems().add(new Treatment(Data[0],Data[1],Data[2]));}else{
                                if(table3.getItems().size()>=12){
                   Alert.display("Warning!!", "max 12 Treatment!!");

                        
                    }else{
                    Alert.display("Warning!!", "you already add it");    
                    }
                    
                }
             } catch (Exception ex) {
                 Logger.getLogger(Dental_Clinic.class.getName()).log(Level.SEVERE, null, ex);
             }
         });
        Cephatraxion_sandos.getStyleClass().add("sandos");
 Button Clindom_300mg=new Button("Clindam 300mg");
    Clindom_300mg.setOnAction((ActionEvent event) -> {
     String Data[]=new String[3];
     Data[1]="Clindam 300mg";
     Data[2]="(2) قرص اول مرة ثم كل قرص (8) ساعات";
     
             try {
                   if (check_tabel(Data[1],table3.getItems())){
                            Data[0]=String.valueOf(count());

                 table3.getItems().add(new Treatment(Data[0],Data[1],Data[2]));}else{
                        if(table3.getItems().size()>=12){
                   Alert.display("Warning!!", "max 12 Treatment!!");

                        
                    }else{
                    Alert.display("Warning!!", "you already add it");    
                    }
                    
                }
             } catch (Exception ex) {
                 Logger.getLogger(Dental_Clinic.class.getName()).log(Level.SEVERE, null, ex);
             }
         });
 Button Dalacin_C_300mg=new Button("Dalacin C 300mg");
  Dalacin_C_300mg.setOnAction((ActionEvent event) -> {
     String Data[]=new String[3];
     Data[1]="Dalacin C 300mg";
     Data[2]="كبسولة كل (12) ساعة";
     
             try {
                  if (check_tabel(Data[1],table3.getItems())){
     Data[0]=String.valueOf(count());

                 table3.getItems().add(new Treatment(Data[0],Data[1],Data[2]));}else{
                     if(table3.getItems().size()>=12){
                   Alert.display("Warning!!", "max 12 Treatment!!");

                        
                    }else{
                    Alert.display("Warning!!", "you already add it");    
                    }
                }
             } catch (Exception ex) {
                 Logger.getLogger(Dental_Clinic.class.getName()).log(Level.SEVERE, null, ex);
             }
         });
 Button Deltaclave_457mg=new Button("Deltaclave 457mg");
   Deltaclave_457mg.setOnAction((ActionEvent event) -> {
     String Data[]=new String[3];
     Data[1]="Deltaclave 457mg";
     Data[2]="معلقة كل (12) ساعة";
     
             try {
                    if (check_tabel(Data[1],table3.getItems())){
                             Data[0]=String.valueOf(count());
                 table3.getItems().add(new Treatment(Data[0],Data[1],Data[2]));}else{
                     if(table3.getItems().size()>=12){
                   Alert.display("Warning!!", "max 12 Treatment!!");

                        
                    }else{
                    Alert.display("Warning!!", "you already add it");    
                    }
                }
             } catch (Exception ex) {
                 Logger.getLogger(Dental_Clinic.class.getName()).log(Level.SEVERE, null, ex);
             }
         });  
   Button Foxim_1g_AMP=new Button("Foxim 1gm Amp");
   Foxim_1g_AMP.getStyleClass().add("sandos");
   
     Foxim_1g_AMP.setOnAction((ActionEvent event) -> {
     String Data[]=new String[3];
     Data[1]="Foxim 1gm Amp";
     Data[2]="حقنة كل (12) ساعة لمدة (3) ايام";
     
             try {
                  if (check_tabel(Data[1],table3.getItems())){
                           Data[0]=String.valueOf(count());

                 table3.getItems().add(new Treatment(Data[0],Data[1],Data[2]));}else{
                     if(table3.getItems().size()>=12){
                   Alert.display("Warning!!", "max 12 Treatment!!");

                        
                    }else{
                    Alert.display("Warning!!", "you already add it");    
                    }
                }
             } catch (Exception ex) {
                 Logger.getLogger(Dental_Clinic.class.getName()).log(Level.SEVERE, null, ex);
             }
         });
 Button Hibiotic_1g=new Button("Hibiotic 1g");
  Hibiotic_1g.getStyleClass().add("sandos");
   Hibiotic_1g.setOnAction((ActionEvent event) -> {
     String Data[]=new String[3];
     Data[1]="Hibiotic 1g";
     Data[2]="كبسولة كل (12) ساعة";
     
             try {
                if (check_tabel(Data[1],table3.getItems())){
                         Data[0]=String.valueOf(count());

                 table3.getItems().add(new Treatment(Data[0],Data[1],Data[2]));}else{
                     if(table3.getItems().size()>=12){
                   Alert.display("Warning!!", "max 12 Treatment!!");

                        
                    }else{
                    Alert.display("Warning!!", "you already add it");    
                    }
                }
             } catch (Exception ex) {
                 Logger.getLogger(Dental_Clinic.class.getName()).log(Level.SEVERE, null, ex);
             }
         });
 Button Hibiotic_457mg=new Button("Hibiotic 457mg");
   Hibiotic_457mg.setOnAction((ActionEvent event) -> {
     String Data[]=new String[3];
     Data[1]="Hibiotic 457mg";
     Data[2]="معلقة كل (12) ساعة";
     
             try {
                                 if (check_tabel(Data[1],table3.getItems())){

                  Data[0]=String.valueOf(count());

                 table3.getItems().add(new Treatment(Data[0],Data[1],Data[2]));}else{
                     if(table3.getItems().size()>=12){
                   Alert.display("Warning!!", "max 12 Treatment!!");

                        
                    }else{
                    Alert.display("Warning!!", "you already add it");    
                    }
                }
             } catch (Exception ex) {
                 Logger.getLogger(Dental_Clinic.class.getName()).log(Level.SEVERE, null, ex);
             }
         });
 Button Ketolac_tab=new Button("Ketolac tab");
 Ketolac_tab.setOnAction((ActionEvent event) -> {
     String Data[]=new String[3];
     Data[1]="Ketolac tab";
     Data[2]="كل (8) ساعات لمدة (3) ايام فقط";
     
             try {
                        if (check_tabel(Data[1],table3.getItems())){
     Data[0]=String.valueOf(count());

                 table3.getItems().add(new Treatment(Data[0],Data[1],Data[2]));}else{
                     if(table3.getItems().size()>=12){
                   Alert.display("Warning!!", "max 12 Treatment!!");

                        
                    }else{
                    Alert.display("Warning!!", "you already add it");    
                    }
                }
             } catch (Exception ex) {
                 Logger.getLogger(Dental_Clinic.class.getName()).log(Level.SEVERE, null, ex);
             }
         });
 Button Megamox_1g=new Button("Megamox 1g");
 Megamox_1g.setOnAction((ActionEvent event) -> {
     String Data[]=new String[3];
     Data[1]="Megamox 1g";
     Data[2]="كبسولة كل (12) ساعة";
     
             try {
                               if (check_tabel(Data[1],table3.getItems())){
                                        Data[0]=String.valueOf(count());
                 table3.getItems().add(new Treatment(Data[0],Data[1],Data[2]));}else{
                                    if(table3.getItems().size()>=12){
                   Alert.display("Warning!!", "max 12 Treatment!!");

                        
                    }else{
                    Alert.display("Warning!!", "you already add it");    
                    }
                    
                }
             } catch (Exception ex) {
                 Logger.getLogger(Dental_Clinic.class.getName()).log(Level.SEVERE, null, ex);
             }
         });
 Button Oravex_h_mouth_wash=new Button("Oravex H Mouth Wash");
         Oravex_h_mouth_wash.getStyleClass().add("sandos");
  Oravex_h_mouth_wash.setOnAction((ActionEvent event) -> {
     String Data[]=new String[3];
     Data[1]="Oravex H Mouth Wash";
     Data[2]="مضمضة (3) مرات يوميا";
     
             try {
  if (check_tabel(Data[1],table3.getItems())){
     Data[0]=String.valueOf(count());
                 table3.getItems().add(new Treatment(Data[0],Data[1],Data[2]));}else{
                     if(table3.getItems().size()>=12){
                   Alert.display("Warning!!", "max 12 Treatment!!");

                        
                    }else{
                    Alert.display("Warning!!", "you already add it");    
                    }
                }
             } catch (Exception ex) {
                 Logger.getLogger(Dental_Clinic.class.getName()).log(Level.SEVERE, null, ex);
             }
         });
 Button Oravex_delicate_mouth_wash=new Button("oravex delicate Mouth wash");
  Oravex_delicate_mouth_wash.getStyleClass().add("sandoss");
 Oravex_delicate_mouth_wash.setOnAction((ActionEvent event) -> {
     String Data[]=new String[3];
     Data[1]="oravex delicate Mouth wash";
     Data[2]="مضمضة (3) مرات يوميا";
     
             try {
                      if (check_tabel(Data[1],table3.getItems())){
     Data[0]=String.valueOf(count());

                 table3.getItems().add(new Treatment(Data[0],Data[1],Data[2]));}else{
                     if(table3.getItems().size()>=12){
                   Alert.display("Warning!!", "max 12 Treatment!!");

                        
                    }else{
                    Alert.display("Warning!!", "you already add it");    
                    }
                }
             } catch (Exception ex) {
                 Logger.getLogger(Dental_Clinic.class.getName()).log(Level.SEVERE, null, ex);
             }
         });
 Button Voltarin=new Button ("Voltarin Amp");
  Voltarin.setOnAction((ActionEvent event) -> {
     String Data[]=new String[3];
     Data[1]="Voltarin Amp";
     Data[2]="حقنة عند اللزوم";
     
             try {
  if (check_tabel(Data[1],table3.getItems())){
     Data[0]=String.valueOf(count());

                 table3.getItems().add(new Treatment(Data[0],Data[1],Data[2]));}else{
                     if(table3.getItems().size()>=12){
                   Alert.display("Warning!!", "max 12 Treatment!!");

                        
                    }else{
                    Alert.display("Warning!!", "you already add it");    
                    }
                }
             } catch (Exception ex) {
                 Logger.getLogger(Dental_Clinic.class.getName()).log(Level.SEVERE, null, ex);
             }
         });
VBox A=new VBox(20);VBox B=new VBox(20);

VBox C=new VBox(20);
VBox D=new VBox(20);
VBox H=new VBox(20);
VBox K=new VBox(20);
VBox M=new VBox(20);
VBox O=new VBox(20);
VBox V=new VBox(20);
          Image  true_mark  = new Image(Alert.class.getResourceAsStream("successful.png"));
                    Image  Failure_mark  = new Image(Alert.class.getResourceAsStream("Failure.png"));

                  ImageView iv_NEW = new ImageView(true_mark);
                  ImageView iv_N = new ImageView(Failure_mark);
 iv_NEW.setFitHeight(25);
        iv_NEW.setFitWidth(25);
 iv_N.setFitHeight(25);
        iv_N.setFitWidth(25);
Button DONE=new Button("DONE",iv_NEW);
Button DELETE=new Button("DELETE",iv_N);
A.getChildren().addAll(Alphenterin,Amrizol_Surp,Amrizole_500mg);
B.getChildren().addAll(A,Betadine_mouth_wash,Bibrufenicl_tab,Brufen_400mg);
C.getChildren().addAll(Catadly_surp,Cataflam_50mg,Cephatraxion_sandos,Clindom_300mg);
D.getChildren().addAll(C,Dalacin_C_300mg,Deltaclave_457mg);
H.getChildren().addAll(Foxim_1g_AMP,Hibiotic_1g,Hibiotic_457mg);
K.getChildren().addAll(Ketolac_tab);
M.getChildren().addAll(H,K,Megamox_1g);
O.getChildren().addAll(Oravex_h_mouth_wash,Oravex_delicate_mouth_wash);
V.getChildren().addAll(O,Voltarin,DELETE,DONE);
HBox Data_Button=new HBox(59);
Data_Button.getChildren().addAll(B,D,M,V); 
Data_Button.getStyleClass().add("Data_Button");
DONE.getStyleClass().add("DONE");
DELETE.getStyleClass().add("DELETE");
DELETE.setOnAction((ActionEvent event) -> {    
    table3.getItems().removeAll(table3.getSelectionModel().getSelectedItem());
                    Treatment T=new Treatment();
                        for (int i = 0; i < table3.getItems().size(); i++) {
                                    T=table3.getItems().get(i);
                                    T.setNumber(String.valueOf(i+1));
                        }
                            count_(table3.getItems().size());

});
DONE.setOnAction((ActionEvent event) -> {
    Treatment T=new Treatment();
    String Array_TREATMENT[][]=new String[table3.getItems().size()][3];
    for (int i = 0; i < table3.getItems().size(); i++) {
        T=table3.getItems().get(i);
        Array_TREATMENT[i][0]=T.getNumber();
        Array_TREATMENT[i][1]=T.getName_Treatment();
        Array_TREATMENT[i][2]=T.getTime();
    }
    try {
        add_TXT_on_Treatment(array[1],String.valueOf(Integer.valueOf(array[0])+1),Array_TREATMENT);
        open_folder(String.valueOf((Integer.valueOf(array[0])+1)));
        Window.setScene(back);
        count_0();
    } catch (IOException ex) {
        Logger.getLogger(Dental_Clinic.class.getName()).log(Level.SEVERE, null, ex);
    }
         });
 ///////////////////////////////////////////////////////////////////
 BorderPane Data=new BorderPane();
 Data.setTop(table3);
 Data.setLeft(data_client);
Data.setCenter(Data_Button);
 table3.getStyleClass().add("tab");
     if(array[3].equalsIgnoreCase("null")||array[3].equalsIgnoreCase("")){
             AGE.setVisible(false);
          
         }
         if(array[4].equalsIgnoreCase("null")||array[4].equalsIgnoreCase("")){
             JOB.setVisible(false);
                     

         }
         if(array[5].equalsIgnoreCase("null")||array[5].equalsIgnoreCase("")){
             Address.setVisible(false);
                               
         }
 TREATMENT=new Scene(Data,1300, 1300);
      String css_Search_JOB = Dental_Clinic.class.getResource("TREATMENT.css").toExternalForm();
        TREATMENT.getStylesheets().add(css_Search_JOB);
 return TREATMENT;
     }
         public Scene Search_by_JoB(Stage Window){
                          TableView<person> table;
             TextField Job=new TextField();
             Job.setPromptText("Enter the job");
             Button submit=new Button("SEARCH");
             Button BACK=new Button("BACK");
               BACK.setOnAction((ActionEvent event) -> {            
            Window.setScene(Homepage(Window));
            Window.setTitle("HOME");
           });
             HBox input=new HBox(40);
             input.getChildren().addAll(Job,submit,BACK);
             input.getStyleClass().add("box");
             BorderPane root = new BorderPane();
             TableColumn<person,String> Number = new TableColumn<>("Number");
        Number.setMinWidth(100);
 Number.setCellValueFactory(
                new PropertyValueFactory<>("Number"));
        TableColumn<person,String> Name = new TableColumn<>("Name");
        Name.setMinWidth(200);
 Name.setCellValueFactory(
                new PropertyValueFactory<>("Name"));
 
        TableColumn<person,String> phoneNum = new TableColumn<>("PhoneNum");
        phoneNum.setMinWidth(100);
        phoneNum.setCellValueFactory(
                new PropertyValueFactory<>("PhoneNum"));
        TableColumn<person,String> Address = new TableColumn<>("Address");
        Address.setMinWidth(100);
        Address.setCellValueFactory(
                new PropertyValueFactory<>("Address"));

        TableColumn<person,String> JOB = new TableColumn<>("JOB");
        JOB.setMinWidth(100);
        JOB.setCellValueFactory(
                new PropertyValueFactory<>("JOB"));
        TableColumn<person,String> Age = new TableColumn<>("Age");
        Age.setMinWidth(100);        
        Age.setCellValueFactory(
                new PropertyValueFactory<>("Age"));
//        input.setPadding(new Insets(250, 300, 0, 0));
        table = new TableView<>(); 
        table.getStyleClass().add("tab");
                   submit.setOnAction((ActionEvent event) -> {
                 try {
                     table.setItems(getProducts(Job.getText()));
                 } catch (FileNotFoundException ex) {
                     Logger.getLogger(Dental_Clinic.class.getName()).log(Level.SEVERE, null, ex);
                 }
             });
table.getColumns().addAll(Number, Name, phoneNum, Address, JOB,Age);
 table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        root.setTop(table);
        root.setCenter(input);
        
       // input.set
        search_Job = new Scene(root, 1300, 1300);
        String css_Search_JOB = Dental_Clinic.class.getResource("Search_JOB.css").toExternalForm();
        search_Job.getStylesheets().add(css_Search_JOB);
             return search_Job;
         }
           
         public Scene INFO(Stage Window){
   TableView<name_Person> table2 = new TableView();
   table2.getStyleClass().add("tab");
             Label txt_name=new Label("NAME:");
             Label txt_phone=new Label("PHONE:");
             Label txt_Folder=new Label("Folder NUM:");
             TextField name=new TextField();
             TextField Folder=new TextField();
             Folder.setMaxWidth(100);
             TextField phone=new TextField();
             name.setPromptText("Enter the Name");
             phone.setPromptText("Enter the Phone");
             Folder.setPromptText("Enter the FolderNUM");
             Button Submit_Name=new Button("SEARCH BY NAME");   
             Button Submit_Phone=new Button("SEARCH BY PHONE");   
             Submit_Phone.setTranslateX(10);
             Button Submit_Folder=new Button("REVIEW");   
             Button BACK=new Button("BACK");
              HBox H_Name=new HBox(50);
             HBox H_Phone=new HBox(40);
             HBox H_Folder=new HBox(40);
             H_Folder.getStyleClass().add("folder");
               H_Name.getChildren().addAll(txt_name,name,Submit_Name);
             H_Phone.getChildren().addAll(txt_phone,phone,Submit_Phone);             
             H_Folder.getChildren().addAll(txt_Folder,Folder,Submit_Folder);
               BACK.setOnAction((ActionEvent event) -> {            
            Window.setScene(Homepage(Window));
            Window.setTitle("HOME");
           });                       
//            H_Folder.setVisible(false);
             VBox data=new VBox(20);
                           data.getStyleClass().add("vox");

              data.getChildren().addAll(H_Name,H_Phone,BACK);
             BorderPane root = new BorderPane();
             TableColumn <name_Person,String>Number_Person = new TableColumn("Number_Person");
        Number_Person.setMinWidth(150);
 Number_Person.setCellValueFactory(
                new PropertyValueFactory<>("Number"));
        TableColumn <name_Person,String>Name_Person = new TableColumn("Name_Person");
        Name_Person.setMinWidth(150);
 Name_Person.setCellValueFactory(
                new PropertyValueFactory<>("Name")); 
        TableColumn <name_Person,String>phoneNumber_Person = new TableColumn("phoneNumber_Person");
        phoneNumber_Person.setMinWidth(150);
        phoneNumber_Person.setCellValueFactory(
                new PropertyValueFactory<>("PhoneNum"));
        TableColumn<name_Person,String> Address_Person = new TableColumn("Address_Person");
        Address_Person.setMinWidth(150);
        Address_Person.setCellValueFactory(
                new PropertyValueFactory<>("Address"));
        TableColumn <name_Person,String> JOB_Person = new TableColumn ("JOB_Person");
        JOB_Person.setMinWidth(150);
        JOB_Person.setCellValueFactory(
                new PropertyValueFactory<>("JOB"));
        TableColumn<name_Person,String> Age_Person = new TableColumn("Age_Person");
        Age_Person.setMinWidth(150);        
        Age_Person.setCellValueFactory(
                new PropertyValueFactory<>("Age"));
//        input.setPadding(new Insets(250, 300, 0, 0));
                   Submit_Name.setOnAction((ActionEvent event) -> {
                           try {
                               
                               table2.setItems(getName(name.getText()));
                           } catch (FileNotFoundException ex) {
                               Logger.getLogger(Dental_Clinic.class.getName()).log(Level.SEVERE, null, ex);
                           }
                                                                         
   });
                   Submit_Phone.setOnAction((ActionEvent event) -> {
                           try {
                               
                               table2.setItems(getPhone(phone.getText()));
                           } catch (FileNotFoundException ex) {
                               Logger.getLogger(Dental_Clinic.class.getName()).log(Level.SEVERE, null, ex);
                           }
                                                                         
   });
            
                   table2.setOnMouseClicked(new EventHandler<MouseEvent>() {
        @Override
        public void handle(MouseEvent event) {
            name_Person name=new name_Person(); 
            name=table2.getSelectionModel().getSelectedItem();
            Folder.setText(name.getNumber());
        }
    });
 Submit_Folder.setOnAction((ActionEvent event) -> {
       try {
          String array[] = special_read(Folder.getText());
             Window.setScene(REVIEW(Window, array,INFO(Window)));                                                             

       } catch (Exception ex) {
           Logger.getLogger(Dental_Clinic.class.getName()).log(Level.SEVERE, null, ex);
       }
                           
                                                                         
   });
         table2.setEditable(true);
table2.getColumns().addAll(Number_Person, Name_Person, phoneNumber_Person, Address_Person, JOB_Person,Age_Person);
 table2.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        root.setTop(table2);
        root.setCenter(data);
        root.setRight(H_Folder);
        INFO = new Scene(root, 1300, 1300);
        String css_INFO = Dental_Clinic.class.getResource("INFO.css").toExternalForm();
        INFO.getStylesheets().add(css_INFO);
             return INFO;
         }
  
         
     public Scene Review_EDIT_CUSTOMER(Stage Window,String array[],Scene Back){
           Label Name = new Label();
        Name.setText("NAME:");
        Label Phone_Number = new Label();
        Phone_Number.setText("PHONE   +20:");
        Label DATE = new Label();
        DATE.setText("DATE:");
        Label JOB = new Label();
        JOB.setText("JOB TITLE:");
        Label ADDRESS = new Label();
        ADDRESS.setText("ADDRESS:");
        Label AGE = new Label();
        AGE.setText("AGE:");
        TextField TXT_NAME = new TextField();
        TextField TXT_NUM = new TextField();
        TextField TXT_JOB = new TextField();
        TextField TXT_ADD = new TextField();
        TextField TXT_AGE = new TextField();     
        TXT_NAME.setText(array[1]);
        TXT_NUM.setText(array[2]);
        TXT_JOB.setText(array[4]);
        TXT_ADD.setText(array[5]);
        TXT_AGE.setText(array[3]);
        TXT_AGE.setMaxWidth(50);
        HBox H_NAME = new HBox(58);
        H_NAME.getChildren().addAll(Name, TXT_NAME);
        H_NAME.getStyleClass().add("BOXES");
        HBox H_NUM = new HBox(20);
        H_NUM.getChildren().addAll(Phone_Number, TXT_NUM);
        H_NUM.getStyleClass().add("BOXES");
        HBox H_DATE = new HBox(5);
        H_DATE.getChildren().addAll(AGE,TXT_AGE);
        H_DATE.getStyleClass().add("BOXES");
        HBox H_JOB = new HBox(35);
        H_JOB.getChildren().addAll(JOB, TXT_JOB);
        H_JOB.getStyleClass().add("BOXES");
        HBox H_ADDRS = new HBox(40);
        H_ADDRS.getChildren().addAll(ADDRESS, TXT_ADD);
        H_ADDRS.getStyleClass().add("BOXES");
        Button BACK = new Button("");
        BACK.setText("BACK");
        BACK.setTranslateX(20);
        Button SUBMIT = new Button("");
        SUBMIT.setText("EDIT IN CSV");
        SUBMIT.setTranslateX(380);
        SUBMIT.setTranslateY(-58);
        BACK.setOnAction((ActionEvent event) -> {
            Window.setScene(Back);
            Window.setTitle("EDIT PATIENT");
           });

        SUBMIT.setOnAction((ActionEvent event) -> {
            if (TXT_NAME.getText().isEmpty()) {
                Alert.display("EmptyName!!", "please fill the Name");
            } else {
                String AGE1 = "";
                if (TXT_NUM.getText().isEmpty()) {
                    Alert.display("EmptyNumber!!", "please fill the Number");
                    
                } else {
                    if (TXT_JOB.getText().equalsIgnoreCase("null")) {
                        TXT_JOB.setText("");
                        
                    }
                    if (TXT_ADD.getText().equalsIgnoreCase("null")) {
                        TXT_ADD.setText("");
                    }
                    
                    if (TXT_AGE.getText().equalsIgnoreCase("null")) {
                        TXT_AGE.setText("");
                    }
                    
                    try {
                        array[1]=TXT_NAME.getText();
                        array[2]=TXT_NUM.getText();
                        array[3]=TXT_AGE.getText();
                        array[4]=TXT_JOB.getText();
                        array[5]=TXT_ADD.getText();
                        change_data(array);
                        Alert.display("successful", "DATA HAS BEEN EDITED IN CSV");
                        Window.setScene(Back);
                    } catch (Exception ex) {
                        Alert.display("Warning!!", "DATA HAS Not BEEN EDITED" + '\n' + "Note:Please check that file is closed");                        
                        Logger.getLogger(Dental_Clinic.class.getName()).log(Level.SEVERE, null, ex);
                    }}
            }
           });
        VBox DATA = new VBox(25);
        DATA.getStyleClass().add("vdata");
        DATA.getChildren().addAll(H_NAME, H_NUM, H_JOB, H_ADDRS, H_DATE, BACK, SUBMIT);
        BorderPane root = new BorderPane();
        DATA.setPadding(new Insets(250, 300, 0, 0));
        root.setRight(DATA);
        Review_EDIT_CUSTOMER = new Scene(root, 1300, 1300);
        String css_Review_EDIT_CUSTOMER = Dental_Clinic.class.getResource("Review_EDIT_CUSTOMER.css").toExternalForm();
        Review_EDIT_CUSTOMER.getStylesheets().add(css_Review_EDIT_CUSTOMER);
        return Review_EDIT_CUSTOMER;
         
     }
     public Scene REVIEW(Stage Window,String array[],Scene back){
         Label Name=new Label();
         Label Phone=new Label();
         Label JOB=new Label();
         Label ADDRESS=new Label();
         Label AGE=new Label();
         Label Folder=new Label();
         Folder.setText("Folder NUM: "+String.valueOf((Integer.valueOf(array[0])+1)));
         Name.setText("Name: "+array[1]);
         Phone.setText("Phone Number: +20"+array[2]);
         JOB.setText("JOB: "+array[4]);
         ADDRESS.setText("Address: "+array[5]);
         AGE.setText("AGE: "+array[3]);
         VBox Label=new VBox(45);      
         Label title=new Label("DATA PERSON:");
         Label.getChildren().addAll(title,Name,Phone,AGE,JOB,ADDRESS,Folder);
            if(array[3].equalsIgnoreCase("null")||array[3].equalsIgnoreCase("")){
             AGE.setVisible(false);
          
         }
         if(array[4].equalsIgnoreCase("null")||array[4].equalsIgnoreCase("")){
             JOB.setVisible(false);
                     

         }
         if(array[5].equalsIgnoreCase("null")||array[5].equalsIgnoreCase("")){
             ADDRESS.setVisible(false);
                               

         }
                 Button Back = new Button("Back");
                 Button Treatment=new Button("ADD TREATMENT");
                 Treatment.setVisible(true);
                 Button Open_Folder = new Button("Open Folder");
                 Button ADD_Statement = new Button("ADD Statement");
                 Button EDIT_CUSTOMER = new Button("EDIT PATIENT");
                 VBox BUTTON =new VBox(60);
                 BUTTON.getChildren().addAll(Treatment,ADD_Statement,EDIT_CUSTOMER,Open_Folder,Back);
  Back.setOnAction((ActionEvent event) -> {
      try {
          Window.setScene(back);
          Window.setTitle("Search");
          
      } catch (Exception ex) {
          Logger.getLogger(Dental_Clinic.class.getName()).log(Level.SEVERE, null, ex);
      }
         });
  Treatment.setOnAction((ActionEvent event) -> {
      try {
          Window.setScene(ADD_TREATMENT(Window, array, REVIEW(Window,array,back)));
          Window.setTitle("ADD TREATMENT");
          
      } catch (Exception ex) {
          Logger.getLogger(Dental_Clinic.class.getName()).log(Level.SEVERE, null, ex);
      }
         });
  Open_Folder.setOnAction((ActionEvent event) -> {
      try {
          open_folder(String.valueOf((Integer.valueOf(array[0])+1)));
          
      } catch (IOException | NumberFormatException ex) {
          Logger.getLogger(Dental_Clinic.class.getName()).log(Level.SEVERE, null, ex);
      }
         });
  ADD_Statement.setOnAction((ActionEvent event) -> {
      try {
          File input=new File("F://Present//Data_Statement.jpeg");//\\Desktop-iul0p5c\f\Present\new.xls
File output=new File("F://Present//client_folder//"+String.valueOf((Integer.valueOf(array[0])+1))+"//"+array[1]+"_Data_Statement.jpeg");
add_text_on_Image(array[1],array[2],array[3],array[5],array[4],"jpeg",input,output);               
      } catch (IOException | NumberFormatException ex) {
          Logger.getLogger(Dental_Clinic.class.getName()).log(Level.SEVERE, null, ex);
      }
         });
EDIT_CUSTOMER.setOnAction((ActionEvent event) -> {
      try {
          Window.setScene(Review_EDIT_CUSTOMER(Window, array, REVIEW(Window,array,back)));
      } catch (NumberFormatException ex) {
          Logger.getLogger(Dental_Clinic.class.getName()).log(Level.SEVERE, null, ex);
      }
         });
         BorderPane root = new BorderPane();
        Label.setPadding(new Insets(190, 0, 0, 130));
        BUTTON.setPadding(new Insets(-390, 150, 0, 0));
        root.setTop(Label);
        root.setRight(BUTTON);
       
        this.REVIEW = new Scene(root, 1300, 1300);
        String css_REVIEW = Dental_Clinic.class.getResource("REVIEW.css").toExternalForm();
        this.REVIEW.getStylesheets().add(css_REVIEW);         
         return REVIEW;
     }
    public Scene search(Stage Window){               
        TextField NAME = new TextField();
        NAME.setMaxWidth(200);        
        TextField Phone = new TextField();
        Phone.setMaxWidth(200);
Label NAME_TXT=new Label("");
NAME_TXT.setText("NAME:");
        Label PHONE_TXT = new Label();
        PHONE_TXT.setText("PHONE +20:");
           Button search = new Button();
        search.setText("Search");
        Button Back = new Button();
        Back.setText("Back");
        HBox Name=new HBox(80);   
        HBox PHONE=new HBox(40);   
        HBox BUTTON=new HBox(140);   
                Name.getChildren().addAll(NAME_TXT,NAME);
                PHONE.getChildren().addAll(PHONE_TXT,Phone);
                BUTTON.getChildren().addAll(Back,search);
        VBox DATA = new VBox(25);     
        DATA.getChildren().addAll(Name, PHONE, BUTTON);
        Back.setOnAction((ActionEvent event) -> {
            try {
                Window.setScene(Homepage(Window));
                Window.setTitle("HOME");
                
            } catch (Exception ex) {
                Logger.getLogger(Dental_Clinic.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        search.setOnAction((ActionEvent event) -> {
            try {
                String array[] = null;
                if(!NAME.getText().isEmpty()&&!Phone.getText().isEmpty()){
                                      array=read_and_Search_on_EX_EQUAL(NAME.getText(),Phone.getText());
                     if(array[0].equalsIgnoreCase("false")){
                    
                    array=read_and_Search_on_EX(NAME.getText(),Phone.getText());}}
                else if(NAME.getText().isEmpty()&&!Phone.getText().isEmpty()){
                    array=read_and_Search_on_EX_By_Phone(Phone.getText());
                    
                }else if(!NAME.getText().isEmpty()&&Phone.getText().isEmpty()){
                    Alert.display("Warning!!", "you didn't put phone Number");
                    
                    
                }else{
                    Alert.display("Warning!!", "you didn't put Name or phone ");
                    
                }
                if(Arrays.deepToString(array).equalsIgnoreCase("null")){
                    
                }else{
                    if(array[0].equals("false")){
                        
                        Alert.display("(404 NOT FOUND)", "We couldn't find the name on CSV");
                        
                    }else{
                        Window.setScene(REVIEW(Window, array,search(Window)));
                        Window.setTitle("REVIEW");
                    }

                }
            } catch (Exception ex) {
                Logger.getLogger(Dental_Clinic.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

        BorderPane root = new BorderPane();
        DATA.setPadding(new Insets(90, 0, 0, 100));
        root.setCenter(DATA);
        this.Search = new Scene(root, 1300, 1300);
        String css_Search = Dental_Clinic.class.getResource("Search.css").toExternalForm();
        this.Search.getStylesheets().add(css_Search);

        return this.Search;
    }
public void change_data(String array[])throws Exception{
     FileInputStream fis = new FileInputStream(new File("F://Present//new.xlsx"));//F:\\Present\\
        try (Workbook wb = WorkbookFactory.create(fis)) {
            Sheet sh = wb.getSheetAt(0);
            Row row = sh.createRow(Integer.valueOf(array[0]));
            Cell cell1 = row.createCell(0);
            Cell cell2 = row.createCell(5);
            Cell cell3 = row.createCell(2);
            Cell cell4 = row.createCell(3);
            Cell cell5 = row.createCell(4);
            cell1.setCellValue(array[1]);
            cell3.setCellValue(array[2]);
            cell4.setCellValue(array[3]);
            cell5.setCellValue(array[4]);
            cell2.setCellValue(array[5]);
         try (FileOutputStream out = new FileOutputStream(new File("F://Present//new.xlsx"))) {
             wb.write(out);
             out.flush();
         }
        }

        
}
    public String Write_EX(String Name, String phone, String Age, String JOB, String Address) throws Exception {
        String folder_num;
        FileInputStream fis = new FileInputStream(new File("F://Present//new.xlsx"));
        try (Workbook wb = WorkbookFactory.create(fis)) {
            Sheet sh = wb.getSheetAt(0);
            folder_num=String.valueOf(sh.getLastRowNum() + 2);
            Row row = sh.createRow(sh.getLastRowNum() + 1);
            Cell cell1 = row.createCell(0);
            Cell cell2 = row.createCell(5);
            Cell cell3 = row.createCell(2);
            Cell cell4 = row.createCell(3);
            Cell cell5 = row.createCell(4);
            cell1.setCellValue(Name);
            cell3.setCellValue(phone);
            cell4.setCellValue(Age);
            cell5.setCellValue(JOB);
            cell2.setCellValue(Address);
            try (FileOutputStream out = new FileOutputStream(new File("F://Present//new.xlsx"))) {
                wb.write(out);
                out.flush();
            }
        }
return folder_num;
    }
    int count_succ =0;
    int count_fail =0;
//    public void create_more_folder() throws  IOException, InvalidFormatException{
//         FileInputStream fis = new FileInputStream(new File("F:\\Present\\new.xls"));
//        Workbook wb = WorkbookFactory.create(fis);
//        Sheet sh = wb.getSheetAt(0);
//                System.out.println(sh.getLastRowNum());
//
//        for (int i = 0; i < sh.getLastRowNum(); i++) {                    
//         File DIR = new File("F:/Present/client_folder/"+String.valueOf(i+1));//‪F:\Present\client_folder   
//        if (!DIR.exists()) {
//            if (DIR.mkdir()) {
//                System.out.println("FOLDER SUCC");
//                count_succ++;
//            } else {         
//                System.out.println("folder fail");
//                count_fail++;
//            }
//        }else{            
////            System.out.println("folder is already here");
//        }}
//        System.out.println("succ:"+count_succ);
//        System.out.println("fail:"+count_fail);
//       
//    }
    public void add_TXT_on_Treatment2(String Name,String Folder_Num,String Array[][])throws IOException{
                BufferedImage image2=ImageIO.read(new File("F://Present//Data_Treatment.jpg"));
    int imageType="png".equalsIgnoreCase("jpg")? BufferedImage.TYPE_INT_ARGB:BufferedImage.TYPE_INT_RGB;
    BufferedImage bold=new BufferedImage(image2.getWidth(),image2.getHeight(),imageType);
        AlphaComposite alpha=AlphaComposite.getInstance(AlphaComposite.SRC_OVER,0.9f);
    Graphics2D w2=(Graphics2D) bold.getGraphics();
    w2.drawImage(image2, 1, 2,null);
    w2.setComposite(alpha);
    w2.setColor(Color.BLACK);
    w2.setFont(new Font(Font.SANS_SERIF,Font.BOLD,60));
    w2.drawString(Name, 650,480);
    LocalDateTime myDateObj = LocalDateTime.now();
    DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("yyyy");
        String Year_of_Today = myDateObj.format(myFormatObj);
    DateTimeFormatter myFormatObj2 = DateTimeFormatter.ofPattern("dd");
        String day_of_Today = myDateObj.format(myFormatObj2);
    DateTimeFormatter myFormatObj3 = DateTimeFormatter.ofPattern("MM");
        String month_of_Today = myDateObj.format(myFormatObj3);
                  w2.drawString(Year_of_Today, 98,500);
    w2.drawString(month_of_Today, 260,500);
    w2.drawString(day_of_Today, 360,500);
  File output=new File("F://Present//client_folder//"+Folder_Num+"//"+Name+String.valueOf(2)+"_Data_Treatment.jpg");
int counter=0;
  for (int i = 6; i <Array.length; i++) {           
     w2.drawString(Array[i][0]+"-"+Array[i][1]+" ", 100,700+(250*counter));
     w2.drawString(Array[i][2], 200,770+(250*counter));
                counter++;
    }
              ImageIO.write(bold, "jpg", output);
    }
    
    public void add_TXT_on_Treatment(String Name,String Folder_Num,String Array[][])throws IOException{
            BufferedImage image=ImageIO.read(new File("F://Present//Data_Treatment.jpg"));
    int imageType="png".equalsIgnoreCase("jpg")? BufferedImage.TYPE_INT_ARGB:BufferedImage.TYPE_INT_RGB;
    BufferedImage bold=new BufferedImage(image.getWidth(),image.getHeight(),imageType);
    Graphics2D w=(Graphics2D) bold.getGraphics();
    w.drawImage(image, 1, 2,null);
    AlphaComposite alpha=AlphaComposite.getInstance(AlphaComposite.SRC_OVER,0.9f);
    w.setComposite(alpha);
    w.setColor(Color.BLACK);
    w.setFont(new Font(Font.SANS_SERIF,Font.BOLD,60));
    w.drawString(Name, 650,480);
        LocalDateTime myDateObj = LocalDateTime.now();
    DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("yyyy");
        String Year_of_Today = myDateObj.format(myFormatObj);
    DateTimeFormatter myFormatObj2 = DateTimeFormatter.ofPattern("dd");
        String day_of_Today = myDateObj.format(myFormatObj2);
    DateTimeFormatter myFormatObj3 = DateTimeFormatter.ofPattern("MM");
        String month_of_Today = myDateObj.format(myFormatObj3);
          w.drawString(Year_of_Today, 98,500);
    w.drawString(month_of_Today, 260,500);
    w.drawString(day_of_Today, 360,500);
if(Array.length<=6){ 
    File output=new File("F://Present//client_folder//"+Folder_Num+"//"+Name+"_Data_Treatment.jpg");
        for (int i = 0; i < Array.length; i++) {
             w.drawString(Array[i][0]+"-"+Array[i][1]+" ", 100,700+(250*i));
     w.drawString(Array[i][2], 200,770+(250*i));
        }
    ImageIO.write(bold, "jpg", output); 
}else{
    for (int i = 0; i <6; i++) {
        counter++;           
     w.drawString(Array[i][0]+"-"+Array[i][1]+" ", 100,700+(250*i));
     w.drawString(Array[i][2], 200,770+(250*i));
                
    }
    File output=new File("F://Present//client_folder//"+Folder_Num+"//"+Name+String.valueOf(1)+"_Data_Treatment.jpg");

     ImageIO.write(bold, "jpg", output);
    
  add_TXT_on_Treatment2(Name,Folder_Num,Array);

}       
    }
    public void add_text_on_Image(String Name,String Phone ,String AGE,String ADDRESS,String JOB,String Type,File Source,File destination) throws IOException{
    BufferedImage image=ImageIO.read(Source);
    int imageType="png".equalsIgnoreCase(Type)? BufferedImage.TYPE_INT_ARGB:BufferedImage.TYPE_INT_RGB;
    BufferedImage bold=new BufferedImage(image.getWidth(),image.getHeight(),imageType);
    Graphics2D w=(Graphics2D) bold.getGraphics();
    w.drawImage(image, 1, 2,null);
    AlphaComposite alpha=AlphaComposite.getInstance(AlphaComposite.SRC_OVER,0.9f);
    w.setComposite(alpha);
    w.setColor(Color.BLACK);
    w.setFont(new Font(Font.SANS_SERIF,Font.BOLD,20));
    w.drawString(Name, 233,130);
    
    w.drawString("0"+Phone, 990,160);
    w.drawString(ADDRESS,233,170);
    w.drawString(AGE,1090,130);
    w.drawString(JOB,800,140);
    ImageIO.write(bold, Type, destination);        
}
    public void create_paper(String Folder_Num,String Name,String Phone ,String AGE,String ADDRESS,String JOB) throws IOException{       
File input=new File("F://Present//Data_Statement.jpeg");//\\Desktop-iul0p5c\f\Present\new.xls
File output=new File("F://Present//client_folder//"+Folder_Num+"//"+Name+"_Data_Statement.jpeg");
add_text_on_Image(Name,Phone,AGE,ADDRESS,JOB,"jpeg",input,output);
    }
public void open_folder(String Folder_Number) throws IOException{
     Desktop d=null;
  File DIR = new File("F://Present//client_folder//"+Folder_Number);//‪F:\Present\client_folder


if (DIR.exists()) {
        if(Desktop.isDesktopSupported()){
            d=Desktop.getDesktop();
        }
        d.open(DIR);
    
        }else{
            
            Alert.display("Warning!!", "File is not there" + '\n' + "Note:Please check that is old customer");


        }    
}
    public Scene FORM(Stage Window) {
        Label Name = new Label();
        Name.setText("NAME");
        Label Phone_Number = new Label();
        Phone_Number.setText("PHONE   +20:");
        Label DATE = new Label();
        DATE.setText("DATE:");
        Label JOB = new Label();
        JOB.setText("JOB TITLE:");
        Label ADDRESS = new Label();
        ADDRESS.setText("ADDRESS:");
        TextField TXT_NAME = new TextField();
        TextField TXT_NUM = new TextField();
        TextField TXT_JOB = new TextField();
        TextField TXT_ADD = new TextField();
        ComboBox<String> COBMBO_DAY = new ComboBox<>();

        COBMBO_DAY.setValue("Day");                  //Choice Box For Day

        for (int i = 1; i <= 30; i++) {                    //For Loop For The Days 
            COBMBO_DAY.getItems().addAll(String.valueOf(i));
        }
        ComboBox<String> COBMBO_MOUNTH = new ComboBox<>();             //Intializing Choice Box 
        COBMBO_MOUNTH.setValue("Month");  //Choice Box For Month
        COBMBO_MOUNTH.getItems().addAll("Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec");     //Add Names OF The Months Will be in the Choice Box 
        ComboBox<String> COBMBO_YEAR = new ComboBox<>();
        COBMBO_YEAR.setValue("Year");          //Choice Box For Year
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("yyyy");
        LocalDateTime myDateObj = LocalDateTime.now();
        String Year_of_Today = myDateObj.format(myFormatObj);
        int YEAR_OF_TODAY = Integer.valueOf(Year_of_Today);

        for (int i = YEAR_OF_TODAY; i >= YEAR_OF_TODAY - 90; i--) {           //For Loop For The Years
            COBMBO_YEAR.getItems().addAll(String.valueOf(i));
        }
        
        HBox H_NAME = new HBox(58);
        H_NAME.getChildren().addAll(Name, TXT_NAME);
        H_NAME.getStyleClass().add("BOXES");
        HBox H_NUM = new HBox(20);
        H_NUM.getChildren().addAll(Phone_Number, TXT_NUM);
        H_NUM.getStyleClass().add("BOXES");
        HBox H_DATE = new HBox(5);
        H_DATE.getChildren().addAll(DATE, COBMBO_DAY, COBMBO_MOUNTH, COBMBO_YEAR);
        H_DATE.getStyleClass().add("BOXES");
        HBox H_JOB = new HBox(35);
        H_JOB.getChildren().addAll(JOB, TXT_JOB);
        H_JOB.getStyleClass().add("BOXES");
        HBox H_ADDRS = new HBox(40);
        H_ADDRS.getChildren().addAll(ADDRESS, TXT_ADD);
        H_ADDRS.getStyleClass().add("BOXES");
        Button BACK = new Button("");
        BACK.setText("BACK");
        BACK.setTranslateX(20);
        Button SUBMIT = new Button("");
        SUBMIT.setText("SAVE TO CSV");
        SUBMIT.setTranslateX(380);
        SUBMIT.setTranslateY(-58);
        BACK.setOnAction((ActionEvent event) -> {
            Window.setScene(Homepage(Window));
            Window.setTitle("HOME");
        });

        SUBMIT.setOnAction((ActionEvent event) -> {
                            String AGE="";

           
                    if (TXT_JOB.getText().isEmpty()) {
                        TXT_JOB.setText("");
                        
                    } else {
                    }
                        if (TXT_ADD.getText().isEmpty()) {
                            TXT_ADD.setText("");
                            
                        } else {
                        }
                            
                        if ("Year".equals(COBMBO_YEAR.getValue())) {
                                AGE="";
                            } else {
                                AGE = String.valueOf(Integer.parseInt(Year_of_Today) - Integer.parseInt(COBMBO_YEAR.getValue()));
                                
                            }
                            
                        
                    
                    String Folder_Num;
                     if (TXT_NAME.getText().isEmpty()) {
                Alert.display("EmptyName!!", "please fill the Name");
            } else {
            
                if (TXT_NUM.getText().isEmpty()) {
                    Alert.display("EmptyNumber!!", "please fill the Number");
                    
                } else {
                
                    try {
                        Folder_Num=Write_EX(TXT_NAME.getText(), TXT_NUM.getText(), AGE, TXT_JOB.getText(), TXT_ADD.getText());                        
                        Alert.display("successful", "DATA HAS BEEN SAVED");
                        create_folder(Folder_Num);
                        create_paper(Folder_Num,TXT_NAME.getText(),TXT_NUM.getText(),AGE,TXT_ADD.getText(),TXT_JOB.getText());
                        open_folder(Folder_Num);
                         Window.setScene(Homepage(Window));
                         Window.setTitle("HOME");
                        
                    } catch (Exception ex) {
                        Alert.display("Warning!!", "DATA HAS Not BEEN SAVED" + '\n' + "Note:Please check that file is closed");
                        
                        Logger.getLogger(Dental_Clinic.class.getName()).log(Level.SEVERE, null, ex);
                    }
                                }}

                
            
        });
        VBox DATA = new VBox(25);
        DATA.getStyleClass().add("vdata");
        DATA.getChildren().addAll(H_NAME, H_NUM, H_JOB, H_ADDRS, H_DATE, BACK, SUBMIT);
        BorderPane root = new BorderPane();
        DATA.setPadding(new Insets(250, 300, 0, 0));
        root.setRight(DATA);
        FORM = new Scene(root, 1300, 1300);
        String css_FORM = Dental_Clinic.class.getResource("FORM.css").toExternalForm();
        FORM.getStylesheets().add(css_FORM);
        return FORM;
    }

//    public Scene NEW_MENU_CUSTOMER(Stage Window) {
//        Button form = new Button("");
//        form.setMaxWidth(200);
//        form.setText("FORM");
//        Button DESCRIPTION = new Button("");
//        DESCRIPTION.setMaxWidth(200);
//        DESCRIPTION.setText("DESCRIPTION");
//        Button BACK = new Button("");
//        BACK.setText("BACK");
//        BACK.setTranslateX(-40);
//
//        VBox MENU = new VBox(25);
//        MENU.getChildren().addAll(form, DESCRIPTION, BACK);
//        BorderPane root = new BorderPane();
//        MENU.setPadding(new Insets(300, 0, 0, 550));
//        root.setCenter(MENU);
//        form.setOnAction(new EventHandler<ActionEvent>() {
//            @Override
//            public void handle(ActionEvent event) {
//                Window.setScene(FORM(Window));
//                Window.setTitle("New Customer Form");
//            }
//        });
//        BACK.setOnAction(new EventHandler<ActionEvent>() {
//            @Override
//            public void handle(ActionEvent event) {
//                Window.setScene(Homepage(Window));
//                Window.setTitle("HOME");
//            }
//        });
//        NEW_MENU_CUSTOMER = new Scene(root, 1300, 1300);
//        String css_Homepage = Dental_Clinic.class.getResource("NEW_MENU_CUSTOMER.css").toExternalForm();
//        NEW_MENU_CUSTOMER.getStylesheets().add(css_Homepage);
//        return NEW_MENU_CUSTOMER;
//
//    }

    public Scene Homepage(Stage Window) {
        Image NEW = new Image(getClass().getResourceAsStream("new1.png"));
        ImageView iv_NEW = new ImageView(NEW);
        iv_NEW.setFitHeight(25);
        iv_NEW.setFitWidth(25);
        Button NEWCUSTOMER = new Button("", iv_NEW);
        Button Info = new Button("INFO");
        NEWCUSTOMER.setText("NEW PATIENT");
        NEWCUSTOMER.setMaxWidth(200);
        Info.setMaxWidth(200);

        ImageView iv_OLD = new ImageView(new Image(getClass().getResourceAsStream("old1.png")));
        iv_OLD.setFitHeight(25);
        iv_OLD.setFitWidth(25);
        Button OLDCUSTOMER = new Button("", iv_OLD);
        OLDCUSTOMER.setText("OLD PATIENT");
        OLDCUSTOMER.setMaxWidth(200);
//        ImageView iv_SETTINGS = new ImageView(new Image(getClass().getResourceAsStream("Settings.png")));
//        iv_SETTINGS.setFitHeight(25);
//        iv_SETTINGS.setFitWidth(25);
        Button SETTINGS = new Button();
        SETTINGS.setText("SEARCH BY JOB");
        SETTINGS.setMaxWidth(200);
//        SETTINGS.setVisible(false);
        ImageView iv_EDIT = new ImageView(new Image(getClass().getResourceAsStream("Edit.png")));
        iv_EDIT.setFitHeight(25);
        iv_EDIT.setFitWidth(25);
        Button EDITCUSTOMER = new Button("", iv_EDIT);
        EDITCUSTOMER.setText("EDIT PATIENT");
        EDITCUSTOMER.setMaxWidth(200);
        ImageView iv_LOGOUT = new ImageView(new Image(getClass().getResourceAsStream("log_out.png")));
        iv_LOGOUT.setFitHeight(25);
        iv_LOGOUT.setFitWidth(25);
        Button LOGOUT = new Button("", iv_LOGOUT);
        LOGOUT.setText("LOG OUT");
        LOGOUT.setTranslateX(-70);
        NEWCUSTOMER.setOnAction((ActionEvent event) -> {
            Window.setScene(FORM(Window));
            Window.setTitle("New Customer");
        });
        OLDCUSTOMER.setOnAction((ActionEvent event) -> {
            try {
                Window.setTitle("Search");
                Window.setScene(search(Window));
            } catch (Exception ex) {
                Logger.getLogger(Dental_Clinic.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        EDITCUSTOMER.setOnAction((ActionEvent event) -> {
            try {
                Window.setTitle("EDITCUSTOMER");
                Window.setScene(Search_EDIT_CUSTOMER(Window));
            } catch (Exception ex) {
                Logger.getLogger(Dental_Clinic.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        SETTINGS.setOnAction((ActionEvent event) -> {
            try {
                 Window.setTitle("Search by Job");
         Window.setScene(Search_by_JoB(Window));
            } catch (Exception ex) {
                Logger.getLogger(Dental_Clinic.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        LOGOUT.setOnAction((ActionEvent event) -> {
            Window.setScene(Lock_screen(Window));
            Window.setTitle("Log in");
        });
        Info.setOnAction((ActionEvent event) -> {
           Window.setScene(INFO(Window));
            Window.setTitle("Log in");
        });
        VBox MENU = new VBox(25);
        MENU.getChildren().addAll(NEWCUSTOMER, OLDCUSTOMER, EDITCUSTOMER, SETTINGS,Info, LOGOUT);
        BorderPane root = new BorderPane();
        MENU.setPadding(new Insets(300, 0, 0, 550));
        root.setCenter(MENU);
        Homepage = new Scene(root, 1300, 1300);
        String css_Homepage = Dental_Clinic.class.getResource("HomePage.css").toExternalForm();
        Homepage.getStylesheets().add(css_Homepage);
        return Homepage;
    }

    public Scene Lock_screen(Stage Window) {
        Label Title = new Label();
        Title.setText("Welcome to Dental Clinic");
        TextField USER_NAME = new TextField();
        USER_NAME.setMaxWidth(200);
        USER_NAME.setPromptText("Enter your User Name");
        PasswordField PASSWORD = new PasswordField();
        PASSWORD.setMaxWidth(200);
        PASSWORD.setPromptText("Enter your Password");
        VBox DATA = new VBox(25);
        Button LOG_IN = new Button();
        LOG_IN.setText("LOG IN");
        DATA.getChildren().addAll(USER_NAME, PASSWORD, LOG_IN);
        LOG_IN.setOnAction((ActionEvent event) -> {
            try {
                if(USER_NAME.getText().equalsIgnoreCase("ADMIN")&&PASSWORD.getText().equalsIgnoreCase("ADMIN")){
                    Window.setScene(Homepage(Window));
                    Window.setTitle("HOME");
                }else{
                    Alert.display("Warning!!", "Wrong USER NAME or PASSWORD" + '\n' + "Please Relax and try again");
                }
            } catch (Exception ex) {
                Logger.getLogger(Dental_Clinic.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

        BorderPane root = new BorderPane();
        DATA.setPadding(new Insets(300, 0, 0, 550));
        root.setTop(Title);
        root.setCenter(DATA);
        Lock_Screen = new Scene(root, 1300, 1300);
        String css_Lock_Screen = Dental_Clinic.class.getResource("Lock_Screen.css").toExternalForm();
        Lock_Screen.getStylesheets().add(css_Lock_Screen);

        return Lock_Screen;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
