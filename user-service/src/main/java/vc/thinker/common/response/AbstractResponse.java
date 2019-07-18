package vc.thinker.common.response;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.context.MessageSource;
import org.springframework.web.servlet.support.RequestContextUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.Locale;

/**
 * 基础返回参数
 *
 * @author HeTongHao
 * @since 2019-07-03
 */
@Data
@Accessors(chain = true)
public abstract class AbstractResponse {

    @ApiModelProperty(hidden = true)
    private MessageSource messageSource;

    @ApiModelProperty(hidden = true)
    private Locale locale;

    @ApiModelProperty("请求是否成功")
    private boolean success = true;

    @ApiModelProperty("自定义异常code")
    private String code;

    @ApiModelProperty("消息提示")
    private String message;

    public AbstractResponse() {
    }

    public AbstractResponse(MessageSource messageSource, HttpServletRequest request) {
        this.messageSource = messageSource;
        this.locale = RequestContextUtils.getLocale(request);
    }

    /**
     * 设置错误信息
     *
     * @param code    自定义异常code
     * @param message 消息提示
     */
    public void setErrorInfo(String code, String message) {
        this.success = false;
        this.code = code;
        this.message = message;
    }

    /**
     * 设置错误信息
     *
     * @param code    自定义异常code
     * @param message 消息提示
     */
    public void setErrorInfo(int code, String message) {
        this.success = false;
        this.code = String.valueOf(code);
        this.message = message;
    }

    /**
     * 设置错误信息
     *
     * @param code           自定义异常code
     * @param messageCode    用于国际化的消息编号
     * @param defaultMessage 如果找不到对应的消息，返回默认的消息
     */
    public void setErrorInfo(String code, String messageCode, String defaultMessage) {
        if (messageSource == null) {
            throw new RuntimeException("未初始化 messageSource 字段");
        }
        this.success = false;
        this.code = code;
        this.message = messageSource.getMessage(messageCode, null, defaultMessage, locale);
    }

    /**
     * 设置错误信息
     *
     * @param code           自定义异常code
     * @param messageCode    用于国际化的消息编号
     * @param defaultMessage 如果找不到对应的消息，返回默认的消息
     */
    public void setErrorInfo(int code, String messageCode, String defaultMessage) {
        setErrorInfo(String.valueOf(code), messageCode, defaultMessage);
    }

    /**
     * 设置错误信息
     *
     * @param code           自定义异常code
     * @param messageCode    用于国际化的消息编号
     * @param args           消息参数列表
     * @param defaultMessage 如果找不到对应的消息，返回默认的消息
     */
    public void setErrorInfo(String code, String messageCode, Object[] args, String defaultMessage) {
        this.success = false;
        this.code = code;
        this.message = messageSource.getMessage(messageCode, args, defaultMessage, locale);
    }

    /**
     * 设置错误信息
     *
     * @param code           自定义异常code
     * @param messageCode    用于国际化的消息编号
     * @param args           消息参数列表
     * @param defaultMessage 如果找不到对应的消息，返回默认的消息
     */
    public void setErrorInfo(int code, String messageCode, Object[] args, String defaultMessage) {
        setErrorInfo(String.valueOf(code), messageCode, args, defaultMessage);
    }
}
