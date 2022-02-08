//package h5EDULive.aop;
//
//import org.aspectj.lang.annotation.After;
//import org.aspectj.lang.annotation.Aspect;
//import org.aspectj.lang.annotation.Before;
//import org.aspectj.lang.annotation.Pointcut;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.stereotype.Component;
//import org.springframework.web.bind.annotation.RequestHeader;
//import org.springframework.web.context.request.RequestContextHolder;
//import org.springframework.web.context.request.ServletRequestAttributes;
//
//import javax.servlet.Servlet;
//import javax.servlet.ServletRequestAttributeEvent;
//import javax.servlet.http.HttpServletRequest;
//
//@Aspect
//@Component
//public class LogAop {
//    private static final Logger logger = LoggerFactory.getLogger(LogAop.class);
//    @Pointcut("execution(* h5EDULive.web.query.*.*(..))")
//    public void pointCut(){
//
//    }
//
//    @Before("pointCut()")
//    public void doBefore(){
//        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
//        String reqUrl = request.getRequestURI().toString();
//        String method = request.getMethod();
//        String addr = request.getRemoteAddr();
//        logger.info("URL:{}", reqUrl);
//        logger.info("METHOD:{}", method);
//        logger.info("ADDR:{}", addr);
//    }
//
//    @After("pointCut()")
//    public void doAfter(){
//
//    }
//}
