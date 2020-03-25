package cz.czechitas.webapp;

public class Clovek {
    private String jmeno;
    private String obrazek;
    private boolean profesor;

    public Clovek(String jmeno, String obrazek, boolean profesor) {
        this.jmeno = jmeno;
        this.obrazek = obrazek;
        this.profesor = profesor;
    }

    public String getJmeno() {
        return jmeno;
    }

    public void setJmeno(String newValue) {
        jmeno = newValue;
    }

    public String getObrazek() {
        return obrazek;
    }

    public void setObrazek(String newValue) {
        obrazek = newValue;
    }

    public boolean isProfesor() {
        return profesor;
    }

    public void setProfesor(boolean newValue) {
        profesor = newValue;
    }
}
