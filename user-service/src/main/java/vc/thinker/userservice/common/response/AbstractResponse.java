package vc.thinker.userservice.common.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.context.MessageSource;
import org.springframework.web.servlet.support.RequestContextUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.Locale;

/**
 * api response 基类
 *
 * @author: dengwei
 * @date: 2018年9月26日 上午11:52:41
 */
public abstract class AbstractResponse {

    private MessageSource messageSource;

    private Locale locale;

    private boolean success = true;

    private String error;

    public AbstractResponse() {
    }

    public AbstractResponse(MessageSource messageSource, HttpServletRequest request) {
        this.messageSource = messageSource;
        this.locale = RequestContextUtils.getLocale(request);
    }

    @JsonProperty(value = "error_description")
    private String errorDescription;

    /**
     * 设置错误信息
     *
     * @param error
     * @param errorDescription
     */
    public void setErrorInfo(String error, String errorDescription) {
        this.success = false;
        this.error = error;
        this.errorDescription = errorDescription;
    }

    /**
     * 设置错误信息
     *
     * @param error
     * @param errorDescription
     */
    public void setErrorInfo(int error, String errorDescription) {
        this.success = false;
        this.error = String.valueOf(error);
        this.errorDescription = errorDescription;
    }

    /**
     * 设置错误信息
     *
     * @param error
     * @param errorDescription
     */
    public void setErrorInfo(String error, String errorMessageCode, String defaultMessage) {
        if (messageSource == null) {
            throw new RuntimeException("未初始化 messageSource 字段");
        }
        this.success = false;
        this.error = error;
        this.errorDescription = messageSource.getMessage(errorMessageCode, null, defaultMessage, locale);
    }

    /**
     * 设置错误信息
     *
     * @param error
     * @param errorDescription
     */
    public void setErrorInfo(int error, String errorMessageCode, String defaultMessage) {
        setErrorInfo(String.valueOf(error), errorMessageCode, defaultMessage);
    }

    /**
     * 设置错误信息
     *
     * @param error
     * @param errorDescription
     */
    public void setErrorInfo(String error, String errorMessageCode, Object[] args, String defaultMessage) {
        this.success = false;
        this.error = error;
        this.errorDescription = messageSource.getMessage(errorMessageCode, args, defaultMessage, locale);
    }

    /**
     * 设置错误信息
     *
     * @param error
     * @param errorMessageCode
     * @param args
     * @param defaultMessage
     */
    public void setErrorInfo(int error, String errorMessageCode, Object[] args, String defaultMessage) {
        setErrorInfo(String.valueOf(error), errorMessageCode, args, defaultMessage);
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getErrorDescription() {
        return errorDescription;
    }

    public void setErrorDescription(String errorDescription) {
        this.errorDescription = errorDescription;
    }
}
