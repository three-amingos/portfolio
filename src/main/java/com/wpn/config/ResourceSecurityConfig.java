package com.wpn.config;

import com.wpn.model.Account;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@Configuration
@EnableWebSecurity

public class ResourceSecurityConfig extends WebSecurityConfigurerAdapter {

    private final String clientId;
    private final String clientSecret;
    private final String introspectionUrl;

    ResourceSecurityConfig(
            @Value("${oauth.clientId}") final String clientId,
            @Value("${oauth.clientSecret}") final String clientSecret,
            @Value("${oauth.introspectionUrl}") final String introspectionUrl) {
        this.clientId = clientId;
        this.clientSecret = clientSecret;
        this.introspectionUrl = introspectionUrl;
    }

    @Override
    protected void configure(final HttpSecurity security) throws Exception
    {

       /* security.authorizeRequests(authz -> authz
                .antMatchers(HttpMethod.GET, "protected-resource").hasAnyAuthority("SCOPE_read")
                .antMatchers(HttpMethod.POST, "protected-resource").hasRole("ADMIN")
                .anyRequest().authenticated())
                .oauth2ResourceServer(oauth2 -> oauth2
                        .opaqueToken(token -> token.introspectionUri(introspectionUrl)
                                .introspectionClientCredentials(clientId, clientSecret)
                        )
                );*/



       // security.oauth2ResourceServer().jwt();
        security.httpBasic().disable();
        security.csrf().disable();
       /* security.authorizeRequests() //
                .antMatchers("/home", "/login**","/callback/", "/webjars/**", "/error**", "/oauth2/authorization/**")
                .permitAll()
                .anyRequest().authenticated() //
                .and() //
                .oauth2Login()
                .userInfoEndpoint()
               .customUserType(Account.class, "home");*/

    }
}
