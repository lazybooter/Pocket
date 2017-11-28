package cn.tarpas.pocket.common.dto;

public enum ErrorStatus {
    SUCCESS("0", "success"),   
    
    ERR_SYSTEM_BUSY("919001", "系统繁忙"),
    ERR_PARAMETER("919002", "参数错误"),
    ERR_PASSWORD("919003","密码错误"),
    ERR_MEMBER_NOT_EXIST("919004", "用户不存在");
    
    private String code;
    private String message;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    ErrorStatus(String code, String message) {
        this.code = code;
        this.message = message;
    }
}

