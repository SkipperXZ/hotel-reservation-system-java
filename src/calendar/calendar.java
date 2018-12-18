package calendar;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.property.StringProperty;

import java.io.Serializable;

public class calendar implements Serializable {
    private StringProperty col1;
    private StringProperty col2;
    private StringProperty col3;
    private StringProperty col4;
    private StringProperty col5;
    private StringProperty col6;
    private StringProperty col7;
    private StringProperty col8;
    private StringProperty col9;
    private StringProperty col10;
    private StringProperty col11;
    private StringProperty col12;
    private StringProperty col13;
    private StringProperty col14;

    public StringProperty getCol1() {
        return col1;
    }

    public void setCol1(StringProperty col1) {
        this.col1 = col1;
    }

    public StringProperty getCol2() {
        return col2;
    }

    public void setCol2(StringProperty col2) {
        this.col2 = col2;
    }

    public StringProperty getCol3() {
        return col3;
    }

    public void setCol3(StringProperty col3) {
        this.col3 = col3;
    }

    public StringProperty getCol4() {
        return col4;
    }

    public void setCol4(StringProperty col4) {
        this.col4 = col4;
    }

    public StringProperty getCol5() {
        return col5;
    }

    public void setCol5(StringProperty col5) {
        this.col5 = col5;
    }

    public StringProperty getCol6() {
        return col6;
    }

    public void setCol6(StringProperty col6) {
        this.col6 = col6;
    }

    public StringProperty getCol7() {
        return col7;
    }

    public void setCol7(StringProperty col7) {
        this.col7 = col7;
    }

    public StringProperty getCol8() {
        return col8;
    }

    public void setCol8(StringProperty col8) {
        this.col8 = col8;
    }

    public StringProperty getCol9() {
        return col9;
    }

    public void setCol9(StringProperty col9) {
        this.col9 = col9;
    }

    public StringProperty getCol10() {
        return col10;
    }

    public void setCol10(StringProperty col10) {
        this.col10 = col10;
    }

    public StringProperty getCol11() {
        return col11;
    }

    public void setCol11(StringProperty col11) {
        this.col11 = col11;
    }

    public StringProperty getCol12() {
        return col12;
    }

    public void setCol12(StringProperty col12) {
        this.col12 = col12;
    }

    public StringProperty getCol13() {
        return col13;
    }

    public void setCol13(StringProperty col13) {
        this.col13 = col13;
    }

    public StringProperty getCol14() {
        return col14;
    }

    public void setCol14(StringProperty col14) {
        this.col14 = col14;
    }




    public calendar(String col1,String col2,String col3,String col4,String col5,String col6,String col7,
                    String col8,String col9,String col10,String col11,String col12,String col13,String col14){

        this.col1= new SimpleStringProperty(col1);
        this.col2= new SimpleStringProperty(col2);
        this.col3= new SimpleStringProperty(col3);
        this.col4= new SimpleStringProperty(col4);
        this.col5= new SimpleStringProperty(col5);
        this.col6= new SimpleStringProperty(col6);
        this.col7= new SimpleStringProperty(col7);
        this.col8= new SimpleStringProperty(col8);
        this.col9= new SimpleStringProperty(col9);
        this.col10= new SimpleStringProperty(col10);
        this.col11= new SimpleStringProperty(col11);
        this.col12= new SimpleStringProperty(col12);
        this.col13= new SimpleStringProperty(col13);
        this.col14= new SimpleStringProperty(col14);


    }
    public void clear (){

    }

}
