package com.example.springnative.config.aot;

import com.example.springnative.scheduler.ReflectionExamplePOJO;
import org.springframework.aot.hint.MemberCategory;
import org.springframework.aot.hint.RuntimeHints;
import org.springframework.aot.hint.RuntimeHintsRegistrar;

public class AppRuntimeHintsRegistrar implements RuntimeHintsRegistrar {

    @Override
    public void registerHints(RuntimeHints hints, ClassLoader classLoader) {
        hints
                .reflection()
                .registerType(ReflectionExamplePOJO.class, MemberCategory.DECLARED_FIELDS);
    }
}
