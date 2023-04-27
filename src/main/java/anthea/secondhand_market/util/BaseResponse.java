package anthea.secondhand_market.util;

import anthea.secondhand_market.constant.enums.ResponseCodes;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/**
 * @author anthea
 * @date 2023/4/25 9:45
 */
@Data
@Builder
public class BaseResponse<T> implements Serializable {
    private static final long serialVersionUID = 3778925047216110770L;

    private Integer code;
    private String message;
    private T data;

    /**
     * 无数据的返回
     * @return code
     * @return message
     * @param <T>
     */
    public static <T> BaseResponse<T> success() {
        return BaseResponse.<T>builder()
                .code(ResponseCodes.SUCCESS.getCode())
                .message(ResponseCodes.SUCCESS.getMessage())
                .data(null)
                .build();
    }

    /**
     * 有数据的返回
     * @return code
     * @return message
     * @return data
     * @param <T>
     */
    public static <T> BaseResponse<T> success(T data) {
        return BaseResponse.<T>builder()
                .code(ResponseCodes.SUCCESS.getCode())
                .message(ResponseCodes.SUCCESS.getMessage())
                .data(data)
                .build();
    }

    /**
     * 传入消息的无数据返回
     * @param message
     * @return code
     * @return message
     * @param <T>
     */
    public static <T> BaseResponse<T> success(String message) {
        return BaseResponse.<T>builder()
                .code(ResponseCodes.SUCCESS.getCode())
                .message(message)
                .data(null)
                .build();
    }

    /**
     * 传入消息的有数据返回
     * @param message
     * @param data
     * @return
     * @param <T>
     */
    public static <T> BaseResponse<T> success(String message, T data) {
        return BaseResponse.<T>builder()
                .code(ResponseCodes.SUCCESS.getCode())
                .message(message)
                .data(data)
                .build();
    }

    public static <T> BaseResponse<T> fail(ResponseCodes responseCodes) {
        return BaseResponse.<T>builder()
                .code(responseCodes.getCode())
                .message(responseCodes.getMessage())
                .data(null)
                .build();
    }
}
