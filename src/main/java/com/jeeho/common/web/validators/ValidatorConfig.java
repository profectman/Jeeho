package com.jeeho.common.web.validators;

import org.hibernate.validator.HibernateValidator;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

/**
 * @author jeeho
 * Validator属性配置
 */
public class ValidatorConfig {

    /**
     * addProperty("hibernate.validator.fail_fast", "true")  --->  设置validator快速校验配置.
     * @return
     */
    public Validator validatorConfig(){

        ValidatorFactory validatorFactory = Validation.byProvider(HibernateValidator.class)
                .configure()
                .addProperty("hibernate.validator.fail_fast", "true")
                .buildValidatorFactory();
        return validatorFactory.getValidator();
    }

}
