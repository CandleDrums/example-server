
package com.cds.server.config;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.expression.OAuth2WebSecurityExpressionHandler;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.web.access.AccessDeniedHandler;

import com.cds.api.auth.config.AuthPathConfig;

/**
 * 资源服务器配置，注解自动增加了一个类型为 OAuth2AuthenticationProcessingFilter 的过滤器链
 *
 * @author ykl
 * @version V1.0
 * @create 2018-08-24 上午9:54
 **/
@Configuration
@EnableResourceServer
@EnableWebSecurity
public class DefaultOAuth2ResourceServiceAdapter extends ResourceServerConfigurerAdapter {

    @Resource
    private AccessDeniedHandler defaultAccessDeniedHandler;
    @Autowired
    private OAuth2WebSecurityExpressionHandler expressionHandler;
    @Autowired
    private DefaultTokenServices tokenServices;
    @Resource
    private TokenStore jwtTokenStore;
    @Resource
    private AuthPathConfig authPathConfig;

    /**
     * 资源安全配置相关
     * 
     * @param resources
     * @throws Exception
     */
    @Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
        super.configure(resources);
        resources.tokenServices(tokenServices);
        resources.expressionHandler(expressionHandler);
        resources.accessDeniedHandler(defaultAccessDeniedHandler);
    }

    /**
     * http安全配置 请求匹配器,用来设置需要进行保护的资源路径，默认的情况下是受保护资源服务的全部路径
     *
     * @param http
     * @throws Exception
     */
    @Override
    public void configure(HttpSecurity http) throws Exception {
        ExpressionUrlAuthorizationConfigurer<HttpSecurity>.ExpressionInterceptUrlRegistry registry =
            http.authorizeRequests().antMatchers(AuthPathConfig.DEFAULT_SKIP_PATH).permitAll();
        if (authPathConfig.getExtSkip() != null) {
            authPathConfig.getExtSkip().forEach(url -> registry.antMatchers(url).permitAll());
        }
        registry.anyRequest().authenticated().and().csrf().disable();// csrf拦截认证处理
    }

    @Bean
    @Primary
    public DefaultTokenServices tokenServices() {
        DefaultTokenServices defaultTokenServices = new DefaultTokenServices();
        defaultTokenServices.setTokenStore(jwtTokenStore);
        return defaultTokenServices;
    }

}
