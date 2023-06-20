package com.example.tarea02;

public class Usuario {


    String nombre, correo,direccion, contraseña;
    int CP, telefono,no_ext, tarjeta, CVV, vencimiento;

    int ID;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public Usuario(){

    }

    public Usuario(String nombre, String correo, String direccion, String contraseña, int CP, int telefono, int no_ext, int tarjeta, int CVV, int vencimiento) {
        this.nombre = nombre;
        this.correo = correo;
        this.direccion = direccion;
        this.contraseña = contraseña;
        this.CP = CP;
        this.telefono = telefono;
        this.no_ext = no_ext;
        this.tarjeta = tarjeta;
        this.CVV = CVV;
        this.vencimiento = vencimiento;
    }

    public boolean isNull(){
        if (nombre.equals("") && correo.equals(""))
            return false;
        return true;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public int getCP() {
        return CP;
    }

    public void setCP(int CP) {
        this.CP = CP;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public int getNo_ext() {
        return no_ext;
    }

    public void setNo_ext(int no_ext) {
        this.no_ext = no_ext;
    }

    public int getTarjeta() {
        return tarjeta;
    }

    public void setTarjeta(int tarjeta) {
        this.tarjeta = tarjeta;
    }

    public int getCVV() {
        return CVV;
    }

    public void setCVV(int CVV) {
        this.CVV = CVV;
    }

    public int getVencimiento() {
        return vencimiento;
    }

    public void setVencimiento(int vencimiento) {
        this.vencimiento = vencimiento;
    }



    @Override
    public String toString() {
        return "Usuario{" +
                "nombre='" + nombre + '\'' +
                ", correo='" + correo + '\'' +
                ", direccion='" + direccion + '\'' +
                ", contraseña='" + contraseña + '\'' +
                ", CP=" + CP +
                ", telefono=" + telefono +
                ", no_ext=" + no_ext +
                ", tarjeta=" + tarjeta +
                ", CVV=" + CVV +
                ", vencimiento=" + vencimiento +
                '}';
    }
}