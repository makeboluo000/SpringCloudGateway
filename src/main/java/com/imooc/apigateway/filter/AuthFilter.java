//package com.imooc.apigateway.filter;
//
//import com.imooc.apigateway.constant.RedisConstant;
//import com.imooc.apigateway.util.CookieUtil;
//import com.netflix.zuul.ZuulFilter;
//import com.netflix.zuul.context.RequestContext;
//import com.netflix.zuul.exception.ZuulException;
//import org.apache.commons.lang.StringUtils;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
//import org.springframework.data.redis.core.StringRedisTemplate;
//import org.springframework.http.HttpStatus;
//import org.springframework.stereotype.Component;
//
//import javax.servlet.http.Cookie;
//import javax.servlet.http.HttpServletRequest;
//
///**
// * 权限拦截，区分卖家和买家
// */
//@Component
//public class AuthFilter extends ZuulFilter {
//
//    @Autowired
//    private StringRedisTemplate stringRedisTemplate;
//
//    @Override
//    public String filterType() {
//        return FilterConstants.PRE_TYPE;
//    }
//
//    @Override
//    public int filterOrder() {
//        // 自定义过滤器顺序 放在PRE_DECORATION_FILTER_ORDER过滤器 之前
//        return FilterConstants.PRE_DECORATION_FILTER_ORDER - 1;
//    }
//
//    @Override
//    public boolean shouldFilter() {
//        return true;
//    }
//
//    @Override
//    public Object run() throws ZuulException {
////        // 实现逻辑
////        RequestContext requestContext = RequestContext.getCurrentContext();
////        HttpServletRequest request = requestContext.getRequest();
////
////        /**
////         * /order/create 买家访问(cookie里有opdenid)
////         * /order/finish 卖家访问（cookie里有token，并且对应的redis中有值）
////         * /product/list 都可访问 都可以访问
////         *
////         */
////        if("/order/order/create".equals(request.getRequestURI())) {
////            Cookie cookie = CookieUtil.get(request, "openid");
////            if (cookie == null || StringUtils.isEmpty(cookie.getValue())) {
////                requestContext.setSendZuulResponse(false);
////                requestContext.setResponseStatusCode(HttpStatus.UNAUTHORIZED.value());
////            }
////
////            if("/order/order/finish".equals(request.getRequestURI())) {
////                cookie = CookieUtil.get(request, "token");
////                if (cookie == null
////                        || StringUtils.isEmpty(cookie.getValue())
////                        // 接着判断redis
////                        || StringUtils.isNotEmpty(stringRedisTemplate.opsForValue().get(String.format(RedisConstant.TOKEN_PREFIX, cookie.getValue())))) {
////                    requestContext.setSendZuulResponse(false);
////                    requestContext.setResponseStatusCode(HttpStatus.UNAUTHORIZED.value());
////
////                }
////
////            }
////
////        }
//
//        return null;
//    }
//}
