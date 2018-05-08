package parcial1;

public class Cliente {
    private String nombres;
    private String apellidos;
    private String sexo;
    private String tipoDoc;
    private String numDoc;
    private int edad;
    private String nacionalidad;
    private String numTarjeta;

    public Cliente(String nombres, String apellidos,String sexo,String tipoDoc,String numDoc ,int edad, String nacionalidad,String numTarjeta) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.sexo = sexo;
        this.tipoDoc = tipoDoc;
        this.numDoc = numDoc;
        this.edad = edad;
        this.nacionalidad = nacionalidad;
        this.numTarjeta = numTarjeta;
    }

    public String getnombres() {
        return nombres;
    }

    public void setnombres(String nombres) {
        this.nombres = nombres;
    }

    public String getapellidos() {
        return apellidos;
    }

    public void setapellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getTipoDoc() {
        return tipoDoc;
    }

    public void setTipoDoc(String tipoDoc) {
        this.tipoDoc = tipoDoc;
    }

    public String getNumDoc() {
        return numDoc;
    }

    public void setNumDoc(String numDoc) {
        this.numDoc = numDoc;
    }
    
    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getnacionalidad() {
        return nacionalidad;
    }

    public void setnacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public String getNumTarjeta() {
        return numTarjeta;
    }

    public void setNumTarjeta(String numTarjeta) {
        this.numTarjeta = numTarjeta;
    }
    
    public String clienteDatos(){
        String sexoT = "";
        if(this.sexo.equals("M")) sexoT = "Masculino";
        else sexoT = "Femenino";
        return " -Nombres: " + this.nombres + "\n -Apellidos: " + this.apellidos + "\n -Edad: " + this.edad + " años\n -Sexo: " + sexoT + "\n -Tipo Doc.: " + this.tipoDoc + "\n -Núm. Doc.: " + this.numDoc + "\n -Nacionalidad: " + this.nacionalidad + "\n -Número Tarjeta: " + this.numTarjeta ;
    }
    
}
