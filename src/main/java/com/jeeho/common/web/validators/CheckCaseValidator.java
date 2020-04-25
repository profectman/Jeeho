package com.jeeho.common.web.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CheckCaseValidator implements ConstraintValidator<CheckCase,String> {

    private CaseMode caseMode;
    @Override
    public void initialize(CheckCase constraintAnnotation) {
        this.caseMode = constraintAnnotation.value();
    }

    @Override
    public boolean isValid(String object, ConstraintValidatorContext constraintContext) {
        boolean isUpper = false;
        if (object == null)
            return true;
        boolean isValid;
        if (caseMode == CaseMode.UPPER) {
            isValid = object.equals(object.toUpperCase());
            isUpper = true;
        }else {
            isValid = object.equals(object.toLowerCase());
        }
        if(!isValid) {
            constraintContext.disableDefaultConstraintViolation();
            if (isUpper){
                constraintContext.buildConstraintViolationWithTemplate("字符串必须为全大写").addConstraintViolation();
            }else{
                constraintContext.buildConstraintViolationWithTemplate("字符串必须为全小写").addConstraintViolation();
            }
        }

        return isValid;
    }
}
