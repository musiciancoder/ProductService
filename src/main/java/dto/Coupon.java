package dto;

import java.math.BigDecimal;

public class Coupon { //esta clase es un dto ya q es proveniente del otro servicio

    private Long id;
    private String code;
    private BigDecimal dicount;
    private String expDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public BigDecimal getDicount() {
        return dicount;
    }

    public void setDicount(BigDecimal dicount) {
        this.dicount = dicount;
    }

    public String getExpDate() {
        return expDate;
    }

    public void setExpDate(String expDate) {
        this.expDate = expDate;
    }
}
