package ${package.Service};

import ${package.Entity}.${entity};
import com.baomidou.mybatisplus.extension.service.IService;
import java.util.List;
/**
 * <p>
    * ${table.comment!} 服务类
    * </p>
 *
 * @since ${date}
 */
<#if kotlin>
interface ${table.serviceName} : ${superServiceClass}<${entity}>
<#else>
public interface ${table.serviceName} extends IService<${entity}> {

}
</#if>
