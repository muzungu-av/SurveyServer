package av.task;

import java.math.BigDecimal;
import java.util.Objects;

public class Valute {
    private String name;
    private String chCode;
    private int code;
    private BigDecimal nom;
    private BigDecimal curs;

    public Valute() {
    }

    public Valute(String vname, String vchcode, int vcode, BigDecimal vnom, BigDecimal vcurs) {
        this.name = vname.trim();
        this.chCode = vchcode.trim();
        this.code = vcode;
        this.nom = vnom;
        this.curs = vcurs;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name.trim();
    }

    public String getChCode() {
        return chCode;
    }

    public void setChCode(String chCode) {
        this.chCode = chCode.trim();
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public BigDecimal getNom() {
        return nom;
    }

    public void setNom(BigDecimal nom) {
        this.nom = nom;
    }

    public BigDecimal getCurs() {
        return curs;
    }

    public void setCurs(BigDecimal curs) {
        this.curs = curs;
    }

    @Override
    public String toString() {
        return "Valute{" +
                "name='" + name + '\'' +
                ", chCode='" + chCode + '\'' +
                ", code=" + code +
                ", nom=" + nom +
                ", curs=" + curs +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Valute)) return false;
        Valute valute = (Valute) o;
        return code == valute.code &&
                chCode.equals(valute.chCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(chCode, code);
    }
}
