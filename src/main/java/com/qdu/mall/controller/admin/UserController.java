package com.qdu.mall.controller.admin;

import com.qdu.mall.service.UserService;
import com.qdu.mall.util.PageQueryUtil;
import com.qdu.mall.util.Result;
import com.qdu.mall.util.ResultGenerator;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @ClassName: com.qdu.mall.controller.admin.UserController.java
 * @Description:
 * @author: ZhangJunqing
 * @date:  2020-04-12 11:39
 * @version V1.0
 */
@Controller
@RequestMapping("/admin")
public class UserController {

    @Resource
    private UserService userService;

    @GetMapping("/users")
    public String usersPage(HttpServletRequest request) {
        request.setAttribute("path", "users");
        return "admin/user";
    }

    /**
     * 列表
     */
    @RequestMapping(value = "/users/list", method = RequestMethod.GET)
    @ResponseBody
    public Result list(@RequestParam Map<String, Object> params) {
        if (StringUtils.isEmpty(params.get("page")) || StringUtils.isEmpty(params.get("limit"))) {
            return ResultGenerator.genFailResult("参数异常！");
        }
        PageQueryUtil pageUtil = new PageQueryUtil(params);
        return ResultGenerator.genSuccessResult(userService.getUsersPage(pageUtil));
    }

    /**
     * 用户禁用与解除禁用
     * 0-未锁定
     * 1-已锁定
     */
    @RequestMapping(value = "/users/lock/{lockStatus}", method = RequestMethod.POST)
    @ResponseBody
    public Result delete(@RequestBody Integer[] ids, @PathVariable int lockStatus) {
        if (ids.length < 1) {
            return ResultGenerator.genFailResult("参数异常！");
        }
        if (lockStatus != 0 && lockStatus != 1) {
            return ResultGenerator.genFailResult("操作非法！");
        }
        if (userService.lockUsers(ids, lockStatus)) {
            return ResultGenerator.genSuccessResult();
        } else {
            return ResultGenerator.genFailResult("禁用失败");
        }
    }
}