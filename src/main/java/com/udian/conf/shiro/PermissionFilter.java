package com.udian.conf.shiro;

import org.apache.shiro.web.filter.authz.AuthorizationFilter;
import org.apache.shiro.web.util.WebUtils;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

/**
 * @author zhuxiaomeng
 * @date 2017/12/11.
 * @email 154040976@qq.com
 * 拦截器 校验用户是否已授权 未授权返回到登录界面
 */
public class PermissionFilter extends AuthorizationFilter {

  @Override
  protected boolean isAccessAllowed(ServletRequest servletRequest, ServletResponse servletResponse,
      Object o) throws Exception {
    String[] roles=(String[])o;

    return true;
  }

  @Override
  protected boolean onAccessDenied(ServletRequest request, ServletResponse response)
      throws IOException {
      saveRequest(request);
      WebUtils.issueRedirect(request, response, "/login");
    return false;
  }
}
