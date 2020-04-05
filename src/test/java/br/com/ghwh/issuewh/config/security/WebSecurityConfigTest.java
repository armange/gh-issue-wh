package br.com.ghwh.issuewh.config.security;

import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.CsrfConfigurer;

public class WebSecurityConfigTest {
    
    @Test
    @SuppressWarnings("unchecked")
    public void configure() {
        final WebSecurityConfig webSecurityConfig = new WebSecurityConfig();

        try {
            final HttpSecurity http = mock(HttpSecurity.class);
            final CsrfConfigurer<HttpSecurity> csrfConfigurer = mock(CsrfConfigurer.class);

            Mockito.doReturn(csrfConfigurer).when(http).csrf();

            webSecurityConfig.configure(http);

            verify(http).csrf();
            verify(csrfConfigurer).disable();
            verifyNoMoreInteractions(csrfConfigurer);
            verifyNoMoreInteractions(http);
        } catch (final Exception e) {
            e.printStackTrace();

            fail(e);
        }
    }
}
