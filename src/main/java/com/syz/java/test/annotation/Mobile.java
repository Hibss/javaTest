package com.syz.java.test.annotation;

import javax.validation.Constraint;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.lang.annotation.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *  验证整数格式
 * @Author steven.sheng
 * @Date 2020/4/9/00915:41
 */
@Target({ElementType.FIELD,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@Constraint(validatedBy = Mobile.Valid.class)
public @interface Mobile {
    String message() default "参数不是手机号码格式";
    boolean required() default false;
    class Valid  implements ConstraintValidator<Mobile,String>{
        Pattern pattern = Pattern.compile("^1[3456789]\\d{9}$");
        String message = "";
        boolean required = false;

        @Override
        public void initialize(Mobile constraintAnnotation) {
            this.message = constraintAnnotation.message();
            this.required = constraintAnnotation.required();
        }

        @Override
        public boolean isValid(String value, ConstraintValidatorContext context) {
            if(!required){
                return true;
            }
            Matcher matcher = pattern.matcher(value);
            if(!matcher.matches()){
                return false;
            }
            return true;
        }
    }
}
