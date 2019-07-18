package vc.thinker.userservice.interceptors;

import com.baomidou.mybatisplus.core.metadata.IPage;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * 分页处理拦截
 * 实现:
 * 1、返回List时，将返回的List动态set到page中的records中
 *
 * @author HeTongHao
 * @since 2019-07-12 14:51
 */
@Component
@Intercepts({@Signature(
        type = Executor.class,
        method = "query",
        args = {MappedStatement.class, Object.class, RowBounds.class, ResultHandler.class}
)})
@Slf4j
public class PageHandlerInterceptor implements Interceptor {
    private IPage getPage(Object params) {
        if (params instanceof IPage) {
            return (IPage) params;
        } else if (params instanceof Map) {
            Map<String, Object> pageParamMap = (Map) params;
            for (Object param : pageParamMap.values()) {
                if (param instanceof IPage) {
                    return (IPage) param;
                }
            }
        }
        return null;
    }

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        Object[] args = invocation.getArgs();
        Object params = args[1];
        IPage page = getPage(params);
        Object result = invocation.proceed();
        if (page != null) {
            page.setRecords((List) result);
        }
        return result;
    }

    @Override
    public Object plugin(Object o) {
        return Plugin.wrap(o, this);
    }

    @Override
    public void setProperties(Properties properties) {
    }
}
