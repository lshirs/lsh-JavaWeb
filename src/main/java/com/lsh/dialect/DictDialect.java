package com.lsh.dialect;

import com.lsh.utils.DistUtils;
import org.thymeleaf.context.IExpressionContext;
import org.thymeleaf.dialect.AbstractDialect;
import org.thymeleaf.dialect.IExpressionObjectDialect;
import org.thymeleaf.expression.IExpressionObjectFactory;

import java.util.Collections;
import java.util.Set;

/**
 *
 * 自定义方言
 */

public class DictDialect extends AbstractDialect implements IExpressionObjectDialect {
    public DictDialect(String name) {
        super(name);
    }

    @Override
    public IExpressionObjectFactory getExpressionObjectFactory(){
        return new IExpressionObjectFactory() {
            @Override  //前缀名
            public Set<String> getAllExpressionObjectNames() {
                return Collections.singleton("dict");
            }

            @Override
            public Object buildObject(IExpressionContext iExpressionContext, String s) {
                return new DistUtils();
            }

            @Override
            public boolean isCacheable(String s) {
                return true;
            }
        };
    }
}
