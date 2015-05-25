package org.example.microservices.currenttimems;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

/**
 * TODO: Document me
 *
 * @author konstantinsteuer
 * @since 25.05.15
 */
@Component
@RefreshScope
public class CurrentDateFormat {

    @Value("${date.format}")
    private String dateFormat;

    public String getDateFormat() {
        return dateFormat;
    }
}
