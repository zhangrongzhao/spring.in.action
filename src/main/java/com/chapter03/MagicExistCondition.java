//package com.zrz.chapter03;
//
//
//import org.springframework.context.annotation.Condition;
//import org.springframework.context.annotation.ConditionContext;
//import org.springframework.core.env.Environment;
//import org.springframework.core.type.AnnotatedTypeMetadata;
//
//public class MagicExistCondition implements Condition {
//    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata){
//        Environment env=context.getEnvironment();
//        return env.containsProperty("magic");
//    }
//}
