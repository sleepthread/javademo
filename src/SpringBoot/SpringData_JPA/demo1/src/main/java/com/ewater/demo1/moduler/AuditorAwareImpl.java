package com.ewater.demo1.moduler;
import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;

import java.util.Optional;
/**
 * @className: AuditorAwareImpl
 * @description: TODO 类描述
 * @author: zhujun
 * @date: 2020/1/16
 **/


@Component
public class AuditorAwareImpl implements AuditorAware<String> {

    @Override
    public Optional<String> getCurrentAuditor() {
        return Optional.of("admin");
    }

}
