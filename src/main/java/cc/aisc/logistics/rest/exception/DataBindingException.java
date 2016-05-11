package cc.aisc.logistics.rest.exception;

import cc.aisc.commons.utils.BindingResultUtils;
import org.springframework.validation.BindingResult;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by sjf on 16-5-11.
 */
public class DataBindingException extends RuntimeException {
    private List<String> globalErrors = new ArrayList<String>();

    private Map<String, List<String>> fieldErrors = new HashMap<String, List<String>>();

    public DataBindingException(BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            globalErrors = BindingResultUtils.getGlobalErrors(bindingResult);
            fieldErrors  = BindingResultUtils.getFieldErros(bindingResult);
        }
    }

    public List<String> getGlobalErrors() {
        return globalErrors;
    }

    public void setGlobalErrors(List<String> globalErrors) {
        this.globalErrors = globalErrors;
    }

    public Map<String, List<String>> getFieldErrors() {
        return fieldErrors;
    }

    public void setFieldErrors(Map<String, List<String>> fieldErrors) {
        this.fieldErrors = fieldErrors;
    }
}
