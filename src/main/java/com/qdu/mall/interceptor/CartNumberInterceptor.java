package com.qdu.mall.interceptor;

import com.qdu.mall.common.Constants;
import com.qdu.mall.controller.vo.UserVO;
import com.qdu.mall.dao.ShoppingCartItemMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @ClassName: com.qdu.mall.interceptor.CartNumberInterceptor.java
 * @Description: 购物车数量处理
 * @author: ZhangJunqing
 * @date:  2020-04-12 15:34
 * @version V1.0
 */
@Component
public class CartNumberInterceptor implements HandlerInterceptor {

    @Autowired
    private ShoppingCartItemMapper shoppingCartItemMapper;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
        //购物车中的数量更改后，对session中的数据也做出修改
        if (null != request.getSession() && null != request.getSession().getAttribute(Constants.MALL_USER_SESSION_KEY)) {
            //如果当前为登陆状态，就查询数据库并设置购物车中的数量值
            UserVO userVO = (UserVO) request.getSession().getAttribute(Constants.MALL_USER_SESSION_KEY);
            //设置购物车中的数量
            userVO.setShopCartItemCount(shoppingCartItemMapper.selectCountByUserId(userVO.getUserId()));
            request.getSession().setAttribute(Constants.MALL_USER_SESSION_KEY, userVO);
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
