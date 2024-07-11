public class Vehiculos {
    String placa;
    String marca;
    String modelo;
    Double cilindraje;
    String tipoCombustible;
    String color;
    String propietario;

    public Vehiculos() {
    }

    public Vehiculos(String propietario, String color, String tipoCombustible, Double cilindraje, String modelo, String marca, String placa) {
        this.propietario = propietario;
        this.color = color;
        this.tipoCombustible = tipoCombustible;
        this.cilindraje = cilindraje;
        this.modelo = modelo;
        this.marca = marca;
        this.placa = placa;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Double getCilindraje() {
        return cilindraje;
    }

    public void setCilindraje(Double cilindraje) {
        this.cilindraje = cilindraje;
    }

    public String getTipoCombustible() {
        return tipoCombustible;
    }

    public void setTipoCombustible(String tipoCombustible) {
        this.tipoCombustible = tipoCombustible;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getPropietario() {
        return propietario;
    }

    public void setPropietario(String propietario) {
        this.propietario = propietario;
    }
}
