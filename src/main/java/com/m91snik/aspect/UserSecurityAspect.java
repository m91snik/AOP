/**
 * Created by m91snik on 22.02.15.
 */
package com.m91snik.aspect;

//@Aspect
public class UserSecurityAspect {

    public static final String ROLE_USER = "ROLE_USER";

//    @Before("execution(* *.*(..)) && @annotation(com.example.restful.annotation.UserSecurityNeeded)")
    public void checkUserPermission() throws Exception {
        checkPermission();
    }

    private void checkPermission() throws Exception {
//        Authentication auth = SecurityContextHolder.getContext()
//                .getAuthentication();
//        if (auth == null) {
//            throw new AuthenticationCredentialsNotFoundException("Access is forbidden for not authenticated user");
//        }
//        if (auth.getAuthorities().contains(
//                new SimpleGrantedAuthority(ROLE_USER))) {
//            return;
//        }
//        throw new AuthenticationCredentialsNotFoundException("Access is forbidden for user " + auth.getName());
    }
}
