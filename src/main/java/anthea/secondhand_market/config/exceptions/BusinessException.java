package anthea.secondhand_market.config.exceptions;

import anthea.secondhand_market.constant.enums.ResponseCodes;

/**
 * @author anthea
 * @date 2023/4/25 17:50
 */
public class BusinessException extends RuntimeException {
    private ResponseCodes responseCodes;
    private String message;

    public BusinessException(ResponseCodes responseCodes) {
        this.responseCodes = responseCodes;
    }

    public BusinessException(ResponseCodes responseCodes, String message) {
        this.message = message;
        this.responseCodes = responseCodes;
    }
}
