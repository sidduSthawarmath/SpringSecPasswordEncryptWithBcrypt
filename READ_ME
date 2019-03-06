Project Name: SpringSecPasswordEncryptWithBcrypt

Login page:
http://localhost:7070/SpringSecPasswordEncryptWithBcrypt/login


Here we will give authentication-provider

	<authentication-manager>
		<authentication-provider user-service-ref="customUserDetailsService" >
		 <password-encoder ref="bcryptEncoder"/>
		 </authentication-provider>
	</authentication-manager>

<beans:bean id="bcryptEncoder" class="org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder" />



API for generate Bcrypt password :
http://localhost:7070/SpringSecPasswordEncryptWithBcrypt/test/passEncode?password=admin


Roles defined : EMP and ADMIN


access : 
/test/**  -> can access without authentication
(http://localhost:7070/SpringSecPasswordEncryptWithBcrypt/test/home)

/emp/**   ->access provided both EMP and ADMIN roles
(http://localhost:7070/SpringSecPasswordEncryptWithBcrypt/emp/home)


/admin/** ->access provided only ADMIN role
(http://localhost:7070/SpringSecPasswordEncryptWithBcrypt/admin/home)
 
 
 Both Java code(SecurityConfiguration.java) and xml (security-config.xml) based configuration is provieded
 
 
  
 For remember me option:
 ------------------------
 
 <http auto-config="true">
		<intercept-url pattern="/test/**" access="permitAll" />
		<intercept-url pattern="/emp/**" access="hasRole('ROLE_EMP')" />
		<intercept-url pattern="/admin/**" access="hasRole('ROLE_ADMIN')" />
		<form-login login-page="/login" username-parameter="ssoId"
			password-parameter="password" authentication-success-handler-ref="customSuccessHandler"
			authentication-failure-url="/login?error=true" />
		<csrf />

		<remember-me remember-me-parameter="remember-me"
			remember-me-cookie="remember-me" token-validity-seconds="86400"
			data-source-ref="dataSource" />
	</http>
 
 
 We need to create table manually:
 
 CREATE TABLE persistent_logins (
    username VARCHAR(64) NOT NULL,
    series VARCHAR(64) NOT NULL,
    token VARCHAR(64) NOT NULL,
    last_used TIMESTAMP NOT NULL,
    PRIMARY KEY (series)
);


when remember-me option is clicked then login to application. Security data is stored in browser cookies 
and data automatically inserted into persistent_logins table. When u try to access any url of that 
user(belongs to one of the role) it wont ask for login.
 
 ref:
 http://websystique.com/spring-security/spring-security-4-remember-me-example-with-hibernate/

