package com.example.dbd_pj_be.interceptor;//package com.example.dbd_pj_be.interceptor;
//
//import org.springframework.stereotype.Component;
//import org.springframework.web.servlet.HandlerInterceptor;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//@Component
//public class LoginInterceptor implements HandlerInterceptor {
//
//    @Override
//
//    // 在调用所有处理请求的方法前首先被自动调用执行
//    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//
//
//        // 获取session中的用户信息
////        String userName = (String) request.getSession().getAttribute("userName");
////        User user = userService.findByUserName(userName);
//
//        System.out.println("here");
//
//
//        Object obj = request.getSession().getAttribute("id");
//        System.out.println(obj);
//
//        System.out.println("\n-------- LogInterception.preHandle --- ");
//        System.out.println("Request URL: " + request.getRequestURL());
//
//
//        //判断用户是否登录
//        if (obj == null) {
//            //用户未登录，重定向到登录页面
////            response.sendRedirect(request.getContextPath() + "/login");
//            response.sendRedirect("http://localhost:8000/login");
//
//            System.out.println("not login yet");
//
//            return false;
//        }
//
//        //用户已登录，放行
//        return true;
//    }
//
//    @Override
//    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
//        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
//    }
//}
